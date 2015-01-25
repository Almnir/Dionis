package dionis.dialogs;

import java.util.LinkedList;
import java.util.List;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import dionis.beans.InterfaceParametrsBean;
import dionis.beans.SIOBean;
import dionis.beans.SYNBean;
import dionis.models.DionisXAO;
import dionis.models.PortsModel;
import dionis.xml.InterfaceType;

public class InterfaceStaticDialog extends Dialog {
	private Text loginText;
	private Text passwordText;
	private Text loginText_1;
	private Text passwordText_1;
	private Button noRadioButton_1;
	private Button papRadioButton_1;
	private Button chapRadioButton_1;
	private Button noRadioButton;
	private Button papRadioButton;
	private Button chapRadioButton;
	private Combo portCombo;
	private Combo modeCombo;
	private InterfaceParametrsBean parametrs;
	private DataBindingContext ctx;
	private ComboViewer portComboViewer;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public InterfaceStaticDialog(Shell parentShell,
			InterfaceParametrsBean parametrs) {
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

		getParentShell().setText("Дополнительные параметры");

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(4, false));

		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label.setText("Порт");

		portCombo = new Combo(container, SWT.NONE);
		portCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		portComboViewer = new ComboViewer(portCombo);
		portComboViewer.setContentProvider(new ArrayContentProvider());
		portComboViewer.setLabelProvider(new LabelProvider());
		List<String> portsAll = new LinkedList<String>();
		List<SIOBean> sioPorts = PortsModel.getInstance().getSios();
		List<SYNBean> synPorts = PortsModel.getInstance().getSyns();
		int j = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sioPorts.size(); i++) {
			sb.append(String.format("%u (SIO %u)", j, i));
			j++;
		}
		portsAll.add(sb.toString());
		// FIX: хардкод во имя непонимания
		// в оригинале авторы ЦУ Дионис складывают количества всех портов чтобы
		// получить начало индексации SYN портов
		// вот так:
		// dialifcestatic.cpp
		// UINT16 _cfg_sio;
		// UINT16 _cfg_x25;
		// UINT16 _cfg_lan;
		// UINT16 _cfg_syn;
		// UINT16 _cfg_ipl;
		// UINT16 _cfg_tcp;
		// j = s->_cfg_sio + s->_cfg_x25 + s->_cfg_lan + s->_cfg_tcp +
		// s->_cfg_ipl;
		// ...
		// sprintf(buf, "%u (SYN %u)", j, i);
		// может быть это сделано чтобы SYN порты всегда имели максимальную
		// индексацию?
		j = 100;
		for (int i = 0; i < synPorts.size(); i++) {
			sb.append(String.format("%u (SIO %u)", j, i));
			j++;
		}
		portsAll.add(sb.toString());
		portComboViewer.setInput(portsAll.toArray());

		Label label_1 = new Label(container, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_1.setText("Режим");

		modeCombo = new Combo(container, SWT.NONE);
		modeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Group group = new Group(container, SWT.NONE);
		group.setText("Аутентификация на удалённой стороне");
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));

		Composite composite = new Composite(group, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
				1, 1));

		noRadioButton = new Button(composite, SWT.RADIO);
		noRadioButton.setText("Нет");

		papRadioButton = new Button(composite, SWT.RADIO);
		papRadioButton.setText("PAP");

		chapRadioButton = new Button(composite, SWT.RADIO);
		chapRadioButton.setText("CHAP");

		Composite composite_1 = new Composite(group, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				1, 1));

		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel.setText("Имя");

		loginText = new Text(composite_1, SWT.BORDER);
		loginText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);

		Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_1.setText("Пароль");

		passwordText = new Text(composite_1, SWT.BORDER);
		passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("Аутентификация на своей стороне");
		group_1.setLayout(new GridLayout(2, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4,
				1));

		Composite composite_second = new Composite(group_1, SWT.NONE);
		composite_second.setLayout(new GridLayout(1, false));
		composite_second.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1));

		noRadioButton_1 = new Button(composite_second, SWT.RADIO);
		noRadioButton_1.setText("Нет");

		papRadioButton_1 = new Button(composite_second, SWT.RADIO);
		papRadioButton_1.setText("PAP");

		chapRadioButton_1 = new Button(composite_second, SWT.RADIO);
		chapRadioButton_1.setText("CHAP");

		Composite composite_2 = new Composite(group_1, SWT.NONE);
		composite_2.setLayout(new GridLayout(2, false));
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				1, 1));

		Label lblNewLabel_2 = new Label(composite_2, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_2.setText("Имя");

		loginText_1 = new Text(composite_2, SWT.BORDER);
		loginText_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		Label lblNewLabel_3 = new Label(composite_2, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_3.setText("Пароль");

		passwordText_1 = new Text(composite_2, SWT.BORDER);
		passwordText_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		return container;
	}

	private void bindData() {
		// контекст датабиндинга
		ctx = new DataBindingContext();
		// порт
		IObservableValue widgetValue = ViewersObservables
				.observeSingleSelection(portComboViewer);
		IObservableValue modelValue = BeanProperties.value("type").observe(
				parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// режим
		widgetValue = ViewersObservables.observeSingleSelection(mode);
		modelValue = BeanProperties.value("type").observe(parametrs);
		ctx.bindValue(widgetValue, modelValue, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT), null);
		// обновить виджеты
		ctx.updateTargets();
	}

	@Override
	protected void okPressed() {
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
		return new Point(450, 377);
	}

}
