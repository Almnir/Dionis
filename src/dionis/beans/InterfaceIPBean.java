package dionis.beans;

public class InterfaceIPBean extends ModelObject {

	private static final long serialVersionUID = 0;
	
	protected String local;
	protected String remote;

	public InterfaceIPBean() {
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String value) {
		firePropertyChange("local", this.local, this.local = value);
	}

	public String getRemote() {
		return remote;
	}

	public void setRemote(String value) {
		firePropertyChange("remote", this.remote, this.remote = value);
	}
}
