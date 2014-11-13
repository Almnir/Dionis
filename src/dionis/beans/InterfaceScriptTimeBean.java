package dionis.beans;

import java.io.Serializable;

public class InterfaceScriptTimeBean extends ModelObject implements
		Serializable {

	private static final long serialVersionUID = 0;

	protected short connection;
	protected short script;

	public InterfaceScriptTimeBean() {
	}

	public short getConnection() {
		return connection;
	}

	public void setConnection(short connection) {
		firePropertyChange("connection", this.connection,
				this.connection = connection);
	}

	public short getScript() {
		return script;
	}

	public void setScript(short script) {
		firePropertyChange("script", this.script, this.script = script);
	}
}
