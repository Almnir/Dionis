package dionis.views;

import java.util.TimeZone;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;

import dionis.beans.InterfaceBean;
import dionis.beans.InterfaceRouteBean;
import dionis.dialogs.InterfaceDialog;
import dionis.dialogs.InterfaceRouteDialog;
import dionis.dialogs.TunnelDialog;
import dionis.formatters.TimeZoneTimeFormatter;
import dionis.models.DionisXAO;
import dionis.models.InterfaceModel;
import dionis.models.InterfaceRouteModel;
import dionis.models.TunnelModel;
import dionis.providers.InterfaceLableProvider;
import dionis.providers.TunnelFilterLableProvider;
import dionis.providers.TunnelLableProvider;
import dionis.utils.Constants;
import dionis.xml.ARP;
import dionis.xml.ARPTableStatic;
import dionis.xml.BaseConsts;
import dionis.xml.BooleanType;
import dionis.xml.Dionis;
import dionis.xml.Global;
import dionis.xml.Host;
import dionis.xml.Level;
import dionis.xml.Local;
import dionis.xml.NAT;
import dionis.xml.NATTableStatic;
import dionis.xml.Parametrs;
import dionis.xml.Password;
import dionis.xml.Ports;
import dionis.xml.RemoteControl;
import dionis.xml.SIO;
import dionis.xml.SYN;
import dionis.xml.TimeService;
import dionis.xml.Tracing;
import dionis.xml.TracingRoute;
import dionis.xml.TracingServers;
import dionis.xml.Tunnel;
import dionis.xml.Type;

/**
 * Класс отображения плагина управления Dionis
 * 
 * @author Ярных А.О.
 * 
 */
public class DionisView extends ViewPart {

	public static final String ID = "dionis.views.DionisView";
	private CTabFolder tabFolder;
	private Shell shell;
	private TableViewer table;
	private Text text;
	private Spinner spinner;
	private Spinner spinner_1;
	private Spinner spinner_2;
	private Spinner spinner_3;
	private Spinner spinner_4;
	private Spinner spinner_5;
	private Combo combo_6;
	private Spinner spinner_7;
	private Button btnCheckButton_2;
	private Button btnCheckButton_1;
	private Button btnCheckButton;
	private Text text_1;
	private Spinner spinner_9;
	private Spinner spinner_8;
	private TableViewer table_1;
	private Button btnArp;
	private Button btnEthernet;
	private Button btnCheckButton_3;
	private Button btnSlipppp;
	private Button btnCheckButton_4;
	private Button btnCheckButton_5;
	private Button btnCheckButton_6;
	private Button btnCheckButton_7;
	private Button btnCheckButton_8;
	private Button btnCheckButton_12;
	private Button btnCheckButton_13;
	private Button btnTelnetd;
	private Button btnCheckButton_14;
	private Button btnRip;
	private Button btnHttpgw;
	private Button btnCheckButton_15;
	private Button btnCheckButton_17;
	private Button btnCheckButton_18;
	private Button btnCheckButton_19;
	private Button btnCheckButton_22;
	private Button btnDns;
	private Button btnCheckButton_23;
	private Button button;
	private Button btnCheckButton_9;
	private Button btnCheckButton_10;
	private Button btnCheckButton_11;
	private Text text_2;
	private Text text_3;
	private Combo combo_1;
	private Button btnCheckButton_24;
	private List list;
	private Text text_4;
	private Text text_5;
	private Combo combo_2;
	private Combo combo_3;
	private Button btnCheckButton_25;
	private Button btnCheckButton_26;
	private Button btnCheckButton_27;
	private Button btnCheckButton_28;
	private Combo combo_4;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Table table_2;
	private Table table_3;

	public DionisView() {
		super();
	}

	public void createPartControl(Composite parent) {
		parent.setVisible(true);

		shell = parent.getShell();

		parent.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1);
		gd_composite.heightHint = 113;
		gd_composite.widthHint = 582;
		composite.setLayoutData(gd_composite);

		Composite composite_4 = new Composite(composite, SWT.NONE);
		composite_4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				1, 1));
		composite_4.setLayout(new GridLayout(1, false));

		final Combo combo = new Combo(composite_4, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		String items[] = { "Параметры", "Сетевые настройки" };
		combo.setItems(items);
		combo.select(0);

		//
		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (combo.getSelectionIndex() == 0) {
					cleanTabs();
//					createCommonSettingsTabs();
					tabFolder.setSelection(0);
				} else if (combo.getSelectionIndex() == 1) {
					cleanTabs();
					createNetSettingsTabs();
					tabFolder.setSelection(0);
				}
			}
		});

		Composite composite_3 = new Composite(composite, SWT.NONE);
		composite_3.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
				1, 1));

		Composite composite_1 = new Composite(composite, SWT.NONE);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.TOP, true, false,
				1, 1);
		gd_composite_1.widthHint = 141;
		composite_1.setLayoutData(gd_composite_1);

		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setLayout(new GridLayout(1, false));
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, true, true,
				3, 1);
		gd_composite_2.widthHint = 331;
		composite_2.setLayoutData(gd_composite_2);

		tabFolder = new CTabFolder(composite_2, SWT.BORDER);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		cleanTabs();
		tabFolder.setVisible(true);
		tabFolder.setEnabled(true);
//		createCommonSettingsTabs();
		createNetSettingsTabs();
		tabFolder.setSelection(1);
	}

	private void cleanTabs() {
		CTabItem[] items = tabFolder.getItems();
		for (CTabItem item : items) {
			item.dispose();
		}
	}

//	@SuppressWarnings("unused")
//	private void createCommonSettingsTabs() {
//		CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE);
//		tabItem.setText("Порты");
//
//		Composite composite_4 = new Composite(tabFolder, SWT.NONE);
//		tabItem.setControl(composite_4);
//		composite_4.setLayout(new GridLayout(1, false));
//
//		table = new TableViewer(composite_4, SWT.BORDER | SWT.FULL_SELECTION
//				| SWT.SINGLE);
//
//		table.getTable().setLayoutData(
//				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		table.getTable().setHeaderVisible(true);
//		table.getTable().setLinesVisible(true);
//
//		Menu menu = new Menu(table.getTable());
//
//		MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
//		menuItem.setText("Изменить");
//		table.getTable().setMenu(menu);
//
//		menuItem.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				// если выбрана строка
//				if (table.getTable().getSelection() != null
//						&& table.getTable().getSelection().length > 0) {
//					// если не SYN порт выбран
//					if (!table.getTable().getSelection()[0].getText().contains(
//							"SYN")) {
//						PortConfigurationDialog dialog = new PortConfigurationDialog(
//								shell, table.getSelection());
//						if (dialog.open() == Window.OK) {
//							Job job = new Job("ports") {
//
//								@Override
//								protected IStatus run(IProgressMonitor monitor) {
//									Display.getDefault().asyncExec(
//											new Runnable() {
//												@Override
//												public void run() {
//													table.setInput(PortsModel
//															.getInstance()
//															.getAllPorts());
//												}
//											});
//									return Status.OK_STATUS;
//								}
//							};
//							job.setPriority(Job.SHORT);
//							job.schedule();
//						}
//					}
//				}
//			}
//		});
//
//		TableViewerColumn tblclmnNewColumn = new TableViewerColumn(table,
//				SWT.NONE);
//
//		tblclmnNewColumn.getColumn().setWidth(100);
//		tblclmnNewColumn.getColumn().setText("Порт");
//
//		TableViewerColumn tblclmnNewColumn_1 = new TableViewerColumn(table,
//				SWT.NONE);
//		tblclmnNewColumn_1.getColumn().setWidth(100);
//		tblclmnNewColumn_1.getColumn().setText("Настройка");
//
//		table.setContentProvider(ArrayContentProvider.getInstance());
//		table.setLabelProvider(new PortLabelProvider());
//		// == тест
//		SIO sio = new SIO();
//		SIO sio2 = new SIO();
//		sio.setBits((byte) 8);
//		sio.setControl(PortsSIOControlType.RTS_CTS);
//		sio.setDirection(PortsSIODirectionType.DYNAMIC);
//		// sio.setNumber((short)0);
//		sio.setParity(PortsSIOParityType.NONE);
//		sio.setSpeed((float) 75.0);
//		sio.setStopBit((float) 1.5);
//		SYN syn = new SYN();
//		syn.setNumber((byte) 0);
//		java.util.List<SIO> sioList = new ArrayList<>();
//		sioList.add(sio);
//		sioList.add(sio2);
//		java.util.List<SYN> synList = new ArrayList<>();
//		synList.add(syn);
//		PortsModel.getInstance().setAllPorts(sioList, synList);
//		// == тест
//		table.setInput(PortsModel.getInstance().getAllPorts());
//		table.getTable().select(0);
//
//		CTabItem tabItem_1 = new CTabItem(tabFolder, SWT.NONE);
//		tabItem_1.setText("Базовые константы");
//
//		Composite composite_5 = new Composite(tabFolder, SWT.NONE);
//		tabItem_1.setControl(composite_5);
//		composite_5.setLayout(new GridLayout(1, false));
//
//		Group group = new Group(composite_5, SWT.NONE);
//		GridData gd_group = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
//		gd_group.heightHint = 228;
//		group.setLayoutData(gd_group);
//		group.setLayout(new GridLayout(4, false));
//
//		Label label = new Label(group, SWT.NONE);
//		label.setText("Адрес узла");
//
//		Label label_8 = new Label(group, SWT.NONE);
//		label_8.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false,
//				1, 1));
//		new Label(group, SWT.NONE);
//
//		text = new Text(group, SWT.BORDER | SWT.LEFT);
//		// IPAddressBox text = new IPAddressBox(group, false);
//		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//
//		Label lblNewLabel = new Label(group, SWT.NONE);
//		lblNewLabel.setText("Время жизни IP датаграмм");
//
//		Label label_9 = new Label(group, SWT.NONE);
//		new Label(group, SWT.NONE);
//
//		spinner = new Spinner(group, SWT.BORDER);
//		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
//				1, 1));
//		spinner.setMinimum(1);
//		spinner.setMaximum(255);
//
//		Label lblTcp = new Label(group, SWT.NONE);
//		lblTcp.setText("Макс. размер TCP пакета(MSS)");
//
//		Label lblNewLabel_12 = new Label(group, SWT.NONE);
//		new Label(group, SWT.NONE);
//
//		// Макс. размер TCP пакета(MSS)
//		spinner_1 = new Spinner(group, SWT.BORDER);
//		spinner_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 1, 1));
//		spinner_1.setMinimum(512);
//		spinner_1.setMaximum(8192);
//
//		Label lblNewLabel_1 = new Label(group, SWT.NONE);
//		lblNewLabel_1.setText("Размер TCP окна");
//
//		Label lblNewLabel_13 = new Label(group, SWT.NONE);
//		new Label(group, SWT.NONE);
//
//		// Размер TCP окна
//		spinner_2 = new Spinner(group, SWT.BORDER);
//		spinner_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 1, 1));
//		spinner_2.setMinimum(0);
//		spinner_2.setMaximum(65535);
//
//		Label lblNewLabel_2 = new Label(group, SWT.NONE);
//		lblNewLabel_2.setText("Количество TCB блоков");
//
//		Label lblNewLabel_14 = new Label(group, SWT.NONE);
//		new Label(group, SWT.NONE);
//
//		// Количество TCB блоков
//		spinner_3 = new Spinner(group, SWT.BORDER);
//		spinner_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 1, 1));
//		spinner_3.setMinimum(16);
//		spinner_3.setMaximum(450);
//
//		Label lblNewLabel_3 = new Label(group, SWT.NONE);
//		lblNewLabel_3.setText("Размер буфера TCB блока");
//
//		Label lblNewLabel_15 = new Label(group, SWT.NONE);
//		new Label(group, SWT.NONE);
//
//		// Размер буфера TCB блока
//		spinner_4 = new Spinner(group, SWT.BORDER);
//		spinner_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 1, 1));
//		spinner_4.setMinimum(8);
//		spinner_4.setMaximum(64);
//
//		Label lblNewLabel_4 = new Label(group, SWT.NONE);
//		lblNewLabel_4.setText("Количество proxy-буферов");
//
//		Label lblNewLabel_16 = new Label(group, SWT.NONE);
//		new Label(group, SWT.NONE);
//
//		// Количество proxy-буферов
//		spinner_5 = new Spinner(group, SWT.BORDER);
//		spinner_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 1, 1));
//		spinner_5.setMinimum(8);
//		spinner_5.setMaximum(255);
//
//		Group group_1 = new Group(composite_5, SWT.NONE);
//		group_1.setText("Кластер");
//		group_1.setLayout(new GridLayout(2, false));
//		GridData gd_group_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
//		gd_group_1.heightHint = 84;
//		gd_group_1.widthHint = 548;
//		group_1.setLayoutData(gd_group_1);
//
//		Label lblNewLabel_5 = new Label(group_1, SWT.NONE);
//		lblNewLabel_5.setText("Режим работы");
//
//		combo_6 = new Combo(group_1, SWT.READ_ONLY);
//		GridData gd_combo_6 = new GridData(SWT.LEFT, SWT.CENTER, true, false,
//				1, 1);
//		gd_combo_6.widthHint = 173;
//		combo_6.setLayoutData(gd_combo_6);
//
//		combo_6.setItems(Constants.CLUSTER_MODE);
//		combo_6.select(Constants.CLUSTER_MODE.length / 2);
//
//		Label lblNewLabel_6 = new Label(group_1, SWT.NONE);
//		lblNewLabel_6.setText("Таймер");
//
//		// Таймер
//		spinner_7 = new Spinner(group_1, SWT.BORDER);
//		GridData gd_spinner_7 = new GridData(SWT.LEFT, SWT.CENTER, true, false,
//				1, 1);
//		gd_spinner_7.widthHint = 51;
//		spinner_7.setLayoutData(gd_spinner_7);
//
//		spinner_7.setMinimum(0);
//		spinner_7.setMaximum(60);
//
//		CTabItem tbtmNewItem_1 = new CTabItem(tabFolder, SWT.NONE);
//		tbtmNewItem_1.setText("Трансляция адресов NAT");
//
//		Composite composite_6 = new Composite(tabFolder, SWT.NONE);
//		tbtmNewItem_1.setControl(composite_6);
//		composite_6.setLayout(new GridLayout(1, false));
//
//		Group group_2 = new Group(composite_6, SWT.NONE);
//		GridData gd_group_2 = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
//		gd_group_2.widthHint = 545;
//		gd_group_2.heightHint = 90;
//		group_2.setLayoutData(gd_group_2);
//		group_2.setText("Адрес перегрузки");
//		group_2.setLayout(new GridLayout(2, false));
//
//		btnCheckButton = new Button(group_2, SWT.RADIO);
//		btnCheckButton.setText("Не установлен");
//		new Label(group_2, SWT.NONE);
//
//		btnCheckButton_1 = new Button(group_2, SWT.RADIO);
//		btnCheckButton_1.setText("Автоматический");
//		new Label(group_2, SWT.NONE);
//
//		btnCheckButton_2 = new Button(group_2, SWT.RADIO);
//		btnCheckButton_2.setText("Фиксированный");
//
//		text_1 = new Text(group_2, SWT.BORDER);
//		// final IPAddressBox text_1 = new IPAddressBox(group_2, false);
//		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, false, false,
//				1, 1);
//		gd_text_1.widthHint = 197;
//		text_1.setLayoutData(gd_text_1);
//		text_1.setText("0.0.0.0");
//
//		// не установлен
//		btnCheckButton.addListener(SWT.Selection, new Listener() {
//			@Override
//			public void handleEvent(Event event) {
//				if (text_1 != null) {
//					text_1.setEnabled(false);
//				}
//			}
//		});
//		// автоматический
//		btnCheckButton_1.addListener(SWT.Selection, new Listener() {
//			@Override
//			public void handleEvent(Event event) {
//				if (text_1 != null) {
//					text_1.setText("1.1.1.1");
//					text_1.setEnabled(false);
//				}
//			}
//		});
//		// Фиксированный
//		btnCheckButton_2.addListener(SWT.Selection, new Listener() {
//			@Override
//			public void handleEvent(Event event) {
//				if (text_1 != null) {
//					text_1.setText("1.1.1.1");
//					text_1.setEnabled(true);
//				}
//			}
//		});
//
//		// Трансляция адресов NAT
//		Composite composite_7 = new Composite(composite_6, SWT.NONE);
//		composite_7.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
//				1, 1));
//		composite_7.setLayout(new GridLayout(2, false));
//
//		Label lblNewLabel_17 = new Label(composite_7, SWT.NONE);
//		lblNewLabel_17.setText("Ограничение сессий для одного абонента");
//
//		spinner_8 = new Spinner(composite_7, SWT.BORDER);
//		GridData gd_spinner_8 = new GridData(SWT.RIGHT, SWT.CENTER, true,
//				false, 1, 1);
//		gd_spinner_8.widthHint = 100;
//		spinner_8.setLayoutData(gd_spinner_8);
//		spinner_8.setMinimum(0);
//		spinner_8.setMaximum(65535);
//
//		Label lblNewLabel_7 = new Label(composite_7, SWT.NONE);
//		lblNewLabel_7.setText("Размер рабочей NAT таблицы в блоках");
//
//		spinner_9 = new Spinner(composite_7, SWT.BORDER);
//		GridData gd_spinner_9 = new GridData(SWT.RIGHT, SWT.CENTER, true,
//				false, 1, 1);
//		gd_spinner_9.widthHint = 100;
//		spinner_9.setLayoutData(gd_spinner_9);
//		spinner_9.setMinimum(1);
//		spinner_9.setMaximum(32);
//
//		Label lblNat = new Label(composite_7, SWT.NONE);
//		lblNat.setText("Статическая NAT таблица");
//		new Label(composite_7, SWT.NONE);
//
//		Composite composite_8 = new Composite(composite_6, SWT.NONE);
//		composite_8.setLayout(new GridLayout(1, false));
//		composite_8.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
//				1, 1));
//
//		table_1 = new TableViewer(composite_8, SWT.BORDER | SWT.FULL_SELECTION);
//		table_1.getTable().setLayoutData(
//				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		table_1.getTable().setHeaderVisible(true);
//		table_1.getTable().setLinesVisible(true);
//
//		Menu menu_1 = new Menu(table_1.getTable());
//		table_1.getTable().setMenu(menu_1);
//
//		final MenuItem menuItem1_1 = new MenuItem(menu_1, SWT.NONE);
//		menuItem1_1.setText("Изменить");
//		final MenuItem menuItem1_2 = new MenuItem(menu_1, SWT.NONE);
//		menuItem1_2.setText("Добавить");
//		final MenuItem menuItem1_3 = new MenuItem(menu_1, SWT.NONE);
//		menuItem1_3.setText("Удалить");
//
//		menu_1.addListener(SWT.Show, new Listener() {
//			@Override
//			public void handleEvent(Event event) {
//				TableItem[] selected = table_1.getTable().getSelection();
//				if (selected.length == 0) {
//					menuItem1_1.setEnabled(false);
//					menuItem1_2.setEnabled(true);
//					menuItem1_3.setEnabled(false);
//				} else {
//					menuItem1_1.setEnabled(true);
//					menuItem1_2.setEnabled(true);
//					menuItem1_3.setEnabled(true);
//				}
//			}
//		});
//
//		// Изменить
//		menuItem1_1.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				// если выбрана строка
//				if (table_1.getTable().getSelection() != null
//						&& table_1.getTable().getSelection().length > 0) {
//					NATAddressDialog dialog = new NATAddressDialog(shell,
//							table_1.getSelection());
//					if (dialog.open() == Window.OK) {
//						Job job = new Job("change") {
//
//							@Override
//							protected IStatus run(IProgressMonitor monitor) {
//								Display.getDefault().asyncExec(new Runnable() {
//									@Override
//									public void run() {
//										table_1.setInput(NATAddressModel
//												.getInstance()
//												.getNatTableArray());
//									}
//								});
//								return Status.OK_STATUS;
//							}
//						};
//						job.setPriority(Job.SHORT);
//						job.schedule();
//					}
//				}
//
//			}
//		});
//		// Добавить
//		menuItem1_2.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				NATAddressDialog dialog = new NATAddressDialog(shell, null);
//				if (dialog.open() == Window.OK) {
//					Job job = new Job("add") {
//
//						@Override
//						protected IStatus run(IProgressMonitor monitor) {
//							Display.getDefault().asyncExec(new Runnable() {
//								@Override
//								public void run() {
//									table_1.setInput(NATAddressModel
//											.getInstance().getNatTableArray());
//								}
//							});
//							return Status.OK_STATUS;
//						}
//					};
//					job.setPriority(Job.SHORT);
//					job.schedule();
//				}
//			}
//		});
//		// Удалить
//		menuItem1_3.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				IStructuredSelection sel = (IStructuredSelection) table_1
//						.getSelection();
//				NATTableStatic natTable = (NATTableStatic) sel
//						.getFirstElement();
//				NATAddressModel.getInstance().removeNatTable(natTable);
//				Job job = new Job("remove") {
//
//					@Override
//					protected IStatus run(IProgressMonitor monitor) {
//						Display.getDefault().asyncExec(new Runnable() {
//							@Override
//							public void run() {
//								table_1.setInput(NATAddressModel.getInstance()
//										.getNatTableArray());
//							}
//						});
//						return Status.OK_STATUS;
//					}
//				};
//				job.setPriority(Job.SHORT);
//				job.schedule();
//			}
//		});
//
//		TableColumn tableColumn = new TableColumn(table_1.getTable(), SWT.NONE);
//		tableColumn.setWidth(100);
//		tableColumn.setText("Внутренний адрес");
//
//		TableColumn tblclmnNewColumn_2 = new TableColumn(table_1.getTable(),
//				SWT.NONE);
//		tblclmnNewColumn_2.setWidth(100);
//		tblclmnNewColumn_2.setText("Внешний адрес");
//
//		table_1.setContentProvider(ArrayContentProvider.getInstance());
//		table_1.setLabelProvider(new NATLabelProvider());
//		table_1.setInput(NATAddressModel.getInstance().getNatTableArray());
//
//		CTabItem tbtmNewItem_4 = new CTabItem(tabFolder, SWT.NONE);
//		tbtmNewItem_4.setText("Удалённое управление");
//
//		Composite composite_12 = new Composite(tabFolder, SWT.NONE);
//		tbtmNewItem_4.setControl(composite_12);
//		composite_12.setLayout(new GridLayout(3, false));
//
//		Label label_1 = new Label(composite_12, SWT.NONE);
//		label_1.setText("Имя абонента");
//
//		text_2 = new Text(composite_12, SWT.BORDER);
//		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
//				1));
//
//		Label lblNewLabel_8 = new Label(composite_12, SWT.NONE);
//		lblNewLabel_8.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
//				false, 1, 1));
//		lblNewLabel_8.setText("Ключи");
//
//		Label label_2 = new Label(composite_12, SWT.NONE);
//		label_2.setText("Доп. пароль");
//
//		text_3 = new Text(composite_12, SWT.BORDER);
//		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
//				1));
//
//		list = new List(composite_12, SWT.BORDER);
//		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));
//
//		Label label_3 = new Label(composite_12, SWT.NONE);
//		label_3.setText("Режим");
//
//		combo_1 = new Combo(composite_12, SWT.NONE);
//		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
//				1, 1));
//		combo_1.setItems(Constants.REMOTE_MODE);
//		combo_1.select(Constants.REMOTE_MODE.length / 2);
//
//		btnCheckButton_24 = new Button(composite_12, SWT.CHECK);
//		btnCheckButton_24.setText("Разрешена перезагрузка");
//		new Label(composite_12, SWT.NONE);
//
//		Group group_8 = new Group(composite_12, SWT.NONE);
//		group_8.setText("Ограничения на обмен файлами");
//		group_8.setLayout(new GridLayout(2, false));
//		group_8.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3,
//				1));
//
//		Label label_4 = new Label(group_8, SWT.NONE);
//		label_4.setText("Передача");
//
//		text_4 = new Text(group_8, SWT.BORDER);
//		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
//				1, 1));
//
//		Label label_5 = new Label(group_8, SWT.NONE);
//		label_5.setText("Приём");
//
//		text_5 = new Text(group_8, SWT.BORDER);
//		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
//				1, 1));
//
//		CTabItem tbtmNewItem = new CTabItem(tabFolder, SWT.NONE);
//		tbtmNewItem.setText("ARP");
//
//		Composite composite_9 = new Composite(tabFolder, SWT.NONE);
//		tbtmNewItem.setControl(composite_9);
//		composite_9.setLayout(new GridLayout(1, false));
//
//		btnArp = new Button(composite_9, SWT.CHECK);
//		btnArp.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 1, 1));
//		btnArp.setText("Разрешить proxy-ARP");
//
//		Group grpArp = new Group(composite_9, SWT.NONE);
//		grpArp.setText("Статическая ARP таблица");
//		grpArp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		grpArp.setLayout(new GridLayout(1, false));
//
//		final TableViewer tableViewer = new TableViewer(grpArp, SWT.BORDER
//				| SWT.FULL_SELECTION);
//		table_2 = tableViewer.getTable();
//		table_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		table_2.setHeaderVisible(true);
//
//		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
//				tableViewer, SWT.NONE);
//		TableColumn tblclmnNewColumn_23 = tableViewerColumn_1.getColumn();
//		tblclmnNewColumn_23.setWidth(100);
//		tblclmnNewColumn_23.setText("MAC адрес");
//
//		TableViewerColumn tableViewerColumn = new TableViewerColumn(
//				tableViewer, SWT.NONE);
//		TableColumn tblclmnNewColumn_22 = tableViewerColumn.getColumn();
//		tblclmnNewColumn_22.setWidth(100);
//		tblclmnNewColumn_22.setText("IP адрес");
//
//		Menu menu_2 = new Menu(table_2);
//		table_2.setMenu(menu_2);
//
//		tableViewer.setContentProvider(new ArrayContentProvider());
//		tableViewer.setLabelProvider(new ARPLabelProvider());
//		tableViewer.setInput(ARPModel.getInstance().getAllARPArray());
//
//		final MenuItem mntmNewItem = new MenuItem(menu_2, SWT.NONE);
//		mntmNewItem.setText("Изменить");
//		// Изменить
//		mntmNewItem.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				if (table_2.getSelection() != null
//						&& table_2.getSelection().length > 0) {
//					IStructuredSelection sel = (IStructuredSelection) tableViewer
//							.getSelection();
//					ARPElementDialog dialog = new ARPElementDialog(shell, sel);
//					if (dialog.open() == Window.OK) {
//						Job job = new Job("change") {
//
//							@Override
//							protected IStatus run(IProgressMonitor monitor) {
//								Display.getDefault().asyncExec(new Runnable() {
//									@Override
//									public void run() {
//										tableViewer
//												.setInput(ARPModel
//														.getInstance()
//														.getAllARPArray());
//									}
//								});
//								return Status.OK_STATUS;
//							}
//						};
//						job.setPriority(Job.SHORT);
//						job.schedule();
//
//					}
//				}
//			}
//		});
//
//		final MenuItem mntmNewItem_1 = new MenuItem(menu_2, SWT.NONE);
//		mntmNewItem_1.setText("Добавить");
//
//		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				ARPElementDialog dialog = new ARPElementDialog(shell, null);
//				if (dialog.open() == Window.OK) {
//					Job job = new Job("add") {
//
//						@Override
//						protected IStatus run(IProgressMonitor monitor) {
//							Display.getDefault().asyncExec(new Runnable() {
//								@Override
//								public void run() {
//									tableViewer.setInput(ARPModel.getInstance()
//											.getAllARPArray());
//								}
//							});
//							return Status.OK_STATUS;
//						}
//					};
//					job.setPriority(Job.SHORT);
//					job.schedule();
//
//				}
//			}
//		});
//
//		final MenuItem mntmNewItem_2 = new MenuItem(menu_2, SWT.NONE);
//		mntmNewItem_2.setText("Удалить");
//
//		mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				IStructuredSelection sel = (IStructuredSelection) tableViewer
//						.getSelection();
//				String[] data = (String[]) sel.getFirstElement();
//				ARPModel.getInstance().removeARP(data);
//				Job job = new Job("remove") {
//
//					@Override
//					protected IStatus run(IProgressMonitor monitor) {
//						Display.getDefault().asyncExec(new Runnable() {
//							@Override
//							public void run() {
//								tableViewer.setInput(ARPModel.getInstance()
//										.getAllARPArray());
//							}
//						});
//						return Status.OK_STATUS;
//					}
//				};
//				job.setPriority(Job.SHORT);
//				job.schedule();
//			}
//		});
//
//		// обработчик отображения пунктов всплывающего меню
//		menu_2.addListener(SWT.Show, new Listener() {
//			@Override
//			public void handleEvent(Event event) {
//				TableItem[] selected = table_2.getSelection();
//				if (selected.length == 0) {
//					mntmNewItem.setEnabled(false);
//					mntmNewItem_1.setEnabled(true);
//					mntmNewItem_2.setEnabled(false);
//				} else {
//					mntmNewItem.setEnabled(true);
//					mntmNewItem_1.setEnabled(true);
//					mntmNewItem_2.setEnabled(true);
//				}
//			}
//		});
//
//		CTabItem tbtmNewItem_2 = new CTabItem(tabFolder, SWT.NONE);
//		tbtmNewItem_2.setText("Трассировка");
//
//		Composite composite_10 = new Composite(tabFolder, SWT.NONE);
//		tbtmNewItem_2.setControl(composite_10);
//		composite_10.setLayout(new GridLayout(2, false));
//
//		Group group_3 = new Group(composite_10, SWT.NONE);
//		group_3.setLayout(new GridLayout(1, false));
//		group_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		group_3.setText("Интерфейсы");
//
//		Group group_6 = new Group(group_3, SWT.NONE);
//		group_6.setLayout(new GridLayout(2, false));
//		group_6.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		group_6.setText("Тип");
//
//		btnEthernet = new Button(group_6, SWT.CHECK);
//		btnEthernet.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				true, 1, 1));
//		btnEthernet.setText("Ethernet");
//
//		btnCheckButton_3 = new Button(group_6, SWT.CHECK);
//		btnCheckButton_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				true, 1, 1));
//		btnCheckButton_3.setText("Loopback, Broadcast");
//
//		btnSlipppp = new Button(group_6, SWT.CHECK);
//		btnSlipppp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true,
//				1, 1));
//		btnSlipppp.setText("SLIP/PPP");
//
//		btnCheckButton_4 = new Button(group_6, SWT.CHECK);
//		btnCheckButton_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				true, 1, 1));
//		btnCheckButton_4.setText("ARP");
//
//		Group group_7 = new Group(group_3, SWT.NONE);
//		group_7.setLayout(new GridLayout(2, false));
//		group_7.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		group_7.setText("Уровень");
//
//		btnCheckButton_5 = new Button(group_7, SWT.CHECK);
//		btnCheckButton_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				true, 1, 1));
//		btnCheckButton_5.setText("Канал");
//
//		btnCheckButton_6 = new Button(group_7, SWT.CHECK);
//		btnCheckButton_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				true, 1, 1));
//		btnCheckButton_6.setText("TCP, UDP, ICMP");
//
//		btnCheckButton_7 = new Button(group_7, SWT.CHECK);
//		btnCheckButton_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				true, 1, 1));
//		btnCheckButton_7.setText("IP, ARP");
//
//		btnCheckButton_8 = new Button(group_7, SWT.CHECK);
//		btnCheckButton_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				true, 1, 1));
//		btnCheckButton_8.setText("HEX дамп");
//
//		Group group_5 = new Group(composite_10, SWT.NONE);
//		group_5.setText("Службы");
//		group_5.setLayout(new GridLayout(2, false));
//		GridData gd_group_5 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
//		gd_group_5.heightHint = 156;
//		group_5.setLayoutData(gd_group_5);
//
//		btnCheckButton_12 = new Button(group_5, SWT.CHECK);
//		btnCheckButton_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_12.setText("Telnet");
//
//		btnCheckButton_13 = new Button(group_5, SWT.CHECK);
//		btnCheckButton_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_13.setText("DNSD");
//
//		btnTelnetd = new Button(group_5, SWT.CHECK);
//		btnTelnetd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true,
//				1, 1));
//		btnTelnetd.setText("TelnetD");
//
//		btnCheckButton_14 = new Button(group_5, SWT.CHECK);
//		btnCheckButton_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_14.setText("DHCPD");
//
//		btnDns = new Button(group_5, SWT.CHECK);
//		btnDns.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1,
//				1));
//		btnDns.setText("DNS");
//
//		btnRip = new Button(group_5, SWT.CHECK);
//		btnRip.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1,
//				1));
//		btnRip.setText("RIP");
//
//		btnHttpgw = new Button(group_5, SWT.CHECK);
//		btnHttpgw.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true,
//				1, 1));
//		btnHttpgw.setText("HTTPGW");
//
//		btnCheckButton_15 = new Button(group_5, SWT.CHECK);
//		btnCheckButton_15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_15.setText("IGMP");
//
//		btnCheckButton_17 = new Button(group_5, SWT.CHECK);
//		btnCheckButton_17.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_17.setText("SNMP");
//
//		btnCheckButton_18 = new Button(group_5, SWT.CHECK);
//		btnCheckButton_18.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_18.setText("ISAKMP");
//
//		btnCheckButton_19 = new Button(group_5, SWT.CHECK);
//		btnCheckButton_19.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_19.setText("SNTP");
//
//		btnCheckButton_22 = new Button(group_5, SWT.CHECK);
//		btnCheckButton_22.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_22.setText("DCP");
//
//		btnCheckButton_23 = new Button(group_5, SWT.CHECK);
//		btnCheckButton_23.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_23.setText("Cluster");
//		new Label(group_5, SWT.NONE);
//
//		Group group_4 = new Group(composite_10, SWT.NONE);
//		group_4.setLayout(new GridLayout(2, false));
//		group_4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		group_4.setText("Маршрутизатор");
//
//		button = new Button(group_4, SWT.CHECK);
//		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1,
//				1));
//		button.setText("Ошибки");
//
//		btnCheckButton_9 = new Button(group_4, SWT.CHECK);
//		btnCheckButton_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				true, 1, 1));
//		btnCheckButton_9.setText("Подробно");
//
//		btnCheckButton_10 = new Button(group_4, SWT.CHECK);
//		btnCheckButton_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_10.setText("Все");
//
//		btnCheckButton_11 = new Button(group_4, SWT.CHECK);
//		btnCheckButton_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
//				true, true, 1, 1));
//		btnCheckButton_11.setText("HEX дамп");
//
//		CTabItem tbtmNewItem_3 = new CTabItem(tabFolder, SWT.NONE);
//		tbtmNewItem_3.setText("Таблица адресов");
//
//		Composite composite_11 = new Composite(tabFolder, SWT.NONE);
//		tbtmNewItem_3.setControl(composite_11);
//		composite_11.setLayout(new GridLayout(1, false));
//
//		final TableViewer tableViewer_1 = new TableViewer(composite_11,
//				SWT.BORDER | SWT.FULL_SELECTION);
//		table_3 = tableViewer_1.getTable();
//		table_3.setHeaderVisible(true);
//		table_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//
//		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
//				tableViewer_1, SWT.NONE);
//		TableColumn tblclmnNewColumn_25 = tableViewerColumn_3.getColumn();
//		tblclmnNewColumn_25.setWidth(100);
//		tblclmnNewColumn_25.setText("Адрес");
//
//		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
//				tableViewer_1, SWT.NONE);
//		TableColumn tblclmnNewColumn_24 = tableViewerColumn_2.getColumn();
//		tblclmnNewColumn_24.setWidth(100);
//		tblclmnNewColumn_24.setText("Имя");
//
//		Menu menu_3 = new Menu(table_3);
//		table_3.setMenu(menu_3);
//
//		final MenuItem mntmNewItem_3 = new MenuItem(menu_3, SWT.NONE);
//		mntmNewItem_3.setText("Изменить");
//
//		mntmNewItem_3.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				if (table_3.getSelection() != null
//						&& table_3.getSelection().length > 0) {
//					IStructuredSelection sel = (IStructuredSelection) tableViewer_1
//							.getSelection();
//					AddressTableDialog dialog = new AddressTableDialog(shell,
//							sel);
//					if (dialog.open() == Window.OK) {
//						Job job = new Job("change") {
//
//							@Override
//							protected IStatus run(IProgressMonitor monitor) {
//								Display.getDefault().asyncExec(new Runnable() {
//									@Override
//									public void run() {
//										tableViewer_1.setInput(AddressModel
//												.getInstance()
//												.getAllAddressArray());
//									}
//								});
//								return Status.OK_STATUS;
//							}
//						};
//						job.setPriority(Job.SHORT);
//						job.schedule();
//
//					}
//				}
//			}
//		});
//
//		final MenuItem mntmNewItem_4 = new MenuItem(menu_3, SWT.NONE);
//		mntmNewItem_4.setText("Добавить");
//
//		mntmNewItem_4.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				AddressTableDialog dialog = new AddressTableDialog(shell, null);
//				if (dialog.open() == Window.OK) {
//					Job job = new Job("add") {
//
//						@Override
//						protected IStatus run(IProgressMonitor monitor) {
//							Display.getDefault().asyncExec(new Runnable() {
//								@Override
//								public void run() {
//									tableViewer_1
//											.setInput(AddressModel
//													.getInstance()
//													.getAllAddressArray());
//								}
//							});
//							return Status.OK_STATUS;
//						}
//					};
//					job.setPriority(Job.SHORT);
//					job.schedule();
//
//				}
//			}
//		});
//
//		final MenuItem mntmNewItem_5 = new MenuItem(menu_3, SWT.NONE);
//		mntmNewItem_5.setText("Удалить");
//
//		mntmNewItem_5.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				IStructuredSelection sel = (IStructuredSelection) tableViewer_1
//						.getSelection();
//				String[] data = (String[]) sel.getFirstElement();
//				AddressModel.getInstance().removeAddress(data);
//				Job job = new Job("remove") {
//
//					@Override
//					protected IStatus run(IProgressMonitor monitor) {
//						Display.getDefault().asyncExec(new Runnable() {
//							@Override
//							public void run() {
//								tableViewer_1.setInput(AddressModel
//										.getInstance().getAllAddressArray());
//							}
//						});
//						return Status.OK_STATUS;
//					}
//				};
//				job.setPriority(Job.SHORT);
//				job.schedule();
//			}
//		});
//
//		menu_3.addListener(SWT.Show, new Listener() {
//			@Override
//			public void handleEvent(Event event) {
//				TableItem[] selected = table_3.getSelection();
//				if (selected.length == 0) {
//					mntmNewItem_3.setEnabled(false);
//					mntmNewItem_4.setEnabled(true);
//					mntmNewItem_5.setEnabled(false);
//				} else {
//					mntmNewItem_3.setEnabled(true);
//					mntmNewItem_4.setEnabled(true);
//					mntmNewItem_5.setEnabled(true);
//				}
//			}
//		});
//
//		tableViewer_1.setContentProvider(new ArrayContentProvider());
//		tableViewer_1.setLabelProvider(new AddressLabelProvider());
//		tableViewer_1.setInput(AddressModel.getInstance().getAllAddressArray());
//		
//		CTabItem tbtmNewItem_5 = new CTabItem(tabFolder, SWT.NONE);
//		tbtmNewItem_5.setText("Подбор паролей");
//
//		Composite composite_13 = new Composite(tabFolder, SWT.NONE);
//		tbtmNewItem_5.setControl(composite_13);
//		composite_13.setLayout(new GridLayout(2, false));
//
//		Label lblNewLabel_9 = new Label(composite_13, SWT.NONE);
//		GridData gd_lblNewLabel_9 = new GridData(SWT.CENTER, SWT.CENTER, true,
//				false, 2, 1);
//		gd_lblNewLabel_9.heightHint = 39;
//		lblNewLabel_9.setLayoutData(gd_lblNewLabel_9);
//		lblNewLabel_9
//				.setText("Реакция системы в случае обнаружения\n попыток подбора паролей абонентами");
//
//		Label lblNewLabel_10 = new Label(composite_13, SWT.NONE);
//		lblNewLabel_10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
//				false, 1, 1));
//		lblNewLabel_10.setText("Уведомлять администратора");
//
//		combo_2 = new Combo(composite_13, SWT.NONE);
//		combo_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false,
//				1, 1));
//		combo_2.setItems(Constants.NOTIFY_ADMIN);
//		combo_2.select(0);
//
//		Label lblNewLabel_11 = new Label(composite_13, SWT.NONE);
//		lblNewLabel_11.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
//				false, 1, 1));
//		lblNewLabel_11.setText("Блокировать абонента");
//
//		combo_3 = new Combo(composite_13, SWT.NONE);
//		combo_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false,
//				1, 1));
//		combo_3.setItems(Constants.FREEZE_CLIENT);
//		combo_3.select(0);
//
//		CTabItem tbtmNewItem_6 = new CTabItem(tabFolder, SWT.NONE);
//		tbtmNewItem_6.setText("Служба времени");
//
//		Composite composite_14 = new Composite(tabFolder, SWT.NONE);
//		tbtmNewItem_6.setControl(composite_14);
//		composite_14.setLayout(new GridLayout(2, false));
//
//		btnCheckButton_25 = new Button(composite_14, SWT.CHECK);
//		btnCheckButton_25.setText("Служба инициализирована");
//
//		btnCheckButton_26 = new Button(composite_14, SWT.CHECK);
//		btnCheckButton_26.setText("Автопереход на летнее время и обратно");
//
//		btnCheckButton_27 = new Button(composite_14, SWT.CHECK);
//		btnCheckButton_27.setText("Установлено летнее время");
//
//		btnCheckButton_28 = new Button(composite_14, SWT.CHECK);
//		btnCheckButton_28.setText("Выполнять SNTP коррекцию часов");
//
//		Group group_9 = new Group(composite_14, SWT.NONE);
//		group_9.setText("Часовой пояс");
//		group_9.setLayout(new GridLayout(1, false));
//		group_9.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1,
//				1));
//
//		combo_4 = new Combo(group_9, SWT.NONE);
//		combo_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
//				1, 1));
//		// выборка только смещений GMT+
//		String[] slice = new String[Constants.TIME_ZONES.length];
//		for (int i = 0; i < slice.length; ++i) {
//			slice[i] = Constants.TIME_ZONES[i][0];
//		}
//		combo_4.setItems(slice);
//
//		text_6 = new Text(group_9, SWT.BORDER);
//		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
//				1));
//
//		Group group_10 = new Group(composite_14, SWT.NONE);
//		group_10.setText("Наименование часового пояса");
//		group_10.setLayout(new GridLayout(2, false));
//		group_10.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
//				1, 1));
//
//		Label label_6 = new Label(group_10, SWT.NONE);
//		label_6.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false,
//				1, 1));
//		label_6.setText("Основное");
//
//		text_7 = new Text(group_10, SWT.BORDER);
//		text_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
//				1, 1));
//
//		Label label_7 = new Label(group_10, SWT.NONE);
//		label_7.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false,
//				1, 1));
//		label_7.setText("Для летнего времени");
//
//		text_8 = new Text(group_10, SWT.BORDER);
//		text_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
//				1, 1));
//
//	}

	private void createNetSettingsTabs() {
		CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("Интерфейсы");

		Composite composite_4 = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite_4);
		composite_4.setLayout(new GridLayout(1, false));

		final TableViewer interfaceTableViewer = new TableViewer(composite_4, SWT.BORDER | SWT.FULL_SELECTION);
		final Table interfaceTable = interfaceTableViewer.getTable();
		interfaceTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		interfaceTable.setHeaderVisible(true);
		interfaceTable.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn.setWidth(10);
		tblclmnNewColumn.setText("№");

		TableColumn tblclmnNewColumn_1 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Имя");

		TableColumn tblclmnNewColumn_2 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Тип");

		TableColumn tblclmnNewColumn_3 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("Активизация");

		TableColumn tblclmnNewColumn_4 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("Локальный IP");

		TableColumn tblclmnNewColumn_5 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("Удалённый IP");

		TableColumn tblclmnNewColumn_6 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("NAT");

		TableColumn tblclmnNewColumn_7 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_7.setWidth(100);
		tblclmnNewColumn_7.setText("Фильтр входящих");

		TableColumn tblclmnNewColumn_8 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_8.setWidth(100);
		tblclmnNewColumn_8.setText("Фильтр исходящих");

		TableColumn tblclmnNewColumn_9 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_9.setWidth(100);
		tblclmnNewColumn_9.setText("MTU");

		TableColumn tblclmnNewColumn_10 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_10.setWidth(100);
		tblclmnNewColumn_10.setText("Порт");

		TableColumn tblclmnNewColumn_11 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_11.setWidth(100);
		tblclmnNewColumn_11.setText("Таймер");

		TableColumn tblclmnNewColumn_12 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_12.setWidth(100);
		tblclmnNewColumn_12.setText("Доп. параметры");

		TableColumn tblclmnNewColumn_13 = new TableColumn(interfaceTable, SWT.NONE);
		tblclmnNewColumn_13.setWidth(100);
		tblclmnNewColumn_13.setText("Таблица маршрутов");
		
		interfaceTableViewer.setContentProvider(ArrayContentProvider.getInstance());
		interfaceTableViewer.setLabelProvider(new InterfaceLableProvider());
		interfaceTableViewer.setInput(InterfaceModel.getInstance().getDataArray());
		
		Menu menu = new Menu(interfaceTable);
		interfaceTable.setMenu(menu);
		
		final MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("Изменить");

		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (interfaceTable.getSelection() != null
						&& interfaceTable.getSelection().length > 0) {
					IStructuredSelection sel = (IStructuredSelection) interfaceTableViewer
							.getSelection();
					// выбранный элемент таблицы как бин
					InterfaceBean ibean = (InterfaceBean) sel
							.getFirstElement();
					// индекс бина в списке
					int indx = InterfaceModel.getInstance().getData()
							.indexOf(ibean);
					// создание диалога
					InterfaceDialog dialog = new InterfaceDialog(
							shell);
					// передача бина диалогу
					dialog.setInterfaceBean(ibean);
					if (dialog.open() == Window.OK) {
						// замена бина в модели по выбранному индексу
						InterfaceModel.getInstance().getData()
								.set(indx, dialog.getInterfaceBean());
						// обновление данных для таблицы
						interfaceTableViewer.refresh();
					}
				}
			}
		});
		
		final MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.setText("Добавить");

//		InterfaceModel.getInstance().addData(new InterfaceBean());
		
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// создание диалога
				InterfaceDialog dialog = new InterfaceDialog(
						shell);
				dialog.setInterfaceBean(null);
				if (dialog.open() == Window.OK) {
					// замена бина в модели по выбранному индексу
					InterfaceModel.getInstance().getData().add(dialog.getInterfaceBean());
					// обновление данных для таблицы
					interfaceTableViewer.setInput(InterfaceModel.getInstance().getDataArray());
				}
			}
		});
		
		final MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("Удалить");

		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (interfaceTable.getSelection() != null
						&& interfaceTable.getSelection().length > 0) {
					IStructuredSelection sel = (IStructuredSelection) interfaceTableViewer
							.getSelection();
					// выбранный элемент таблицы как бин
					InterfaceBean ibean = (InterfaceBean) sel
							.getFirstElement();
					InterfaceModel.getInstance().getData().remove(ibean);
					// обновление данных для таблицы
					interfaceTableViewer.setInput(InterfaceModel.getInstance().getDataArray());
				}
			}
		});
		
		
		menu.addListener(SWT.Show, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TableItem[] selected = interfaceTable.getSelection();
				if (selected.length == 0) {
					menuItem.setEnabled(false);
					menuItem_1.setEnabled(true);
					mntmNewItem.setEnabled(false);
				} else {
					menuItem.setEnabled(true);
					menuItem_1.setEnabled(true);
					mntmNewItem.setEnabled(true);
				}
			}
		});
		
		/** Фильтры **/
		CTabItem tbtmNewItem = new CTabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("Фильтры");

		Composite composite_5 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem.setControl(composite_5);
		composite_5.setLayout(new GridLayout(1, false));

		TreeViewer treeViewer = new TreeViewer(composite_5, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setWidth(10);
		treeColumn.setText("№");

		TreeColumn trclmnNewColumn = new TreeColumn(tree, SWT.NONE);
		trclmnNewColumn.setWidth(100);
		trclmnNewColumn.setText("Имя");

		TreeColumn trclmnNewColumn_1 = new TreeColumn(tree, SWT.NONE);
		trclmnNewColumn_1.setWidth(100);
		trclmnNewColumn_1.setText("Значение");

		TreeColumn trclmnNewColumn_2 = new TreeColumn(tree, SWT.NONE);
		trclmnNewColumn_2.setWidth(100);
		trclmnNewColumn_2.setText("Расширенное значение");

		CTabItem tbtmNewItem_1 = new CTabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("Туннели");

		Composite composite_6 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem_1.setControl(composite_6);
		composite_6.setLayout(new GridLayout(1, false));

		final TableViewer tunnelTableViewer = new TableViewer(composite_6, SWT.BORDER | SWT.FULL_SELECTION);
		final Table tunnelTable = tunnelTableViewer.getTable();
		tunnelTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tunnelTable.setHeaderVisible(true);
		tunnelTable.setLinesVisible(true);

		tunnelTableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tunnelTableViewer.setLabelProvider(new TunnelLableProvider());
		tunnelTableViewer.setInput(TunnelModel.getInstance().getDataArray());
		
		TableColumn tblclmnNewColumn_14 = new TableColumn(tunnelTable, SWT.NONE);
		tblclmnNewColumn_14.setWidth(100);
		tblclmnNewColumn_14.setText("№");

		TableColumn tblclmnNewColumn_15 = new TableColumn(tunnelTable, SWT.NONE);
		tblclmnNewColumn_15.setWidth(100);
		tblclmnNewColumn_15.setText("Идентификатор");

		TableColumn tblclmnNewColumn_16 = new TableColumn(tunnelTable, SWT.NONE);
		tblclmnNewColumn_16.setWidth(100);
		tblclmnNewColumn_16.setText("Заголовок");

		TableColumn tblclmnNewColumn_17 = new TableColumn(tunnelTable, SWT.NONE);
		tblclmnNewColumn_17.setWidth(100);
		tblclmnNewColumn_17.setText("Локальный IP");

		TableColumn tblclmnNewColumn_18 = new TableColumn(tunnelTable, SWT.NONE);
		tblclmnNewColumn_18.setWidth(100);
		tblclmnNewColumn_18.setText("Удалённый IP");

		TableColumn tblclmnNewColumn_19 = new TableColumn(tunnelTable, SWT.NONE);
		tblclmnNewColumn_19.setWidth(100);
		tblclmnNewColumn_19.setText("Шифрование");

		TableColumn tblclmnNewColumn_20 = new TableColumn(tunnelTable, SWT.NONE);
		tblclmnNewColumn_20.setWidth(100);
		tblclmnNewColumn_20.setText("Сжатие");

		TableColumn tblclmnNewColumn_21 = new TableColumn(tunnelTable, SWT.NONE);
		tblclmnNewColumn_21.setWidth(100);
		tblclmnNewColumn_21.setText("Правила отбора");
		
		Menu tunnelMenu = new Menu(tunnelTable);
		tunnelTable.setMenu(tunnelMenu);
		
		final MenuItem changeMenuItem = new MenuItem(tunnelMenu, SWT.NONE);
		changeMenuItem.setText("Изменить");
		
		changeMenuItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (tunnelTable.getSelection() != null
						&& tunnelTable.getSelection().length > 0) {
					IStructuredSelection sel = (IStructuredSelection) tunnelTableViewer
							.getSelection();
					TunnelDialog dialog = new TunnelDialog(
							shell, sel);
					if (dialog.open() == Window.OK) {
						Job job = new Job("change") {

							@Override
							protected IStatus run(IProgressMonitor monitor) {
								Display.getDefault().asyncExec(new Runnable() {
									@Override
									public void run() {
										tunnelTableViewer.setInput(TunnelModel
												.getInstance().getDataArray());
									}
								});
								return Status.OK_STATUS;
							}
						};
						job.setPriority(Job.SHORT);
						job.schedule();

					}
				}
			}
		});
		
		final MenuItem addMenuItem = new MenuItem(tunnelMenu, SWT.NONE);
		addMenuItem.setText("Добавить");
		
		addMenuItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TunnelDialog dialog = new TunnelDialog(shell,
						null);
				if (dialog.open() == Window.OK) {
					Job job = new Job("add") {

						@Override
						protected IStatus run(IProgressMonitor monitor) {
							Display.getDefault().asyncExec(new Runnable() {
								@Override
								public void run() {
									tunnelTableViewer.setInput(TunnelModel
											.getInstance().getDataArray());
								}
							});
							return Status.OK_STATUS;
						}
					};
					job.setPriority(Job.SHORT);
					job.schedule();
				}
			}
		});

		
		final MenuItem removeMenuItem = new MenuItem(tunnelMenu, SWT.NONE);
		removeMenuItem.setText("Удалить");
		
		removeMenuItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tunnelTableViewer
						.getSelection();
				Tunnel tunnel = (Tunnel) sel
						.getFirstElement();
				TunnelModel.getInstance().removeData(tunnel);
				Job job = new Job("remove") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								tunnelTableViewer.setInput(TunnelModel
										.getInstance().getDataArray());
							}
						});
						return Status.OK_STATUS;
					}
				};
				job.setPriority(Job.SHORT);
				job.schedule();
			}
		});
		
		tunnelMenu.addListener(SWT.Show, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TableItem[] selected = tunnelTable.getSelection();
				if (selected.length == 0) {
					changeMenuItem.setEnabled(false);
					addMenuItem.setEnabled(true);
					removeMenuItem.setEnabled(false);
				} else {
					changeMenuItem.setEnabled(true);
					addMenuItem.setEnabled(true);
					removeMenuItem.setEnabled(true);
				}
			}
		});

	}

	private void getAll() {
		// Объект конфигурации
		Dionis dionis = DionisXAO.getDionis();
		Parametrs parametrs = dionis.getParametrs();
		/** Порты **/
		java.util.List<SIO> sioPorts = parametrs.getPorts().getSIO();
		java.util.List<SYN> synPorts = parametrs.getPorts().getSYN();
		// добавление SIO портов в таблицу
		for (int i = 0; i < sioPorts.size(); ++i) {
			SIO sioPort = sioPorts.get(i);
			// первая колонка
			String firstColumn = "SIO_" + String.valueOf(i);
			// вторая колонка содержит все параметры в виде строки
			// (возможно не лучший вариант)
			StringBuilder secondColumn = new StringBuilder(
					String.valueOf(sioPort.isSetSpeed() ? sioPort.getSpeed()
							: ""));
			secondColumn.append(" ");
			secondColumn.append(sioPort.isSetBits() ? String.valueOf(sioPort
					.getBits()) : "");
			secondColumn.append(" ");
			secondColumn.append(sioPort.isSetParity() ? String.valueOf(sioPort
					.getParity().name()) : "");
			secondColumn.append(" ");
			secondColumn.append(
					sioPort.isSetStopBit() ? String.valueOf(sioPort
							.getStopBit()) : "").append(" ");
			secondColumn.append(
					sioPort.isSetControl() ? String.valueOf(sioPort
							.getControl().name()) : "").append(" ");
			secondColumn.append(
					sioPort.isSetDirection() ? String.valueOf(sioPort
							.getDirection().name()) : "").append(" ");
			secondColumn.append(sioPort.isSetModem() ? String.valueOf(sioPort
					.getModem()) : "");
			secondColumn.append(" ");
			// создаём строку
			TableItem item = new TableItem(table.getTable(), SWT.NONE);
			// отображаем строку
			item.setText(new String[] { firstColumn, secondColumn.toString() });
		}
		// добавление SYN портов
		for (int i = 0; i < synPorts.size(); ++i) {
			String firstColumn = "SYN_" + String.valueOf(i);
			TableItem item = new TableItem(table.getTable(), SWT.NONE);
			item.setText(new String[] { firstColumn, " " });
		}

		/** Базовые константы **/
		BaseConsts baseconsts = parametrs.getBaseConsts();
		// адрес порта
		text.setText(baseconsts.getIP());
		// Время жизни IP датаграмм
		spinner.setValues(baseconsts.getTTL(), 1, 255, 3, 1, 10);
		// Макс. размер TCP пакета(MSS)
		spinner_1.setValues(baseconsts.getMSS(), 512, 8192, 4, 1, 10);
		// Размер TCP окна
		spinner_2.setValues(baseconsts.getWindow(), 0, 65535, 5, 1, 10);
		// Количество TCB блоков
		spinner_3.setValues(baseconsts.getTCB(), 16, 450, 3, 1, 10);
		// Размер буфера TCB блока
		spinner_4.setValues(baseconsts.getTCBBuf(), 8, 64, 2, 1, 3);
		// Количество proxy-буферов
		spinner_5.setValues(baseconsts.getProxy(), 8, 225, 3, 1, 3);
		// Режим работы
		int index = baseconsts.getCluster().getMode().ordinal();
		combo_6.select(index);
		// Таймер
		spinner_7.setValues(baseconsts.getCluster().getTimer(), 0, 60, 2, 1, 3);

		/** Трансляция адресов NAT **/
		NAT nat = parametrs.getNAT();
		// TODO: парсить!
		// адрес перегрузки
		String overload = nat.getOverload();
		// TODO: автоматически? третий вариант?
		// TODO: если 1.1.1.1 - автоматически, нужно парсить
		if (overload != null && !overload.isEmpty()) {
			// Фиксированный
			btnCheckButton_2.setSelection(true);
			// адрес
			text_1.setText(overload);
		} else {
			// не установлен
			btnCheckButton.setSelection(true);
		}
		// Ограничение сессий для одного абонента
		spinner_8.setValues(nat.getLimit(), 0, 65535, 5, 1, 10);
		// Размер рабочей NAT таблицы в блоках
		spinner_9.setValues(nat.getSize(), 0, 32, 2, 1, 3);
		// Статическая NAT таблица
		java.util.List<NATTableStatic> natTableList = nat.getTable()
				.getStatic();
		for (NATTableStatic nts : natTableList) {
			StringBuilder firstColumn = new StringBuilder();
			// если есть внутренние настройки
			if (nts.isSetLocal() == true) {
				Local localNTS = nts.getLocal();
				firstColumn.append(localNTS.getIP());
				// если выставлено использовать правило тарнсляции NAT
				if (nts.isSetPAT() && localNTS.isSetPort()) {
					// добавляем порт
					firstColumn.append(":").append(localNTS.getPort());
					// если выставлены значащие биты
					if (nts.isSetBits()) {
						firstColumn.append("//").append(nts.getBits());
					}
				}
			}
			StringBuilder secondColumn = new StringBuilder();
			// если есть внутренние настройки
			if (nts.isSetGlobal() == true) {
				Global globalNTS = nts.getGlobal();
				secondColumn.append(globalNTS.getIP());
				// если выставлено использовать правило тарнсляции NAT
				if (nts.isSetPAT() && globalNTS.isSetPort()) {
					// добавляем порт
					secondColumn.append(":").append(globalNTS.getPort());
					// если выставлены значащие биты
					if (nts.isSetBits()) {
						secondColumn.append("//").append(nts.getBits());
					}
				}
			}
			TableItem item = new TableItem(table_1.getTable(), SWT.NONE);
			item.setText(new String[] { firstColumn.toString(),
					secondColumn.toString() });
		}

		/** ARP **/
		ARP arp = parametrs.getARP();
		// Разрешить proxy-ARP
		btnArp.setSelection(arp.isSetProxy());
		// Статическая ARP таблица
		java.util.List<ARPTableStatic> arpTableList = arp.getTable()
				.getStatic();
		for (ARPTableStatic arpElement : arpTableList) {
			String firstColumn = arpElement.getIP();
			String secondColumn = arpElement.getMAC();
			TableItem item = new TableItem(table_2, SWT.NONE);
			item.setText(new String[] { firstColumn, secondColumn });
		}
		/** Трассировка **/
		Tracing tracing = parametrs.getTracing();
		// Интерфейсы
		if (tracing.isSetInterfaces()) {
			// Тип
			if (tracing.getInterfaces().isSetType()) {
				Type type = tracing.getInterfaces().getType();
				// Ethernet
				btnEthernet.setSelection(type.isSetEthernet());
				// Loopback, Broadcast
				btnCheckButton_3.setSelection(type.isSetLoopbackBroadcast());
				// SLIP/PPP
				btnSlipppp.setSelection(type.isSetSLIPPPP());
				// ARP
				btnCheckButton_4.setSelection(type.isSetARP());
			}
			// Уровень
			if (tracing.getInterfaces().isSetLevel()) {
				Level level = tracing.getInterfaces().getLevel();
				// Канал
				btnCheckButton_5.setSelection(level.isSetChannel());
				// TCP, UDP, ICMP
				btnCheckButton_6.setSelection(level.isSetTCPUDPICMP());
				// IP, ARP
				btnCheckButton_7.setSelection(level.isSetIPARP());
				// HEX дамп
				btnCheckButton_8.setSelection(level.isSetHEXDump());
			}
		}
		if (tracing.isSetServers()) {
			TracingServers servers = tracing.getServers();
			// Telnet
			btnCheckButton_12.setSelection(servers.isSetTelnet());
			// DNSD
			btnCheckButton_13.setSelection(servers.isSetDNSD());
			// TelnetD
			btnTelnetd.setSelection(servers.isSetTelnetD());
			// DHCPD
			btnCheckButton_14.setSelection(servers.isSetDHCPD());
			// DNS
			btnDns.setSelection(servers.isSetDNS());
			// RIP
			btnRip.setSelection(servers.isSetRIP());
			// HTTPGW
			btnHttpgw.setSelection(servers.isSetHTTPGW());
			// IGMP
			btnCheckButton_15.setSelection(servers.isSetIGMP());
			// SNMP
			btnCheckButton_17.setSelection(servers.isSetSNMP());
			// ISAKMP
			btnCheckButton_18.setSelection(servers.isSetISAKMP());
			// SNTP
			btnCheckButton_19.setSelection(servers.isSetSNTP());
			// DCP
			btnCheckButton_22.setSelection(servers.isSetDCP());
			// Cluster
			btnCheckButton_23.setSelection(servers.isSetCluster());
		}
		// Маршрутизатор
		if (tracing.isSetRoute()) {
			TracingRoute route = tracing.getRoute();
			// Ошибки
			button.setSelection(route.isSetErrors());
			// Подробно
			btnCheckButton_9.setSelection(route.isSetDetail());
			// Все
			btnCheckButton_10.setSelection(route.isSetAll());
			// HEX дамп
			btnCheckButton_11.setSelection(route.isSetHEXDump());
		}
		/** Таблица адресов **/
		// TODO: переключатели в диалоге!
		if (parametrs.isSetHosts()) {
			java.util.List<Host> hostList = parametrs.getHosts().getHost();
			for (Host host : hostList) {
				String name = host.isSetName() ? host.getName() : "";
				String address = host.isSetAddress() ? host.getAddress() : "";
				TableItem item = new TableItem(table_3, SWT.NONE);
				item.setText(new String[] { address, name });
			}
		}

		/** Удалённое управление **/
		if (parametrs.isSetRemoteControl()) {
			RemoteControl remote = parametrs.getRemoteControl();
			// Имя абонента
			text_2.setText(remote.isSetUser() ? remote.getUser() : "");
			// Доп. пароль
			text_3.setText(remote.isSetPassword() ? remote.getPassword() : "");
			// Ключи
			if (remote.isSetKeys()) {
				java.util.List<Integer> keyList = remote.getKeys().getKey();
				for (Integer i : keyList) {
					list.add(i.toString());
				}
			}
			// Режим
			// если есть режим, то установить его, иначе посередине списка
			combo_1.select(remote.isSetMode() ? remote.getMode().ordinal()
					: Constants.REMOTE_MODE.length / 2);
			// Разрешена перезагрузка
			if (remote.isSetReload()) {
				if (remote.getReload() == BooleanType.YES) {
					btnCheckButton_24.setSelection(true);
				} else {
					btnCheckButton_24.setSelection(false);
				}
			}
			// Передача
			text_4.setText(remote.isSetUpload() ? remote.getUpload() : "");
			// Приём
			text_5.setText(remote.isSetDownload() ? remote.getDownload() : "");
		}
		/** Подбор паролей **/
		// Уведомлять администратора
		if (parametrs.isSetPassword()) {
			Password passwords = parametrs.getPassword();
			// если нет значения - 0 (нет уведомления)
			combo_2.select(passwords.isSetSend() ? passwords.getSend()
					.ordinal() : 0);
			// если нет значения - 0 (нет блокировки)
			combo_3.select(passwords.isSetFreez() ? passwords.getFreez()
					.ordinal() : 0);
		}
		/** Служба времени **/
		if (parametrs.isSetTimeService()) {
			TimeService timeserv = parametrs.getTimeService();
			// Служба инициализирована
			btnCheckButton_25
					.setSelection(timeserv.getInitialized() == BooleanType.YES ? true
							: false);
			// Автопереход на летнее время и обратно
			btnCheckButton_26
					.setSelection(timeserv.getAuto() == BooleanType.YES ? true
							: false);
			// Установлено летнее время
			btnCheckButton_27
					.setSelection(timeserv.getSummer() == BooleanType.YES ? true
							: false);
			// Выполнять SNTP коррекцию часов
			btnCheckButton_28
					.setSelection(timeserv.getSNTP() == BooleanType.YES ? true
							: false);

			// Часовой пояс
			if (timeserv.isSetZone()) {
				TimeZone tz = timeserv.getZone();
				String tzGMT = TimeZoneTimeFormatter.printTimeZoneTime(tz);
				// находим индекс выборки GMT+
				int i = 0;
				for (; i < Constants.TIME_ZONES.length; ++i) {
					if (Constants.TIME_ZONES[i].equals(tzGMT)) {
						break;
					}
				}
				// устанавливаем выбор GMT+
				combo_4.select(i);
				// устанавливаем наименование часового пояса
				text_6.setText(Constants.TIME_ZONES[i][1]);
			}
			// Основное
			text_7.setText(timeserv.isSetName() ? timeserv.getName() : "");
			// Для летнего времени
			text_8.setText(timeserv.isSetSummerName() ? timeserv
					.getSummerName() : "");
		}

	}

	private void saveAll() {
		// Объект конфигурации
		Dionis dionis = DionisXAO.getDionis();
		Parametrs param = new Parametrs();
		Ports ports = new Ports();

		param.setPorts(ports);
		dionis.setParametrs(param);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
