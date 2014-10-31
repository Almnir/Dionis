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
import dionis.models.InterfaceModel;
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
	private InterfaceBean data;
	private boolean newadd;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public InterfaceDialog(Shell parentShell, IStructuredSelection sel) {
		super(parentShell);
		if (sel != null) {
			this.data = (InterfaceBean) sel.getFirstElement();
			this.newadd = false;
		} else {
			this.data = new InterfaceBean();
			this.newadd = true;
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
		comboViewer.setInput(Arrays.asList(InterfaceType.values()));
		typeCombo.select(0);

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
					return iElement.name();
				}
				return super.getText(element);
			}
		});
		modeComboViewer.setInput(Arrays.asList(InterfaceModeType.values()));
		modeCombo.select(0);

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
					return iElement.name();
				}
				return super.getText(element);
			}
		});
		natComboViewer.setInput(Arrays.asList(InterfaceNatType.values()));
		natCombo.select(0);

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
					// создание диалога
					InterfaceRouteDialog dialog = new InterfaceRouteDialog(
							getShell(), sel);
					if (dialog.open() == Window.OK) {
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								// обновление данных для таблицы
								tableViewer.setInput(InterfaceRouteModel
										.getInstance().getDataArray());
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
					// обновление данных для таблицы
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							// обновление данных для таблицы
							tableViewer.setInput(InterfaceRouteModel
									.getInstance().getDataArray());
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
					InterfaceRouteModel.getInstance().getData().remove(ibean);
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							// обновление данных для таблицы
							tableViewer.setInput(InterfaceRouteModel
									.getInstance().getDataArray());
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
					InterfaceParametrsBean params = data.getParametrs();
					if (params == null) {
						params = new InterfaceParametrsBean();
					} else {
						// устанавливаем родительский бин
						params.setInterfaceBean(data);
					}
					switch (itype) {
					case GRE:
						GREDialog greDialog = new GREDialog(getShell());
						greDialog.setParametrs(params);
						if (greDialog.open() == Window.OK) {
							data.setParametrs(greDialog.getParametrs());
						}
						break;
					case VLAN:
						VLANDialog vlanDialog = new VLANDialog(getShell());
						vlanDialog.setParametrs(params);
						if (vlanDialog.open() == Window.OK) {
							data.setParametrs(vlanDialog.getParametrs());
						}
						break;
					case ODI:
						ODIDialog odiDialog = new ODIDialog(getShell());
						odiDialog.setParametrsBean(params);
						if (odiDialog.open() == Window.OK) {
							data.setParametrs(odiDialog.getParametrsBean());
						}
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

		// bindData();

		getAll();

		/** Таблица **/
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setLabelProvider(new InterfaceRouteLabelProvider());
		tableViewer.setInput(InterfaceRouteModel.getInstance().getDataArray());

		return container;
	}

	private void getAll() {
		setFieldsToDefault();
		if (data != null) {
			if (newadd == false) {
				/** изменение **/
				nameText.setText(data.getName());
				typeCombo.select(data.getType().ordinal());
				modeCombo.select(data.getMode().ordinal());
				localIpText.setText(data.getIp().getLocal());
				remoteIpText.setText(data.getIp().getRemote());
				timerSpinner.setSelection(data.getTimer());
				natCombo.select(data.getNat().ordinal());
				mtuSpinner.setSelection(data.getMtu());
				InterfaceFiltersBean filtersBean = data.getFilters();
				// если есть фильтры
				if (filtersBean != null) {
					String inputFilterName = filtersBean.getInput();
					String outputFilterName = filtersBean.getOutput();
					for (FiltersBean fb : FiltersModel.getInstance().getData()) {
						if (fb.getFilter().getName().equals(inputFilterName)) {
							filterInputCombo.select(FiltersModel.getInstance()
									.getData().indexOf(fb));
						}
						if (fb.getFilter().getName().equals(outputFilterName)) {
							filterOutputCombo.select(FiltersModel.getInstance()
									.getData().indexOf(fb));
						}
					}
				}
				DisableDatagramsBean datagrams = data.getDisableDatagrams();
				tunnelButton
						.setSelection(datagrams.getNotTunneled() == BooleanType.YES ? true
								: false);
				transitButton
						.setSelection(datagrams.getForward() == BooleanType.YES ? true
								: false);
				dhcpButton
						.setSelection(datagrams.getDhcp() == BooleanType.YES ? true
								: false);
				ripButton
						.setSelection(datagrams.getRip() == BooleanType.YES ? true
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
				// таблица
				System.out.println("Before: "
						+ InterfaceRouteModel.getInstance().toString());
				InterfaceRouteModel.getInstance().removeAll();
				System.out.println("After clean: "
						+ InterfaceRouteModel.getInstance().toString());
				InterfaceRouteModel.getInstance().setData(
						data.getRoutes().getRoute());
				System.out.println("New filters : "
						+ data.getRoutes().getRoute().toString());
				System.out.println("After having set new values: "
						+ InterfaceRouteModel.getInstance().toString());
			}
		}
	}

	private void setFieldsToDefault() {
		nameText.setText("");
		typeCombo.select(0);
		modeCombo.select(0);
		localIpText.setText("0.0.0.0");
		remoteIpText.setText("0.0.0.0");
		timerSpinner.setSelection(0);
		natCombo.select(0);
		mtuSpinner.setSelection(0);
		tunnelButton.setSelection(false);
		transitButton.setSelection(false);
		dhcpButton.setSelection(false);
		ripButton.setSelection(false);
		multicastButton.setSelection(false);
		clusterButton.setSelection(false);
		ipButton.setSelection(false);
		proxyButton.setSelection(false);
	}

	@Override
	protected void okPressed() {
		data.setName(nameText.getText());
		if (typeCombo.getSelectionIndex() != -1) {
			data.setType(Arrays.asList(InterfaceType.values()).get(
					typeCombo.getSelectionIndex()));
		}
		if (modeCombo.getSelectionIndex() != -1) {
			data.setMode(Arrays.asList(InterfaceModeType.values()).get(
					modeCombo.getSelectionIndex()));
		}
		InterfaceIPBean ipbean = new InterfaceIPBean();
		ipbean.setLocal(localIpText.getText());
		ipbean.setRemote(remoteIpText.getText());
		data.setIp(ipbean);
		InterfaceFiltersBean filters = new InterfaceFiltersBean();
		filters.setInput(filterInputCombo.getText());
		filters.setOutput(filterOutputCombo.getText());
		data.setFilters(filters);
		data.setTimer(timerSpinner.getSelection());
		if (natCombo.getSelectionIndex() != -1) {
			data.setNat(Arrays.asList(InterfaceNatType.values()).get(
					natCombo.getSelectionIndex()));
		}
		data.setMtu((short) mtuSpinner.getSelection());
		// InterfaceRoutesBean routes = new InterfaceRoutesBean();
		// routes.setRoute(InterfaceRouteModel.getInstance().getData());
		// System.out.println("instance: "
		// + InterfaceRouteModel.getInstance().toString());
		// System.out.println("routes: " + routes.getRoute().size());
		//
		// data.setRoutes(routes);
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
		data.setDisableDatagrams(disableDatagrams);

		// добавляем ссылку на модель маршрутов
		InterfaceRoutesBean routess = new InterfaceRoutesBean();
		List<InterfaceRouteBean> routessList = new LinkedList<InterfaceRouteBean>();
		routessList.addAll(InterfaceRouteModel.getInstance().getData());
		routess.setRoute(routessList);
		data.setRoutes(routess);
		// очищаем синглтон с состоянием модели маршрутов (роутов)
		InterfaceRouteModel.getInstance().removeAll();
		// получаем данные модели
		List<InterfaceBean> interfaceList = InterfaceModel.getInstance()
				.getData();
		// если список не пуст
		if (interfaceList != null) {
			// изменяем элемент в списке
			int indexx = interfaceList.indexOf(data);
			if (indexx == -1) {
				// если нет в списке - добавить
				interfaceList.add(data);
			} else {
				// если есть - заменить на текущее
				interfaceList.set(indexx, data);
			}
		} else {
			// новый список
			interfaceList = new LinkedList<InterfaceBean>();
			interfaceList.add(data);
		}
		// меняем список в модели на изменённый
		InterfaceModel.getInstance().setData(interfaceList);
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		// очищаем синглтон с состоянием модели роутов
		InterfaceRouteModel.getInstance().removeAll();
		super.cancelPressed();
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
