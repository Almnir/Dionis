package dionis.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;

import dionis.beans.InterfaceBean;
import dionis.models.InterfaceModel;
import dionis.xml.InterfaceParametrs;

public class VLANDialog extends Dialog {

	private Spinner vlanSpinner;
	private InterfaceParametrs parametrs;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public VLANDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		
		parent.getShell().setText("Дополнительные параметры");
		
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));
		
		Label label = new Label(container, SWT.NONE);
		label.setText("Базовый интерфейс");
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Combo interfaceCombo = new Combo(container, SWT.READ_ONLY);
		ComboViewer interfaceComboViewer = new ComboViewer(interfaceCombo);
		GridData gd_interfaceCombo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_interfaceCombo.widthHint = 119;
		interfaceCombo.setLayoutData(gd_interfaceCombo);
		interfaceComboViewer.setContentProvider(ArrayContentProvider.getInstance());
		interfaceComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				String rv = "";
				if (element instanceof InterfaceBean) {
					InterfaceBean ibean = (InterfaceBean) element;
					rv = ibean.getName();
				}
				return rv;
			}
		});
		// если нет интерфейсов, то отключаем комбо
		if (InterfaceModel.getInstance().getData() != null && !InterfaceModel.getInstance().getData().isEmpty()) {
			interfaceComboViewer.setInput(InterfaceModel.getInstance().getData());
			interfaceCombo.setEnabled(true);
		} else {
			interfaceCombo.setEnabled(false);
		}
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("VLAN идентификатор");
		
		vlanSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_vlanSpinner = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_vlanSpinner.widthHint = 119;
		vlanSpinner.setLayoutData(gd_vlanSpinner);
		vlanSpinner.setMinimum(1);
		vlanSpinner.setMaximum(4095);
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_1.setText("Скорость передачи");
		
		Spinner spinner = new Spinner(container, SWT.BORDER);
		GridData gd_spinner = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_spinner.widthHint = 119;
		spinner.setLayoutData(gd_spinner);
		spinner.setMinimum(0);
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_2.setText("Скорость приёма");
		
		Spinner spinner_2 = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_spinner_2.widthHint = 119;
		spinner_2.setLayoutData(gd_spinner_2);
		spinner_2.setMinimum(0);

		init();
		
		return container;
	}

	private void init() {
//		parametrs.getVLANs().getVLAN().getVNID()
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
		return new Point(367, 227);
	}

	@Override
	protected void okPressed() {
		// TODO Auto-generated method stub
		super.okPressed();
	}

	public InterfaceParametrs getParametrs() {
		return parametrs;
	}

	public void setParametrs(InterfaceParametrs parametrs) {
		this.parametrs = parametrs;
	}
}
