package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class UDPBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;
	protected BooleanType title;
	protected TunnelUDPPortsBean ports;

	public UDPBean() {
	}

	public BooleanType getTitle() {
		return title;
	}

	public void setTitle(BooleanType title) {
		firePropertyChange("title", this.title, this.title = title);
	}

	public TunnelUDPPortsBean getPorts() {
		return ports;
	}

	public void setPorts(TunnelUDPPortsBean ports) {
		ports.addPropertyChangeListener("sender", this);
		ports.addPropertyChangeListener("receiver", this);
		firePropertyChange("ports", this.ports, this.ports = ports);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

	}
}
