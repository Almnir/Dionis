package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HostBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String address;
	protected String name;

	public HostBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		firePropertyChange("address", this.address, this.address = address);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

}
