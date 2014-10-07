package dionis.beans;

public class TunnelFilterSourceBean extends ModelObject {

	protected String ip;
	protected short bits;

	public TunnelFilterSourceBean() {
	}

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
