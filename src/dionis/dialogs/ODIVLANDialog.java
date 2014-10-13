package dionis.dialogs;

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
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import dionis.beans.VLANBean;

public class ODIVLANDialog extends Dialog {
	private Text addressText;
	private VLANBean data;
	private boolean newadd;
	private Spinner bitsSpinner;
	private Spinner vlanIdSpinner;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ODIVLANDialog(Shell parentShell, IStructuredSelection sel) {
		super(parentShell);
		if (sel != null) {
			this.data = (VLANBean) sel.getFirstElement();
			this.newadd = false;
		} else {
			this.data = new VLANBean();
			this.newadd = true;
		}
	}
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(4, false));
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Адрес");
		
		addressText = new Text(container, SWT.BORDER);
		GridData gd_addressText = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_addressText.widthHint = 178;
		addressText.setLayoutData(gd_addressText);
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("Значащих бит");
		
		bitsSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_bitsSpinner = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_bitsSpinner.widthHint = 49;
		bitsSpinner.setLayoutData(gd_bitsSpinner);
		
		Label lblVnid = new Label(container, SWT.NONE);
		lblVnid.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblVnid.setText("VNID идентификатор");
		
		vlanIdSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_vlanIdSpinner = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_vlanIdSpinner.widthHint = 49;
		vlanIdSpinner.setLayoutData(gd_vlanIdSpinner);
		new Label(container, SWT.NONE);

		init();
		
		return container;
	}

	private void init() {
		setFieldsToDefault();
		if (data != null) {
			if (newadd == false) {
				addressText.setText(data.getIp());
				bitsSpinner.setSelection(data.getBits());
				vlanIdSpinner.setSelection(data.getVnid());
			}
		}
		
	}
	
	private void setFieldsToDefault() {
		addressText.setText("");
		bitsSpinner.setSelection(0);
		vlanIdSpinner.setSelection(0);
	}
	
	
	@Override
	protected void okPressed() {
		data.setIp(addressText.getText());
		data.setBits((short) bitsSpinner.getSelection());
		data.setVnid(vlanIdSpinner.getSelection());
		super.okPressed();
	}
	
	/**
	 * Create contents of the button bar.
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
		return new Point(435, 166);
	}
	public VLANBean getData() {
		return data;
	}
	public void setData(VLANBean data) {
		this.data = data;
	}
}
