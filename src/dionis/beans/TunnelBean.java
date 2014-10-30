package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class TunnelBean extends ModelObject implements PropertyChangeListener,
		Cloneable {

	private static final long serialVersionUID = 0;
	protected int id;
	protected TunnelIPBean ip;
	protected UDPBean udp;
	protected BooleanType lzw;
	protected BooleanType unused;
	protected BooleanType blocked;
	protected TunnelEncryptionBean encryption;
	protected TunnelFiltersBean filters;

	public TunnelBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		firePropertyChange("id", this.id, this.id = id);
	}

	public TunnelIPBean getIp() {
		return ip;
	}

	public void setIp(TunnelIPBean ip) {
		ip.addPropertyChangeListener("local", this);
		ip.addPropertyChangeListener("remote", this);
		firePropertyChange("ip", this.ip, this.ip = ip);
	}

	public UDPBean getUdp() {
		return udp;
	}

	public void setUdp(UDPBean udp) {
		ip.addPropertyChangeListener("title", this);
		ip.addPropertyChangeListener("ports", this);
		firePropertyChange("udp", this.udp, this.udp = udp);
	}

	public BooleanType getLzw() {
		return lzw;
	}

	public void setLzw(BooleanType lzw) {
		firePropertyChange("lzw", this.lzw, this.lzw = lzw);
	}

	public BooleanType getUnused() {
		return unused;
	}

	public void setUnused(BooleanType unused) {
		firePropertyChange("unused", this.unused, this.unused = unused);
	}

	public BooleanType getBlocked() {
		return blocked;
	}

	public void setBlocked(BooleanType blocked) {
		firePropertyChange("blocked", this.blocked, this.blocked = blocked);
	}

	public TunnelEncryptionBean getEncryption() {
		return encryption;
	}

	public void setEncryption(TunnelEncryptionBean encryption) {
		ip.addPropertyChangeListener("method", this);
		ip.addPropertyChangeListener("serNumber", this);
		ip.addPropertyChangeListener("channel", this);
		ip.addPropertyChangeListener("cryptoNumber", this);
		firePropertyChange("encryption", this.encryption,
				this.encryption = encryption);
	}

	public TunnelFiltersBean getFilters() {
		return filters;
	}

	public void setFilters(TunnelFiltersBean filters) {
		ip.addPropertyChangeListener("filter", this);
		firePropertyChange("filters", this.filters, this.filters = filters);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
