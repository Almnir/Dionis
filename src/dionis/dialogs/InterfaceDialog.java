package dionis.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

import dionis.models.InterfaceBean;

public class InterfaceDialog extends Dialog {
	private Text text;
	private Text text_1;
	private Combo combo;
	private Combo combo_1;
	private Combo combo_2;
	private Combo combo_3;
	private Combo combo_4;
	private Spinner spinner;
	private Combo combo_5;
	private Spinner spinner_1;
	private Combo combo_6;
	private Button button;
	private Button btnCheckButton;
	private Button btnCheckButton_1;
	private Button btnCheckButton_2;
	private Button btnCheckButton_3;
	private Button btnCheckButton_4;
	private Button btnIp;
	private Button btnCheckButton_5;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public InterfaceDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(7, false));
		
		Label label = new Label(container, SWT.NONE);
		label.setText("Имя");
		new Label(container, SWT.NONE);
		
		text = new Text(container, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 103;
		text.setLayoutData(gd_text);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("Тип");
		
		combo = new Combo(container, SWT.NONE);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 201;
		combo.setLayoutData(gd_combo);
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("Режим активизации");
		
		combo_1 = new Combo(container, SWT.NONE);
		GridData gd_combo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_1.widthHint = 351;
		combo_1.setLayoutData(gd_combo_1);
		
		Label lblIp = new Label(container, SWT.NONE);
		lblIp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblIp.setText("Локальный ip адрес");
		
		combo_2 = new Combo(container, SWT.NONE);
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label label_4 = new Label(container, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_4.setText("Фильтр входящих");
		
		combo_3 = new Combo(container, SWT.NONE);
		GridData gd_combo_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_3.widthHint = 351;
		combo_3.setLayoutData(gd_combo_3);
		
		Label lblIp_1 = new Label(container, SWT.NONE);
		lblIp_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblIp_1.setText("Удалённый ip адрес");
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label label_6 = new Label(container, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_6.setText("Фильтр исходящих");
		
		combo_4 = new Combo(container, SWT.NONE);
		GridData gd_combo_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_4.widthHint = 351;
		combo_4.setLayoutData(gd_combo_4);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblNewLabel.setText("Таймер неактивности");
		
		spinner = new Spinner(container, SWT.BORDER);
		GridData gd_spinner = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_spinner.widthHint = 124;
		spinner.setLayoutData(gd_spinner);
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("NAT режим");
		
		combo_5 = new Combo(container, SWT.NONE);
		GridData gd_combo_5 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_5.widthHint = 351;
		combo_5.setLayoutData(gd_combo_5);
		
		Label lblMtu = new Label(container, SWT.NONE);
		lblMtu.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblMtu.setText("MTU");
		
		spinner_1 = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_spinner_1.widthHint = 124;
		spinner_1.setLayoutData(gd_spinner_1);
		
		Group group_2 = new Group(container, SWT.NONE);
		group_2.setText("Таблица маршрутов");
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 4));
		
		Group group = new Group(container, SWT.NONE);
		group.setText("Дополнительные параметры");
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 5, 1));
		
		Label label_8 = new Label(group, SWT.NONE);
		label_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_8.setText("Порт");
		
		combo_6 = new Combo(group, SWT.NONE);
		GridData gd_combo_6 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo_6.widthHint = 167;
		combo_6.setLayoutData(gd_combo_6);
		
		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("Запретить обработку датаграмм");
		group_1.setLayout(new GridLayout(2, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 5, 1));
		
		button = new Button(group_1, SWT.CHECK);
		button.setText("Не туннелированных");
		
		btnCheckButton = new Button(group_1, SWT.CHECK);
		btnCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnCheckButton.setText("Транзитных");
		
		btnCheckButton_1 = new Button(group_1, SWT.CHECK);
		btnCheckButton_1.setText("DHCP протокола");
		
		btnCheckButton_2 = new Button(group_1, SWT.CHECK);
		btnCheckButton_2.setText("RIP протокола");
		
		btnCheckButton_3 = new Button(group_1, SWT.CHECK);
		btnCheckButton_3.setText("Multicast");
		
		btnCheckButton_4 = new Button(group_1, SWT.CHECK);
		btnCheckButton_4.setText("Cluster");
		
		btnIp = new Button(container, SWT.CHECK);
		btnIp.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnIp.setText("IP статистика");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		btnCheckButton_5 = new Button(container, SWT.CHECK);
		btnCheckButton_5.setText("Прокси ARP");
		btnCheckButton_5.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		new Label(container, SWT.NONE);

		bindData();
		
		return container;
	}

	private void bindData() {
		WritableValue value  = new WritableValue();

		// create the binding
		DataBindingContext ctx = new DataBindingContext();
		
		IObservableValue target = WidgetProperties.
		  text(SWT.Modify).observe(text);
		IObservableValue model = BeanProperties.value("name").
		    observeDetail(value);

		ctx.bindValue(target, model);
		    
		// create a Person object called p
		InterfaceBean ib = new InterfaceBean();

		// make the binding valid for this new object
		value.setValue(ib);
		
		
	}

	/**
	 * Create contents of the button bar.
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
		return new Point(1114, 447);
	}

}
