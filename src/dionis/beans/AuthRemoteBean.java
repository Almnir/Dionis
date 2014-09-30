package dionis.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import dionis.xml.InterfaceAuthorityType;

public class AuthRemoteBean {

	protected InterfaceAuthorityType auth;
	protected String name;
	protected String password;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public AuthRemoteBean() {
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public InterfaceAuthorityType getAuth() {
		return auth;
	}

	public void setAuth(InterfaceAuthorityType auth) {
		propertyChangeSupport.firePropertyChange("auth", this.auth,
				this.auth = auth);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		propertyChangeSupport.firePropertyChange("name", this.name,
				this.name = name);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		propertyChangeSupport.firePropertyChange("password", this.password,
				this.password = password);
	}
}
