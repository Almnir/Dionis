package dionis.beans;

public class TunnelIPBean extends ModelObject {

	private static final long serialVersionUID = 0;
	protected String local;
	protected String remote;

	public TunnelIPBean() {
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		firePropertyChange("local", this.local, this.local = local);
	}

	public String getRemote() {
		return remote;
	}

	public void setRemote(String remote) {
		firePropertyChange("remote", this.remote, this.remote = remote);
	}
}
