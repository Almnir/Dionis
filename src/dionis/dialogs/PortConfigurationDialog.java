package dionis.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

import dionis.utils.Constants;

public class PortConfigurationDialog extends Dialog {
	private Text text;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public PortConfigurationDialog(Shell parentShell) {
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

		Label label = new Label(container, SWT.NONE);
		label.setText("Скорость");

		Combo combo = new Combo(container, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1));
		combo.setItems(Constants.PORT_SPEED);
		combo.select(Constants.PORT_SPEED.length / 2);

		Label label_1 = new Label(container, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_1.setText("Количество бит");

		Combo combo_1 = new Combo(container, SWT.READ_ONLY);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		combo_1.setItems(Constants.BIT_COUNT);
		combo_1.select(Constants.BIT_COUNT.length / 2);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("Управление потоком");

		Combo combo_2 = new Combo(container, SWT.READ_ONLY);
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		combo_2.setItems(Constants.PORT_CONTROL);
		combo_2.select(Constants.PORT_CONTROL.length / 2);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_1.setText("Чётность");

		Combo combo_3 = new Combo(container, SWT.READ_ONLY);
		combo_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		combo_3.setItems(Constants.PORT_FRAME_CHECK);
		combo_3.select(Constants.PORT_FRAME_CHECK.length / 2);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setText("Направление");

		Combo combo_4 = new Combo(container, SWT.READ_ONLY);
		combo_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		combo_4.setItems(Constants.PORT_TYPE);
		combo_4.select(Constants.PORT_TYPE.length / 2);

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_3.setText("Стоп-бит");

		Combo combo_5 = new Combo(container, SWT.READ_ONLY);
		combo_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		combo_5.setItems(Constants.PORT_FRAME_STOP);
		combo_5.select(Constants.PORT_FRAME_STOP.length / 2);

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setText("Настройка модема");

		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3,
				1));

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
		return new Point(688, 223);
	}

}
