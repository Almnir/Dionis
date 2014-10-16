package dionis.dialogs;

import java.util.Arrays;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import dionis.beans.FilterPortsBean;
import dionis.beans.FilterSourceBean;
import dionis.beans.FilterTargetBean;
import dionis.beans.StandardFilterItemBean;
import dionis.utils.Constants;
import dionis.xml.BooleanType;
import dionis.xml.FilterPortsType;
import dionis.xml.FilterProtocolType;
import dionis.xml.FilterStatusType;
import dionis.xml.FilterTCPFlagsType;

public class StandardFilterDialog extends Dialog {
	private Text sourceAddressText;
	private Text targetAddressText;
	private StandardFilterItemBean data;
	private boolean newadd;
	private Button blockButton;
	private Combo modeCombo;
	private Button noRadioButton;
	private Button synRadioButton;
	private Button ackRadioButton;
	private Combo protocolCombo;
	private Spinner bitSourceSpinner;
	private Spinner bitTargetSpinner;
	private Spinner lowPortSpinner;
	private Spinner highPortSpinner;
	private Combo directionCombo;
	private ComboViewer protocolComboViewer;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public StandardFilterDialog(Shell parentShell) {
		super(parentShell);
	}

	public StandardFilterDialog(Shell parentShell, StandardFilterItemBean sfi) {
		super(parentShell);
		if (sfi != null) {
			this.setData(sfi);
			this.newadd = false;
		} else {
			this.setData(new StandardFilterItemBean());
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
		container.setLayout(new GridLayout(6, false));

		parent.getShell().setText("Стандартный IP фильтр");

		blockButton = new Button(container, SWT.CHECK);
		blockButton.setText("Фиксировать");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_3.setText("Режим");

		modeCombo = new Combo(container, SWT.NONE);
		modeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		modeCombo.setItems(Constants.FILTER_MODE);

		Group grpTcp = new Group(container, SWT.NONE);
		grpTcp.setText("TCP флаги");
		grpTcp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
		grpTcp.setLayout(new GridLayout(3, false));

		noRadioButton = new Button(grpTcp, SWT.RADIO);
		noRadioButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
				false, 1, 1));
		noRadioButton.setText("Нет");

		synRadioButton = new Button(grpTcp, SWT.RADIO);
		synRadioButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
				false, 1, 1));
		synRadioButton.setText("SYN");

		ackRadioButton = new Button(grpTcp, SWT.RADIO);
		ackRadioButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
				false, 1, 1));
		ackRadioButton.setText("ACK");

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_4.setText("Протокол");

		protocolCombo = new Combo(container, SWT.NONE);
		protocolCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		protocolComboViewer = new ComboViewer(protocolCombo);
		protocolComboViewer.setContentProvider(new ArrayContentProvider());
		protocolComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof FilterProtocolType) {
					FilterProtocolType iTypeElement = (FilterProtocolType) element;
					return iTypeElement.name();
				}
				return super.getText(element);
			}
		});

		protocolComboViewer
				.setInput(Arrays.asList(FilterProtocolType.values()));

		Group group = new Group(container, SWT.NONE);
		group.setText("Отправитель");
		group.setLayout(new GridLayout(4, false));
		GridData gd_group = new GridData(SWT.FILL, SWT.FILL, true, false, 6, 1);
		gd_group.heightHint = 41;
		group.setLayoutData(gd_group);

		Label lblNewLabel_5 = new Label(group, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_5.setText("Адрес");

		sourceAddressText = new Text(group, SWT.BORDER);
		GridData gd_sourceAddressText = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		gd_sourceAddressText.widthHint = 282;
		sourceAddressText.setLayoutData(gd_sourceAddressText);

		Label lblNewLabel_6 = new Label(group, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_6.setText("Значащих бит");

		bitSourceSpinner = new Spinner(group, SWT.BORDER);
		bitSourceSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("Получатель");
		group_1.setLayout(new GridLayout(6, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 6,
				1));

		Label lblNewLabel_7 = new Label(group_1, SWT.NONE);
		lblNewLabel_7.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_7.setText("Адрес");

		targetAddressText = new Text(group_1, SWT.BORDER);
		GridData gd_targetAddressText = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 3, 1);
		gd_targetAddressText.widthHint = 282;
		targetAddressText.setLayoutData(gd_targetAddressText);

		Label lblNewLabel_8 = new Label(group_1, SWT.NONE);
		lblNewLabel_8.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_8.setText("Значащих бит");

		bitTargetSpinner = new Spinner(group_1, SWT.BORDER);
		bitTargetSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblNewLabel_9 = new Label(group_1, SWT.NONE);
		lblNewLabel_9.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_9.setText("Порты");

		lowPortSpinner = new Spinner(group_1, SWT.BORDER);
		lowPortSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblNewLabel_12 = new Label(group_1, SWT.NONE);
		lblNewLabel_12.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_12.setText("...");

		highPortSpinner = new Spinner(group_1, SWT.BORDER);
		highPortSpinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);

		directionCombo = new Combo(group_1, SWT.NONE);
		directionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1));
		directionCombo.setItems(Constants.FILTER_DIRECTION);

		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);

		init();

		return container;
	}

	private void init() {
		setFieldsToDefault();
		if (getData() != null) {
			if (newadd == false) {
				/** изменение **/
				blockButton
						.setEnabled(getData().getBlock() == BooleanType.YES ? true
								: false);
				modeCombo.select(getData().getMode().ordinal());
				noRadioButton
						.setEnabled(getData().getTcpFlags() == FilterTCPFlagsType.NO ? true
								: false);
				synRadioButton
						.setEnabled(getData().getTcpFlags() == FilterTCPFlagsType.SYN ? true
								: false);
				ackRadioButton
						.setEnabled(getData().getTcpFlags() == FilterTCPFlagsType.ACK ? true
								: false);
				protocolCombo.select(getData().getProtocol().ordinal());
				if (getData().getSource() != null) {
					sourceAddressText.setText(getData().getSource().getIp());
					bitSourceSpinner.setSelection(getData().getSource().getBits());
				}
				if (getData().getTarget() != null) {
					targetAddressText.setText(getData().getTarget().getIp());
					bitTargetSpinner.setSelection(getData().getTarget().getBits());
				}
				if (getData().getPorts() != null) {
					lowPortSpinner.setSelection(getData().getPorts().getLow());
					highPortSpinner.setSelection(getData().getPorts().getHigh());
					directionCombo.select(getData().getPorts().getType().ordinal());
				}
			}
		}
	}

	@Override
	protected void okPressed() {
		getData().setBlock(blockButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		getData().setMode(Arrays.asList(FilterStatusType.values()).get(
				modeCombo.getSelectionIndex()));
		if (noRadioButton.getSelection())
			getData().setTcpFlags(FilterTCPFlagsType.NO);
		else if (ackRadioButton.getSelection())
			getData().setTcpFlags(FilterTCPFlagsType.ACK);
		else if (synRadioButton.getSelection())
			getData().setTcpFlags(FilterTCPFlagsType.SYN);
		getData().setProtocol(Arrays.asList(FilterProtocolType.values()).get(
				protocolCombo.getSelectionIndex()));
		FilterSourceBean sourceBean = new FilterSourceBean();
		sourceBean.setIp(sourceAddressText.getText());
		sourceBean.setBits((short) bitSourceSpinner.getSelection());
		getData().setSource(sourceBean);
		FilterTargetBean targetBean = new FilterTargetBean();
		targetBean.setIp(targetAddressText.getText());
		targetBean.setBits((short) bitTargetSpinner.getSelection());
		getData().setTarget(targetBean);
		FilterPortsBean filterPortsBean = new FilterPortsBean();
		filterPortsBean.setLow(lowPortSpinner.getSelection());
		filterPortsBean.setHigh(highPortSpinner.getSelection());
		filterPortsBean.setType(Arrays.asList(FilterPortsType.values()).get(
				directionCombo.getSelectionIndex()));
		getData().setPorts(filterPortsBean);
		super.okPressed();
	}

	/**
	 * Установка полей в начальные значения
	 */
	private void setFieldsToDefault() {
		blockButton.setSelection(false);
		modeCombo.select(0);
		noRadioButton.setEnabled(false);
		synRadioButton.setEnabled(false);
		ackRadioButton.setEnabled(false);
		protocolCombo.select(0);
		sourceAddressText.setText("0.0.0.0");
		bitSourceSpinner.setSelection(0);
		targetAddressText.setText("0.0.0.0");
		bitTargetSpinner.setSelection(0);
		lowPortSpinner.setSelection(0);
		highPortSpinner.setSelection(0);
		directionCombo.select(0);
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
		return new Point(674, 370);
	}

	public StandardFilterItemBean getData() {
		return data;
	}

	public void setData(StandardFilterItemBean data) {
		this.data = data;
	}

}
