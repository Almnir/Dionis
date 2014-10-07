package dionis.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
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
import dionis.utils.Constants;
import dionis.xml.BooleanType;
import dionis.xml.InterfaceDFType;

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

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public GREDialog(Shell parentShell) {
		super(parentShell);
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
		flagCombo.setItems(Constants.DF_FLAG);

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

		init();

		return container;
	}

	private void init() {
		numerationCheck
				.setSelection(parametrs.getSeq() == BooleanType.YES ? true
						: false);
		if (parametrs.getTos() != null) {
			copyTOSCheck
					.setSelection(parametrs.getTos().getCopy() == BooleanType.YES ? true
							: false);
			tosSpinner.setSelection(parametrs.getTos().getValue());
		}
		controlSumCheck
				.setSelection(parametrs.getChksum() == BooleanType.YES ? true
						: false);
		if (parametrs.getDf() != null) {
			flagCombo.select(parametrs.getDf().ordinal());
		} else {
			flagCombo.select(0);
		}
		if (parametrs.getBuf() != null) {
			bufferSpinner.setSelection(parametrs.getBuf());
		} else {
			bufferSpinner.setSelection(0);
		}
		if (parametrs.getDelay() != null) {
			latencySpinner.setSelection(parametrs.getDelay());
		} else {
			latencySpinner.setSelection(0);
		}
		if (parametrs.getInterval() != null) {
			intervalSpinner.setSelection(parametrs.getInterval());
		} else {
			intervalSpinner.setSelection(0);
		}
		if (parametrs.getWait() != null) {
			timeoutSpinner.setSelection(parametrs.getWait());
		} else {
			timeoutSpinner.setSelection(0);
		}
	}

	@Override
	protected void okPressed() {
		parametrs
				.setSeq(numerationCheck.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		TOSBean tos = new TOSBean();
		tos.setCopy(copyTOSCheck.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		tos.setValue((short) tosSpinner.getSelection());
		parametrs.setTos(tos);
		parametrs
				.setChksum(controlSumCheck.getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
		parametrs
				.setDf(InterfaceDFType.values()[flagCombo.getSelectionIndex()]);
		parametrs.setBuf(bufferSpinner.getSelection());
		parametrs.setDelay(latencySpinner.getSelection());
		parametrs.setInterval(intervalSpinner.getSelection());
		parametrs.setWait(timeoutSpinner.getSelection());
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

	public InterfaceParametrsBean getParametrs() {
		return parametrs;
	}

	public void setParametrs(InterfaceParametrsBean parametrs) {
		this.parametrs = parametrs;
	}

}
