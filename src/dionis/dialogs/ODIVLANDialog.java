package dionis.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
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

/**
 * Диалог ODI параметров для диалога VLAN
 * 
 * @author Ярных А.О.
 *
 */
public class ODIVLANDialog extends Dialog {
	private Text addressText;
	private Spinner bitsSpinner;
	private Spinner vlanIdSpinner;
	private DataBindingContext ctx;

	private VLANBean vlanBean;

	public ODIVLANDialog(Shell parentShell, VLANBean vlanBean) {
		super(parentShell);
		this.vlanBean = vlanBean;
		if (this.vlanBean == null) {
			this.vlanBean = new VLANBean();
		}
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		
		parent.getShell().setText("VLAN - описатель");
		
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(4, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel.setText("Адрес");

		addressText = new Text(container, SWT.BORDER);
		GridData gd_addressText = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_addressText.widthHint = 178;
		addressText.setLayoutData(gd_addressText);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("Значащих бит");

		bitsSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_bitsSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_bitsSpinner.widthHint = 49;
		bitsSpinner.setLayoutData(gd_bitsSpinner);

		Label lblVnid = new Label(container, SWT.NONE);
		lblVnid.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
				2, 1));
		lblVnid.setText("VNID идентификатор");

		vlanIdSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_vlanIdSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_vlanIdSpinner.widthHint = 49;
		vlanIdSpinner.setLayoutData(gd_vlanIdSpinner);
		new Label(container, SWT.NONE);

		setFieldsToDefault();

		bindData();

		return container;
	}

	private void bindData() {
		// контекст датабиндинга
		ctx = new DataBindingContext();
		// Адрес
		IObservableValue widgetValue = SWTObservables.observeText(addressText,
				SWT.Modify);
		IObservableValue modelValue = BeanProperties
				.value(VLANBean.class, "ip").observe(vlanBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// Значащих бит
		widgetValue = SWTObservables.observeSelection(bitsSpinner);
		modelValue = BeanProperties.value("bits").observe(vlanBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// VNID идентификатор
		widgetValue = SWTObservables.observeSelection(vlanIdSpinner);
		modelValue = BeanProperties.value("vnid").observe(vlanBean);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// обновить виджеты
		ctx.updateTargets();
	}

	@Override
	protected void okPressed() {
		ctx.updateModels();
		super.okPressed();
	}

	// private void init() {
	// setFieldsToDefault();
	// if (vlanBean != null) {
	// if (newadd == false) {
	// addressText.setText(vlanBean.getIp());
	// bitsSpinner.setSelection(vlanBean.getBits());
	// vlanIdSpinner.setSelection(vlanBean.getVnid());
	// }
	// }
	//
	// }

	private void setFieldsToDefault() {
		addressText.setText("");
		bitsSpinner.setSelection(0);
		vlanIdSpinner.setSelection(0);
	}

	// @Override
	// protected void okPressed() {
	// vlanBean.setIp(addressText.getText());
	// vlanBean.setBits((short) bitsSpinner.getSelection());
	// vlanBean.setVnid(vlanIdSpinner.getSelection());
	// super.okPressed();
	// }

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
		return new Point(435, 166);
	}

	public VLANBean getVlanBean() {
		return vlanBean;
	}
}
