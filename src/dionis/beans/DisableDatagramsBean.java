package dionis.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import dionis.xml.BooleanType;

public class DisableDatagramsBean {

	protected BooleanType notTunneled;
	protected BooleanType dhcp;
	protected BooleanType multicast;
	protected BooleanType forward;
	protected BooleanType rip;
	protected BooleanType cluster;
	protected BooleanType ipStat;
	protected BooleanType proxyARP;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public DisableDatagramsBean() {
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public void setNotTunneled(BooleanType value) {
		propertyChangeSupport.firePropertyChange("notTunneled",
				this.notTunneled, this.notTunneled = value);
	}

	public void setDhcp(BooleanType value) {
		propertyChangeSupport.firePropertyChange("dhcp", this.dhcp,
				this.dhcp = value);
	}

	public void setMulticast(BooleanType value) {
		propertyChangeSupport.firePropertyChange("multicast", this.multicast,
				this.multicast = value);
	}

	public void setForward(BooleanType value) {
		propertyChangeSupport.firePropertyChange("forward", this.forward,
				this.forward = value);
	}

	public void setRip(BooleanType value) {
		propertyChangeSupport.firePropertyChange("rip", this.rip,
				this.rip = value);
	}

	public void setCluster(BooleanType value) {
		propertyChangeSupport.firePropertyChange("cluster", this.cluster,
				this.cluster = value);
	}

	public void setIpStat(BooleanType value) {
		propertyChangeSupport.firePropertyChange("ipStat", this.ipStat,
				this.ipStat = value);
	}

	public void setProxyARP(BooleanType value) {
		propertyChangeSupport.firePropertyChange("proxyARP", this.proxyARP,
				this.proxyARP = value);
	}

	public BooleanType getNotTunneled() {
		return this.notTunneled;
	}

	public BooleanType getDhcp() {
		return this.dhcp;
	}

	public BooleanType getMulticast() {
		return this.multicast;
	}

	public BooleanType getForward() {
		return this.forward;
	}

	public BooleanType getRip() {
		return this.rip;
	}

	public BooleanType getCluster() {
		return this.cluster;
	}

	public BooleanType getIpStat() {
		return this.ipStat;
	}

	public BooleanType getProxyARP() {
		return this.proxyARP;
	}

}