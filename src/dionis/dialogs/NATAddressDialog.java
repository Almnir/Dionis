package dionis.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;

public class NATAddressDialog extends Dialog {
    private Text text;
    private Text text_1;

    /**
     * Create the dialog.
     * @param parentShell
     */
    public NATAddressDialog(Shell parentShell) {
        super(parentShell);
        parentShell.setText("Элемент статической NAT таблицы");
    }

    /**
     * Create contents of the dialog.
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        container.setLayout(new GridLayout(4, false));
        
        Button btnpat = new Button(container, SWT.CHECK);
        btnpat.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
        btnpat.setText("Правило трансляции портов(PAT)");
        
        Label lblNewLabel = new Label(container, SWT.NONE);
        lblNewLabel.setText("Внутренний адрес");
        
        text = new Text(container, SWT.BORDER);
        GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_text.widthHint = 187;
        text.setLayoutData(gd_text);
        
        Label label = new Label(container, SWT.NONE);
        label.setText("порт");
        
        Spinner spinner = new Spinner(container, SWT.BORDER);
        GridData gd_spinner = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_spinner.widthHint = 99;
        spinner.setLayoutData(gd_spinner);
        
        Label label_1 = new Label(container, SWT.NONE);
        label_1.setText("Внешний адрес");
        
        text_1 = new Text(container, SWT.BORDER);
        GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_text_1.widthHint = 211;
        text_1.setLayoutData(gd_text_1);
        
        Label lblNewLabel_1 = new Label(container, SWT.NONE);
        lblNewLabel_1.setText("порт");
        
        Spinner spinner_1 = new Spinner(container, SWT.BORDER);
        GridData gd_spinner_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_spinner_1.widthHint = 99;
        spinner_1.setLayoutData(gd_spinner_1);
        new Label(container, SWT.NONE);
        
        Label label_2 = new Label(container, SWT.NONE);
        label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        label_2.setText("Значащих бит");
        
        Spinner spinner_2 = new Spinner(container, SWT.BORDER);
        new Label(container, SWT.NONE);
        
        return container;
    }

    /**
     * Create contents of the button bar.
     * @param parent
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(576, 217);
    }

}
