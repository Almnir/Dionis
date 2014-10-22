package dionis.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import dionis.beans.DateBean;
import dionis.beans.DateBeginBean;
import dionis.beans.DateEndBean;
import dionis.beans.DaysBean;
import dionis.beans.IFilterItem;
import dionis.beans.SheduleFilterItemBean;
import dionis.beans.TimeInterval1Bean;
import dionis.beans.TimeInterval1BeginBean;
import dionis.beans.TimeInterval1EndBean;
import dionis.beans.TimeInterval2Bean;
import dionis.beans.TimeInterval2BeginBean;
import dionis.beans.TimeInterval2EndBean;
import dionis.xml.BooleanType;

public class SheduleRuleDialog extends Dialog {

	private IFilterItem data;
	private boolean newadd;
	private Button excludeRadioButton;
	private Button includeRadioButton;
	private Button monCheckButton;
	private Button tueCheckButton;
	private Button wedCheckButton;
	private Button thuCheckButton;
	private Button friCheckButton;
	private Button satCheckButton;
	private Button sunCheckButton;
	private Button dateCheckButton;
	private DateTime beginDateTime;
	private DateTime endDateTime;
	private DateTime beginTimeInterval1;
	private DateTime endTimeInterval1;
	private DateTime beginTimeInterval2;
	private DateTime endTimeInterval2;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public SheduleRuleDialog(Shell parentShell, IFilterItem data) {
		super(parentShell);
		if (data != null) {
			this.data = data;
			this.newadd = false;
		} else {
			this.data = new SheduleFilterItemBean();
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
		container.setLayout(new GridLayout(1, false));

		parent.getShell().setText("Элемент расписания IP фильтра");

		Group group = new Group(container, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		group.setText("Режим действия элемента");
		group.setLayout(new GridLayout(2, false));

		excludeRadioButton = new Button(group, SWT.RADIO);
		excludeRadioButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		excludeRadioButton.setText("Исключить");

		includeRadioButton = new Button(group, SWT.RADIO);
		includeRadioButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		includeRadioButton.setText("Включить");

		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("Дни недели");
		group_1.setLayout(new GridLayout(7, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		monCheckButton = new Button(group_1, SWT.CHECK);
		monCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		monCheckButton.setText("Пн");

		tueCheckButton = new Button(group_1, SWT.CHECK);
		tueCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		tueCheckButton.setText("Вт");

		wedCheckButton = new Button(group_1, SWT.CHECK);
		wedCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		wedCheckButton.setText("Ср");

		thuCheckButton = new Button(group_1, SWT.CHECK);
		thuCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		thuCheckButton.setText("Чт");

		friCheckButton = new Button(group_1, SWT.CHECK);
		friCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		friCheckButton.setText("Пт");

		satCheckButton = new Button(group_1, SWT.CHECK);
		satCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		satCheckButton.setText("Сб");

		sunCheckButton = new Button(group_1, SWT.CHECK);
		sunCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		sunCheckButton.setText("Вс");

		Group group_2 = new Group(container, SWT.NONE);
		group_2.setText("Диапазон дат");
		group_2.setLayout(new GridLayout(2, false));
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		dateCheckButton = new Button(group_2, SWT.CHECK);
		dateCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		dateCheckButton.setText("Учитывать даты");
		dateCheckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (dateCheckButton.getSelection() == true) {
					beginDateTime.setEnabled(true);
					endDateTime.setEnabled(true);
				} else {
					beginDateTime.setEnabled(false);
					endDateTime.setEnabled(false);
				}
			}
		});

		Composite composite = new Composite(group_2, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		composite.setLayout(new GridLayout(2, false));

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel.setText("Начало");

		beginDateTime = new DateTime(composite, SWT.BORDER);

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setText("Конец");

		endDateTime = new DateTime(composite, SWT.BORDER);

		Group group_3 = new Group(container, SWT.NONE);
		group_3.setLayout(new GridLayout(4, false));
		group_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		group_3.setText("Интервал времени 1");

		Label lblNewLabel_2 = new Label(group_3, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				true, 1, 1));
		lblNewLabel_2.setText("Начало");

		beginTimeInterval1 = new DateTime(group_3, SWT.BORDER | SWT.TIME
				| SWT.SHORT);
		beginTimeInterval1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, true, 1, 1));

		Label lblNewLabel_3 = new Label(group_3, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				true, 1, 1));
		lblNewLabel_3.setText("Конец");

		endTimeInterval1 = new DateTime(group_3, SWT.BORDER | SWT.TIME
				| SWT.SHORT);
		endTimeInterval1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				true, 1, 1));

		Group group_4 = new Group(container, SWT.NONE);
		group_4.setLayout(new GridLayout(4, false));
		group_4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		group_4.setText("Интервал времени 2");

		Label label = new Label(group_4, SWT.NONE);
		label.setText("Начало");

		beginTimeInterval2 = new DateTime(group_4, SWT.BORDER | SWT.TIME
				| SWT.SHORT);

		Label label_1 = new Label(group_4, SWT.NONE);
		label_1.setText("Конец");

		endTimeInterval2 = new DateTime(group_4, SWT.BORDER | SWT.TIME
				| SWT.SHORT);

		init();

		return container;
	}

	private void init() {
		setFieldsToDefault();
		if (this.data != null) {
			if (newadd == false) {
				if (data.getExclude() == BooleanType.YES) {
					excludeRadioButton.setSelection(true);
					includeRadioButton.setSelection(false);
				} else {
					excludeRadioButton.setSelection(false);
					includeRadioButton.setSelection(true);
				}
				if (data.getDays().getMon() == BooleanType.YES)
					monCheckButton.setSelection(true);
				else
					monCheckButton.setSelection(false);
				if (data.getDays().getTue() == BooleanType.YES)
					tueCheckButton.setSelection(true);
				else
					tueCheckButton.setSelection(false);
				if (data.getDays().getWed() == BooleanType.YES)
					wedCheckButton.setSelection(true);
				else
					wedCheckButton.setSelection(false);
				if (data.getDays().getThu() == BooleanType.YES)
					thuCheckButton.setSelection(true);
				else
					thuCheckButton.setSelection(false);
				if (data.getDays().getFri() == BooleanType.YES)
					friCheckButton.setSelection(true);
				else
					friCheckButton.setSelection(false);
				if (data.getDays().getSun() == BooleanType.YES)
					sunCheckButton.setSelection(true);
				else
					sunCheckButton.setSelection(false);
				if (data.getDate() != null) {
					dateCheckButton.setSelection(true);
					beginDateTime.setDate(data.getDate().getBegin().getYear(),
							data.getDate().getBegin().getMonth(), data
									.getDate().getBegin().getDay());
					endDateTime.setDate(data.getDate().getEnd().getYear(), data
							.getDate().getEnd().getMonth(), data.getDate()
							.getEnd().getDay());
				}
				if (data.getTimeInterval1() != null) {
					TimeInterval1Bean gti1 = data.getTimeInterval1();
					beginTimeInterval1.setTime(gti1.getBegin().getHour(), gti1
							.getBegin().getMinute(), 0);
					endTimeInterval1.setTime(gti1.getEnd().getHour(), gti1
							.getEnd().getHour(), 0);
				}
				if (data.getTimeInterval2() != null) {
					TimeInterval2Bean gti2 = data.getTimeInterval2();
					beginTimeInterval2.setTime(gti2.getBegin().getHour(), gti2
							.getBegin().getMinute(), 0);
					endTimeInterval2.setTime(gti2.getEnd().getHour(), gti2
							.getEnd().getHour(), 0);
				}
			}
		}
	}

	@Override
	protected void okPressed() {
		data.setExclude(excludeRadioButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		DaysBean daysBean;
		if (data.getDays() == null) {
			daysBean = new DaysBean();
		} else {
			daysBean = data.getDays();
		}
		daysBean.setMon(monCheckButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		daysBean.setTue(tueCheckButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		daysBean.setWed(wedCheckButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		daysBean.setThu(thuCheckButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		daysBean.setFri(friCheckButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		daysBean.setSat(satCheckButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		daysBean.setSun(sunCheckButton.getSelection() == true ? BooleanType.YES
				: BooleanType.NO);
		data.setDays(daysBean);
		if (dateCheckButton.getSelection() == true) {
			DateBean ddate;
			if (data.getDate() == null) {
				ddate = new DateBean();
			} else {
				ddate = data.getDate();
			}
			DateBeginBean beginBean = new DateBeginBean();
			beginBean.setYear((short) beginDateTime.getYear());
			beginBean.setMonth((byte) beginDateTime.getMonth());
			beginBean.setDay((byte) beginDateTime.getDay());
			ddate.setBegin(beginBean);
			DateEndBean endBean = new DateEndBean();
			endBean.setYear((short) endDateTime.getYear());
			endBean.setMonth((byte) endDateTime.getMonth());
			endBean.setDay((byte) endDateTime.getDay());
			ddate.setEnd(endBean);
			data.setDate(ddate);
		}
		TimeInterval1Bean interval1Bean = new TimeInterval1Bean();
		TimeInterval1BeginBean interval1BeginBean = new TimeInterval1BeginBean();
		interval1BeginBean.setHour((short) beginTimeInterval1.getHours());
		interval1BeginBean.setMinute((short) beginTimeInterval1.getMinutes());
		interval1Bean.setBegin(interval1BeginBean);
		TimeInterval1EndBean interval1EndBean = new TimeInterval1EndBean();
		interval1EndBean.setHour((short) endTimeInterval1.getHours());
		interval1EndBean.setMinute((short) endTimeInterval1.getMinutes());
		interval1Bean.setEnd(interval1EndBean);
		data.setTimeInterval1(interval1Bean);

		TimeInterval2Bean interval2Bean = new TimeInterval2Bean();
		TimeInterval2BeginBean interval2BeginBean = new TimeInterval2BeginBean();
		interval2BeginBean.setHour((short) beginTimeInterval2.getHours());
		interval2BeginBean.setMinute((short) beginTimeInterval2.getMinutes());
		interval2Bean.setBegin(interval2BeginBean);
		TimeInterval2EndBean interval2EndBean = new TimeInterval2EndBean();
		interval2EndBean.setHour((short) endTimeInterval2.getHours());
		interval2EndBean.setMinute((short) endTimeInterval2.getMinutes());
		interval2Bean.setEnd(interval2EndBean);
		data.setTimeInterval2(interval2Bean);
		super.okPressed();
	}

	private void setFieldsToDefault() {
		excludeRadioButton.setSelection(false);
		includeRadioButton.setSelection(true);
		monCheckButton.setSelection(false);
		tueCheckButton.setSelection(false);
		wedCheckButton.setSelection(false);
		thuCheckButton.setSelection(false);
		friCheckButton.setSelection(false);
		satCheckButton.setSelection(false);
		sunCheckButton.setSelection(false);
		dateCheckButton.setSelection(false);
		beginTimeInterval1.setDate(0, 0, 0);
		endTimeInterval1.setDate(0, 0, 0);
		beginTimeInterval2.setDate(0, 0, 0);
		endTimeInterval2.setDate(0, 0, 0);
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
		return new Point(395, 442);
	}

	public IFilterItem getData() {
		return data;
	}

	public void setData(IFilterItem data) {
		this.data = data;
	}
}
