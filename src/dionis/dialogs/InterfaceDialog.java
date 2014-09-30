package dionis.dialogs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
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
import dionis.beans.InterfaceBean;
import dionis.beans.InterfaceFiltersBean;
import dionis.beans.InterfaceIPBean;
import dionis.beans.InterfaceParametrsBean;
import dionis.beans.InterfaceRouteBean;
import dionis.beans.InterfaceRoutesBean;
import dionis.models.InterfaceRouteModel;
import dionis.providers.InterfaceRouteLabelProvider;
import dionis.xml.BooleanType;
import dionis.xml.InterfaceModeType;
import dionis.xml.InterfaceNatType;
import dionis.xml.InterfaceType;

public class InterfaceDialog extends Dialog {
	private Text nameText;
	private Text remoteIpText;
	private Combo typeCombo;
	private Combo modeCombo;
	private Combo filterInputCombo;
	private Combo filterOutputCombo;
	private Spinner timerSpinner;
	private Combo natCombo;
	private Spinner mtuSpinner;
	private Button tunnelButton;
	private Button transitButton;
	private Button dhcpButton;
	private Button ripButton;
	private Button multicastButton;
	private Button clusterButton;
	private Button ipButton;
	private Button proxyButton;
	private InterfaceBean interfaceBean;
	private ComboViewer comboViewer;
	private ComboViewer modeComboViewer;
	private ComboViewer filterInputComboViewer;
	private Text localIpText;
	private ComboViewer filterOutputComboViewer;
	private ComboViewer natComboViewer;
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
	private Button otherParamsButton;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public InterfaceDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		/** Установка **/
		setUp();

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

		typeCombo = new Combo(container, SWT.NONE);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gd_combo.widthHint = 201;
		typeCombo.setLayoutData(gd_combo);
		comboViewer = new ComboViewer(typeCombo);
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

		modeCombo = new Combo(container, SWT.NONE);
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
					return iElement.name();
				}
				return super.getText(element);
			}
		});
		modeComboViewer.setInput(Arrays.asList(InterfaceModeType.values()));

		Label lblIp = new Label(container, SWT.NONE);
		lblIp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3,
				1));
		lblIp.setText("Локальный ip адрес");

		localIpText = new Text(container, SWT.NONE);
		localIpText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));

		Label label_4 = new Label(container, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_4.setText("Фильтр входящих");

		filterInputCombo = new Combo(container, SWT.NONE);
		GridData gd_combo_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_3.widthHint = 351;
		filterInputCombo.setLayoutData(gd_combo_3);
		filterInputComboViewer = new ComboViewer(filterInputCombo);
		filterInputComboViewer.setContentProvider(new ArrayContentProvider());
		filterInputComboViewer.setLabelProvider(new LabelProvider());
		// TODO: доделать связь с таблицей фильтров
		// ib
		// comboViewer_2.setInput(new String[] { ib.getFilters().getInput() });

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

		filterOutputCombo = new Combo(container, SWT.NONE);
		GridData gd_combo_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_combo_4.widthHint = 351;
		filterOutputCombo.setLayoutData(gd_combo_4);
		filterOutputComboViewer = new ComboViewer(filterOutputCombo);
		filterOutputComboViewer.setContentProvider(new ArrayContentProvider());
		filterOutputComboViewer.setLabelProvider(new LabelProvider());
		// TODO: доделать связь с таблицей фильтров

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

		natCombo = new Combo(container, SWT.NONE);
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
					return iElement.name();
				}
				return super.getText(element);
			}
		});
		natComboViewer.setInput(Arrays.asList(InterfaceNatType.values()));

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

		/** Таблица **/
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setLabelProvider(new InterfaceRouteLabelProvider());
		tableViewer.setInput(InterfaceRouteModel.getInstance().getDataArray());

		Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("Изменить");

		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (table.getSelection() != null
						&& table.getSelection().length > 0) {
					IStructuredSelection sel = (IStructuredSelection) tableViewer
							.getSelection();
					// выбранный элемент таблицы как бин
					InterfaceRouteBean ibean = (InterfaceRouteBean) sel
							.getFirstElement();
					// индекс бина в списке
					int indx = InterfaceRouteModel.getInstance().getData()
							.indexOf(ibean);
					// создание диалога
					InterfaceRouteDialog dialog = new InterfaceRouteDialog(
							getShell());
					// передача бина диалогу
					dialog.setInterfaceRouteBean(ibean);
					if (dialog.open() == Window.OK) {
						// замена бина в модели по выбранному индексу
						InterfaceRouteModel.getInstance().getData()
								.set(indx, dialog.getInterfaceRouteBean());
						// обновление данных для таблицы
						tableViewer.refresh();
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
						getShell());
				dialog.setInterfaceRouteBean(null);
				if (dialog.open() == Window.OK) {
					// замена бина в модели по выбранному индексу
					InterfaceRouteModel.getInstance().getData()
							.add(dialog.getInterfaceRouteBean());
					// обновление данных для таблицы
					tableViewer.setInput(InterfaceRouteModel.getInstance()
							.getDataArray());
				}
			}
		});

		final MenuItem mntmNewItem_2 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_2.setText("Удалить");

		mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (table.getSelection() != null
						&& table.getSelection().length > 0) {
					IStructuredSelection sel = (IStructuredSelection) tableViewer
							.getSelection();
					// выбранный элемент таблицы как бин
					InterfaceRouteBean ibean = (InterfaceRouteBean) sel
							.getFirstElement();
					InterfaceRouteModel.getInstance().getData().remove(ibean);
					// обновление данных для таблицы
					tableViewer.setInput(InterfaceRouteModel.getInstance()
							.getDataArray());
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

		// bindData();

		getAll();

		return container;
	}

	// private void bindData() {
	// // контекст датабиндинга
	// DataBindingContext ctx = new DataBindingContext();
	// // имя
	// IObservableValue widgetValue = WidgetProperties.text(SWT.Modify)
	// .observe(text);
	// IObservableValue modelValue = BeanProperties.value(InterfaceBean.class,
	// "name").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue);
	// // Тип
	// widgetValue = ViewersObservables.observeSingleSelection(comboViewer);
	// modelValue = BeanProperties.value("type").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue);
	// // режим активизации
	// widgetValue = ViewersObservables.observeSingleSelection(comboViewer_1);
	// modelValue = BeanProperties.value("mode").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue);
	// // локальный ip
	// widgetValue = WidgetProperties.text(SWT.Modify).observe(text_2);
	// modelValue = BeanProperties.value(InterfaceBean.class, "ip.local")
	// .observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue);
	// // фильтр входящих
	// widgetValue = ViewersObservables.observeSingleSelection(comboViewer_2);
	// modelValue =
	// BeanProperties.value("filters.input").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue);
	// // удалённый ip
	// widgetValue = WidgetProperties.text(SWT.Modify).observe(text_1);
	// modelValue = BeanProperties.value(InterfaceBean.class, "ip.remote")
	// .observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue);
	// // фильтр исходящих
	// widgetValue = ViewersObservables.observeSingleSelection(comboViewer_3);
	// modelValue =
	// BeanProperties.value("filters.input").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue);
	// // Таймер неактивности
	// widgetValue = SWTObservables.observeSelection(spinner);
	// modelValue = BeanProperties.value("timer").observe(getInterfaceBean());
	// // NAT режим
	// widgetValue = ViewersObservables.observeSingleSelection(comboViewer_4);
	// modelValue = BeanProperties.value("nat").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue);
	// // MTU
	// widgetValue = SWTObservables.observeSelection(spinner_1);
	// modelValue = BeanProperties.value("mtu").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue);
	// /** **/
	// // Не туннелированных
	// widgetValue = SWTObservables.observeSelection(button);
	// modelValue = BeanProperties.value(InterfaceBean.class,
	// "disableDatagrams.notTunneled").observe(getInterfaceBean());
	// // стратегия для конверсии boolean -> BooleanType
	// UpdateValueStrategy updateValueStrategy = new UpdateValueStrategy()
	// .setConverter(new Boolean2BooleanTypeConverter());
	// // стратегия для обратной конверсии BooleanType -> boolean
	// UpdateValueStrategy updateFromValueStrategy = new UpdateValueStrategy()
	// .setConverter(new BooleanType2BooleanConverter());
	// ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
	// updateFromValueStrategy);
	// // Транзитных
	// widgetValue = SWTObservables.observeSelection(btnCheckButton);
	// modelValue = BeanProperties.value(InterfaceBean.class,
	// "disableDatagrams.forward").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
	// updateFromValueStrategy);
	// // DHCP протокола
	// widgetValue = SWTObservables.observeSelection(btnCheckButton_1);
	// modelValue = BeanProperties.value(InterfaceBean.class,
	// "disableDatagrams.dhcp").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
	// updateFromValueStrategy);
	// // RIP протокола
	// widgetValue = SWTObservables.observeSelection(btnCheckButton_2);
	// modelValue = BeanProperties.value(InterfaceBean.class,
	// "disableDatagrams.rip").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
	// updateFromValueStrategy);
	// // Multicast
	// widgetValue = SWTObservables.observeSelection(btnCheckButton_3);
	// modelValue = BeanProperties.value(InterfaceBean.class,
	// "disableDatagrams.multicast").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
	// updateFromValueStrategy);
	// // Cluster
	// widgetValue = SWTObservables.observeSelection(btnCheckButton_4);
	// modelValue = BeanProperties.value(InterfaceBean.class,
	// "disableDatagrams.cluster").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
	// updateFromValueStrategy);
	// // IP статистика
	// widgetValue = SWTObservables.observeSelection(btnIp);
	// modelValue = BeanProperties.value(InterfaceBean.class,
	// "disableDatagrams.ipStat").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
	// updateFromValueStrategy);
	// // Прокси ARP
	// widgetValue = SWTObservables.observeSelection(btnCheckButton_5);
	// modelValue = BeanProperties.value(InterfaceBean.class,
	// "disableDatagrams.proxyARP").observe(getInterfaceBean());
	// ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
	// updateFromValueStrategy);
	// ObservableListContentProvider contentProvider = new
	// ObservableListContentProvider();
	// tableViewer.setContentProvider(contentProvider);
	//
	// List<InterfaceRouteBean> routesList = ib.getRoutes().getRoute();
	// IObservableSet knownElements = contentProvider.getKnownElements();
	// final IObservableMap ips = BeanProperties.value(
	// InterfaceRouteBean.class, "ip").observeDetail(knownElements);
	// final IObservableMap bitss = BeanProperties.value(
	// InterfaceRouteBean.class, "bits").observeDetail(knownElements);
	// final IObservableMap gateways = BeanProperties.value(
	// InterfaceRouteBean.class, "gateway").observeDetail(
	// knownElements);
	// final IObservableMap metrics = BeanProperties.value(
	// InterfaceRouteBean.class, "metric")
	// .observeDetail(knownElements);
	// final IObservableMap tags = BeanProperties.value(
	// InterfaceRouteBean.class, "tag").observeDetail(knownElements);
	//
	// IObservableMap[] maps = { ips, bitss, gateways, metrics, tags };
	//
	// ILabelProvider labelProvider = new ObservableMapLabelProvider(maps) {
	// @Override
	// public String getColumnText(Object element, int columnIndex) {
	// String rv = "";
	// switch (columnIndex) {
	// case 0:
	// rv = ips.get(element).toString() + "/"
	// + bitss.get(element).toString();
	// break;
	// case 1:
	// rv = gateways.get(element).toString();
	// break;
	//
	// case 2:
	// rv = metrics.get(element).toString();
	// break;
	//
	// case 3:
	// rv = tags.get(element).toString();
	// break;
	//
	// }
	// return rv;
	// }
	// };
	//
	// IObservableList input = Properties.selfList(InterfaceRouteBean.class)
	// .observe(routesList);
	//
	// tableViewer.setLabelProvider(labelProvider);
	// tableViewer.setInput(input);
	// }

	private void setUp() {
		if (interfaceBean == null) {
			InterfaceRouteModel.getInstance().removeAll();
			System.out.println("clean");
		} else {
			InterfaceRouteModel.getInstance().setData(
					interfaceBean.getRoutes().getRoute());
		}
	}

	private void getAll() {
		if (interfaceBean == null) {
			// новый экземпляр бина
			setInterfaceBean(new InterfaceBean());
			InterfaceIPBean ipb = new InterfaceIPBean();
			getInterfaceBean().setIp(ipb);
			InterfaceFiltersBean filtersBean = new InterfaceFiltersBean();
			getInterfaceBean().setFilters(filtersBean);
			DisableDatagramsBean datagramsBean = new DisableDatagramsBean();
			datagramsBean.setNotTunneled(BooleanType.YES);
			datagramsBean.setForward(BooleanType.YES);
			getInterfaceBean().setDisableDatagrams(datagramsBean);
			InterfaceRoutesBean routes = new InterfaceRoutesBean();
			LinkedList<InterfaceRouteBean> route = new LinkedList<InterfaceRouteBean>();
			routes.setRoute(route);
			getInterfaceBean().setRoutes(routes);
		} else {
			nameText.setText(interfaceBean.getName());
			typeCombo.select((interfaceBean.getType() != null) ? interfaceBean
					.getType().ordinal() : 0);
			modeCombo.select((interfaceBean.getMode() != null) ? interfaceBean
					.getMode().ordinal() : 0);
			localIpText.setText(interfaceBean.getIp().getLocal());
			remoteIpText.setText(interfaceBean.getIp().getRemote());
			// TODO: !!!
			// filterInputCombo.select(index)
			timerSpinner.setSelection(interfaceBean.getTimer());
			natCombo.select((interfaceBean.getNat() != null) ? interfaceBean
					.getNat().ordinal() : 0);
			mtuSpinner.setSelection(interfaceBean.getMtu());
			// TODO !!!
			// params???
			DisableDatagramsBean datagrams = interfaceBean
					.getDisableDatagrams();
			tunnelButton
					.setSelection(datagrams.getNotTunneled() == BooleanType.YES ? true
							: false);
			transitButton
					.setSelection(datagrams.getForward() == BooleanType.YES ? true
							: false);
			dhcpButton
					.setSelection(datagrams.getDhcp() == BooleanType.YES ? true
							: false);
			ripButton.setSelection(datagrams.getRip() == BooleanType.YES ? true
					: false);
			multicastButton
					.setSelection(datagrams.getMulticast() == BooleanType.YES ? true
							: false);
			clusterButton
					.setSelection(datagrams.getCluster() == BooleanType.YES ? true
							: false);
			ipButton.setSelection(datagrams.getIpStat() == BooleanType.YES ? true
					: false);
			proxyButton
					.setSelection(datagrams.getProxyARP() == BooleanType.YES ? true
							: false);
		}
	}

	@Override
	protected void okPressed() {
		interfaceBean.setName(nameText.getText());
		if (typeCombo.getSelectionIndex() != -1) {
			interfaceBean.setType(Arrays.asList(InterfaceType.values()).get(
					typeCombo.getSelectionIndex()));
		}
		if (modeCombo.getSelectionIndex() != -1) {
			interfaceBean.setMode(Arrays.asList(InterfaceModeType.values())
					.get(modeCombo.getSelectionIndex()));
		}
		InterfaceIPBean ipbean = new InterfaceIPBean();
		ipbean.setLocal(localIpText.getText());
		ipbean.setRemote(remoteIpText.getText());
		interfaceBean.setIp(ipbean);
		InterfaceFiltersBean filters = new InterfaceFiltersBean();
		filters.setInput(filterInputCombo.getText());
		filters.setOutput(filterOutputCombo.getText());
		interfaceBean.setFilters(filters);
		interfaceBean.setTimer(timerSpinner.getSelection());
		if (natCombo.getSelectionIndex() != -1) {
			interfaceBean.setNat(Arrays.asList(InterfaceNatType.values()).get(
					natCombo.getSelectionIndex()));
		}
		interfaceBean.setMtu((short) mtuSpinner.getSelection());
		InterfaceRoutesBean routes = new InterfaceRoutesBean();
		routes.setRoute(InterfaceRouteModel.getInstance().getData());
		interfaceBean.setRoutes(routes);
		InterfaceParametrsBean params = new InterfaceParametrsBean();
		interfaceBean.setParametrs(params);
		DisableDatagramsBean disableDatagrams = new DisableDatagramsBean();
		disableDatagrams
				.setNotTunneled(tunnelButton.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		disableDatagrams
				.setForward(transitButton.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		disableDatagrams
				.setDhcp(dhcpButton.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		disableDatagrams
				.setRip(ripButton.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		disableDatagrams
				.setMulticast(multicastButton.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		disableDatagrams
				.setCluster(clusterButton.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		disableDatagrams
				.setIpStat(ipButton.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		disableDatagrams
				.setProxyARP(proxyButton.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		interfaceBean.setDisableDatagrams(disableDatagrams);
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

	public InterfaceBean getInterfaceBean() {
		return interfaceBean;
	}

	public void setInterfaceBean(InterfaceBean interfaceBean) {
		this.interfaceBean = interfaceBean;
	}
}
