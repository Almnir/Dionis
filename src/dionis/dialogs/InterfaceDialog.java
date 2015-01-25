package dionis.dialogs;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
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
import org.eclipse.swt.widgets.Button;
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
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import dionis.beans.DisableDatagramsBean;
import dionis.beans.FiltersBean;
import dionis.beans.InterfaceBean;
import dionis.beans.InterfaceFiltersBean;
import dionis.beans.InterfaceIPBean;
import dionis.beans.InterfaceParametrsBean;
import dionis.beans.InterfaceRouteBean;
import dionis.beans.InterfaceRoutesBean;
import dionis.models.FiltersModel;
import dionis.models.InterfaceRouteModel;
import dionis.utils.BindHelper;
import dionis.utils.Constants;
import dionis.validators.IPAddressValidator;
import dionis.xml.InterfaceModeType;
import dionis.xml.InterfaceNatType;
import dionis.xml.InterfaceType;

/**
 * Класс диалога отображения интерфейсов
 * 
 * @author Ярных А.О.
 *
 */
public class InterfaceDialog extends Dialog {

	private Text nameText;
	private Combo typeCombo;
	private ComboViewer typeComboViewer;
	private ComboViewer modeComboViewer;
	private Combo modeCombo;
	private Text localIpText;
	private Combo filterInputCombo;
	private ComboViewer filterInputComboViewer;
	private Text remoteIpText;
	private Combo filterOutputCombo;
	private ComboViewer filterOutputComboViewer;
	private Spinner timerSpinner;
	private Combo natCombo;
	private ComboViewer natComboViewer;
	private Spinner mtuSpinner;
	private TableViewer tableViewer;
	private Table table;
	private Button otherParamsButton;
	private Button tunnelButton;
	private Button transitButton;
	private Button dhcpButton;
	private Button ripButton;
	private Button multicastButton;
	private Button clusterButton;
	private Button ipButton;
	private Button proxyButton;
	private DataBindingContext ctx;

	// получаемый бин интерфейса
	private dionis.beans.InterfaceBean interfacesBean;
	// модель маршрутов
	private InterfaceRouteModel routeModel = new InterfaceRouteModel();
	// кэшированная модель маршрутов
	private InterfaceRouteModel oldModel = new InterfaceRouteModel();

	/**
	 * @wbp.parser.constructor
	 */
	@SuppressWarnings("unchecked")
	public InterfaceDialog(Shell parentShell,
			dionis.beans.InterfaceBean newInterfaceBean) {
		super(parentShell);
		if (newInterfaceBean != null) {
			this.interfacesBean = newInterfaceBean;
			// установка модели из бина конкретного интерфейса
			routeModel.setData(this.interfacesBean.getRoutes().getRoute());
			// кэш объекта модели бина
			oldModel.setData((List<InterfaceRouteBean>) routeModel.getClone());
		} else {
			this.interfacesBean = new dionis.beans.InterfaceBean();
			this.interfacesBean.setIp(new InterfaceIPBean());
			this.interfacesBean.setFilters(new InterfaceFiltersBean());
			this.interfacesBean.setDisableDatagrams(new DisableDatagramsBean());
			this.interfacesBean.setParametrs(new InterfaceParametrsBean());
			this.interfacesBean.setRoutes(new InterfaceRoutesBean());
			routeModel.removeAll();
		}
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText("Интерфейс");

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(7, false));

		Label label = new Label(container, SWT.NONE);
		label.setText("Имя");
		new Label(container, SWT.NONE);

		nameText = new Text(container, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gd_text.widthHint = 103;
		nameText.setLayoutData(gd_text);
		nameText.setTextLimit(7);

		Label label_1 = new Label(container, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_1.setText("Тип");

		typeCombo = new Combo(container, SWT.READ_ONLY);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gd_combo.widthHint = 201;
		typeCombo.setLayoutData(gd_combo);
		typeComboViewer = new ComboViewer(typeCombo);
		typeComboViewer.setContentProvider(new ArrayContentProvider());
		typeComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof InterfaceType) {
					InterfaceType iTypeElement = (InterfaceType) element;
					return iTypeElement.name();
				}
				return super.getText(element);
			}
		});
		typeComboViewer.setInput(InterfaceType.values());

		Label label_2 = new Label(container, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_2.setText("Режим активизации");

		modeCombo = new Combo(container, SWT.READ_ONLY);
		GridData gd_combo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_1.widthHint = 351;
		modeCombo.setLayoutData(gd_combo_1);
		modeComboViewer = new ComboViewer(modeCombo);
		modeComboViewer.setContentProvider(new ArrayContentProvider());
		modeComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof InterfaceModeType) {
					InterfaceModeType iElement = (InterfaceModeType) element;
					return Constants.INTERFACE_MODE_TYPE[iElement.ordinal()];
				}
				return super.getText(element);
			}
		});
		modeComboViewer.setInput(InterfaceModeType.values());

		Label lblIp = new Label(container, SWT.NONE);
		lblIp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3,
				1));
		lblIp.setText("Локальный ip адрес");

		localIpText = new Text(container, SWT.BORDER);
		localIpText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));

		Label label_4 = new Label(container, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_4.setText("Фильтр входящих");

		filterInputCombo = new Combo(container, SWT.READ_ONLY);
		GridData gd_combo_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_3.widthHint = 351;
		filterInputCombo.setLayoutData(gd_combo_3);
		filterInputComboViewer = new ComboViewer(filterInputCombo);
		filterInputComboViewer.setContentProvider(new ArrayContentProvider());
		filterInputComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				FiltersBean fsb = (FiltersBean) element;
				return fsb.getFilter().getName();
			}
		});
		filterInputComboViewer.setInput(FiltersModel.getInstance()
				.getDataArray());

		Label lblIp_1 = new Label(container, SWT.NONE);
		lblIp_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
				3, 1));
		lblIp_1.setText("Удалённый ip адрес");

		remoteIpText = new Text(container, SWT.BORDER);
		remoteIpText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));

		Label label_6 = new Label(container, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_6.setText("Фильтр исходящих");

		filterOutputCombo = new Combo(container, SWT.READ_ONLY);
		GridData gd_combo_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_4.widthHint = 351;
		filterOutputCombo.setLayoutData(gd_combo_4);
		filterOutputComboViewer = new ComboViewer(filterOutputCombo);
		filterOutputComboViewer.setContentProvider(new ArrayContentProvider());
		filterOutputComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				FiltersBean fsb = (FiltersBean) element;
				return fsb.getFilter().getName();
			}
		});
		filterOutputComboViewer.setInput(FiltersModel.getInstance()
				.getDataArray());

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 3, 1));
		lblNewLabel.setText("Таймер неактивности");

		timerSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_spinner = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				2, 1);
		gd_spinner.widthHint = 124;
		timerSpinner.setLayoutData(gd_spinner);
		timerSpinner.setMinimum(0);
		timerSpinner.setMaximum(65535);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_1.setText("NAT режим");

		natCombo = new Combo(container, SWT.READ_ONLY);
		GridData gd_combo_5 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_5.widthHint = 351;
		natCombo.setLayoutData(gd_combo_5);
		natComboViewer = new ComboViewer(natCombo);
		natComboViewer.setContentProvider(new ArrayContentProvider());
		natComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof InterfaceNatType) {
					InterfaceNatType iElement = (InterfaceNatType) element;
					return Constants.INTERFACE_NAT_TYPE[iElement.ordinal()];
				}
				return super.getText(element);
			}
		});
		natComboViewer.setInput(InterfaceNatType.values());

		Label lblMtu = new Label(container, SWT.NONE);
		lblMtu.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
				3, 1));
		lblMtu.setText("MTU");

		mtuSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1);
		gd_spinner_1.widthHint = 124;
		mtuSpinner.setLayoutData(gd_spinner_1);
		mtuSpinner.setMinimum(576);
		mtuSpinner.setMaximum(1500);

		Group group_2 = new Group(container, SWT.NONE);
		group_2.setText("Таблица маршрутов");
		group_2.setLayout(new GridLayout(1, false));
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 4));

		tableViewer = new TableViewer(group_2, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Адрес/бит");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("Шлюз");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Метрика");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Метка");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("Изменить");

		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				if (!sel.isEmpty()) {
					InterfaceRouteBean bean = (InterfaceRouteBean) sel
							.getFirstElement();
					int index = routeModel.getData().indexOf(bean);
					// создание диалога
					InterfaceRouteDialog dialog = new InterfaceRouteDialog(
							getShell(), bean);
					if (dialog.open() == Window.OK) {
						routeModel.getData().set(index,
								dialog.getInterfaceRouteBean());
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								// обновление данных для таблицы
								tableViewer.setInput(Properties.selfList(
										InterfaceRouteBean.class).observe(
										routeModel.getData()));
							}
						});

					}
				}
			}
		});

		final MenuItem mntmNewItem_1 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_1.setText("Добавить");

		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// создание диалога
				InterfaceRouteDialog dialog = new InterfaceRouteDialog(
						getShell(), null);
				if (dialog.open() == Window.OK) {
					routeModel.getData().add(dialog.getInterfaceRouteBean());
					// обновление данных для таблицы
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							// обновление данных для таблицы
							tableViewer.setInput(Properties.selfList(
									InterfaceRouteBean.class).observe(
									routeModel.getData()));
						}
					});
				}
			}
		});

		final MenuItem mntmNewItem_2 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_2.setText("Удалить");

		mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				if (!sel.isEmpty()) {
					// выбранный элемент таблицы как бин
					InterfaceRouteBean ibean = (InterfaceRouteBean) sel
							.getFirstElement();
					routeModel.getData().remove(ibean);
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							// обновление данных для таблицы
							tableViewer.setInput(Properties.selfList(
									InterfaceRouteBean.class).observe(
									routeModel.getData()));
						}
					});

				}
			}
		});

		menu.addListener(SWT.Show, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TableItem[] selected = table.getSelection();
				if (selected.length == 0) {
					mntmNewItem.setEnabled(false);
					mntmNewItem_1.setEnabled(true);
					mntmNewItem_2.setEnabled(false);
				} else {
					mntmNewItem.setEnabled(true);
					mntmNewItem_1.setEnabled(true);
					mntmNewItem_2.setEnabled(true);
				}
			}
		});

		Group group = new Group(container, SWT.NONE);
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 5, 1));

		otherParamsButton = new Button(group, SWT.NONE);
		otherParamsButton.setText("Дополнительные параметры");
		otherParamsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String tctext = typeCombo.getText();
				if (!tctext.isEmpty()) {
					InterfaceType itype = InterfaceType.valueOf(typeCombo
							.getText());
					InterfaceParametrsBean params = interfacesBean
							.getParametrs();
					// устанавливаем родительский бин
					params.setInterfacesBean(interfacesBean);
					switch (itype) {
					case GRE:
						GREDialog greDialog = new GREDialog(getShell(), params);
						greDialog.open();
						break;
					case VLAN:
						VLANDialog vlanDialog = new VLANDialog(getShell(),
								params);
						vlanDialog.open();
						break;
					case ODI:
						ODIDialog odiDialog = new ODIDialog(getShell(), params);
						odiDialog.open();
						break;
					case FACTOR:
						FactorDialog factorDialog = new FactorDialog(
								getShell(), params);
						factorDialog.open();
						break;

					default:
						break;
					}
				}
			}
		});

		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("Запретить обработку датаграмм");
		group_1.setLayout(new GridLayout(2, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 5,
				1));

		tunnelButton = new Button(group_1, SWT.CHECK);
		tunnelButton.setText("Не туннелированных");

		transitButton = new Button(group_1, SWT.CHECK);
		transitButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		transitButton.setText("Транзитных");

		dhcpButton = new Button(group_1, SWT.CHECK);
		dhcpButton.setText("DHCP протокола");

		ripButton = new Button(group_1, SWT.CHECK);
		ripButton.setText("RIP протокола");

		multicastButton = new Button(group_1, SWT.CHECK);
		multicastButton.setText("Multicast");

		clusterButton = new Button(group_1, SWT.CHECK);
		clusterButton.setText("Cluster");

		ipButton = new Button(container, SWT.CHECK);
		ipButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1,
				1));
		ipButton.setText("IP статистика");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		proxyButton = new Button(container, SWT.CHECK);
		proxyButton.setText("Прокси ARP");
		proxyButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1));
		new Label(container, SWT.NONE);

		bindData();

		return container;
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

	private void bindData() {
		// контекст датабиндинга
		ctx = new DataBindingContext();
		// имя
		IObservableValue widgetValue = SWTObservables.observeText(nameText,
				SWT.Modify);
		IObservableValue modelValue = BeanProperties.value(InterfaceBean.class,
				"name").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// тип
		widgetValue = ViewersObservables
				.observeSingleSelection(typeComboViewer);
		modelValue = BeanProperties.value("type").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// --
		IConverter typeConverter = new IConverter() {
			public Object convert(Object fromObject) {
				InterfaceType obj = (InterfaceType) fromObject;
				if (obj == InterfaceType.GRE) {
					return false;
				}
				return true;
			}

			public Object getFromType() {
				return InterfaceType.class;
			}

			public Object getToType() {
				return Boolean.class;
			}
		};
		// 1. Observe changes in selection.
		IObservableValue selection = ViewersObservables
				.observeSingleSelection(typeComboViewer);

		// 2. Observe the name property of the current selection.
		IObservableValue detailObservable = BeanProperties.value(
				(Class<?>) selection.getValueType(), "type",
				InterfaceType.class).observeDetail(selection);

		// 3. Bind the Text widget to the name detail (selection's
		// name).
		ctx.bindValue(detailObservable, SWTObservables
				.observeEnabled(timerSpinner),
				new UpdateValueStrategy(true,
						UpdateValueStrategy.POLICY_CONVERT)
						.setConverter(typeConverter), null);

		// --
		// режим активизации
		widgetValue = ViewersObservables
				.observeSingleSelection(modeComboViewer);
		modelValue = BeanProperties.value(InterfaceBean.class, "mode").observe(
				interfacesBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// локальный ip
		widgetValue = WidgetProperties.text(SWT.Modify).observe(localIpText);
		// widgetValue = SWTObservables.observeText(localIpText, SWT.Modify);
		modelValue = BeanProperties.value("ip.local").observe(interfacesBean);
		Binding bindValue = ctx.bindValue(widgetValue, modelValue,
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_ON_REQUEST)
						.setBeforeSetValidator(new IPAddressValidator()), null);
		ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.LEFT);
		// фильтр входящих
		widgetValue = ViewersObservables
				.observeSingleSelection(filterInputComboViewer);
		modelValue = BeanProperties.value("filters.input").observe(
				interfacesBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// удалённый ip
		widgetValue = SWTObservables.observeText(remoteIpText, SWT.Modify);
		modelValue = BeanProperties.value(InterfaceBean.class, "ip.remote")
				.observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// фильтр исходящих
		widgetValue = ViewersObservables
				.observeSingleSelection(filterOutputComboViewer);
		modelValue = BeanProperties.value("filters.output").observe(
				interfacesBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// Таймер неактивности
		widgetValue = SWTObservables.observeSelection(timerSpinner);
		modelValue = BeanProperties.value("timer").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// NAT режим
		widgetValue = ViewersObservables.observeSingleSelection(natComboViewer);
		modelValue = BeanProperties.value("nat").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// MTU
		widgetValue = SWTObservables.observeSelection(mtuSpinner);
		modelValue = BeanProperties.value("mtu").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// Не туннелированных
		modelValue = BeanProperties
				.value(InterfaceBean.class, "disableDatagrams")
				.value("notTunneled").observe(interfacesBean);
		BindHelper.bindCheckButton(ctx, tunnelButton, modelValue);
		// Транзитных
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.forward").observe(interfacesBean);
		BindHelper.bindCheckButton(ctx, transitButton, modelValue);
		// DHCP протокола
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.dhcp").observe(interfacesBean);
		BindHelper.bindCheckButton(ctx, dhcpButton, modelValue);
		// RIP протокола
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.rip").observe(interfacesBean);
		BindHelper.bindCheckButton(ctx, ripButton, modelValue);
		// Multicast
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.multicast").observe(interfacesBean);
		BindHelper.bindCheckButton(ctx, multicastButton, modelValue);
		// Cluster
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.cluster").observe(interfacesBean);
		BindHelper.bindCheckButton(ctx, clusterButton, modelValue);
		// IP статистика
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.ipStat").observe(interfacesBean);
		BindHelper.bindCheckButton(ctx, ipButton, modelValue);
		// Прокси ARP
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.proxyARP").observe(interfacesBean);
		BindHelper.bindCheckButton(ctx, proxyButton, modelValue);

		ObservableListContentProvider contentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(contentProvider);
		// получить список из модели маршрутов
		List<InterfaceRouteBean> routesList = routeModel.getData();
		// извлечь элементы наблюдения
		IObservableSet knownElements = contentProvider.getKnownElements();
		// выставить соответствие в свойствах
		final IObservableMap ips = BeanProperties.value(
				InterfaceRouteBean.class, "ip").observeDetail(knownElements);
		final IObservableMap bitss = BeanProperties.value(
				InterfaceRouteBean.class, "bits").observeDetail(knownElements);
		final IObservableMap gateways = BeanProperties.value(
				InterfaceRouteBean.class, "gateway").observeDetail(
				knownElements);
		final IObservableMap metrics = BeanProperties.value(
				InterfaceRouteBean.class, "metric")
				.observeDetail(knownElements);
		final IObservableMap tags = BeanProperties.value(
				InterfaceRouteBean.class, "tag").observeDetail(knownElements);

		// свойства в массив
		IObservableMap[] maps = { ips, bitss, gateways, metrics, tags };

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
					rv = gateways.get(element).toString();
					break;

				case 2:
					rv = metrics.get(element).toString();
					break;

				case 3:
					rv = tags.get(element).toString();
					break;

				}
				return rv;
			}
		};
		// данные для вьюера
		IObservableList input = Properties.selfList(InterfaceRouteBean.class)
				.observe(routesList);
		tableViewer.setLabelProvider(labelProvider);
		tableViewer.setInput(input);
		ctx.updateTargets();
	}

	@Override
	protected void okPressed() {
		// обновить модели
		ctx.updateModels();
		// сохранить данные модели таблицы маршрутов в бин интерфейса
		List<InterfaceRouteBean> irb = routeModel.getData();
		interfacesBean.getRoutes().setRoute(irb);
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		// загрузить предыдущее состояние маршрутов в модель
		List<InterfaceRouteBean> irb = oldModel.getData();
		interfacesBean.getRoutes().setRoute(irb);
		super.cancelPressed();
	}

	public dionis.beans.InterfaceBean getInterfacesBean() {
		return interfacesBean;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(1114, 447);
	}
}
