package dionis.dialogs;

import java.util.LinkedList;
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
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import dionis.beans.InterfaceRouteBean;
import dionis.models.InterfaceRouteModel;

public class InterfaceRouteDialog extends Dialog {

	private Spinner bitsSpinner;
	private Text gatewayText;
	private Text ipText;
	private Spinner metricSpinner;
	private Spinner tagSpinner;
	private InterfaceRouteBean data;
	private boolean newadd;

	public InterfaceRouteDialog(Shell parentShell, IStructuredSelection sel) {
		super(parentShell);
		if (sel != null) {
			this.data = (InterfaceRouteBean) sel.getFirstElement();
			this.newadd = false;
		} else {
			this.data = new InterfaceRouteBean();
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

		parent.getShell().setText("IP маршрут");

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));

		new Label(container, SWT.NONE).setText("Значащих бит");

		bitsSpinner = new Spinner(container, SWT.BORDER);
		bitsSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		bitsSpinner.setMinimum(0);
		bitsSpinner.setMaximum(255);

		new Label(container, SWT.NONE).setText("Адрес шлюза");

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
		return new Point(450, 258);
	}

	private void getAll() {
		setFieldsToDefault();
		if (data != null) {
			if (newadd == false) {
				/** изменение **/
				bitsSpinner.setSelection(data.getBits());
				gatewayText.setText(data.getGateway());
				ipText.setText(data.getIp());
				metricSpinner.setSelection(data.getMetric());
				tagSpinner.setSelection(data.getTag());
			}
		}
	}

	private void setFieldsToDefault() {
		bitsSpinner.setSelection(0);
		gatewayText.setText("");
		ipText.setText("");
		metricSpinner.setSelection(0);
		tagSpinner.setSelection(0);
	}

	@Override
	protected void okPressed() {
		data.setBits((short) bitsSpinner.getSelection());
		data.setGateway(gatewayText.getText());
		data.setIp(ipText.getText());
		data.setMetric((short) metricSpinner.getSelection());
		data.setTag((short) tagSpinner.getSelection());
		List<InterfaceRouteBean> routesList = InterfaceRouteModel.getInstance().getData();
		// если список не пуст
		if (routesList != null) {
			// изменяем элемент в списке
			int indexx = routesList.indexOf(data);
			if (indexx == -1) {
				// если нет в списке - добавить
				routesList.add(data);
			} else {
				// если есть - заменить на текущее
				routesList.set(indexx, data);
			}
		} else {
			// новый список
			routesList = new LinkedList<InterfaceRouteBean>();
			routesList.add(data);
		}
		// меняем список в модели на изменённый
		InterfaceRouteModel.getInstance().setData(routesList);		
		super.okPressed();
	}

}
