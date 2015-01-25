package dionis.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class InterfaceDuplexDialog extends Dialog {
	private Text addressText;
	private Table scriptTable;
	private Button noRadioButton;
	private Button papRadioButton;
	private Button chapRadioButton;
	private Text loginText;
	private Text passwordText;
	private Button noRadioButton_1;
	private Button papRadioButton_1;
	private Button chapRadioButton_1;
	private Text loginText_1;
	private Text passwordText_1;
	private Combo portsCombo;
	private Combo modeCombo;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public InterfaceDuplexDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.RESIZE | SWT.TITLE);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		getParentShell().setMinimumSize(new Point(849, 631));

		getParentShell().setText("Дополнительные параметры");

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(9, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel.setText("Тип портов");

		portsCombo = new Combo(container, SWT.READ_ONLY);
		portsCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_2.setText("Режим");

		modeCombo = new Combo(container, SWT.READ_ONLY);
		modeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Group group = new Group(container, SWT.NONE);
		group.setText("Порты");
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 9, 1));

		ScrolledComposite scrolledComposite = new ScrolledComposite(group,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("Сценарий соединения");
		group_1.setLayout(new GridLayout(2, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 9, 1));

		Composite composite = new Composite(group_1, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				1, 1));

		Label lblNewLabel_6 = new Label(composite, SWT.NONE);
		lblNewLabel_6.setText("Адрес");

		addressText = new Text(composite, SWT.BORDER);
		addressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		new Label(composite, SWT.NONE);

		Label lblNewLabel_7 = new Label(composite, SWT.NONE);
		lblNewLabel_7.setText("Количество попыток");

		Spinner retrySpinner = new Spinner(composite, SWT.BORDER);
		retrySpinner.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 1, 1));
		new Label(composite, SWT.NONE);

		Label lblNewLabel_9 = new Label(composite, SWT.NONE);
		lblNewLabel_9.setText("Ждать соединения (сек.)");

		Spinner connectTimeoutSpinner = new Spinner(composite, SWT.BORDER);
		connectTimeoutSpinner.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL,
				true, false, 1, 1));
		new Label(composite, SWT.NONE);

		Label lblNewLabel_10 = new Label(composite, SWT.NONE);
		lblNewLabel_10.setText("Ждать получения ответа (сек.)");

		Spinner answerTimeoutSpinner = new Spinner(composite, SWT.BORDER);
		answerTimeoutSpinner.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				true, false, 1, 1));
		new Label(composite, SWT.NONE);

		Composite composite_1 = new Composite(group_1, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));

		TableViewer scriptTableViewer = new TableViewer(composite_1, SWT.BORDER
				| SWT.FULL_SELECTION);
		scriptTable = scriptTableViewer.getTable();
		scriptTable.setHeaderVisible(true);
		scriptTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				scriptTableViewer, SWT.NONE);
		TableColumn receiveColumn = tableViewerColumn.getColumn();
		receiveColumn.setWidth(100);
		receiveColumn.setText("Получить");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				scriptTableViewer, SWT.NONE);
		TableColumn sendColumn = tableViewerColumn_1.getColumn();
		sendColumn.setWidth(100);
		sendColumn.setText("Послать");

		Group group_2 = new Group(container, SWT.NONE);
		group_2.setText("Аутентификация на удалённой стороне");
		group_2.setLayout(new GridLayout(2, false));
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4,
				1));

		Composite composite_3 = new Composite(group_2, SWT.NONE);
		composite_3.setLayout(new GridLayout(1, false));
		composite_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1));

		noRadioButton = new Button(composite_3, SWT.RADIO);
		noRadioButton.setText("Нет");

		papRadioButton = new Button(composite_3, SWT.RADIO);
		papRadioButton.setText("PAP");

		chapRadioButton = new Button(composite_3, SWT.RADIO);
		chapRadioButton.setText("CHAP");

		Composite composite_4 = new Composite(group_2, SWT.NONE);
		composite_4.setLayout(new GridLayout(2, false));
		composite_4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				1, 1));

		Label lblNewLabel_11 = new Label(composite_4, SWT.NONE);
		lblNewLabel_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_11.setText("Имя");

		loginText = new Text(composite_4, SWT.BORDER);
		loginText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		new Label(composite_4, SWT.NONE);
		new Label(composite_4, SWT.NONE);

		Label lblNewLabel_12 = new Label(composite_4, SWT.NONE);
		lblNewLabel_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_12.setText("Пароль");

		passwordText = new Text(composite_4, SWT.BORDER);
		passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Group group_3 = new Group(container, SWT.NONE);
		group_3.setText("Аутентификация на своей стороне");
		group_3.setLayout(new GridLayout(2, false));
		group_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 5,
				1));

		Composite composite_second = new Composite(group_3, SWT.NONE);
		composite_second.setLayout(new GridLayout(1, false));
		composite_second.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1));

		noRadioButton_1 = new Button(composite_second, SWT.RADIO);
		noRadioButton_1.setText("Нет");

		papRadioButton_1 = new Button(composite_second, SWT.RADIO);
		papRadioButton_1.setText("PAP");

		chapRadioButton_1 = new Button(composite_second, SWT.RADIO);
		chapRadioButton_1.setText("CHAP");

		Composite composite_2 = new Composite(group_3, SWT.NONE);
		composite_2.setLayout(new GridLayout(2, false));
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				1, 1));

		Label lblNewLabel_13 = new Label(composite_2, SWT.NONE);
		lblNewLabel_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_13.setText("Имя");

		loginText_1 = new Text(composite_2, SWT.BORDER);
		loginText_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		Label lblNewLabel_14 = new Label(composite_2, SWT.NONE);
		lblNewLabel_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_14.setText("Пароль");

		passwordText_1 = new Text(composite_2, SWT.BORDER);
		passwordText_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

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
		return new Point(849, 631);
	}

}
