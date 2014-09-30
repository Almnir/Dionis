package dionis.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import dionis.models.AddressModel;

public class AddressTableDialog extends Dialog {
	private Text text;
	private Text text_1;
	private String[] data;
	private boolean newadd;
	private Button button;
	private Button btnRadioButton;
	private Button button_1;
	private Button btnRadioButton_1;

	/**
	 * Create the dialog.
	 * 
	 * @param Shell
	 * @param iStructuredSelection
	 */
	public AddressTableDialog(Shell parentShell, IStructuredSelection sel) {
		super(parentShell);
		parentShell.setText("Элемент таблицы адресов");
		if (sel != null) {
			this.data = (String[]) sel.getFirstElement();
			this.newadd = false;
		} else {
			this.data = new String[] { "", "" };
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
		container.setLayout(new GridLayout(3, false));

		button = new Button(container, SWT.RADIO);
		button.setText("Адрес домена");

		// при выборе адреса домена включаем ввод "ip адреса" и включаем ввод
		// домена
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setEnabled(true);
				text_1.setEnabled(true);
			}
		});

		Label lblIp = new Label(container, SWT.NONE);
		lblIp.setText("IP адрес");

		text = new Text(container, SWT.BORDER);
		// text = new IPAddressBox(container, false, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gd_text.widthHint = 160;
		text.setLayoutData(gd_text);

		btnRadioButton = new Button(container, SWT.RADIO);
		btnRadioButton.setText("Чёрный список");

		// при выборе чёрного списка отключаем ввод "ip адреса"
		btnRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("0.0.0.0");
				text.setEnabled(false);
				text_1.setEnabled(true);
			}
		});

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("Имя домена");

		text_1 = new Text(container, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

		button_1 = new Button(container, SWT.RADIO);
		button_1.setText("Белый список");

		// при выборе белого списка отключаем ввод "ip адреса"
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("0.0.0.1");
				text.setEnabled(false);
				text_1.setEnabled(true);
			}
		});

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		btnRadioButton_1 = new Button(container, SWT.RADIO);
		btnRadioButton_1.setText("Адрес интерфейса");

		// при выборе адреса интерфейса включаем ввод "ip адреса" и отключаем
		// ввод домена
		btnRadioButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setEnabled(true);
				text_1.setEnabled(false);
			}
		});

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		getAll();

		return container;
	}

	private void getAll() {
		if (data != null) {
			if (newadd == false) {
				String ip = this.data[0];
				String domain = this.data[1];
				if (ip.equals("Чёрный список")) {
					btnRadioButton.setSelection(true);
					btnRadioButton.setFocus();
					text.setEnabled(false);
					ip = "0.0.0.0";
				} else if (ip.equals("Белый список")) {
					button_1.setSelection(true);
					button_1.setFocus();
					text.setEnabled(false);
					ip = "0.0.0.1";
				} else if (domain.equals("IP адрес интерфейса")) {
					btnRadioButton_1.setSelection(true);
					btnRadioButton_1.setFocus();
					text_1.setEnabled(false);
					domain = "";
				} else {
					button.setSelection(true);
					button.setFocus();
				}
				// изменение
				text.setText(ip);
				text_1.setText(domain);
			} else {
				// новое (добавление)
				text.setText("0.0.0.0");
				text_1.setText("");
				button.setSelection(true);
			}
		}
	}

	@Override
	protected void okPressed() {
		String ip = text.getText();
		String domain = text_1.getText();

		List<String[]> adata = AddressModel.getInstance().getAllAddress();

		// чёрный список
		if (btnRadioButton.getSelection()) {
			ip = "Чёрный список";
		} else if (button_1.getSelection()) {
			ip = "Белый список";
		} else if (btnRadioButton_1.getSelection()) {
			domain = "IP адрес интерфейса";
		}

		this.data[0] = ip;
		this.data[1] = domain;

		// если список не пуст
		if (adata != null) {
			// изменяем элемент в списке
			int indexx = adata.indexOf(data);
			if (indexx == -1) {
				// если нет в списке - добавить
				adata.add(data);
			} else {
				// если есть - заменить на текущее
				adata.set(indexx, data);
			}
		} else {
			// новый список
			adata = new ArrayList<String[]>();
			adata.add(data);
		}
		// меняем список в модели на изменённый
		AddressModel.getInstance().setAllAddress(adata);
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
		return new Point(469, 225);
	}

}
