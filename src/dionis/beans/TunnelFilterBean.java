package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.FilterStatusType;
import dionis.xml.TunnelProtocolType;

public class TunnelFilterBean extends ModelObject implements
		PropertyChangeListener, Cloneable {

	protected FilterStatusType status;
	protected TunnelFilterSourceBean source;
	protected TunnelFilterTargetBean target;
	protected TunnelProtocolType protocol;
	protected TunnelFilterPortsBean ports;

	public TunnelFilterBean() {
	}

	public FilterStatusType getStatus() {
		return status;
	}

	public void setStatus(FilterStatusType status) {
		firePropertyChange("status", this.status, this.status = status);
	}

	public TunnelFilterSourceBean getSource() {
		return source;
	}

	public void setSource(TunnelFilterSourceBean source) {
		source.addPropertyChangeListener("ip", this);
		source.addPropertyChangeListener("bits", this);
		firePropertyChange("source", this.source, this.source = source);
	}

	public TunnelFilterTargetBean getTarget() {
		return target;
	}

	public void setTarget(TunnelFilterTargetBean target) {
		target.addPropertyChangeListener("ip", this);
		target.addPropertyChangeListener("bits", this);
		firePropertyChange("target", this.target, this.target = target);
	}

	public TunnelProtocolType getProtocol() {
		return protocol;
	}

	public void setProtocol(TunnelProtocolType protocol) {
		firePropertyChange("protocol", this.protocol, this.protocol = protocol);
	}

	public TunnelFilterPortsBean getPorts() {
		return ports;
	}

	public void setPorts(TunnelFilterPortsBean ports) {
		ports.addPropertyChangeListener("low", this);
		ports.addPropertyChangeListener("high", this);
		firePropertyChange("ports", this.ports, this.ports = ports);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
