package dionis.dialogs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import dionis.models.TunnelFilterModel;
import dionis.providers.TunnelFilterLableProvider;
import dionis.xml.TunnelFilter;

public class TunnelDialog extends Dialog {
	private Text localIpText;
	private Text remoteIpText;
	private Table table;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public TunnelDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(5, false));

		Label label = new Label(container, SWT.NONE);
		label.setText("Идентификатор");

		Spinner idSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_idSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_idSpinner.widthHint = 58;
		idSpinner.setLayoutData(gd_idSpinner);

		Label label_1 = new Label(container, SWT.NONE);

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

		Group group = new Group(container, SWT.NONE);
		group.setLayout(new GridLayout(3, false));
		GridData gd_group = new GridData(SWT.FILL, SWT.FILL, false, false, 5, 1);
		gd_group.widthHint = 352;
		group.setLayoutData(gd_group);

		Button btnUdp = new Button(group, SWT.CHECK);
		btnUdp.setText("UDP заголовок");

		Label label_2 = new Label(group, SWT.NONE);
		label_2.setText("Порт отправителя");

		Spinner senderPortSpinner = new Spinner(group, SWT.BORDER);
		GridData gd_senderPortSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_senderPortSpinner.widthHint = 58;
		senderPortSpinner.setLayoutData(gd_senderPortSpinner);
		new Label(group, SWT.NONE);

		Label label_3 = new Label(group, SWT.NONE);
		label_3.setText("Порт получателя");

		Spinner receiverPortSpinner = new Spinner(group, SWT.BORDER);
		GridData gd_receiverPortSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_receiverPortSpinner.widthHint = 58;
		receiverPortSpinner.setLayoutData(gd_receiverPortSpinner);

		Button compressStreamButton = new Button(container, SWT.CHECK);
		compressStreamButton.setText("Сжатие потока");
		new Label(container, SWT.NONE);

		Button doNotProcessButton = new Button(container, SWT.CHECK);
		doNotProcessButton.setText("Не обрабатывать");
		new Label(container, SWT.NONE);

		Button blockButton = new Button(container, SWT.CHECK);
		blockButton.setText("Блокировать");

		Group group_1 = new Group(container, SWT.NONE);
		group_1.setLayout(new GridLayout(4, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 5,
				1));

		Button encryptButton = new Button(group_1, SWT.CHECK);
		encryptButton.setText("Шифрование потока");
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);

		Label label_4 = new Label(group_1, SWT.NONE);
		label_4.setText("Номер серии ключей");

		Spinner keySeriesNumberSpinner = new Spinner(group_1, SWT.BORDER);
		GridData gd_keySeriesNumberSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_keySeriesNumberSpinner.widthHint = 58;
		keySeriesNumberSpinner.setLayoutData(gd_keySeriesNumberSpinner);

		Label lblNewLabel_2 = new Label(group_1, SWT.NONE);
		lblNewLabel_2.setText("Локальный криптономер");

		Spinner localCryptonumberSpinner = new Spinner(group_1, SWT.BORDER);
		GridData gd_localCryptonumberSpinner = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_localCryptonumberSpinner.widthHint = 58;
		localCryptonumberSpinner.setLayoutData(gd_localCryptonumberSpinner);

		Label lblNewLabel_3 = new Label(group_1, SWT.NONE);
		lblNewLabel_3.setText("Номер криптоканала");

		Spinner cryptochannelNumberSpinner = new Spinner(group_1, SWT.BORDER);
		GridData gd_cryptochannelNumberSpinner = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_cryptochannelNumberSpinner.widthHint = 58;
		cryptochannelNumberSpinner.setLayoutData(gd_cryptochannelNumberSpinner);

		Label lblNewLabel_4 = new Label(group_1, SWT.NONE);
		lblNewLabel_4.setText("Удалённый криптономер");

		Spinner remoteCryptonumberSpinner = new Spinner(group_1, SWT.BORDER);
		GridData gd_remoteCryptonumberSpinner = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_remoteCryptonumberSpinner.widthHint = 58;
		remoteCryptonumberSpinner.setLayoutData(gd_remoteCryptonumberSpinner);

		Group group_2 = new Group(container, SWT.NONE);
		group_2.setText("Правило отбора");
		group_2.setLayout(new GridLayout(1, false));
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));

		final TableViewer tableViewer = new TableViewer(group_2, SWT.BORDER
				| SWT.FULL_SELECTION);
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

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setLabelProvider(new TunnelFilterLableProvider());
		tableViewer.setInput(TunnelFilterModel.getInstance().getDataArray());

		Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem changeItem = new MenuItem(menu, SWT.NONE);
		changeItem.setText("Изменить");

		changeItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (table.getSelection() != null
						&& table.getSelection().length > 0) {
					IStructuredSelection sel = (IStructuredSelection) tableViewer
							.getSelection();
					TunnelFilterDialog dialog = new TunnelFilterDialog(
							getShell(), sel);
					if (dialog.open() == Window.OK) {
						Job job = new Job("change") {

							@Override
							protected IStatus run(IProgressMonitor monitor) {
								Display.getDefault().asyncExec(new Runnable() {
									@Override
									public void run() {
										tableViewer.setInput(TunnelFilterModel
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

		final MenuItem addItem = new MenuItem(menu, SWT.NONE);
		addItem.setText("Добавить");

		addItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TunnelFilterDialog dialog = new TunnelFilterDialog(getShell(),
						null);
				if (dialog.open() == Window.OK) {
					Job job = new Job("add") {

						@Override
						protected IStatus run(IProgressMonitor monitor) {
							Display.getDefault().asyncExec(new Runnable() {
								@Override
								public void run() {
									tableViewer.setInput(TunnelFilterModel
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

		final MenuItem removeItem = new MenuItem(menu, SWT.NONE);
		removeItem.setText("Удалить");

		removeItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				TunnelFilter tunnelFilter = (TunnelFilter) sel
						.getFirstElement();
				TunnelFilterModel.getInstance().removeData(tunnelFilter);
				Job job = new Job("remove") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								tableViewer.setInput(TunnelFilterModel
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

		menu.addListener(SWT.Show, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TableItem[] selected = table.getSelection();
				if (selected.length == 0) {
					changeItem.setEnabled(false);
					addItem.setEnabled(true);
					removeItem.setEnabled(false);
				} else {
					changeItem.setEnabled(true);
					addItem.setEnabled(true);
					removeItem.setEnabled(true);
				}
			}
		});

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

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(774, 567);
	}
}
