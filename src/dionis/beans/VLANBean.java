package dionis.beans;

public class VLANBean extends ModelObject implements Cloneable {

	protected String ip;
	protected short bits;
	protected int vnid;

	public VLANBean() {
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

	public int getVnid() {
		return vnid;
	}

	public void setVnid(int vnid) {
		firePropertyChange("vnid", this.vnid, this.vnid = vnid);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VLANBean [");
		if (ip != null) {
			builder.append("ip=");
			builder.append(ip);
			builder.append(", ");
		}
		builder.append("bits=");
		builder.append(bits);
		builder.append(", vnid=");
		builder.append(vnid);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
