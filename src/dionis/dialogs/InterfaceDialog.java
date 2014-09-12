package dionis.dialogs;

import java.util.Arrays;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import dionis.beans.DisableDatagramsBean;
import dionis.beans.InterfaceBean;
import dionis.beans.InterfaceFiltersBean;
import dionis.beans.InterfaceIPBean;
import dionis.models.InterfaceModel;
import dionis.xml.BooleanType;
import dionis.xml.InterfaceModeType;
import dionis.xml.InterfaceNatType;
import dionis.xml.InterfaceType;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class InterfaceDialog extends Dialog {
	private Text text;
	private Text text_1;
	private Combo combo;
	private Combo combo_1;
	private Combo combo_3;
	private Combo combo_4;
	private Spinner spinner;
	private Combo combo_5;
	private Spinner spinner_1;
	private Button button;
	private Button btnCheckButton;
	private Button btnCheckButton_1;
	private Button btnCheckButton_2;
	private Button btnCheckButton_3;
	private Button btnCheckButton_4;
	private Button btnIp;
	private Button btnCheckButton_5;
	private InterfaceBean ib;
	private ComboViewer comboViewer;
	private int index;
	private ComboViewer comboViewer_1;
	private ComboViewer comboViewer_2;
	private Text text_2;
	private ComboViewer comboViewer_3;
	private ComboViewer comboViewer_4;
	private Table table;
	private TableViewer tableViewer;
	private TableColumn tblclmnNewColumn;
	private TableViewerColumn tableViewerColumn;
	private TableColumn tblclmnNewColumn_1;
	private TableViewerColumn tableViewerColumn_1;
	private TableColumn tblclmnNewColumn_2;
	private TableViewerColumn tableViewerColumn_2;
	private TableColumn tblclmnNewColumn_3;
	private TableViewerColumn tableViewerColumn_3;
	private Button btnNewButton;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public InterfaceDialog(Shell parentShell, int index) {
		super(parentShell);
		this.index = index;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		/** Создаём бины **/
		createData();

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(7, false));

		Label label = new Label(container, SWT.NONE);
		label.setText("Имя");
		new Label(container, SWT.NONE);

		text = new Text(container, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gd_text.widthHint = 103;
		text.setLayoutData(gd_text);
		text.setTextLimit(7);

		Label label_1 = new Label(container, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_1.setText("Тип");

		combo = new Combo(container, SWT.NONE);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gd_combo.widthHint = 201;
		combo.setLayoutData(gd_combo);
		comboViewer = new ComboViewer(combo);
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof InterfaceType) {
					InterfaceType iTypeElement = (InterfaceType) element;
					return iTypeElement.name();
				}
				return super.getText(element);
			}
		});
		// java.util.LinkedList<String> list = new LinkedList<String>();
		// for (InterfaceType s : InterfaceType.values()) {
		// list.add(s.name());
		// }
		// comboViewer.setInput(list.toArray(new String[list.size()]));
		comboViewer.setInput(Arrays.asList(InterfaceType.values()));

		Label label_2 = new Label(container, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_2.setText("Режим активизации");

		combo_1 = new Combo(container, SWT.NONE);
		GridData gd_combo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_1.widthHint = 351;
		combo_1.setLayoutData(gd_combo_1);
		comboViewer_1 = new ComboViewer(combo_1);
		comboViewer_1.setContentProvider(new ArrayContentProvider());
		comboViewer_1.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof InterfaceModeType) {
					InterfaceModeType iElement = (InterfaceModeType) element;
					return iElement.name();
				}
				return super.getText(element);
			}
		});
		comboViewer_1.setInput(Arrays.asList(InterfaceModeType.values()));

		Label lblIp = new Label(container, SWT.NONE);
		lblIp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3,
				1));
		lblIp.setText("Локальный ip адрес");

		text_2 = new Text(container, SWT.NONE);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				2, 1));

		Label label_4 = new Label(container, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_4.setText("Фильтр входящих");

		combo_3 = new Combo(container, SWT.NONE);
		GridData gd_combo_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_3.widthHint = 351;
		combo_3.setLayoutData(gd_combo_3);
		comboViewer_2 = new ComboViewer(combo_3);
		comboViewer_2.setContentProvider(new ArrayContentProvider());
		comboViewer_2.setLabelProvider(new LabelProvider());
		// TODO: доделать связь с таблицей фильтров
		// ib
		// comboViewer_2.setInput(new String[] { ib.getFilters().getInput() });

		Label lblIp_1 = new Label(container, SWT.NONE);
		lblIp_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
				3, 1));
		lblIp_1.setText("Удалённый ip адрес");

		text_1 = new Text(container, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				2, 1));

		Label label_6 = new Label(container, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_6.setText("Фильтр исходящих");

		combo_4 = new Combo(container, SWT.NONE);
		GridData gd_combo_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_4.widthHint = 351;
		combo_4.setLayoutData(gd_combo_4);
		comboViewer_3 = new ComboViewer(combo_4);
		comboViewer_3.setContentProvider(new ArrayContentProvider());
		comboViewer_3.setLabelProvider(new LabelProvider());
		// TODO: доделать связь с таблицей фильтров

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 3, 1));
		lblNewLabel.setText("Таймер неактивности");

		spinner = new Spinner(container, SWT.BORDER);
		GridData gd_spinner = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				2, 1);
		gd_spinner.widthHint = 124;
		spinner.setLayoutData(gd_spinner);
		spinner.setMinimum(0);
		spinner.setMaximum(65535);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_1.setText("NAT режим");

		combo_5 = new Combo(container, SWT.NONE);
		GridData gd_combo_5 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_5.widthHint = 351;
		combo_5.setLayoutData(gd_combo_5);
		comboViewer_4 = new ComboViewer(combo_5);
		comboViewer_4.setContentProvider(new ArrayContentProvider());
		comboViewer_4.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof InterfaceNatType) {
					InterfaceNatType iElement = (InterfaceNatType) element;
					return iElement.name();
				}
				return super.getText(element);
			}
		});
		comboViewer_4.setInput(Arrays.asList(InterfaceNatType.values()));

		Label lblMtu = new Label(container, SWT.NONE);
		lblMtu.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
				3, 1));
		lblMtu.setText("MTU");

		spinner_1 = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1);
		gd_spinner_1.widthHint = 124;
		spinner_1.setLayoutData(gd_spinner_1);
		spinner_1.setMinimum(576);
		spinner_1.setMaximum(1500);

		Group group_2 = new Group(container, SWT.NONE);
		group_2.setText("Таблица маршрутов");
		group_2.setLayout(new GridLayout(1, false));
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 4));

		tableViewer = new TableViewer(group_2, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Адрес/бит");

		tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("Шлюз");

		tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Метрика");

		tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Метка");

		Group group = new Group(container, SWT.NONE);
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 5, 1));
		
		btnNewButton = new Button(group, SWT.NONE);
		btnNewButton.setText("Дополнительные параметры");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});

		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("Запретить обработку датаграмм");
		group_1.setLayout(new GridLayout(2, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 5,
				1));

		button = new Button(group_1, SWT.CHECK);
		button.setText("Не туннелированных");

		btnCheckButton = new Button(group_1, SWT.CHECK);
		btnCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		btnCheckButton.setText("Транзитных");

		btnCheckButton_1 = new Button(group_1, SWT.CHECK);
		btnCheckButton_1.setText("DHCP протокола");

		btnCheckButton_2 = new Button(group_1, SWT.CHECK);
		btnCheckButton_2.setText("RIP протокола");

		btnCheckButton_3 = new Button(group_1, SWT.CHECK);
		btnCheckButton_3.setText("Multicast");

		btnCheckButton_4 = new Button(group_1, SWT.CHECK);
		btnCheckButton_4.setText("Cluster");

		btnIp = new Button(container, SWT.CHECK);
		btnIp.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnIp.setText("IP статистика");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		btnCheckButton_5 = new Button(container, SWT.CHECK);
		btnCheckButton_5.setText("Прокси ARP");
		btnCheckButton_5.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1));
		new Label(container, SWT.NONE);

		bindData();

		return container;
	}

	private void createData() {
		// если ничего не выбрано (добавление)
		if (index == -1) {
			// новый экземпляр бина
			ib = new InterfaceBean();
			InterfaceIPBean ipb = new InterfaceIPBean();
			ib.setIp(ipb);
			InterfaceFiltersBean filtersBean = new InterfaceFiltersBean();
			ib.setFilters(filtersBean);
			DisableDatagramsBean datagramsBean = new DisableDatagramsBean();
			datagramsBean.setNotTunneled(BooleanType.YES);
			datagramsBean.setForward(BooleanType.YES);
			ib.setDisableDatagrams(datagramsBean);
		} else {
			// ссылка на экземпляр бина из модели
			ib = InterfaceModel.getInstance().getData().get(index);
		}
	}

	private void bindData() {
		// контекст датабиндинга
		DataBindingContext ctx = new DataBindingContext();
		// имя
		IObservableValue widgetValue = WidgetProperties.text(SWT.Modify)
				.observe(text);
		IObservableValue modelValue = BeanProperties.value(InterfaceBean.class,
				"name").observe(ib);
		ctx.bindValue(widgetValue, modelValue);
		// Тип
		widgetValue = ViewersObservables.observeSingleSelection(comboViewer);
		modelValue = BeanProperties.value("type").observe(ib);
		ctx.bindValue(widgetValue, modelValue);
		// режим активизации
		widgetValue = ViewersObservables.observeSingleSelection(comboViewer_1);
		modelValue = BeanProperties.value("mode").observe(ib);
		ctx.bindValue(widgetValue, modelValue);
		// локальный ip
		widgetValue = WidgetProperties.text(SWT.Modify).observe(text_2);
		modelValue = BeanProperties.value(InterfaceBean.class, "ip.local")
				.observe(ib);
		ctx.bindValue(widgetValue, modelValue);
		// фильтр входящих
		widgetValue = ViewersObservables.observeSingleSelection(comboViewer_2);
		modelValue = BeanProperties.value("filters.input").observe(ib);
		ctx.bindValue(widgetValue, modelValue);
		// удалённый ip
		widgetValue = WidgetProperties.text(SWT.Modify).observe(text_1);
		modelValue = BeanProperties.value(InterfaceBean.class, "ip.remote")
				.observe(ib);
		ctx.bindValue(widgetValue, modelValue);
		// фильтр исходящих
		widgetValue = ViewersObservables.observeSingleSelection(comboViewer_3);
		modelValue = BeanProperties.value("filters.input").observe(ib);
		ctx.bindValue(widgetValue, modelValue);
		// Таймер неактивности
		widgetValue = SWTObservables.observeSelection(spinner);
		modelValue = BeanProperties.value("timer").observe(ib);
		// NAT режим
		widgetValue = ViewersObservables.observeSingleSelection(comboViewer_4);
		modelValue = BeanProperties.value("nat").observe(ib);
		ctx.bindValue(widgetValue, modelValue);
		// MTU
		widgetValue = SWTObservables.observeSelection(spinner_1);
		modelValue = BeanProperties.value("mtu").observe(ib);
		ctx.bindValue(widgetValue, modelValue);
		/** **/
		// Не туннелированных
		widgetValue = SWTObservables.observeSelection(button);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.notTunneled").observe(ib);
		// стратегия для конверсии boolean -> BooleanType
		UpdateValueStrategy updateValueStrategy = new UpdateValueStrategy()
		.setConverter(new Boolean2BooleanTypeConverter());
		// стратегия для обратной конверсии BooleanType -> boolean 
		UpdateValueStrategy updateFromValueStrategy = new UpdateValueStrategy()
		.setConverter(new BooleanType2BooleanConverter());
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy, updateFromValueStrategy);
		// Транзитных
		widgetValue = SWTObservables.observeSelection(btnCheckButton);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.forward").observe(ib);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy, updateFromValueStrategy);
		// DHCP протокола
		widgetValue = SWTObservables.observeSelection(btnCheckButton_1);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.dhcp").observe(ib);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy, updateFromValueStrategy);
		// RIP протокола
		widgetValue = SWTObservables.observeSelection(btnCheckButton_2);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.rip").observe(ib);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy, updateFromValueStrategy);
		// Multicast
		widgetValue = SWTObservables.observeSelection(btnCheckButton_3);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.multicast").observe(ib);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy, updateFromValueStrategy);
		// Cluster
		widgetValue = SWTObservables.observeSelection(btnCheckButton_4);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.cluster").observe(ib);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy, updateFromValueStrategy);
		// IP статистика
		widgetValue = SWTObservables.observeSelection(btnIp);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.ipStat").observe(ib);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy, updateFromValueStrategy);
		// Прокси ARP
		widgetValue = SWTObservables.observeSelection(btnCheckButton_5);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.proxyARP").observe(ib);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy, updateFromValueStrategy);

	}

	/**
	 * Класс конверсии значений из типа boolean в тип BooleanType
	 * 
	 * @author Ярных А.О.
	 *
	 */
	private class Boolean2BooleanTypeConverter extends Converter {

		public Boolean2BooleanTypeConverter() {
			this(boolean.class, BooleanType.class);
		}

		public Boolean2BooleanTypeConverter(Object fromType, Object toType) {
			super(fromType, toType);
		}

		@Override
		public Object convert(Object fromObject) {
			if ((boolean) fromObject == true)
				return BooleanType.YES;
			else
				return BooleanType.NO;
		}

	}
	/**
	 * Класс конверсии значений из типа boolean в тип BooleanType
	 * 
	 * @author Ярных А.О.
	 *
	 */
	private class BooleanType2BooleanConverter extends Converter {

		public BooleanType2BooleanConverter() {
			this(BooleanType.class, boolean.class);
		}

		public BooleanType2BooleanConverter(Object fromType, Object toType) {
			super(fromType, toType);
		}

		@Override
		public Object convert(Object fromObject) {
			if ((BooleanType) fromObject == BooleanType.YES)
				return true;
			else
				return false;
		}

	}

	@Override
	protected void okPressed() {
		InterfaceModel.getInstance().addData(ib);
		super.okPressed();
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
		return new Point(1114, 447);
	}

}
