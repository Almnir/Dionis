package dionis.dialogs;

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

import dionis.beans.InterfaceRouteBean;

public class InterfaceRouteDialog extends Dialog {

	private Spinner bitsSpinner;
	private Text gatewayText;
	private Text ipText;
	private Spinner metricSpinner;
	private Spinner tagSpinner;
	private InterfaceRouteBean bean;

	public InterfaceRouteDialog(Shell parentShell) {
		super(parentShell);
	}

	public void setInterfaceRouteBean(InterfaceRouteBean bean) {
		this.bean = bean;
	}

	public InterfaceRouteBean getInterfaceRouteBean() {
		return this.bean;
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

		new Label(container, SWT.NONE).setText("Количество бит");

		bitsSpinner = new Spinner(container, SWT.BORDER);
		bitsSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		bitsSpinner.setMinimum(0);
		bitsSpinner.setMaximum(255);

		new Label(container, SWT.NONE).setText("Шлюз");

		gatewayText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gatewayText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		new Label(container, SWT.NONE).setText("IP адрес");

		ipText = new Text(container, SWT.BORDER | SWT.SINGLE);
		ipText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(container, SWT.NONE).setText("Метрика");

		metricSpinner = new Spinner(container, SWT.BORDER);
		metricSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		metricSpinner.setMinimum(0);
		metricSpinner.setMaximum(255);

		new Label(container, SWT.NONE).setText("Метка");

		tagSpinner = new Spinner(container, SWT.BORDER);
		tagSpinner
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		tagSpinner.setMinimum(0);
		tagSpinner.setMaximum(255);

		getAll();

		// if (interfaceRouteBean != null) {
		// m_bindingContext = initDataBindings();
		// }
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
		return new Point(450, 235);
	}

	private void getAll() {
		if (bean != null) {
			bitsSpinner.setSelection(bean.getBits());
			gatewayText.setText(bean.getGateway());
			ipText.setText(bean.getIp());
			metricSpinner.setSelection(bean.getMetric());
			tagSpinner.setSelection(bean.getTag());
		} else {
			bitsSpinner.setSelection(0);
			gatewayText.setText("");
			ipText.setText("");
			metricSpinner.setSelection(0);
			tagSpinner.setSelection(0);
		}
	}

	@Override
	protected void okPressed() {
		if (bean == null) {
			bean = new InterfaceRouteBean();
		}
		bean.setBits((short) bitsSpinner.getSelection());
		bean.setGateway(gatewayText.getText());
		bean.setIp(ipText.getText());
		bean.setMetric((short) metricSpinner.getSelection());
		bean.setTag((short) tagSpinner.getSelection());
		super.okPressed();
	}

}
