package dionis.beans;

import java.io.Serializable;

public class ElementBean extends ModelObject implements Serializable {

	private static final long serialVersionUID = 0;

	protected String get;
	protected String send;

	public ElementBean() {
	}

	public String getGet() {
		return get;
	}

	public void setGet(String get) {
		firePropertyChange("get", this.get, this.get = get);
	}

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		firePropertyChange("send", this.send, this.send = send);
	}

}
