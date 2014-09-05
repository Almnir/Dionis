package dionis.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
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
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import dionis.models.NATAddressModel;
import dionis.xml.Global;
import dionis.xml.Local;
import dionis.xml.NATTableStatic;

public class NATAddressDialog extends Dialog {
	private Text text;
	private Text text_1;
	private Spinner spinner;
	private Spinner spinner_1;
	private NATTableStatic natTable;
	boolean newadd;
	private Button btnpat;
	private Spinner spinner_2;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param iSelection
	 */
	public NATAddressDialog(Shell parentShell, ISelection iSelection) {
		super(parentShell);
		if (iSelection != null) {
			IStructuredSelection sel = (IStructuredSelection) iSelection;
			natTable = (NATTableStatic) sel.getFirstElement();
			newadd = false;
		} else {
			natTable = new NATTableStatic();
			newadd = true;
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
		container.setLayout(new GridLayout(4, false));

		btnpat = new Button(container, SWT.CHECK);
		btnpat.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
				4, 1));
		btnpat.setText("Правило трансляции портов(PAT)");

		btnpat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (spinner != null && spinner_1 != null) {
					Button button = (Button) e.widget;
					if (button.getSelection()) {
						spinner.setEnabled(true);
						spinner_1.setEnabled(true);
					} else {
						spinner.setEnabled(false);
						spinner_1.setEnabled(false);
					}
				}
			}
		});

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("Внутренний адрес");

		text = new Text(container, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gd_text.widthHint = 187;
		text.setLayoutData(gd_text);
		text.setText("0.0.0.0");
		
		Label label = new Label(container, SWT.NONE);
		label.setText("порт");

		spinner = new Spinner(container, SWT.BORDER);
		GridData gd_spinner = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_spinner.widthHint = 99;
		spinner.setLayoutData(gd_spinner);
		spinner.setMinimum(0);
		spinner.setMaximum(65535);

		Label label_1 = new Label(container, SWT.NONE);
		label_1.setText("Внешний адрес");

		text_1 = new Text(container, SWT.BORDER);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1);
		gd_text_1.widthHint = 211;
		text_1.setLayoutData(gd_text_1);
		text_1.setText("0.0.0.0");

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("порт");

		spinner_1 = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_spinner_1.widthHint = 99;
		spinner_1.setLayoutData(gd_spinner_1);
		spinner_1.setMinimum(0);
		spinner_1.setMaximum(65535);

		new Label(container, SWT.NONE);

		Label label_2 = new Label(container, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_2.setText("Значащих бит");

		spinner_2 = new Spinner(container, SWT.BORDER);
		new Label(container, SWT.NONE);
		spinner_2.setMinimum(0);
		spinner_2.setMaximum(32);

		
		getAll();
		
		return container;
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

	private void getAll() {
		if (newadd == false) {
			// добавление
			btnpat.setSelection(natTable.isPAT());
			text.setText(natTable.getLocal().getIP());
			spinner.setSelection(natTable.getLocal().getPort());
			text_1.setText(natTable.getGlobal().getIP());
			spinner_1.setSelection(natTable.getGlobal().getPort());
			spinner_2.setSelection(natTable.getBits());
			// отключать порты, если нет правила трансляции портов
			if (natTable.isPAT()) {
				spinner.setEnabled(true);
				spinner_1.setEnabled(true);
			} else {
				spinner.setEnabled(false);
				spinner_1.setEnabled(false);
			}

		} else {
			// новое
			btnpat.setSelection(false);
			text.setText("0.0.0.0");
			text_1.setText("0.0.0.0");
			spinner.setSelection(0); spinner.setEnabled(false);
			spinner_1.setSelection(0);spinner_1.setEnabled(false);
			spinner_2.setSelection(0);
		}
	}

	@Override
	protected void okPressed() {
		natTable.setPAT(btnpat.getSelection());
		if (natTable.getLocal() != null) {
			natTable.getLocal().setIP(text.getText());
			natTable.getLocal().setPort(spinner.getSelection());
		} else {
			Local local = new Local();
			local.setIP(text.getText());
			local.setPort(spinner.getSelection());
			natTable.setLocal(local);
		}
		if (natTable.getGlobal() != null) {
			natTable.getGlobal().setIP(text_1.getText());
			natTable.getLocal().setPort(spinner_1.getSelection());
		} else {
			Global global = new Global();
			global.setIP(text_1.getText());
			global.setPort(spinner_1.getSelection());
			natTable.setGlobal(global);
		}
		natTable.setBits(Byte.parseByte(String.valueOf(spinner_2.getSelection())));
		List<NATTableStatic> natList = NATAddressModel.getInstance()
				.getNatTable();
		// если список SIO портов не пуст
		if (natList != null) {
			// изменяем элемент порта в списке
			int indexx = natList.indexOf(natTable);
			if (indexx == -1) {
				// если нет в списке - добавить
				natList.add(natTable);
			} else {
				// если есть - заменить на текущее
				natList.set(indexx, natTable);
			}
		} else {
			// новый список портов
			natList = new ArrayList<NATTableStatic>();
			natList.add(natTable);
		}
		// меняем список SIO портов в модели на изменённый
		NATAddressModel.getInstance().setNatTable(natList);
		super.okPressed();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(576, 217);
	}

}
