package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.LogsPartsType;

public class LogsBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected ControlBean control;
	protected String mode;
	protected int size;
	protected LogsScheduleBean schedule;
	protected String renameTo;
	protected LogsPartsType parts;

	public LogsBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public ControlBean getControl() {
		return control;
	}

	public void setControl(ControlBean control) {
		control.addPropertyChangeListener("log", this);
		control.addPropertyChangeListener("logUser", this);
		control.addPropertyChangeListener("logSend", this);
		control.addPropertyChangeListener("logTcp", this);
		control.addPropertyChangeListener("logSess", this);
		firePropertyChange("control", this.control, this.control = control);
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		firePropertyChange("mode", this.mode, this.mode = mode);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		firePropertyChange("size", this.size, this.size = size);
	}

	public LogsScheduleBean getSchedule() {
		return schedule;
	}

	public void setSchedule(LogsScheduleBean schedule) {
		schedule.addPropertyChangeListener("use", this);
		schedule.addPropertyChangeListener("item", this);
		firePropertyChange("schedule", this.schedule, this.schedule = schedule);
	}

	public String getRenameTo() {
		return renameTo;
	}

	public void setRenameTo(String renameTo) {
		firePropertyChange("renameTo", this.renameTo, this.renameTo = renameTo);
	}

	public LogsPartsType getParts() {
		return parts;
	}

	public void setParts(LogsPartsType parts) {
		firePropertyChange("parts", this.parts, this.parts = parts);
	}

}
