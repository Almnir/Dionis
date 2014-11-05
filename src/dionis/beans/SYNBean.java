package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SYNBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private byte number;

	public SYNBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public byte getNumber() {
		return number;
	}

	public void setNumber(byte number) {
		firePropertyChange("number", this.number, this.number = number);
	}

}
