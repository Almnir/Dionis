package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;
import dionis.xml.RemoteControlModeType;

public class RemoteControlBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String user;
	protected String password;
	protected RemoteControlModeType mode;
	protected BooleanType reload;
	protected String upload;
	protected String download;
	protected RemoteControlKeysBean keys;

	public RemoteControlBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		firePropertyChange("user", this.user, this.user = user);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		firePropertyChange("password", this.password, this.password = password);
	}

	public RemoteControlModeType getMode() {
		return mode;
	}

	public void setMode(RemoteControlModeType mode) {
		firePropertyChange("mode", this.mode, this.mode = mode);
	}

	public BooleanType getReload() {
		return reload;
	}

	public void setReload(BooleanType reload) {
		firePropertyChange("reload", this.reload, this.reload = reload);
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		firePropertyChange("upload", this.upload, this.upload = upload);
	}

	public String getDownload() {
		return download;
	}

	public void setDownload(String download) {
		firePropertyChange("download", this.download, this.download = download);
	}

	public RemoteControlKeysBean getKeys() {
		return keys;
	}

	public void setKeys(RemoteControlKeysBean keys) {
		keys.addPropertyChangeListener("key", this);
		firePropertyChange("keys", this.keys, this.keys = keys);
	}

}
