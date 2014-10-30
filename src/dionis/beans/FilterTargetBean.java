package dionis.beans;

import java.io.Serializable;

public class FilterTargetBean extends ModelObject implements Serializable {
	
	private static final long serialVersionUID = 0;
	
	protected String ip;
	protected short bits;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		firePropertyChange("ip", this.ip, this.ip = ip);
	}

	public short getBits() {
		return bits;
	}

	public void setBits(short bits) {
		firePropertyChange("bits", this.bits, this.bits = bits);
	}
}
