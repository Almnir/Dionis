package dionis.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class VLANBean {

	protected String ip;
	protected short bits;
	protected int vnid;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public VLANBean() {
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

	public int getVnid() {
		return vnid;
	}

	public void setVnid(int vnid) {
		propertyChangeSupport.firePropertyChange("vnid", this.vnid,
				this.vnid = vnid);
	}
}
