package dionis.beans;

public class CryptoNumberBean extends ModelObject {

	protected long local;
	protected long remote;

	public CryptoNumberBean() {
	}

	public long getLocal() {
		return local;
	}

	public void setLocal(long local) {
		firePropertyChange("local", this.local, this.local = local);
	}

	public long getRemote() {
		return remote;
	}

	public void setRemote(long remote) {
		firePropertyChange("remote", this.remote, this.remote = remote);
	}
}
