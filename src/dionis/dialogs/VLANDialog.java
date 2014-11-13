package dionis.dialogs;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
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

import dionis.beans.InterfaceBean;
import dionis.beans.InterfaceParametrsBean;
import dionis.models.InterfaceModel;

/**
 * Диалог отображения выбора VLAN параметров
 * 
 * @author Ярных А.О.
 *
 */
public class VLANDialog extends Dialog {

	private Spinner vlanSpinner;
	private InterfaceParametrsBean parametrs;
	private Combo interfaceCombo;
	private ComboViewer interfaceComboViewer;
	private Spinner sendSpeedSpinner;
	private Spinner receiveSpeedSpinner;
	private DataBindingContext ctx;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public VLANDialog(Shell parentShell, InterfaceParametrsBean parametrs) {
		super(parentShell);
		this.parametrs = parametrs;
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

		bindData();

		return container;
	}

	private void bindData() {
		// контекст датабиндинга
		ctx = new DataBindingContext();

		ObservableListContentProvider contentProvider = new ObservableListContentProvider();
		interfaceComboViewer.setContentProvider(contentProvider);

		IObservableSet knownElements = contentProvider.getKnownElements();
		final IObservableMap names = BeanProperties.value(InterfaceBean.class,
				"name").observeDetail(knownElements);

		IObservableMap[] labelMaps = { names };

		ILabelProvider labelProvider = new ObservableMapLabelProvider(labelMaps) {
			public String getText(Object element) {
				return names.get(element).toString();
			}
		};

		interfaceComboViewer.setLabelProvider(labelProvider);

		List<InterfaceBean> interfaces = InterfaceModel.getInstance().getData();
		// делаем копию модели интерфейсов
		List<InterfaceBean> interfaceList = new LinkedList<InterfaceBean>(
				interfaces);
		// удаляем себя
		interfaceList.remove(parametrs.getInterfacesBean());
		// данные для вьюера
		IObservableList input = Properties.selfList(InterfaceBean.class)
				.observe(interfaceList);
		interfaceComboViewer.setInput(input);
		// привязка выбора конкретного интерфейса в комбо
		String selectedBean = parametrs.getBaseInterface();
		// поиск по копии модели интерфейса с именем заданным полем бина
		// параметров
		for (InterfaceBean ifb : interfaceList) {
			if (ifb.getName().equals(selectedBean)) {
				IStructuredSelection sel = new StructuredSelection(ifb);
				// установка выбора комбо
				interfaceComboViewer.setSelection(sel);
				break;
			}
		}
		// VLAN идентификатор
		IObservableValue widgetValue = SWTObservables
				.observeSelection(vlanSpinner);
		IObservableValue modelValue = BeanProperties.value("vnid").observe(
				parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);

		// Скорость передачи
		widgetValue = SWTObservables.observeSelection(sendSpeedSpinner);
		modelValue = BeanProperties.value("bandwidth").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		// Скорость приёма
		widgetValue = SWTObservables.observeSelection(receiveSpeedSpinner);
		modelValue = BeanProperties.value("bandrecv").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST), null);
		ctx.updateTargets();
	}

	@Override
	protected void okPressed() {
		// обновление моделей
		ctx.updateModels();
		// установка имени выбранного интерфейса по текущему выбору в комбо
		IStructuredSelection sel = (IStructuredSelection) interfaceComboViewer
				.getSelection();
		if (!sel.isEmpty()) {
			InterfaceBean ibn = (InterfaceBean) sel.getFirstElement();
			parametrs.setBaseInterface(ibn.getName());
		}
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
}
