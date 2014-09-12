package dionis.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;

public class GREDialog extends Dialog {

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public GREDialog(Shell parentShell) {
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
		container.setLayout(new GridLayout(4, false));

		Button btnCheckButton = new Button(container, SWT.CHECK);
		btnCheckButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 2));
		btnCheckButton.setText("Нумерация пакетов");
		new Label(container, SWT.NONE);

		Button btnCheckButton_1 = new Button(container, SWT.CHECK);
		btnCheckButton_1.setText("Контрольная сумма");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Button btnCheckButton_2 = new Button(container, SWT.CHECK);
		btnCheckButton_2.setText("Копировать поле TOS");
		new Label(container, SWT.NONE);

		Label lblDf = new Label(container, SWT.NONE);
		lblDf.setText("Флаг DF");

		Combo combo = new Combo(container, SWT.NONE);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gd_combo.widthHint = 130;
		combo.setLayoutData(gd_combo);

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		GridData gd_lblNewLabel_4 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel_4.widthHint = 215;
		lblNewLabel_4.setLayoutData(gd_lblNewLabel_4);
		lblNewLabel_4.setText("Установить значение TOS");

		Spinner spinner_4 = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_4 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_spinner_4.widthHint = 48;
		spinner_4.setLayoutData(gd_spinner_4);
		spinner_4.setMinimum(0);
		spinner_4.setMaximum(255);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		lblNewLabel.setText("Размер буфера");

		Spinner spinner = new Spinner(container, SWT.BORDER);
		GridData gd_spinner = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_spinner.widthHint = 78;
		spinner.setLayoutData(gd_spinner);
		spinner.setMinimum(0);
		spinner.setMaximum(65535);

		new Label(container, SWT.NONE);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		lblNewLabel_1.setText("Максимальная задержка пакетов");

		Spinner spinner_1 = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_spinner_1.widthHint = 78;
		spinner_1.setLayoutData(gd_spinner_1);
		spinner_1.setMinimum(0);
		spinner_1.setMaximum(65535);
		new Label(container, SWT.NONE);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		lblNewLabel_2.setText("Интервал отрпавки запросов");

		Spinner spinner_2 = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_2 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_spinner_2.widthHint = 78;
		spinner_2.setLayoutData(gd_spinner_2);
		spinner_2.setMinimum(0);
		spinner_2.setMaximum(65535);
		new Label(container, SWT.NONE);

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		lblNewLabel_3.setText("Максимальный интервал ожидания ответов");

		Spinner spinner_3 = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_3 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_spinner_3.widthHint = 78;
		spinner_3.setLayoutData(gd_spinner_3);
		spinner_3.setMinimum(0);
		spinner_3.setMaximum(65535);
		new Label(container, SWT.NONE);

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
		return new Point(660, 315);
	}

	@Override
	protected void okPressed() {
		// TODO Auto-generated method stub
		super.okPressed();
	}
	
}
