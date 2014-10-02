package dionis.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import dionis.models.TunnelFilterModel;
import dionis.utils.Constants;
import dionis.xml.FilterStatusType;
import dionis.xml.TunnelFilter;
import dionis.xml.TunnelFilterPorts;
import dionis.xml.TunnelFilterSource;
import dionis.xml.TunnelFilterTarget;
import dionis.xml.TunnelProtocolType;

public class TunnelFilterDialog extends Dialog {
	private Text senderAddressText;
	private Text receiverAddressText;
	private TunnelFilter data;
	private boolean newadd;
	private Combo protocolCombo;
	private Spinner portStartSpinner;
	private Spinner portEndSpinner;
	private Spinner senderBitsSpinner;
	private Spinner receiverBitsSpinner;
	private Combo modeCombo;
	private ComboViewer protocolComboViewer;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public TunnelFilterDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public TunnelFilterDialog(Shell parentShell, IStructuredSelection sel) {
		super(parentShell);
		if (sel != null) {
			this.data = (TunnelFilter) sel.getFirstElement();
			this.newadd = false;
		} else {
			this.data = new TunnelFilter();
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

		parent.getShell().setText("Правило отбора в туннель");

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(5, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("Режим");

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		modeCombo = new Combo(container, SWT.READ_ONLY);
		GridData gd_modeCombo = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_modeCombo.widthHint = 162;
		modeCombo.setLayoutData(gd_modeCombo);
		modeCombo.setItems(Constants.TUNNEL_FILTER_STATUS);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("Протокол");

		protocolCombo = new Combo(container, SWT.READ_ONLY);
		GridData gd_protocolCombo = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_protocolCombo.widthHint = 102;
		protocolCombo.setLayoutData(gd_protocolCombo);

		protocolComboViewer = new ComboViewer(protocolCombo);
		protocolComboViewer.setContentProvider(new ArrayContentProvider());
		protocolComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TunnelProtocolType) {
					TunnelProtocolType iElement = (TunnelProtocolType) element;
					return iElement.name();
				}
				return super.getText(element);
			}
		});
		protocolComboViewer
				.setInput(Arrays.asList(TunnelProtocolType.values()));

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setText("Порты");
		new Label(container, SWT.NONE);

		portStartSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_portStartSpinner = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_portStartSpinner.widthHint = 98;
		portStartSpinner.setLayoutData(gd_portStartSpinner);

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_4.setText("...");

		portEndSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_portEndSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_portEndSpinner.widthHint = 98;
		portEndSpinner.setLayoutData(gd_portEndSpinner);

		Group group = new Group(container, SWT.NONE);
		group.setText("Отправитель");
		group.setLayout(new GridLayout(4, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 5, 1));

		Label lblNewLabel_5 = new Label(group, SWT.NONE);
		lblNewLabel_5.setText("Адрес");

		senderAddressText = new Text(group, SWT.BORDER);
		GridData gd_senderAddressText = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		gd_senderAddressText.widthHint = 306;
		senderAddressText.setLayoutData(gd_senderAddressText);

		Label lblNewLabel_6 = new Label(group, SWT.NONE);
		lblNewLabel_6.setText("Значащих бит");

		senderBitsSpinner = new Spinner(group, SWT.BORDER);
		GridData gd_senderBitsSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_senderBitsSpinner.widthHint = 41;
		senderBitsSpinner.setLayoutData(gd_senderBitsSpinner);

		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("Получатель");
		group_1.setLayout(new GridLayout(4, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 5,
				1));

		Label lblNewLabel_7 = new Label(group_1, SWT.NONE);
		lblNewLabel_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_7.setText("Адрес");

		receiverAddressText = new Text(group_1, SWT.BORDER);
		receiverAddressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		Label lblNewLabel_8 = new Label(group_1, SWT.NONE);
		lblNewLabel_8.setText("Значащих бит");

		receiverBitsSpinner = new Spinner(group_1, SWT.BORDER);
		GridData gd_receiverBitsSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_receiverBitsSpinner.widthHint = 41;
		receiverBitsSpinner.setLayoutData(gd_receiverBitsSpinner);

		getAll();

		return container;
	}

	private void getAll() {
		setFieldsToDefault();
		if (data != null) {
			if (newadd == false) {
				/** изменение **/
				// статус
				modeCombo.select(data.getStatus().ordinal());
				// протокол
				protocolCombo.select(data.getProtocol().ordinal());
				// порты
				if (data.isSetPorts()) {
					if (data.getPorts().isSetLow()) {
						portStartSpinner.setSelection(data.getPorts().getLow());
					}
					if (data.getPorts().isSetHigh()) {
						portEndSpinner.setSelection(data.getPorts().getHigh());
					}
				}
				// отправитель
				if (data.isSetSource()) {
					if (data.getSource().isSetIP()) {
						senderAddressText.setText(data.getSource().getIP());
					}
					if (data.getSource().isSetBits()) {
						senderBitsSpinner.setSelection(data.getSource()
								.getBits());
					}
				}
				// получатель
				if (data.isSetTarget()) {
					if (data.getTarget().isSetIP()) {
						receiverAddressText.setText(data.getTarget().getIP());
					}
					if (data.getTarget().isSetBits()) {
						receiverBitsSpinner.setSelection(data.getTarget()
								.getBits());
					}
				}
			}
		}
	}

	private void setFieldsToDefault() {
		modeCombo.select(0);
		protocolCombo.select(0);
		portStartSpinner.setSelection(0);
		portEndSpinner.setSelection(0);
		senderAddressText.setText("0.0.0.0");
		senderBitsSpinner.setSelection(0);
		receiverAddressText.setText("0.0.0.0");
		receiverBitsSpinner.setSelection(0);
	}

	@Override
	protected void okPressed() {
		switch (modeCombo.getSelectionIndex()) {
		case 0:
			// разрешить
			data.setStatus(FilterStatusType.SOLVE);
			break;
		case 1:
			// запретить
			data.setStatus(FilterStatusType.BAN);
			break;
		case 2:
			// перезагрузить
			data.setStatus(FilterStatusType.RESET);
			break;

		}
		switch (protocolCombo.getSelectionIndex()) {
		case 0:
			data.setProtocol(TunnelProtocolType.ANY);
			break;
		case 1:
			data.setProtocol(TunnelProtocolType.ICMP);
			break;
		case 2:
			data.setProtocol(TunnelProtocolType.TCP);
			break;
		case 3:
			data.setProtocol(TunnelProtocolType.UDP);
			break;
		}
		TunnelFilterPorts tunnelFilterPorts = new TunnelFilterPorts();
		tunnelFilterPorts.setLow(portStartSpinner.getSelection());
		tunnelFilterPorts.setHigh(portEndSpinner.getSelection());
		data.setPorts(tunnelFilterPorts);
		TunnelFilterSource filterSource = new TunnelFilterSource();
		filterSource.setIP(senderAddressText.getText());
		filterSource.setBits((short) senderBitsSpinner.getSelection());
		data.setSource(filterSource);
		TunnelFilterTarget filterTarget = new TunnelFilterTarget();
		filterTarget.setIP(receiverAddressText.getText());
		filterTarget.setBits((short) receiverBitsSpinner.getSelection());
		data.setTarget(filterTarget);

		List<TunnelFilter> filtersList = TunnelFilterModel.getInstance()
				.getData();
		// если список не пуст
		if (filtersList != null) {
			// изменяем элемент в списке
			int indexx = filtersList.indexOf(data);
			if (indexx == -1) {
				// если нет в списке - добавить
				filtersList.add(data);
			} else {
				// если есть - заменить на текущее
				filtersList.set(indexx, data);
			}
		} else {
			// новый список
			filtersList = new ArrayList<TunnelFilter>();
			filtersList.add(data);
		}
		// меняем список в модели на изменённый
		TunnelFilterModel.getInstance().setData(filtersList);
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
		return new Point(620, 276);
	}
}
