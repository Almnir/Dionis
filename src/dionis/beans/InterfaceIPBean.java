package dionis.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InterfaceIPBean {

	protected String local;
	protected String remote;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public InterfaceIPBean() {
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String value) {
		propertyChangeSupport.firePropertyChange("local", this.local,
				this.local = value);
	}

	public String getRemote() {
		return remote;
	}

	public void setRemote(String value) {
		propertyChangeSupport.firePropertyChange("remote", this.remote,
				this.remote = value);
	}
}
