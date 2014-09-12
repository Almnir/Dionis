package dionis.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class FactorDialog extends Dialog {
	private Text text;
	private Table table;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public FactorDialog(Shell parentShell) {
		super(parentShell);
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

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("Номер платы");

		Spinner spinner = new Spinner(container, SWT.BORDER);
		GridData gd_spinner = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_spinner.widthHint = 100;
		spinner.setLayoutData(gd_spinner);
		spinner.setMinimum(0);
		spinner.setMaximum(15);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		GridData gd_lblNewLabel_1 = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel_1.widthHint = 88;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setText("Интерфейс");

		Combo combo = new Combo(container, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2,
				1));

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setText("Режим работы");

		Combo combo_1 = new Combo(container, SWT.NONE);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				2, 1));

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setText("Размер буфера обмена");

		Spinner spinner_1 = new Spinner(container, SWT.BORDER);
		GridData gd_spinner_1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_spinner_1.widthHint = 100;
		spinner_1.setLayoutData(gd_spinner_1);
		new Label(container, SWT.NONE);
		spinner_1.setMinimum(8);
		spinner_1.setMaximum(255);

		Label lblNewLabel_5 = new Label(container, SWT.NONE);
		lblNewLabel_5.setText("MAC адрес");

		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2,
				1));

		Group grpVlan = new Group(container, SWT.NONE);
		grpVlan.setText("Таблица VLAN");
		grpVlan.setLayout(new GridLayout(1, false));
		GridData gd_grpVlan = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_grpVlan.heightHint = 104;
		grpVlan.setLayoutData(gd_grpVlan);

		TableViewer tableViewer = new TableViewer(grpVlan, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Адрес/бит");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("VNID");

		Label lblNewLabel_6 = new Label(container, SWT.NONE);
		lblNewLabel_6.setText("Ограничение скорости передачи");

		Spinner spinner_2 = new Spinner(container, SWT.BORDER);
		spinner_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		spinner_2.setMinimum(0);

		Label lblNewLabel_7 = new Label(container, SWT.NONE);
		lblNewLabel_7.setText("Ограничение скорости приёма");

		Spinner spinner_3 = new Spinner(container, SWT.BORDER);
		spinner_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		spinner_3.setMinimum(0);

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

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(496, 535);
	}

}
