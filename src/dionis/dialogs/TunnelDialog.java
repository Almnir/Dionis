package dionis.dialogs;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
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

import dionis.beans.CryptoNumberBean;
import dionis.beans.TunnelBean;
import dionis.beans.TunnelEncryptionBean;
import dionis.beans.TunnelFilterBean;
import dionis.beans.TunnelFiltersBean;
import dionis.beans.TunnelIPBean;
import dionis.beans.TunnelUDPPortsBean;
import dionis.beans.UDPBean;
import dionis.models.TunnelFilterModel;
import dionis.models.TunnelModel;
import dionis.providers.TunnelFilterLableProvider;
import dionis.xml.BooleanType;

/**
 * Диалог позволяющий редактировать настройки конкретного туннеля
 * 
 * @author Ярных А.О.
 *
 */
public class TunnelDialog extends Dialog {
	private Text localIpText;
	private Text remoteIpText;
	private Table table;
	private TunnelBean data;
	private boolean newadd;
	private Spinner idSpinner;
	private Button btnUdp;
	private Spinner senderPortSpinner;
	private Spinner receiverPortSpinner;
	private Button compressStreamButton;
	private Button doNotProcessButton;
	private Button blockButton;
	private Button encryptButton;
	private Spinner keySeriesNumberSpinner;
	private Spinner localCryptonumberSpinner;
	private Spinner cryptochannelNumberSpinner;
	private Spinner remoteCryptonumberSpinner;
	private TableViewer tableViewer;
	protected TunnelFilterBean copyPasteFilter;
	private MenuItem pasteItem;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public TunnelDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public TunnelDialog(Shell parentShell, IStructuredSelection sel) {
		super(parentShell);
		if (sel != null) {
			this.data = (TunnelBean) sel.getFirstElement();
			this.newadd = false;
		} else {
			this.data = new TunnelBean();
			this.newadd = true;
			TunnelFilterModel.getNewInstance();
		}
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		parent.getShell().setText("Туннель");

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(5, false));

		Label label = new Label(container, SWT.NONE);
		label.setText("Идентификатор");

		idSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_idSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_idSpinner.widthHint = 58;
		idSpinner.setLayoutData(gd_idSpinner);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel.setText("Локальный IP адрес");

		localIpText = new Text(container, SWT.BORDER);
		GridData gd_localIpText = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_localIpText.widthHint = 191;
		localIpText.setLayoutData(gd_localIpText);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_1.setText("Удалённый IP адрес");

		remoteIpText = new Text(container, SWT.BORDER);
		GridData gd_remoteIpText = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_remoteIpText.widthHint = 191;
		remoteIpText.setLayoutData(gd_remoteIpText);
		new Label(container, SWT.NONE);

		Group group = new Group(container, SWT.NONE);
		group.setLayout(new GridLayout(3, false));
		GridData gd_group = new GridData(SWT.FILL, SWT.FILL, false, false, 5, 1);
		gd_group.widthHint = 352;
		group.setLayoutData(gd_group);

		btnUdp = new Button(group, SWT.CHECK);
		btnUdp.setText("UDP заголовок");

		Label label_2 = new Label(group, SWT.NONE);
		label_2.setText("Порт отправителя");

		senderPortSpinner = new Spinner(group, SWT.BORDER);
		GridData gd_senderPortSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_senderPortSpinner.widthHint = 58;
		senderPortSpinner.setLayoutData(gd_senderPortSpinner);
		new Label(group, SWT.NONE);

		Label label_3 = new Label(group, SWT.NONE);
		label_3.setText("Порт получателя");

		receiverPortSpinner = new Spinner(group, SWT.BORDER);
		GridData gd_receiverPortSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_receiverPortSpinner.widthHint = 58;
		receiverPortSpinner.setLayoutData(gd_receiverPortSpinner);

		// переключатель UDP секции
		btnUdp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnUdp.getSelection()) {
					senderPortSpinner.setEnabled(true);
					receiverPortSpinner.setEnabled(true);
				} else {
					senderPortSpinner.setEnabled(false);
					receiverPortSpinner.setEnabled(false);
				}
			}
		});

		compressStreamButton = new Button(container, SWT.CHECK);
		compressStreamButton.setText("Сжатие потока");
		new Label(container, SWT.NONE);

		doNotProcessButton = new Button(container, SWT.CHECK);
		doNotProcessButton.setText("Не обрабатывать");
		new Label(container, SWT.NONE);

		blockButton = new Button(container, SWT.CHECK);
		blockButton.setText("Блокировать");

		Group group_1 = new Group(container, SWT.NONE);
		group_1.setLayout(new GridLayout(4, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 5,
				1));

		encryptButton = new Button(group_1, SWT.CHECK);
		encryptButton.setText("Шифрование потока");
		encryptButton.setSelection(false);
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);

		encryptButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (encryptButton.getSelection()) {
					keySeriesNumberSpinner.setEnabled(true);
					localCryptonumberSpinner.setEnabled(true);
					remoteCryptonumberSpinner.setEnabled(true);
					cryptochannelNumberSpinner.setEnabled(true);
				} else {
					keySeriesNumberSpinner.setEnabled(false);
					localCryptonumberSpinner.setEnabled(false);
					remoteCryptonumberSpinner.setEnabled(false);
					cryptochannelNumberSpinner.setEnabled(false);
				}
			}
		});

		Label label_4 = new Label(group_1, SWT.NONE);
		label_4.setText("Номер серии ключей");

		keySeriesNumberSpinner = new Spinner(group_1, SWT.BORDER);
		GridData gd_keySeriesNumberSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_keySeriesNumberSpinner.widthHint = 58;
		keySeriesNumberSpinner.setLayoutData(gd_keySeriesNumberSpinner);

		Label lblNewLabel_2 = new Label(group_1, SWT.NONE);
		lblNewLabel_2.setText("Локальный криптономер");

		localCryptonumberSpinner = new Spinner(group_1, SWT.BORDER);
		GridData gd_localCryptonumberSpinner = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_localCryptonumberSpinner.widthHint = 58;
		localCryptonumberSpinner.setLayoutData(gd_localCryptonumberSpinner);

		Label lblNewLabel_3 = new Label(group_1, SWT.NONE);
		lblNewLabel_3.setText("Номер криптоканала");

		cryptochannelNumberSpinner = new Spinner(group_1, SWT.BORDER);
		GridData gd_cryptochannelNumberSpinner = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_cryptochannelNumberSpinner.widthHint = 58;
		cryptochannelNumberSpinner.setLayoutData(gd_cryptochannelNumberSpinner);

		Label lblNewLabel_4 = new Label(group_1, SWT.NONE);
		lblNewLabel_4.setText("Удалённый криптономер");

		remoteCryptonumberSpinner = new Spinner(group_1, SWT.BORDER);
		GridData gd_remoteCryptonumberSpinner = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_remoteCryptonumberSpinner.widthHint = 58;
		remoteCryptonumberSpinner.setLayoutData(gd_remoteCryptonumberSpinner);

		Group group_2 = new Group(container, SWT.NONE);
		group_2.setText("Правило отбора");
		group_2.setLayout(new GridLayout(1, false));
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));

		tableViewer = new TableViewer(group_2, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn idColumn = tableViewerColumn.getColumn();
		idColumn.setWidth(100);
		idColumn.setText("№");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn modeColumn = tableViewerColumn_5.getColumn();
		modeColumn.setWidth(100);
		modeColumn.setText("Режим");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn senderColumn = tableViewerColumn_4.getColumn();
		senderColumn.setWidth(100);
		senderColumn.setText("Отправитель");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn receiverColumn = tableViewerColumn_3.getColumn();
		receiverColumn.setWidth(100);
		receiverColumn.setText("Получатель");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn protocolColumn = tableViewerColumn_2.getColumn();
		protocolColumn.setWidth(100);
		protocolColumn.setText("Протокол");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn portsColumn = tableViewerColumn_1.getColumn();
		portsColumn.setWidth(100);
		portsColumn.setText("Порты");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem changeItem = new MenuItem(menu, SWT.NONE);
		changeItem.setText("Изменить");

		changeItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				if (!sel.isEmpty()) {
					TunnelFilterDialog dialog = new TunnelFilterDialog(
							getShell(), sel);
					if (dialog.open() == Window.OK) {
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								tableViewer.setInput(TunnelFilterModel
										.getInstance().getDataArray());
							}
						});
					}
				}
			}
		});

		final MenuItem addItem = new MenuItem(menu, SWT.NONE);
		addItem.setText("Добавить");

		// обработчик добавления фильтров туннелей в таблицу
		addItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TunnelFilterDialog dialog = new TunnelFilterDialog(getShell(),
						null);
				if (dialog.open() == Window.OK) {
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							tableViewer.setInput(TunnelFilterModel
									.getInstance().getDataArray());
						}
					});
				}
			}
		});

		final MenuItem removeItem = new MenuItem(menu, SWT.NONE);
		removeItem.setText("Удалить");

		// обработчик удаления строк в таблице фильтров туннелей
		removeItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				TunnelFilterBean tunnelFilter = (TunnelFilterBean) sel
						.getFirstElement();
				TunnelFilterModel.getInstance().removeData(tunnelFilter);
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						tableViewer.setInput(TunnelFilterModel.getInstance()
								.getDataArray());
					}
				});
			}
		});

		final MenuItem copyItem = new MenuItem(menu, SWT.NONE);
		copyItem.setText("Копировать");

		copyItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (table.getSelection() != null
						&& table.getSelection().length > 0) {
					IStructuredSelection sel = (IStructuredSelection) tableViewer
							.getSelection();
					TunnelFilterBean tunnelFilter = (TunnelFilterBean) sel
							.getFirstElement();
					// скопировать ссылку на текущее выделение
					try {
						copyPasteFilter = (TunnelFilterBean) tunnelFilter
								.clone();
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
				TunnelFilterBean filterPaste = new TunnelFilterBean();
				try {
					filterPaste = (TunnelFilterBean) copyPasteFilter.clone();
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				TunnelFilterModel.getInstance().addData(filterPaste);
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						tableViewer.setInput(TunnelFilterModel.getInstance()
								.getDataArray());
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
				TableItem[] selected = table.getSelection();
				if (selected.length == 0) {
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

		// инициализация
		getAll();

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setLabelProvider(new TunnelFilterLableProvider());
		tableViewer.setInput(TunnelFilterModel.getInstance().getDataArray());

		return container;
	}

	/**
	 * Метод инициализации диалога данными
	 */
	private void getAll() {
		setFieldsToDefault();
		if (data != null) {
			if (newadd == false) {
				/** изменение **/
				// идентификатор
				idSpinner.setSelection(data.getId());
				if (data.getIp() != null) {
					localIpText.setText(data.getIp().getLocal() != null ? data
							.getIp().getLocal() : "0.0.0.0");
					remoteIpText
							.setText(data.getIp().getRemote() != null ? data
									.getIp().getRemote() : "0.0.0.0");
				}
				// UDP секция
				if (data.getUdp() != null
						&& data.getUdp().getTitle() == BooleanType.YES) {
					// UDP порт отправления
					senderPortSpinner.setSelection(data.getUdp().getPorts()
							.getSender());
					// порт получения
					receiverPortSpinner.setSelection(data.getUdp().getPorts()
							.getReceiver());
					btnUdp.setSelection(true);
				} else {
					btnUdp.setSelection(false);
				}
				// компрессия
				compressStreamButton
						.setSelection(data.getLzw() == BooleanType.YES ? true
								: false);
				// не использовать
				doNotProcessButton
						.setSelection(data.getUnused() == BooleanType.YES ? true
								: false);
				// не блокировать
				blockButton
						.setSelection(data.getBlocked() == BooleanType.YES ? true
								: false);
				// шифрование
				if (data.getEncryption() != null) {
					keySeriesNumberSpinner.setSelection((int) data
							.getEncryption().getSerNumber());
					if (data.getEncryption().getCryptoNumber() != null) {
						localCryptonumberSpinner.setSelection((int) data
								.getEncryption().getCryptoNumber().getLocal());
						remoteCryptonumberSpinner.setSelection((int) data
								.getEncryption().getCryptoNumber().getRemote());
					} else {
						localCryptonumberSpinner.setSelection(0);
						remoteCryptonumberSpinner.setSelection(0);
					}
					cryptochannelNumberSpinner.setSelection(data
							.getEncryption().getChannel());
					encryptButton.setEnabled(true);
				} else {
					encryptButton.setEnabled(false);
				}
				// таблица
				System.out.println("Before: "
						+ TunnelFilterModel.getInstance().toString());
				TunnelFilterModel.getInstance().removeAll();
				System.out.println("After clean: "
						+ TunnelFilterModel.getInstance().toString());
				TunnelFilterModel.getInstance().setData(
						data.getFilters().getFilter());
				System.out.println("New filters : "
						+ data.getFilters().getFilter().toString());
				System.out.println("After having set new values: "
						+ TunnelFilterModel.getInstance().toString());
			}
		}
	}

	/**
	 * Установка полей в начальные значения
	 */
	private void setFieldsToDefault() {
		idSpinner.setSelection(0);
		remoteIpText.setText("0.0.0.0");
		localIpText.setText("0.0.0.0");
		btnUdp.setSelection(true);
		senderPortSpinner.setSelection(0);
		receiverPortSpinner.setSelection(0);
		compressStreamButton.setSelection(false);
		doNotProcessButton.setSelection(false);
		blockButton.setSelection(false);
		encryptButton.setSelection(true);
		keySeriesNumberSpinner.setSelection(0);
		localCryptonumberSpinner.setSelection(0);
		remoteCryptonumberSpinner.setSelection(0);
		cryptochannelNumberSpinner.setSelection(0);
	}

	@Override
	protected void okPressed() {
		// идентификатор
		data.setId(idSpinner.getSelection());
		TunnelIPBean tip = new TunnelIPBean();
		// локальный и удалённый IP
		tip.setLocal(localIpText.getText());
		tip.setRemote(remoteIpText.getText());
		data.setIp(tip);

		UDPBean udp = new UDPBean();
		// выбран
		if (btnUdp.getSelection()) {
			// UDP заголовок
			udp.setTitle(BooleanType.YES);
			TunnelUDPPortsBean udpPorts = new TunnelUDPPortsBean();
			udpPorts.setSender(senderPortSpinner.getSelection());
			udpPorts.setReceiver(receiverPortSpinner.getSelection());
			udp.setPorts(udpPorts);
		} else {
			udp.setTitle(BooleanType.NO);
		}
		data.setUdp(udp);
		// сжатие потока
		data.setLzw(compressStreamButton.getSelection() ? BooleanType.YES
				: BooleanType.NO);
		// обрабатывать
		data.setUnused(doNotProcessButton.getSelection() ? BooleanType.YES
				: BooleanType.NO);
		// блокировать
		data.setBlocked(blockButton.getSelection() ? BooleanType.YES
				: BooleanType.NO);

		// шифрование туннеля
		TunnelEncryptionBean tunnelEncryption = new TunnelEncryptionBean();
		// если блок шифрования включен
		if (encryptButton.getSelection()) {
			tunnelEncryption
					.setSerNumber(keySeriesNumberSpinner.getSelection());
			CryptoNumberBean cryptoNumber = new CryptoNumberBean();
			cryptoNumber.setLocal(localCryptonumberSpinner.getSelection());
			cryptoNumber.setRemote(remoteCryptonumberSpinner.getSelection());
			tunnelEncryption.setCryptoNumber(cryptoNumber);
			tunnelEncryption.setChannel((short) cryptochannelNumberSpinner
					.getSelection());
			// признак шифрования?
			tunnelEncryption.setMethod(BooleanType.YES);
		} else {
			tunnelEncryption.setMethod(BooleanType.NO);
		}
		data.setEncryption(tunnelEncryption);

		// добавляем ссылку на модель фильтров
		TunnelFiltersBean filters = new TunnelFiltersBean();
		List<TunnelFilterBean> filter = new LinkedList<TunnelFilterBean>();
		filter.addAll(TunnelFilterModel.getInstance().getData());
		filters.setFilter(filter);
		data.setFilters(filters);
		// очищаем синглтон с состоянием модели фильтрации туннелей
		TunnelFilterModel.getInstance().removeAll();

		List<TunnelBean> tunnelList = TunnelModel.getInstance().getData();
		// если список не пуст
		if (tunnelList != null) {
			// изменяем элемент в списке
			int indexx = tunnelList.indexOf(data);
			if (indexx == -1) {
				// если нет в списке - добавить
				tunnelList.add(data);
			} else {
				// если есть - заменить на текущее
				tunnelList.set(indexx, data);
			}
		} else {
			// новый список
			tunnelList = new LinkedList<TunnelBean>();
			tunnelList.add(data);
		}
		// меняем список в модели на изменённый
		TunnelModel.getInstance().setData(tunnelList);
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		TunnelFilterModel.getNewInstance();
		// очищаем синглтон с состоянием модели фильтрации туннелей
		// TunnelFilterModel.getInstance().removeAll();
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
		return new Point(774, 567);
	}
}
