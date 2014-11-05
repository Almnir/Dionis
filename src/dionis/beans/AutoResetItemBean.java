package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.WeekDayType;

public class AutoResetItemBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected WeekDayType day;
	protected short houre;

	public AutoResetItemBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public WeekDayType getDay() {
		return day;
	}

	public void setDay(WeekDayType day) {
		firePropertyChange("day", this.day, this.day = day);
	}

	public short getHoure() {
		return houre;
	}

	public void setHoure(short houre) {
		firePropertyChange("houre", this.houre, this.houre = houre);
	}

}
