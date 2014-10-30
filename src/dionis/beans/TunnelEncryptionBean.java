package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class TunnelEncryptionBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;
	protected BooleanType method;
	protected long serNumber;
	protected short channel;
	protected CryptoNumberBean cryptoNumber;

	public TunnelEncryptionBean() {
	}

	public BooleanType getMethod() {
		return method;
	}

	public void setMethod(BooleanType method) {
		firePropertyChange("method", this.method, this.method = method);
	}

	public long getSerNumber() {
		return serNumber;
	}

	public void setSerNumber(long serNumber) {
		firePropertyChange("serNumber", this.serNumber,
				this.serNumber = serNumber);
	}

	public short getChannel() {
		return channel;
	}

	public void setChannel(short channel) {
		firePropertyChange("channel", this.channel, this.channel = channel);
	}

	public CryptoNumberBean getCryptoNumber() {
		return cryptoNumber;
	}

	public void setCryptoNumber(CryptoNumberBean cryptoNumber) {
		cryptoNumber.addPropertyChangeListener("local", this);
		cryptoNumber.addPropertyChangeListener("remote", this);
		firePropertyChange("cryptoNumber", this.cryptoNumber,
				this.cryptoNumber = cryptoNumber);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}
}
