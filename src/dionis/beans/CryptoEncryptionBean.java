package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class CryptoEncryptionBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private BooleanType ip;
	
	public CryptoEncryptionBean() {
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public BooleanType getIp() {
		return ip;
	}

	public void setIp(BooleanType ip) {
		firePropertyChange("ip", this.ip, this.ip = ip);
	}

}
