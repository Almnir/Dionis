package dionis.beans;

import dionis.xml.BooleanType;

public class DisableDatagramsBean extends ModelObject {

	protected BooleanType notTunneled;
	protected BooleanType dhcp;
	protected BooleanType multicast;
	protected BooleanType forward;
	protected BooleanType rip;
	protected BooleanType cluster;
	protected BooleanType ipStat;
	protected BooleanType proxyARP;

	public DisableDatagramsBean() {
	}

	public void setNotTunneled(BooleanType value) {
		firePropertyChange("notTunneled", this.notTunneled,
				this.notTunneled = value);
	}

	public void setDhcp(BooleanType value) {
		firePropertyChange("dhcp", this.dhcp, this.dhcp = value);
	}

	public void setMulticast(BooleanType value) {
		firePropertyChange("multicast", this.multicast, this.multicast = value);
	}

	public void setForward(BooleanType value) {
		firePropertyChange("forward", this.forward, this.forward = value);
	}

	public void setRip(BooleanType value) {
		firePropertyChange("rip", this.rip, this.rip = value);
	}

	public void setCluster(BooleanType value) {
		firePropertyChange("cluster", this.cluster, this.cluster = value);
	}

	public void setIpStat(BooleanType value) {
		firePropertyChange("ipStat", this.ipStat, this.ipStat = value);
	}

	public void setProxyARP(BooleanType value) {
		firePropertyChange("proxyARP", this.proxyARP, this.proxyARP = value);
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
