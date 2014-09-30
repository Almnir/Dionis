package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class VLANsBean implements PropertyChangeListener {

	protected VLANBean vlan;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public VLANsBean() {
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public VLANBean getVlan() {
		return vlan;
	}

	public void setVlan(VLANBean vlan) {
		vlan.addPropertyChangeListener("ip", this);
		vlan.addPropertyChangeListener("bits", this);
		vlan.addPropertyChangeListener("vnid", this);
		propertyChangeSupport.firePropertyChange("vlan", this.vlan,
				this.vlan = vlan);
	}
}
