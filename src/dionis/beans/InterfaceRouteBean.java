package dionis.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InterfaceRouteBean {

	protected String ip;
	protected short bits;
	protected String gateway;
	protected short metric;
	protected short tag;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public InterfaceRouteBean() {
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		propertyChangeSupport.firePropertyChange("ip", this.ip, this.ip = ip);
	}

	public short getBits() {
		return bits;
	}

	public void setBits(short bits) {
		propertyChangeSupport.firePropertyChange("bits", this.bits,
				this.bits = bits);
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		propertyChangeSupport.firePropertyChange("gateway", this.gateway,
				this.gateway = gateway);
	}

	public short getMetric() {
		return metric;
	}

	public void setMetric(short metric) {
		propertyChangeSupport.firePropertyChange("metric", this.metric,
				this.metric = metric);
	}

	public short getTag() {
		return tag;
	}

	public void setTag(short tag) {
		propertyChangeSupport.firePropertyChange("tag", this.tag,
				this.tag = tag);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (ip != null)
			builder.append(ip).append(" ");
		builder.append(bits).append(" ");
		if (gateway != null)
			builder.append(gateway).append(" ");
		if (metric != 0)
			builder.append(metric).append(" ");
		if (tag != 0)
			builder.append(tag);
		return builder.toString();
	}
}
