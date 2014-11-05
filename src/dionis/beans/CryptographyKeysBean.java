package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CryptographyKeysBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private KeyBean key;

	public CryptographyKeysBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public KeyBean getKey() {
		return key;
	}

	public void setKey(KeyBean key) {
		key.addPropertyChangeListener("serial", this);
		key.addPropertyChangeListener("number", this);
		firePropertyChange("key", this.key, this.key = key);
	}

}
