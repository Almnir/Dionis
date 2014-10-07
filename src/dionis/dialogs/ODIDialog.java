package dionis.dialogs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import dionis.beans.InterfaceParametrsBean;
import dionis.beans.VLANBean;

public class ODIDialog extends Dialog {
	private Text macText;
	private Table table;
	private TableViewer tableViewer;
	private InterfaceParametrsBean parametrsBean;
	protected VLANBean copyPasteFilter;
	private MenuItem pasteItem;
	private Spinner frameSpinner;
	private Spinner buffSizeSpinner;
	private Spinner receiveLimitSpinner;
	private Control sendLimitSpinner;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public ODIDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@SuppressWarnings("unused")
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(3, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel.widthHint = 192;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("Номер фрейма");

		frameSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_frameSpinner = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_frameSpinner.widthHint = 73;
		frameSpinner.setLayoutData(gd_frameSpinner);
		frameSpinner.setMinimum(0);
		frameSpinner.setMaximum(255);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		GridData gd_lblNewLabel_2 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel_2.widthHint = 192;
		lblNewLabel_2.setLayoutData(gd_lblNewLabel_2);
		lblNewLabel_2.setText("Размер буфера обмена");

		buffSizeSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_buffSizeSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_buffSizeSpinner.widthHint = 73;
		buffSizeSpinner.setLayoutData(gd_buffSizeSpinner);
		new Label(container, SWT.NONE);
		buffSizeSpinner.setMinimum(8);
		buffSizeSpinner.setMaximum(255);

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		GridData gd_lblNewLabel_3 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel_3.widthHint = 192;
		lblNewLabel_3.setLayoutData(gd_lblNewLabel_3);
		lblNewLabel_3.setText("MAC адрес");

		macText = new Text(container, SWT.BORDER);
		macText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2,
				1));

		Group grpVlan = new Group(container, SWT.NONE);
		grpVlan.setText("Таблица VLAN");
		grpVlan.setLayout(new GridLayout(1, false));
		grpVlan.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		tableViewer = new TableViewer(grpVlan, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
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

		final MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("Изменить");

		final MenuItem changeItem = new MenuItem(menu, SWT.NONE);
		changeItem.setText("Изменить");

		changeItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (table.getSelection() != null
						&& table.getSelection().length > 0) {
					IStructuredSelection sel = (IStructuredSelection) tableViewer
							.getSelection();
					ODIVLANDialog dialog = new ODIVLANDialog(getShell(), sel);
					if (dialog.open() == Window.OK) {
						VLANBean dialogbean = dialog.getData();
						// изменяем элемент в списке
						int indexx = parametrsBean.getVlaNs().getVlan()
								.indexOf(dialogbean);
						// если есть - заменить на текущее
						parametrsBean.getVlaNs().getVlan()
								.set(indexx, dialogbean);
						Job job = new Job("change") {

							@Override
							protected IStatus run(IProgressMonitor monitor) {
								Display.getDefault().asyncExec(new Runnable() {
									@Override
									public void run() {
										tableViewer.setInput(parametrsBean
												.getVlaNs().getVlan());
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

		// обработчик добавления фильтров туннелей в таблицу
		addItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ODIVLANDialog dialog = new ODIVLANDialog(getShell(), null);
				if (dialog.open() == Window.OK) {
					// добавляем бин в список
					parametrsBean.getVlaNs().getVlan().add(dialog.getData());

					Job job = new Job("add") {

						@Override
						protected IStatus run(IProgressMonitor monitor) {
							Display.getDefault().asyncExec(new Runnable() {
								@Override
								public void run() {
									tableViewer.setInput(parametrsBean
											.getVlaNs().getVlan());
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

		// обработчик удаления строк в таблице фильтров туннелей
		removeItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				VLANBean vlanBean = (VLANBean) sel.getFirstElement();
				parametrsBean.getVlaNs().getVlan().remove(vlanBean);
				Job job = new Job("remove") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								tableViewer.setInput(parametrsBean.getVlaNs()
										.getVlan());
							}
						});
						return Status.OK_STATUS;
					}
				};
				job.setPriority(Job.SHORT);
				job.schedule();
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
					VLANBean vlanBean = (VLANBean) sel
							.getFirstElement();
					// скопировать ссылку на текущее выделение
					try {
						copyPasteFilter = (VLANBean) vlanBean
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
				VLANBean vlanBean = new VLANBean();
				try {
					vlanBean = (VLANBean) copyPasteFilter.clone();
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				parametrsBean.getVlaNs().getVlan().add(vlanBean);
				Job job = new Job("paste") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								tableViewer.setInput(parametrsBean.getVlaNs()
										.getVlan());
							}
						});
						return Status.OK_STATUS;
					}
				};
				job.setPriority(Job.SHORT);
				job.schedule();
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

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setText("Ограничение скорости передачи");
		new Label(container, SWT.NONE);

		sendLimitSpinner = new Spinner(container, SWT.BORDER);
		sendLimitSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Label lblNewLabel_5 = new Label(container, SWT.NONE);
		lblNewLabel_5.setText("Ограничение скорости приёма");
		new Label(container, SWT.NONE);

		receiveLimitSpinner = new Spinner(container, SWT.BORDER);
		receiveLimitSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		receiveLimitSpinner.setMinimum(0);

		init();

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return null;
			}
		});
		tableViewer.setInput(parametrsBean.getVlaNs().getVlan());

		return container;
	}

	private void init() {
		frameSpinner.setSelection(parametrsBean.getFrame());
//		buffSizeSpinner.setSelection(parametrsBean.get)
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
		return new Point(529, 461);
	}

	@Override
	protected void okPressed() {
		// TODO Auto-generated method stub
		super.okPressed();
	}

	public InterfaceParametrsBean getParametrsBean() {
		return parametrsBean;
	}

	public void setParametrsBean(InterfaceParametrsBean parametrsBean) {
		this.parametrsBean = parametrsBean;
	}
}
