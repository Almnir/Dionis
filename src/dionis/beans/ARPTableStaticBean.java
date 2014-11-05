package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ARPTableStaticBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String ip;
	protected String mac;

	public ARPTableStaticBean() {
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

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		firePropertyChange("mac", this.mac, this.mac = mac);
	}

}
