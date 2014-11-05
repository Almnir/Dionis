package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BaseConstsBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String ip;
	protected short mss;
	protected int window;
	protected short ttl;
	protected short tcb;
	protected byte tcbBuf;
	protected short proxy;
	protected ClusterBean cluster;

	public BaseConstsBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		firePropertyChange("ip", this.ip, this.ip = ip);
	}

	public short getMss() {
		return mss;
	}

	public void setMss(short mss) {
		firePropertyChange("mss", this.mss, this.mss = mss);
	}

	public int getWindow() {
		return window;
	}

	public void setWindow(int window) {
		firePropertyChange("window", this.window, this.window = window);
	}

	public short getTtl() {
		return ttl;
	}

	public void setTtl(short ttl) {
		firePropertyChange("ttl", this.ttl, this.ttl = ttl);
	}

	public short getTcb() {
		return tcb;
	}

	public void setTcb(short tcb) {
		firePropertyChange("tcb", this.tcb, this.tcb = tcb);
	}

	public byte getTcbBuf() {
		return tcbBuf;
	}

	public void setTcbBuf(byte tcbBuf) {
		firePropertyChange("tcbBuf", this.tcbBuf, this.tcbBuf = tcbBuf);
	}

	public short getProxy() {
		return proxy;
	}

	public void setProxy(short proxy) {
		firePropertyChange("proxy", this.proxy, this.proxy = proxy);
	}

	public ClusterBean getCluster() {
		return cluster;
	}

	public void setCluster(ClusterBean cluster) {
		cluster.addPropertyChangeListener(this);
		firePropertyChange("cluster", this.cluster, this.cluster = cluster);
	}

}
