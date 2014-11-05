package dionis.dialogs;

import java.util.LinkedList;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

import dionis.beans.InterfaceParametrsBean;
import dionis.beans.InterfaceBean;
import dionis.models.InterfaceModel;

public class VLANDialog extends Dialog {

	private Spinner vlanSpinner;
	private InterfaceParametrsBean parametrs;
	private Combo interfaceCombo;
	private ComboViewer interfaceComboViewer;
	private Spinner sendSpeedSpinner;
	private Spinner receiveSpeedSpinner;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public VLANDialog(Shell parentShell) {
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
		container.setLayout(new GridLayout(2, false));

		Label label = new Label(container, SWT.NONE);
		label.setText("Базовый интерфейс");
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1));

		interfaceCombo = new Combo(container, SWT.READ_ONLY);
		interfaceComboViewer = new ComboViewer(interfaceCombo);
		GridData gd_interfaceCombo = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_interfaceCombo.widthHint = 119;
		interfaceCombo.setLayoutData(gd_interfaceCombo);
		interfaceComboViewer.setContentProvider(ArrayContentProvider
				.getInstance());
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

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel.setText("VLAN идентификатор");

		vlanSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_vlanSpinner = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_vlanSpinner.widthHint = 119;
		vlanSpinner.setLayoutData(gd_vlanSpinner);
		vlanSpinner.setMinimum(1);
		vlanSpinner.setMaximum(4095);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_1.setText("Скорость передачи");

		sendSpeedSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_sendSpeedSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_sendSpeedSpinner.widthHint = 119;
		sendSpeedSpinner.setLayoutData(gd_sendSpeedSpinner);
		sendSpeedSpinner.setMinimum(0);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel_2.setText("Скорость приёма");

		receiveSpeedSpinner = new Spinner(container, SWT.BORDER);
		GridData gd_receiveSpeedSpinner = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_receiveSpeedSpinner.widthHint = 119;
		receiveSpeedSpinner.setLayoutData(gd_receiveSpeedSpinner);
		receiveSpeedSpinner.setMinimum(0);

		init();

		return container;
	}

	private void init() {
		List<InterfaceBean> interfaceList = InterfaceModel.getInstance()
				.getData();
		// если есть интерфейсы
		if (interfaceList != null && !interfaceList.isEmpty()) {
			// формируем список отображаемых чтобы не отображать текущий
			// интерфейс
			List<InterfaceBean> listBeans = new LinkedList<InterfaceBean>();
			for (InterfaceBean ibean : interfaceList) {
				// если найденный в списке совпадает с текущим - не включать
				if (parametrs.getInterfacesBean() != null
						&& parametrs.getInterfacesBean().getName()
								.equals(ibean.getName())) {
					continue;
				}
				// добавить в список
				listBeans.add(ibean);
			}
			// данные в комбо
			interfaceComboViewer.setInput(listBeans);
			interfaceCombo.setEnabled(true);

			// ищем интерфейс по имени и устанавливаем выбор
			for (int i = 0; i < listBeans.size(); i++) {
				if (listBeans.get(i).getName()
						.equals(parametrs.getBaseInterface())) {
					interfaceCombo.select(i);
					break;
				}
			}
		} else {
			// если нет интерфейсов, то отключаем комбо
			interfaceCombo.setEnabled(false);
		}
		if (parametrs.getVnid() != null)
			vlanSpinner.setSelection(parametrs.getVnid());
		else
			vlanSpinner.setSelection(1);
		if (parametrs.getBandwidth() != null)
			sendSpeedSpinner.setSelection(parametrs.getBandwidth());
		else
			sendSpeedSpinner.setSelection(0);
		if (parametrs.getBandrecv() != null)
			receiveSpeedSpinner.setSelection(parametrs.getBandrecv());
		else
			receiveSpeedSpinner.setSelection(0);
	}

	@Override
	protected void okPressed() {
		IStructuredSelection selection = (IStructuredSelection) interfaceComboViewer
				.getSelection();
		InterfaceBean ifaceBean = (InterfaceBean) selection.getFirstElement();
		if (ifaceBean != null) {
			String ifaceText = ifaceBean.getName();
			parametrs.setBaseInterface(ifaceText);
		}
		parametrs.setVnid(vlanSpinner.getSelection());
		parametrs.setBandwidth(sendSpeedSpinner.getSelection());
		parametrs.setBandrecv(receiveSpeedSpinner.getSelection());
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
		return new Point(367, 227);
	}

	public InterfaceParametrsBean getParametrs() {
		return parametrs;
	}

	public void setParametrs(InterfaceParametrsBean parametrs) {
		this.parametrs = parametrs;
	}
}
