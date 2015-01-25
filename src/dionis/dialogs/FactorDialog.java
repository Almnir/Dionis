package dionis.dialogs;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import dionis.beans.InterfaceParametrsBean;
import dionis.beans.VLANBean;
import dionis.beans.VLANsBean;
import dionis.models.ODIModel;
import dionis.utils.Constants;
import dionis.xml.InterfaceParametrsMediaType;
import dionis.xml.InterfaceParametrsModeType;

/**
 * Диалог отображения настроек Factor
 * 
 * @author Ярных А.О.
 *
 */
public class FactorDialog extends Dialog {
	private Spinner numberSpinner;
	private Combo interfaceMediaCombo;
	private Combo modeCombo;
	private Spinner buffSizeSpinner;
	private Text macText;
	private TableViewer tableViewer;
	private Spinner sendLimitSpinner;
	private Spinner receiveLimitSpinner;
	private MenuItem pasteItem;

	// бин параметров
	private InterfaceParametrsBean parametrs;
	// модель VLANs
	private ODIModel vlanBeans = new ODIModel();
	// кэшированная модель VLANs
	private ODIModel oldVlanBeans = new ODIModel();
	// кэш копипасты
	protected VLANBean copyPasteFilter;
	private DataBindingContext ctx;
	private ComboViewer interfaceMediaComboViewer;
	private ComboViewer modeComboViewer;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	@SuppressWarnings("unchecked")
	public FactorDialog(Shell parentShell, InterfaceParametrsBean parametrs) {
		super(parentShell);
		this.parametrs = parametrs;
		if (this.parametrs.getVlaNs() == null) {
			List<VLANBean> vlan = new LinkedList<VLANBean>();
			VLANsBean vlaNsBean = new VLANsBean();
			vlaNsBean.setVlan(vlan);
			this.parametrs.setVlaNs(vlaNsBean);
		}
		// установка модели из бина конкретного интерфейса
		vlanBeans.setData(this.parametrs.getVlaNs().getVlan());
		// кэш объекта модели бина
		try {
			oldVlanBeans.setData((LinkedList<VLANBean>) vlanBeans.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText("Дополнительные параметры");

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(3, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel.widthHint = 192;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("Номер платы");

		numberSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_frameSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_frameSpinner.widthHint = 73;
		numberSpinner.setLayoutData(gd_frameSpinner);
		numberSpinner.setMinimum(0);
		numberSpinner.setMaximum(15);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		GridData gd_lblNewLabel_1 = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel_1.widthHint = 88;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setText("Интерфейс");

		interfaceMediaCombo = new Combo(container, SWT.READ_ONLY);
		interfaceMediaCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 2, 1));
		interfaceMediaComboViewer = new ComboViewer(interfaceMediaCombo);
		interfaceMediaComboViewer
				.setContentProvider(new ArrayContentProvider());
		interfaceMediaComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof InterfaceParametrsMediaType) {
					InterfaceParametrsMediaType iTypeElement = (InterfaceParametrsMediaType) element;
					return Constants.CONNECTION_TYPE[iTypeElement.ordinal()];
				}
				return super.getText(element);
			}
		});
		interfaceMediaComboViewer
				.setInput(InterfaceParametrsMediaType.values());

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setText("Режим работы");

		modeCombo = new Combo(container, SWT.READ_ONLY);
		modeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		modeComboViewer = new ComboViewer(modeCombo);
		modeComboViewer.setContentProvider(new ArrayContentProvider());
		modeComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof InterfaceParametrsModeType) {
					InterfaceParametrsModeType iTypeElement = (InterfaceParametrsModeType) element;
					return Constants.CONNECTION_MODE[iTypeElement.ordinal()];
				}
				return super.getText(element);
			}
		});
		modeComboViewer.setInput(InterfaceParametrsModeType.values());

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setText("Размер буфера обмена");

		buffSizeSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_buffSizeSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_buffSizeSpinner.widthHint = 73;
		buffSizeSpinner.setLayoutData(gd_buffSizeSpinner);
		new Label(container, SWT.NONE);
		buffSizeSpinner.setMinimum(8);
		buffSizeSpinner.setMaximum(255);

		Label lblNewLabel_5 = new Label(container, SWT.NONE);
		GridData gd_lblNewLabel_5 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel_5.widthHint = 192;
		lblNewLabel_5.setLayoutData(gd_lblNewLabel_5);
		lblNewLabel_5.setText("MAC адрес");

		macText = new Text(container, SWT.BORDER);
		macText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				2, 1));

		Group grpVlan = new Group(container, SWT.NONE);
		grpVlan.setText("Таблица VLAN");
		grpVlan.setLayout(new GridLayout(1, false));
		grpVlan.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		tableViewer = new TableViewer(grpVlan, SWT.BORDER | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setText("Адрес/бит");
		tblclmnNewColumn_1.setWidth(188);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("VNID");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem changeItem = new MenuItem(menu, SWT.NONE);
		changeItem.setText("Изменить");

		changeItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				if (!sel.isEmpty()) {
					VLANBean bean = (VLANBean) sel.getFirstElement();
					int index = vlanBeans.getData().indexOf(bean);
					ODIVLANDialog dialog = new ODIVLANDialog(getShell(), bean);
					if (dialog.open() == Window.OK) {
						// изменяем элемент в списке
						// если есть - заменить на текущее
						vlanBeans.getData().set(index, dialog.getVlanBean());
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								tableViewer.setInput(Properties.selfList(
										VLANBean.class).observe(
										vlanBeans.getData()));
							}
						});
					}
				}
			}
		});

		final MenuItem addItem = new MenuItem(menu, SWT.NONE);
		addItem.setText("Добавить");

		// обработчик добавления в таблицу
		addItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ODIVLANDialog dialog = new ODIVLANDialog(getShell(), null);
				if (dialog.open() == Window.OK) {
					// добавляем бин в список
					vlanBeans.getData().add(dialog.getVlanBean());
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							tableViewer.setInput(Properties.selfList(
									VLANBean.class)
									.observe(vlanBeans.getData()));
						}
					});
				}
			}
		});

		final MenuItem removeItem = new MenuItem(menu, SWT.NONE);
		removeItem.setText("Удалить");

		// обработчик удаления строк в таблице
		removeItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				VLANBean vlanBean = (VLANBean) sel.getFirstElement();
				vlanBeans.getData().remove(vlanBean);
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						tableViewer.setInput(Properties
								.selfList(VLANBean.class).observe(
										vlanBeans.getData()));
					}
				});
			}
		});

		final MenuItem copyItem = new MenuItem(menu, SWT.NONE);
		copyItem.setText("Копировать");

		copyItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				if (!sel.isEmpty()) {
					VLANBean vlanBean = (VLANBean) sel.getFirstElement();
					// скопировать ссылку на текущее выделение
					try {
						copyPasteFilter = (VLANBean) vlanBean.clone();
					} catch (CloneNotSupportedException e1) {
						e1.printStackTrace();
					}
					// сделать активной пункт "вставить"
					pasteItem.setEnabled(true);
				}
			}
		});

		pasteItem = new MenuItem(menu, SWT.NONE);
		pasteItem.setText("Вставить");
		pasteItem.setEnabled(false);

		pasteItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				VLANBean vlanBean = new VLANBean();
				try {
					vlanBean = (VLANBean) copyPasteFilter.clone();
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				vlanBeans.getData().add(vlanBean);
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						tableViewer.setInput(Properties
								.selfList(VLANBean.class).observe(
										vlanBeans.getData()));
					}
				});
			}
		});

		// обработчик меню, дающий возможность изменять, удалять, копировать,
		// вставлять выбранные
		// строки таблицы
		menu.addListener(SWT.Show, new Listener() {
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				if (sel.isEmpty()) {
					changeItem.setEnabled(false);
					addItem.setEnabled(true);
					removeItem.setEnabled(false);
					copyItem.setEnabled(false);
				} else {
					changeItem.setEnabled(true);
					addItem.setEnabled(true);
					removeItem.setEnabled(true);
					copyItem.setEnabled(true);
				}
			}
		});

		Label lblNewLabel_6 = new Label(container, SWT.NONE);
		lblNewLabel_6.setText("Ограничение скорости передачи");
		new Label(container, SWT.NONE);

		sendLimitSpinner = new Spinner(container, SWT.BORDER);
		sendLimitSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Label lblNewLabel_7 = new Label(container, SWT.NONE);
		lblNewLabel_7.setText("Ограничение скорости приёма");
		new Label(container, SWT.NONE);

		receiveLimitSpinner = new Spinner(container, SWT.BORDER);
		receiveLimitSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		receiveLimitSpinner.setMinimum(0);

		setDefaultValues();
		bindData();

		return container;
	}

	private void bindData() {
		// контекст датабиндинга
		ctx = new DataBindingContext();
		// Номер платы
		IObservableValue widgetValue = SWTObservables
				.observeSelection(numberSpinner);
		IObservableValue modelValue = BeanProperties.value("frame").observe(
				parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// тип интерфейса
		widgetValue = ViewersObservables
				.observeSingleSelection(interfaceMediaComboViewer);
		modelValue = BeanProperties
				.value(InterfaceParametrsBean.class, "media")
				.observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// режим работы
		widgetValue = ViewersObservables
				.observeSingleSelection(modeComboViewer);
		modelValue = BeanProperties.value(InterfaceParametrsBean.class, "mode")
				.observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// Размер буфера обмена
		widgetValue = SWTObservables.observeSelection(buffSizeSpinner);
		modelValue = BeanProperties.value("buf").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// MAC адрес
		widgetValue = SWTObservables.observeText(macText, SWT.Modify);
		modelValue = BeanProperties.value(InterfaceParametrsBean.class, "mac")
				.observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// Таблица
		ObservableListContentProvider contentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(contentProvider);
		// извлечь элементы наблюдения
		IObservableSet knownElements = contentProvider.getKnownElements();
		// выставить соответствие в свойствах
		final IObservableMap ips = BeanProperties.value(VLANBean.class, "ip")
				.observeDetail(knownElements);
		final IObservableMap bitss = BeanProperties.value(VLANBean.class,
				"bits").observeDetail(knownElements);
		final IObservableMap vnids = BeanProperties.value(VLANBean.class,
				"vnid").observeDetail(knownElements);
		// свойства в массив
		IObservableMap[] maps = { ips, bitss, vnids };
		// провайдер отображения
		ILabelProvider labelProvider = new ObservableMapLabelProvider(maps) {
			@Override
			public String getColumnText(Object element, int columnIndex) {
				String rv = "";
				switch (columnIndex) {
				case 0:
					rv = ips.get(element).toString() + "/"
							+ bitss.get(element).toString();
					break;
				case 1:
					rv = vnids.get(element).toString();
					break;
				}
				return rv;
			}
		};
		// данные для вьюера
		IObservableList input = Properties.selfList(VLANBean.class).observe(
				vlanBeans.getData());
		tableViewer.setLabelProvider(labelProvider);
		tableViewer.setInput(input);
		// Ограничение скорости передачи
		widgetValue = SWTObservables.observeSelection(sendLimitSpinner);
		modelValue = BeanProperties.value("bandwidth").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// Ограничение скорости приёма
		widgetValue = SWTObservables.observeSelection(receiveLimitSpinner);
		modelValue = BeanProperties.value("bandrecv").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// обновить виджеты данными бина
		ctx.updateTargets();
	}

	@Override
	protected void okPressed() {
		// обновляем модели
		ctx.updateModels();
		// устанавливаем модель таблицы
		this.parametrs.getVlaNs().setVlan(vlanBeans.getData());
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		// восстанавливаем модель таблицы
		this.parametrs.getVlaNs().setVlan(oldVlanBeans.getData());
		super.cancelPressed();
	}

	/**
	 * Установка дефолтных значений
	 */
	private void setDefaultValues() {
		numberSpinner.setSelection(0);
		buffSizeSpinner.setSelection(8);
		macText.setText("0.0.0.0");
		sendLimitSpinner.setSelection(0);
		receiveLimitSpinner.setSelection(0);
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(496, 535);
	}

}
