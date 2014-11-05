package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class CryptographyBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected BooleanType initialized;
	protected BooleanType kernel;
	protected CryptoEncryptionBean encryption;
	protected BooleanType keep;
	protected CryptographyKeysBean keys;

	public CryptographyBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public BooleanType getInitialized() {
		return initialized;
	}

	public void setInitialized(BooleanType initialized) {
		firePropertyChange("initialized", this.initialized,
				this.initialized = initialized);
	}

	public BooleanType getKernel() {
		return kernel;
	}

	public void setKernel(BooleanType kernel) {
		firePropertyChange("kernel", this.kernel, this.kernel = kernel);
	}

	public CryptoEncryptionBean getEncryption() {
		return encryption;
	}

	public void setEncryption(CryptoEncryptionBean encryption) {
		encryption.addPropertyChangeListener("ip", this);
		firePropertyChange("encryption", this.encryption,
				this.encryption = encryption);
	}

	public BooleanType getKeep() {
		return keep;
	}

	public void setKeep(BooleanType keep) {
		firePropertyChange("keep", this.keep, this.keep = keep);
	}

	public CryptographyKeysBean getKeys() {
		return keys;
	}

	public void setKeys(CryptographyKeysBean keys) {
		keys.addPropertyChangeListener("key", this);
		firePropertyChange("keys", this.keys, this.keys = keys);
	}

}
