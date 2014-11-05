package dionis.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
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

import dionis.beans.InterfaceRouteBean;

public class InterfaceRouteDialog extends Dialog {

	private Spinner bitsSpinner;
	private Text gatewayText;
	private Text ipText;
	private Spinner metricSpinner;
	private Spinner tagSpinner;
	private InterfaceRouteBean bean;
	private DataBindingContext ctx;

	public InterfaceRouteDialog(Shell parentShell,
			InterfaceRouteBean bean) {
		super(parentShell);
		if (bean == null) {
			this.bean = new InterfaceRouteBean();
		} else {
			this.bean = bean;
		}
	}

	public InterfaceRouteBean getInterfaceRouteBean() {
		return bean;
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

		bindData();

		return container;
	}

	private void bindData() {
		// контекст датабиндинга
		ctx = new DataBindingContext();
		UpdateValueStrategy strategy = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST);
		UpdateValueStrategy strategy_text = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT);
		// значащих бит
		IObservableValue widgetValue = SWTObservables
				.observeSelection(bitsSpinner);
		IObservableValue modelValue = BeanProperties.value("bits")
				.observe(bean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
		// адрес шлюза
		widgetValue = SWTObservables.observeText(gatewayText, SWT.Modify);
		modelValue = BeansObservables.observeValue(bean, "gateway");
		ctx.bindValue(widgetValue, modelValue, strategy_text, null);
		// ip адрес
		widgetValue = SWTObservables.observeText(ipText, SWT.Modify);
		modelValue = BeansObservables.observeValue(bean, "ip");
		ctx.bindValue(widgetValue, modelValue, strategy_text, null);
		// метрика шлюза
		widgetValue = SWTObservables.observeSelection(metricSpinner);
		modelValue = BeanProperties.value("metric").observe(bean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
		// метка
		widgetValue = SWTObservables.observeSelection(tagSpinner);
		modelValue = BeanProperties.value("tag").observe(bean);
		ctx.bindValue(widgetValue, modelValue, strategy, null);
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

	@Override
	protected void okPressed() {
		ctx.updateModels();
		super.okPressed();
	}

}