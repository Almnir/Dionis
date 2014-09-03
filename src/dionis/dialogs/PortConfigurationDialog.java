package dionis.dialogs;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import dionis.models.PortsModel;
import dionis.utils.Constants;
import dionis.xml.PortsSIOControlType;
import dionis.xml.PortsSIODirectionType;
import dionis.xml.PortsSIOParityType;
import dionis.xml.SIO;

public class PortConfigurationDialog extends Dialog {
	private Text text;
	private Combo combo;
	private Combo combo_1;
	private Combo combo_2;
	private Combo combo_3;
	private Combo combo_4;
	private Combo combo_5;
	private SIO sio;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param iSelection
	 */
	public PortConfigurationDialog(Shell parentShell, ISelection iSelection) {
		super(parentShell);
		IStructuredSelection sel = (IStructuredSelection) iSelection;
		sio = (SIO) sel.getFirstElement();
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

		combo = new Combo(container, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1));
		combo.setItems(Constants.PORT_SPEED);
		// combo.select(Constants.PORT_SPEED.length / 2);

		Label label_1 = new Label(container, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_1.setText("Количество бит");

		combo_1 = new Combo(container, SWT.READ_ONLY);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		combo_1.setItems(Constants.BIT_COUNT);
		// combo_1.select(Constants.BIT_COUNT.length / 2);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("Управление потоком");

		combo_2 = new Combo(container, SWT.READ_ONLY);
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		combo_2.setItems(Constants.PORT_CONTROL);
		// combo_2.select(Constants.PORT_CONTROL.length / 2);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_1.setText("Чётность");

		combo_3 = new Combo(container, SWT.READ_ONLY);
		combo_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		combo_3.setItems(Constants.PORT_FRAME_CHECK);
		// combo_3.select(Constants.PORT_FRAME_CHECK.length / 2);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setText("Направление");

		combo_4 = new Combo(container, SWT.READ_ONLY);
		combo_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		combo_4.setItems(Constants.PORT_TYPE);
		// combo_4.select(Constants.PORT_TYPE.length / 2);

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_3.setText("Стоп-бит");

		combo_5 = new Combo(container, SWT.READ_ONLY);
		combo_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		combo_5.setItems(Constants.PORT_FRAME_STOP);
		// combo_5.select(Constants.PORT_FRAME_STOP.length / 2);

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setText("Настройка модема");

		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3,
				1));

		getAll();
		return container;
	}

	private void getAll() {
		// SPEED
		// форматирование для дробных, отбрасывание знаков после запятой
		String df = new DecimalFormat("#.#").format(sio.getSpeed()).replaceAll(
				",", ".");
		combo.select(Arrays.asList(Constants.PORT_SPEED).indexOf(df));
		// BITS
		combo_1.select(Arrays.asList(Constants.BIT_COUNT).indexOf(
				String.valueOf(sio.getBits())));
		// CONTROL
		combo_2.select((Arrays.asList(Constants.PORT_CONTROL)
				.indexOf(Constants.PORT_CONTROL[sio.getControl().ordinal()])));
		// PARITY
		combo_3.select((Arrays.asList(Constants.PORT_FRAME_CHECK)
				.indexOf(Constants.PORT_FRAME_CHECK[sio.getParity().ordinal()])));
		// DIRECTION
		combo_4.select((Arrays.asList(Constants.PORT_TYPE)
				.indexOf(Constants.PORT_TYPE[sio.getDirection().ordinal()])));
		// STOP BIT
		// форматирование для дробных, отбрасывание знаков после запятой
		df = new DecimalFormat("#.#").format(sio.getStopBit()).replaceAll(",",
				".");
		combo_5.select(Arrays.asList(Constants.PORT_FRAME_STOP).indexOf(df));
		// MODEM
		String textStr = sio.getModem();
		if (textStr != null) {
			text.setText(textStr);
		} else {
			text.setText("");
		}
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

	@Override
	protected void okPressed() {
		sio.setSpeed(Float.parseFloat(Constants.PORT_SPEED[combo
				.getSelectionIndex()]));
		sio.setBits(Byte.parseByte(Constants.BIT_COUNT[combo_1
				.getSelectionIndex()]));
		sio.setControl(PortsSIOControlType
				.fromValue(Constants.PORT_CONTROL[combo_2.getSelectionIndex()]));
		sio.setParity(PortsSIOParityType
				.fromValue(Constants.PORT_FRAME_CHECK[combo_3
						.getSelectionIndex()]));
		switch (combo_4.getSelectionIndex()) {
		// входной
		case 0:
			sio.setDirection(PortsSIODirectionType.INPUT);
			break;
		// выходной
		case 1:
			sio.setDirection(PortsSIODirectionType.OUTPUT);
			break;
		// динамический
		case 2:
			sio.setDirection(PortsSIODirectionType.DYNAMIC);
			break;
		}
		sio.setStopBit(Float.parseFloat(Constants.PORT_FRAME_STOP[combo_5
				.getSelectionIndex()]));
		sio.setModem(text.getText());
		List<SIO> siosList = PortsModel.getInstance().getSios();
		// если список SIO портов не пуст
		if (siosList != null) {
			// изменяем элемент порта в списке
			int indexx = siosList.indexOf(sio);
			siosList.set(indexx, sio);
			// меняем список SIO портов в модели на изменённый
			PortsModel.getInstance().setSios(siosList);
		}
		super.okPressed();
	}
}
