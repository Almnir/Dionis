package dionis.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
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
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import dionis.beans.FiltersBean;
import dionis.beans.InterfaceBean;
import dionis.beans.InterfaceRouteBean;
import dionis.beans.InterfaceRoutesBean;
import dionis.models.FiltersModel;
import dionis.models.InterfaceRouteModel;
import dionis.utils.Boolean2BooleanTypeConverter;
import dionis.utils.BooleanType2BooleanConverter;
import dionis.xml.InterfaceModeType;
import dionis.xml.InterfaceNatType;
import dionis.xml.InterfaceType;

public class InterfaceBeanDialog extends Dialog {

	private dionis.beans.InterfaceBean interfacesBean;
	private Scale bandrecvScale;
	private Scale bandwidthScale;
	private Text baseInterfaceText;
	private Scale boardScale;
	private Scale bufScale;
	private Scale delayScale;
	private Scale frameScale;
	private Scale intervalScale;
	private Text macText;
	private Text portsText;
	private Scale recvScale;
	private Scale sendScale;
	private Scale vnidScale;
	private Scale waitScale;
	private Text nameText;
	private Combo typeCombo;
	private ComboViewer comboViewer;
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

	/**
	 * @wbp.parser.constructor
	 */
	public InterfaceBeanDialog(Shell parentShell,
			dionis.beans.InterfaceBean newInterfaceBean) {
		super(parentShell);
		if (newInterfaceBean != null) {
			this.interfacesBean = newInterfaceBean;
		} else {
			this.interfacesBean = new dionis.beans.InterfaceBean();
		}
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// Composite container = (Composite) super.createDialogArea(parent);
		// container.setLayout(new GridLayout(2, false));
		//
		// new Label(container, SWT.NONE).setText("Bandrecv:");
		//
		// bandrecvScale = new Scale(container, SWT.HORIZONTAL);
		// bandrecvScale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		// false));
		//
		// new Label(container, SWT.NONE).setText("Bandwidth:");
		//
		// bandwidthScale = new Scale(container, SWT.HORIZONTAL);
		// bandwidthScale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		// false));
		//
		// new Label(container, SWT.NONE).setText("BaseInterface:");
		//
		// baseInterfaceText = new Text(container, SWT.BORDER | SWT.SINGLE);
		// baseInterfaceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
		// true, false));
		//
		// new Label(container, SWT.NONE).setText("Board:");
		//
		// boardScale = new Scale(container, SWT.HORIZONTAL);
		// boardScale
		// .setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		//
		// new Label(container, SWT.NONE).setText("Buf:");
		//
		// bufScale = new Scale(container, SWT.HORIZONTAL);
		// bufScale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		// false));
		//
		// new Label(container, SWT.NONE).setText("Delay:");
		//
		// delayScale = new Scale(container, SWT.HORIZONTAL);
		// delayScale
		// .setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		//
		// new Label(container, SWT.NONE).setText("Frame:");
		//
		// frameScale = new Scale(container, SWT.HORIZONTAL);
		// frameScale
		// .setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		//
		// new Label(container, SWT.NONE).setText("Interval:");
		//
		// intervalScale = new Scale(container, SWT.HORIZONTAL);
		// intervalScale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		// false));
		//
		// new Label(container, SWT.NONE).setText("Mac:");
		//
		// macText = new Text(container, SWT.BORDER | SWT.SINGLE);
		// macText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
		// false));
		//
		// new Label(container, SWT.NONE).setText("Ports:");
		//
		// portsText = new Text(container, SWT.BORDER | SWT.SINGLE);
		// portsText
		// .setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		//
		// new Label(container, SWT.NONE).setText("Recv:");
		//
		// recvScale = new Scale(container, SWT.HORIZONTAL);
		// recvScale
		// .setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		//
		// new Label(container, SWT.NONE).setText("Send:");
		//
		// sendScale = new Scale(container, SWT.HORIZONTAL);
		// sendScale
		// .setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		//
		// new Label(container, SWT.NONE).setText("Vnid:");
		//
		// vnidScale = new Scale(container, SWT.HORIZONTAL);
		// vnidScale
		// .setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		//
		// new Label(container, SWT.NONE).setText("Wait:");
		//
		// waitScale = new Scale(container, SWT.HORIZONTAL);
		// waitScale
		// .setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		//
		// if (interfaceParametrsBean != null) {
		// m_bindingContext = initDataBindings();
		// }

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
		comboViewer.setInput(InterfaceType.values());
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
		natComboViewer.setInput(InterfaceNatType.values());
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
					int index = InterfaceRouteModel.getInstance().getData()
							.indexOf(bean);
					// создание диалога
					InterfaceRouteDialog dialog = new InterfaceRouteDialog(
							getShell(), bean);
					if (dialog.open() == Window.OK) {
						InterfaceRouteModel.getInstance().getData()
								.set(index, dialog.getInterfaceRouteBean());
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
					InterfaceRouteModel.getInstance().getData()
							.add(dialog.getInterfaceRouteBean());
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
		// otherParamsButton.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// String tctext = typeCombo.getText();
		// if (!tctext.isEmpty()) {
		// InterfaceType itype = InterfaceType.valueOf(typeCombo
		// .getText());
		// InterfaceParametrsBean params = data.getParametrs();
		// if (params == null) {
		// params = new InterfaceParametrsBean();
		// } else {
		// // устанавливаем родительский бин
		// params.setInterfaceBean(data);
		// }
		// switch (itype) {
		// case GRE:
		// GREDialog greDialog = new GREDialog(getShell());
		// greDialog.setParametrs(params);
		// if (greDialog.open() == Window.OK) {
		// data.setParametrs(greDialog.getParametrs());
		// }
		// break;
		// case VLAN:
		// VLANDialog vlanDialog = new VLANDialog(getShell());
		// vlanDialog.setParametrs(params);
		// if (vlanDialog.open() == Window.OK) {
		// data.setParametrs(vlanDialog.getParametrs());
		// }
		// break;
		// case ODI:
		// ODIDialog odiDialog = new ODIDialog(getShell());
		// odiDialog.setParametrsBean(params);
		// if (odiDialog.open() == Window.OK) {
		// data.setParametrs(odiDialog.getParametrsBean());
		// }
		// break;
		//
		// default:
		// break;
		// }
		// }
		// }
		// });

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

		/** Таблица **/
		// tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		// tableViewer.setLabelProvider(new InterfaceRouteLabelProvider());
		// tableViewer.setInput(InterfaceRouteModel.getInstance().getDataArray());

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

	private DataBindingContext initDataBindings() {
		IObservableValue bandrecvObserveWidget = SWTObservables
				.observeSelection(bandrecvScale);
		IObservableValue bandrecvObserveValue = BeansObservables.observeValue(
				interfacesBean, "bandrecv");
		IObservableValue bandwidthObserveWidget = SWTObservables
				.observeSelection(bandwidthScale);
		IObservableValue bandwidthObserveValue = BeansObservables.observeValue(
				interfacesBean, "bandwidth");
		IObservableValue baseInterfaceObserveWidget = SWTObservables
				.observeText(baseInterfaceText, SWT.Modify);
		IObservableValue baseInterfaceObserveValue = BeansObservables
				.observeValue(interfacesBean, "baseInterface");
		IObservableValue boardObserveWidget = SWTObservables
				.observeSelection(boardScale);
		IObservableValue boardObserveValue = BeansObservables.observeValue(
				interfacesBean, "board");
		IObservableValue bufObserveWidget = SWTObservables
				.observeSelection(bufScale);
		IObservableValue bufObserveValue = BeansObservables.observeValue(
				interfacesBean, "buf");
		IObservableValue delayObserveWidget = SWTObservables
				.observeSelection(delayScale);
		IObservableValue delayObserveValue = BeansObservables.observeValue(
				interfacesBean, "delay");
		IObservableValue frameObserveWidget = SWTObservables
				.observeSelection(frameScale);
		IObservableValue frameObserveValue = BeansObservables.observeValue(
				interfacesBean, "frame");
		IObservableValue intervalObserveWidget = SWTObservables
				.observeSelection(intervalScale);
		IObservableValue intervalObserveValue = BeansObservables.observeValue(
				interfacesBean, "interval");
		IObservableValue macObserveWidget = SWTObservables.observeText(macText,
				SWT.Modify);
		IObservableValue macObserveValue = BeansObservables.observeValue(
				interfacesBean, "mac");
		IObservableValue portsObserveWidget = SWTObservables.observeText(
				portsText, SWT.Modify);
		IObservableValue portsObserveValue = BeansObservables.observeValue(
				interfacesBean, "ports");
		IObservableValue recvObserveWidget = SWTObservables
				.observeSelection(recvScale);
		IObservableValue recvObserveValue = BeansObservables.observeValue(
				interfacesBean, "recv");
		IObservableValue sendObserveWidget = SWTObservables
				.observeSelection(sendScale);
		IObservableValue sendObserveValue = BeansObservables.observeValue(
				interfacesBean, "send");
		IObservableValue vnidObserveWidget = SWTObservables
				.observeSelection(vnidScale);
		IObservableValue vnidObserveValue = BeansObservables.observeValue(
				interfacesBean, "vnid");
		IObservableValue waitObserveWidget = SWTObservables
				.observeSelection(waitScale);
		IObservableValue waitObserveValue = BeansObservables.observeValue(
				interfacesBean, "wait");
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(bandrecvObserveWidget, bandrecvObserveValue,
				null, null);
		bindingContext.bindValue(bandwidthObserveWidget, bandwidthObserveValue,
				null, null);
		bindingContext.bindValue(baseInterfaceObserveWidget,
				baseInterfaceObserveValue, null, null);
		bindingContext.bindValue(boardObserveWidget, boardObserveValue, null,
				null);
		bindingContext.bindValue(bufObserveWidget, bufObserveValue, null, null);
		bindingContext.bindValue(delayObserveWidget, delayObserveValue, null,
				null);
		bindingContext.bindValue(frameObserveWidget, frameObserveValue, null,
				null);
		bindingContext.bindValue(intervalObserveWidget, intervalObserveValue,
				null, null);
		bindingContext.bindValue(macObserveWidget, macObserveValue, null, null);
		bindingContext.bindValue(portsObserveWidget, portsObserveValue, null,
				null);
		bindingContext.bindValue(recvObserveWidget, recvObserveValue, null,
				null);
		bindingContext.bindValue(sendObserveWidget, sendObserveValue, null,
				null);
		bindingContext.bindValue(vnidObserveWidget, vnidObserveValue, null,
				null);
		bindingContext.bindValue(waitObserveWidget, waitObserveValue, null,
				null);
		//
		return bindingContext;
	}

	private void bindData() {
		// контекст датабиндинга
		ctx = new DataBindingContext();
		// стратегия для численных значений
		UpdateValueStrategy strategy = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST);
		// стратегия для текстовых значений
		UpdateValueStrategy strategy_text = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT);
		UpdateValueStrategy strategy_other = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_UPDATE);
		// имя
		IObservableValue widgetValue = SWTObservables.observeText(nameText,
				SWT.Modify);
		IObservableValue modelValue = BeanProperties.value(InterfaceBean.class,
				"name").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy_text, null);
		// Тип
		widgetValue = ViewersObservables.observeSingleSelection(comboViewer);
		modelValue = BeanProperties.value("type").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
		// режим активизации
		widgetValue = ViewersObservables
				.observeSingleSelection(modeComboViewer);
		modelValue = BeanProperties.value("mode").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
		// локальный ip
		widgetValue = SWTObservables.observeText(localIpText, SWT.Modify);
		modelValue = BeanProperties.value(InterfaceBean.class, "ip.local")
				.observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy_text, null);
		// фильтр входящих
		widgetValue = ViewersObservables
				.observeSingleSelection(filterInputComboViewer);
		modelValue = BeanProperties.value("filters.input").observe(
				interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
		// удалённый ip
		widgetValue = SWTObservables.observeText(remoteIpText, SWT.Modify);
		modelValue = BeanProperties.value(InterfaceBean.class, "ip.remote")
				.observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy_text, null);
		// фильтр исходящих
		widgetValue = ViewersObservables
				.observeSingleSelection(filterOutputComboViewer);
		modelValue = BeanProperties.value("filters.output").observe(
				interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
		// Таймер неактивности
		widgetValue = SWTObservables.observeSelection(timerSpinner);
		modelValue = BeanProperties.value("timer").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
		// NAT режим
		widgetValue = ViewersObservables.observeSingleSelection(natComboViewer);
		modelValue = BeanProperties.value("nat").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
		// MTU
		widgetValue = SWTObservables.observeSelection(mtuSpinner);
		modelValue = BeanProperties.value("mtu").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
		/** **/
		// Не туннелированных
		widgetValue = SWTObservables.observeSelection(tunnelButton);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.notTunneled").observe(interfacesBean);
		// стратегия для конверсии boolean -> BooleanType
		UpdateValueStrategy updateValueStrategy = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT);
		updateValueStrategy.setConverter(new Boolean2BooleanTypeConverter());
		// стратегия для обратной конверсии BooleanType -> boolean
		UpdateValueStrategy updateFromValueStrategy = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT)
				.setConverter(new BooleanType2BooleanConverter());
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
				updateFromValueStrategy);
		// Транзитных
		widgetValue = SWTObservables.observeSelection(transitButton);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.forward").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
				updateFromValueStrategy);
		// DHCP протокола
		widgetValue = SWTObservables.observeSelection(dhcpButton);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.dhcp").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
				updateFromValueStrategy);
		// RIP протокола
		widgetValue = SWTObservables.observeSelection(ripButton);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.rip").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
				updateFromValueStrategy);
		// Multicast
		widgetValue = SWTObservables.observeSelection(multicastButton);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.multicast").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
				updateFromValueStrategy);
		// Cluster
		widgetValue = SWTObservables.observeSelection(clusterButton);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.cluster").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
				updateFromValueStrategy);
		// IP статистика
		widgetValue = SWTObservables.observeSelection(ipButton);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.ipStat").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
				updateFromValueStrategy);
		// Прокси ARP
		widgetValue = SWTObservables.observeSelection(proxyButton);
		modelValue = BeanProperties.value(InterfaceBean.class,
				"disableDatagrams.proxyARP").observe(interfacesBean);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
				updateFromValueStrategy);
		ObservableListContentProvider contentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(contentProvider);

		List<InterfaceRouteBean> routesList = InterfaceRouteModel.getInstance().getData();
		IObservableSet knownElements = contentProvider.getKnownElements();
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

		IObservableMap[] maps = { ips, bitss, gateways, metrics, tags };

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

		IObservableList input = Properties.selfList(InterfaceRouteBean.class)
				.observe(routesList);

		tableViewer.setLabelProvider(labelProvider);
		tableViewer.setInput(input);
	}

	@Override
	protected void okPressed() {
		List<InterfaceRouteBean> irb = InterfaceRouteModel.getInstance()
				.getData();
		InterfaceRoutesBean irbean = new InterfaceRoutesBean();
		irbean.setRoute(irb);
		interfacesBean.setRoutes(irbean);
		ctx.updateModels();
		super.okPressed();
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
