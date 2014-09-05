package dionis.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import dionis.models.ARPModel;
import dionis.models.NATAddressModel;
import dionis.xml.NATTableStatic;

public class ARPElementDialog extends Dialog {
	private String[] data;
	private Text text;
	private Text text_1;
	private boolean newadd;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param sel
	 */
	public ARPElementDialog(Shell parentShell, IStructuredSelection sel) {
		super(parentShell);
		if (sel != null) {
			this.data = (String[]) sel.getFirstElement();
			this.newadd = false;
		} else {
			this.data = new String[] { "", "" };
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
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));

		Label lblIp = new Label(container, SWT.NONE);
		lblIp.setText("IP адрес");

		text = new Text(container, SWT.BORDER);
		// text = new IPAddressBox(container, false, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblMac = new Label(container, SWT.NONE);
		lblMac.setText("MAC адрес");

		text_1 = new Text(container, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		getAll();

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

	private void getAll() {
		if (data != null) {
			if (newadd == false) {
				// добавление
				text.setText(this.data[0]);
				text_1.setText(this.data[1]);
			} else {
				// новое
				text.setText("0.0.0.0");
				text_1.setText("0.0.0.0");
			}
		}
	}

	@Override
	protected void okPressed() {

		this.data[0] = text.getText();
		this.data[1] = text_1.getText();

		List<String[]> arpdata = ARPModel.getInstance().getAllARP();

		// если список портов не пуст
		if (arpdata != null) {
			// изменяем элемент в списке
			int indexx = arpdata.indexOf(data);
			if (indexx == -1) {
				// если нет в списке - добавить
				arpdata.add(data);
			} else {
				// если есть - заменить на текущее
				arpdata.set(indexx, data);
			}
		} else {
			// новый список портов
			arpdata = new ArrayList<String[]>();
			arpdata.add(data);
		}
		// меняем список в модели на изменённый
		ARPModel.getInstance().setAllARP(arpdata);
		super.okPressed();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 153);
	}

}
