package dionis.dialogs;

import java.util.ArrayList;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import dionis.utils.Constants;

public class FilterDialog extends Dialog {
	private Text nameText;
	// убрано в целях безопасности
	private String name = "";

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public FilterDialog(Shell parentShell) {
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
		container.setLayout(new GridLayout(1, false));

		parent.getShell().setText("Задайте имя фильтра");
		
		nameText = new Text(container, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

		Group filtersGroup = new Group(container, SWT.NONE);
		filtersGroup.setText("Список имён системных фильтров");
		filtersGroup.setLayout(new GridLayout(1, false));
		filtersGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));

		ListViewer listViewer = new ListViewer(filtersGroup, SWT.BORDER
				| SWT.V_SCROLL);
		List filterList = listViewer.getList();
		filterList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));

		listViewer.setContentProvider(ArrayContentProvider.getInstance());
		ArrayList<String> fltrs = new ArrayList<String>();
		for (int i = 0; i < Constants.FLT_SYS_NAMES.length; i++) {
			fltrs.add(Constants.FLT_SYS_NAMES[i]);
		}
		listViewer.setLabelProvider(new LabelProvider() {
			public String getText(Object element) {
				String name = (String) element;
				int index = 0;
				for (String str : Constants.FLT_SYS_NAMES) {
					if (str.equals(name)) {
						break;
					}
					index++;
				}
				return name + " " + Constants.FLT_SYS_DESCRIPTIONS[index];
			};
		});
		listViewer.setInput(fltrs);

		DataBindingContext bindingContext = new DataBindingContext();

		IObservableValue selection = ViewersObservables
				.observeSingleSelection(listViewer);
		bindingContext.bindValue(
				SWTObservables.observeText(nameText, SWT.None), selection);
		return container;
	}

	@Override
	protected void okPressed() {
		setName(nameText.getText());
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
		return new Point(660, 553);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
