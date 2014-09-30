package dionis.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import dionis.xml.BooleanType;

public class TOSBean {

	protected BooleanType copy;
	protected short value;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public TOSBean() {
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public void setCopy(BooleanType value) {
		propertyChangeSupport.firePropertyChange("copy", this.copy,
				this.copy = value);
	}

	public void setValue(short value) {
		propertyChangeSupport.firePropertyChange("value", this.value,
				this.value = value);
	}

	public BooleanType getCopy() {
		return copy;
	}

	public short getValue() {
		return value;
	}

}
