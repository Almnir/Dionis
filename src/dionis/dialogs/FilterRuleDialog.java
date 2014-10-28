package dionis.dialogs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
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

import dionis.beans.ExtBean;
import dionis.beans.ExtendedFilterItemBean;
import dionis.beans.FilterPortsBean;
import dionis.beans.FilterSourceBean;
import dionis.beans.FilterTargetBean;
import dionis.beans.IFilterItem;
import dionis.beans.StandardFilterItemBean;
import dionis.utils.Constants;
import dionis.xml.BooleanType;
import dionis.xml.FilterLinkType;
import dionis.xml.FilterOperationType;
import dionis.xml.FilterPortsType;
import dionis.xml.FilterProtocolType;
import dionis.xml.FilterStatusType;
import dionis.xml.FilterTCPFlagsType;

public class FilterRuleDialog extends Dialog {
	private Text sourceAddressText;
	private Text targetAddressText;
	private IFilterItem data;
	private boolean newadd;
	private Button fixButton;
	private Combo modeCombo;
	private Button noRadioButton;
	private Button synRadioButton;
	private Button ackRadioButton;
	private Combo protocolCombo;
	private Spinner bitSourceSpinner;
	private Spinner bitTargetSpinner;
	private Spinner lowPortSpinner;
	private Spinner highPortSpinner;
	private Combo operationCombo;
	private ComboViewer protocolComboViewer;

	private int type;
	private Group[] group;
	private Label[] emptyLabel;
	private Label[] dataLabel;
	private Label[] shiftLabel;
	private Label[] operationLabel;
	private Button[] ipCheckButton;
	private Spinner[] shiftSpinner;
	private Combo[] logicalCombo;
	private Text[] dataText;
	private Button[] btnOrRadioButton;
	private Button[] btnAndRadioButton;

	/**
	 * @wbp.parser.constructor
	 */
	public FilterRuleDialog(Shell parentShell, IFilterItem sfi, int type) {
		super(parentShell);
		/** Инициализация массивов элементов расширенного блока **/
		group = new Group[4];
		emptyLabel = new Label[4];
		shiftLabel = new Label[4];
		operationLabel = new Label[4];
		dataLabel = new Label[4];
		ipCheckButton = new Button[4];
		shiftSpinner = new Spinner[4];
		logicalCombo = new Combo[4];
		dataText = new Text[4];
		btnOrRadioButton = new Button[3];
		btnAndRadioButton = new Button[3];

		this.type = type;
		if (sfi != null) {
			this.setData(sfi);
			this.newadd = false;
		} else {
			if (type == Constants.DLG_STANDARD) {
				this.setData(new StandardFilterItemBean());
			} else if (type == Constants.DLG_EXTENDED) {
				this.setData(new ExtendedFilterItemBean());
			}
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
		container.setLayout(new GridLayout(7, false));

		parent.getShell().setText("Стандартный IP фильтр");

		fixButton = new Button(container, SWT.CHECK);
		fixButton.setText("Фиксировать");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_3.setText("Режим");

		modeCombo = new Combo(container, SWT.READ_ONLY);
		modeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		modeCombo.setItems(Constants.FILTER_MODE);
		new Label(container, SWT.NONE);

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

		protocolCombo = new Combo(container, SWT.READ_ONLY);
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
		new Label(container, SWT.NONE);

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
		new Label(container, SWT.NONE);

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

		operationCombo = new Combo(group_1, SWT.READ_ONLY);
		operationCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1));
		operationCombo.setItems(Constants.FILTER_DIRECTION);

		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);
		new Label(container, SWT.NONE);

		if (this.type == Constants.DLG_EXTENDED) {
			createExtendedArea(container);
		}

		init();

		return container;
	}

	private void createExtendedArea(Composite parent) {
		Group group_all = new Group(parent, SWT.NONE);
		group_all.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 7,
				1));
		group_all.setLayout(new GridLayout(3, true));

		for (int i = 0; i < 3; i += 1) {
			createGroupBlock(group_all, i);
			createLogicBlock(group_all, i);
		}
		createGroupBlock(group_all, 3);
	}

	private void createGroupBlock(Composite parent, int blockNumber) {
		group[blockNumber] = new Group(parent, SWT.NONE);
		group[blockNumber].setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 5, 2));
		group[blockNumber].setLayout(new GridLayout(4, true));
		group[blockNumber].setText(String.valueOf(blockNumber + 1));

		emptyLabel[blockNumber] = new Label(group[blockNumber], SWT.NONE);
		emptyLabel[blockNumber].setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, false, 1, 2));
		emptyLabel[blockNumber].setText("      ");

		shiftLabel[blockNumber] = new Label(group[blockNumber], SWT.NONE);
		shiftLabel[blockNumber].setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, false, 1, 2));
		shiftLabel[blockNumber].setText("Смещение");

		operationLabel[blockNumber] = new Label(group[blockNumber], SWT.NONE);
		operationLabel[blockNumber].setLayoutData(new GridData(SWT.FILL,
				SWT.FILL, true, false, 1, 2));
		operationLabel[blockNumber].setText("Операция");

		dataLabel[blockNumber] = new Label(group[blockNumber], SWT.NONE);
		dataLabel[blockNumber].setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, false, 1, 2));
		dataLabel[blockNumber].setText("Данные");

		ipCheckButton[blockNumber] = new Button(group[blockNumber], SWT.CHECK);
		ipCheckButton[blockNumber].setLayoutData(new GridData(SWT.FILL,
				SWT.FILL, true, false, 1, 2));
		ipCheckButton[blockNumber].setText("IP+");

		shiftSpinner[blockNumber] = new Spinner(group[blockNumber], SWT.BORDER);
		shiftSpinner[blockNumber].setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, true, false, 1, 1));
		shiftSpinner[blockNumber].setMinimum(0);
		shiftSpinner[blockNumber].setMaximum(255);

		logicalCombo[blockNumber] = new Combo(group[blockNumber], SWT.NONE);
		logicalCombo[blockNumber].setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, true, false, 1, 1));
		logicalCombo[blockNumber].setItems(Constants.FILTER_LOGIC);

		dataText[blockNumber] = new Text(group[blockNumber], SWT.NONE);
		dataText[blockNumber].setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		dataText[blockNumber].setText("0");
	}

	private void createLogicBlock(Composite parent, final int blockNumber) {
		Composite logicComposite = new Composite(parent, SWT.NONE);
		logicComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 4, 1));
		logicComposite.setLayout(new GridLayout(3, false));

		btnAndRadioButton[blockNumber] = new Button(logicComposite, SWT.RADIO);
		btnAndRadioButton[blockNumber].setLayoutData(new GridData(SWT.FILL,
				SWT.FILL, true, false, 1, 2));
		btnAndRadioButton[blockNumber].setText("И");

		btnOrRadioButton[blockNumber] = new Button(logicComposite, SWT.RADIO);
		btnOrRadioButton[blockNumber].setLayoutData(new GridData(SWT.FILL,
				SWT.FILL, true, false, 1, 2));
		btnOrRadioButton[blockNumber].setText("ИЛИ");
	}

	/**
	 * Метод инициализации полей данными
	 */
	protected void init() {
		setFieldsToDefault();
		if (newadd == false) {
			/** изменение **/
			fixButton.setSelection(data.getFix() == BooleanType.YES ? true
					: false);
			modeCombo.select(data.getMode().ordinal());
			noRadioButton
					.setSelection(data.getTcpFlags() == FilterTCPFlagsType.NO ? true
							: false);
			synRadioButton
					.setSelection(data.getTcpFlags() == FilterTCPFlagsType.SYN ? true
							: false);
			ackRadioButton
					.setSelection(data.getTcpFlags() == FilterTCPFlagsType.ACK ? true
							: false);
			protocolCombo.select(data.getProtocol().ordinal());
			if (data.getSource() != null) {
				sourceAddressText.setText(data.getSource().getIp());
				bitSourceSpinner.setSelection(data.getSource().getBits());
			}
			if (data.getTarget() != null) {
				targetAddressText.setText(data.getTarget().getIp());
				bitTargetSpinner.setSelection(data.getTarget().getBits());
			}
			if (data.getPorts() != null) {
				lowPortSpinner.setSelection(data.getPorts().getLow());
				highPortSpinner.setSelection(data.getPorts().getHigh());
				operationCombo.select(data.getPorts().getType().ordinal());
			}
			if (this.type == Constants.DLG_EXTENDED) {
				if (data.getExt() != null) {
					List<ExtBean> ext = data.getExt();
					int inx = 0;
					for (ExtBean eb : ext) {
						ipCheckButton[inx]
								.setSelection(eb.getIp() == BooleanType.YES ? true
										: false);
						shiftSpinner[inx].setSelection(eb.getOffset());
						logicalCombo[inx].select(eb.getOperation().ordinal());
						dataText[inx].setText(eb.getData());
						if (inx < 3) {
							if (eb.getLink() == FilterLinkType.AND) {
								btnAndRadioButton[inx].setSelection(true);
								btnOrRadioButton[inx].setSelection(false);
							} else {
								btnAndRadioButton[inx].setSelection(false);
								btnOrRadioButton[inx].setSelection(true);
							}
						}
						inx += 1;
					}
				}
			}
		}
	}

	/**
	 * Заполнение объекта данными формы диалога
	 */
	@Override
	protected void okPressed() {
		data.setFix(fixButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		data.setMode(Arrays.asList(FilterStatusType.values()).get(
				modeCombo.getSelectionIndex()));
		if (noRadioButton.getSelection())
			data.setTcpFlags(FilterTCPFlagsType.NO);
		else if (ackRadioButton.getSelection())
			data.setTcpFlags(FilterTCPFlagsType.ACK);
		else if (synRadioButton.getSelection())
			data.setTcpFlags(FilterTCPFlagsType.SYN);
		data.setProtocol(Arrays.asList(FilterProtocolType.values()).get(
				protocolCombo.getSelectionIndex()));
		FilterSourceBean sourceBean = new FilterSourceBean();
		sourceBean.setIp(sourceAddressText.getText());
		sourceBean.setBits((short) bitSourceSpinner.getSelection());
		data.setSource(sourceBean);
		FilterTargetBean targetBean = new FilterTargetBean();
		targetBean.setIp(targetAddressText.getText());
		targetBean.setBits((short) bitTargetSpinner.getSelection());
		data.setTarget(targetBean);
		FilterPortsBean filterPortsBean = new FilterPortsBean();
		filterPortsBean.setLow(lowPortSpinner.getSelection());
		filterPortsBean.setHigh(highPortSpinner.getSelection());
		filterPortsBean.setType(Arrays.asList(FilterPortsType.values()).get(
				operationCombo.getSelectionIndex()));
		data.setPorts(filterPortsBean);
		if (this.type == Constants.DLG_EXTENDED) {
			List<ExtBean> extBeans;
			if (data.getExt() == null) {
				extBeans = new LinkedList<ExtBean>();
			} else {
				extBeans = data.getExt();
			}
			extBeans.clear();
			ExtBean bean;
			for (int i = 0; i < 4; i++) {
				bean = new ExtBean();
				bean.setIp(ipCheckButton[i].getSelection() == true ? BooleanType.YES
						: BooleanType.NO);
				bean.setOffset((short) shiftSpinner[i].getSelection());
				bean.setOperation(Arrays.asList(FilterOperationType.values())
						.get(logicalCombo[i].getSelectionIndex()));
				bean.setData(dataText[i].getText());
				if (i < 3) {
					if (btnAndRadioButton[i].getSelection() == true
							&& btnOrRadioButton[i].getSelection() == false) {
						bean.setLink(FilterLinkType.AND);
					} else {
						bean.setLink(FilterLinkType.OR);
					}
				} else {
					// дефолтное значение для логического блока
					bean.setLink(FilterLinkType.OR);
				}
				extBeans.add(bean);
			}
			data.setExt(extBeans);
		}
		super.okPressed();
	}

	/**
	 * Установка полей в начальные значения
	 */
	protected void setFieldsToDefault() {
		fixButton.setSelection(false);
		modeCombo.select(0);
		noRadioButton.setSelection(true);
		synRadioButton.setSelection(false);
		ackRadioButton.setSelection(false);
		protocolCombo.select(0);
		sourceAddressText.setText("0.0.0.0");
		bitSourceSpinner.setSelection(0);
		targetAddressText.setText("0.0.0.0");
		bitTargetSpinner.setSelection(0);
		lowPortSpinner.setSelection(0);
		highPortSpinner.setSelection(0);
		operationCombo.select(0);
		if (this.type == Constants.DLG_EXTENDED) {
			for (int i = 0; i < 4; i += 1) {
				ipCheckButton[i].setSelection(false);
				shiftSpinner[i].setSelection(0);
				logicalCombo[i].select(0);
				dataText[i].setText("00");
				if (i < 3) {
					btnAndRadioButton[i].setSelection(true);
				}
			}
		}
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

	public IFilterItem getData() {
		return data;
	}

	public void setData(IFilterItem data) {
		this.data = data;
	}

}
