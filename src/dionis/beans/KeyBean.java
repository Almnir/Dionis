package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class KeyBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected long serial;
	protected long number;

	public KeyBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public long getSerial() {
		return serial;
	}

	public void setSerial(long serial) {
		firePropertyChange("serial", this.serial, this.serial = serial);
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		firePropertyChange("number", this.number, this.number = number);
	}

}
