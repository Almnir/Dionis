package dionis.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

import dionis.beans.InterfaceParametrsBean;
import dionis.beans.TOSBean;
import dionis.utils.BindHelper;
import dionis.utils.Constants;
import dionis.xml.InterfaceDFType;

/**
 * Диалог GRE дополнительных параметров интерфейса
 * 
 * @author Ярных А.О.
 *
 */
public class GREDialog extends Dialog {

	private InterfaceParametrsBean parametrs;
	private Button numerationCheck;
	private Button controlSumCheck;
	private Button copyTOSCheck;
	private Combo flagCombo;
	private Spinner tosSpinner;
	private Spinner bufferSpinner;
	private Spinner latencySpinner;
	private Spinner intervalSpinner;
	private Spinner timeoutSpinner;
	private DataBindingContext ctx;
	private ComboViewer flagComboViewer;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public GREDialog(Shell parentShell, InterfaceParametrsBean parametrs) {
		super(parentShell);
		this.parametrs = parametrs;
		if (this.parametrs.getTos() == null) {
			TOSBean tosBean = new TOSBean();
			this.parametrs.setTos(tosBean);
		}
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		parent.getShell().setText("Дополнительные параметры");

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(4, false));

		numerationCheck = new Button(container, SWT.CHECK);
		numerationCheck.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 2));
		numerationCheck.setText("Нумерация пакетов");
		new Label(container, SWT.NONE);

		controlSumCheck = new Button(container, SWT.CHECK);
		controlSumCheck.setText("Контрольная сумма");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		copyTOSCheck = new Button(container, SWT.CHECK);
		copyTOSCheck.setText("Копировать поле TOS");
		new Label(container, SWT.NONE);

		Label lblDf = new Label(container, SWT.NONE);
		lblDf.setText("Флаг DF");

		flagCombo = new Combo(container, SWT.READ_ONLY);
		GridData gd_flagCombo = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_flagCombo.widthHint = 130;
		flagCombo.setLayoutData(gd_flagCombo);
		flagComboViewer = new ComboViewer(flagCombo);
		flagComboViewer.setContentProvider(new ArrayContentProvider());
		flagComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof InterfaceDFType) {
					InterfaceDFType iTypeElement = (InterfaceDFType) element;
					return Constants.DF_FLAG[iTypeElement.ordinal()];
				}
				return super.getText(element);
			}
		});
		flagComboViewer.setInput(InterfaceDFType.values());

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		GridData gd_lblNewLabel_4 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel_4.widthHint = 215;
		lblNewLabel_4.setLayoutData(gd_lblNewLabel_4);
		lblNewLabel_4.setText("Установить значение TOS");

		tosSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_tosSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_tosSpinner.widthHint = 48;
		tosSpinner.setLayoutData(gd_tosSpinner);
		tosSpinner.setMinimum(0);
		tosSpinner.setMaximum(255);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		lblNewLabel.setText("Размер буфера");

		bufferSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_bufferSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_bufferSpinner.widthHint = 78;
		bufferSpinner.setLayoutData(gd_bufferSpinner);
		bufferSpinner.setMinimum(0);
		bufferSpinner.setMaximum(65535);

		new Label(container, SWT.NONE);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		lblNewLabel_1.setText("Максимальная задержка пакетов");

		latencySpinner = new Spinner(container, SWT.BORDER);
		GridData gd_latencySpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_latencySpinner.widthHint = 78;
		latencySpinner.setLayoutData(gd_latencySpinner);
		latencySpinner.setMinimum(0);
		latencySpinner.setMaximum(65535);
		new Label(container, SWT.NONE);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		lblNewLabel_2.setText("Интервал отправки запросов");

		intervalSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_intervalSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_intervalSpinner.widthHint = 78;
		intervalSpinner.setLayoutData(gd_intervalSpinner);
		intervalSpinner.setMinimum(0);
		intervalSpinner.setMaximum(65535);
		new Label(container, SWT.NONE);

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		lblNewLabel_3.setText("Максимальный интервал ожидания ответов");

		timeoutSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_timeoutSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_timeoutSpinner.widthHint = 78;
		timeoutSpinner.setLayoutData(gd_timeoutSpinner);
		timeoutSpinner.setMinimum(0);
		timeoutSpinner.setMaximum(65535);
		new Label(container, SWT.NONE);

		bindData();

		return container;
	}

	private void bindData() {
		// контекст датабиндинга
		ctx = new DataBindingContext();
		// нумерация пакетов
		IObservableValue modelValue = BeanProperties.value(
				InterfaceParametrsBean.class, "seq").observe(parametrs);
		BindHelper.bindCheckButton(ctx, numerationCheck, modelValue);
		// копировать после TOS
		modelValue = BeanProperties.value(InterfaceParametrsBean.class,
				"tos.copy").observe(parametrs);
		BindHelper.bindCheckButton(ctx, copyTOSCheck, modelValue);
		// Установить значение TOS
		IObservableValue widgetValue = SWTObservables
				.observeSelection(tosSpinner);
		modelValue = BeanProperties.value("tos.value").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// Контрольная сумма
		modelValue = BeanProperties.value(InterfaceParametrsBean.class,
				"chksum").observe(parametrs);
		BindHelper.bindCheckButton(ctx, controlSumCheck, modelValue);
		// Флаг DF
		widgetValue = ViewersObservables
				.observeSingleSelection(flagComboViewer);
		modelValue = BeanProperties.value("df").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// Размер буфера
		widgetValue = SWTObservables.observeSelection(bufferSpinner);
		modelValue = BeanProperties.value("buf").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// Максимальная задержка пакетов
		widgetValue = SWTObservables.observeSelection(latencySpinner);
		modelValue = BeanProperties.value("delay").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// Интервал отправки запросов
		widgetValue = SWTObservables.observeSelection(intervalSpinner);
		modelValue = BeanProperties.value("interval").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// Максимальный интервал ожидания ответов
		widgetValue = SWTObservables.observeSelection(timeoutSpinner);
		modelValue = BeanProperties.value("wait").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// обновить виджеты из бина
		ctx.updateTargets();
	}

	@Override
	protected void okPressed() {
		// обновить модель по подтверждению
		ctx.updateModels();
		super.okPressed();
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

}
