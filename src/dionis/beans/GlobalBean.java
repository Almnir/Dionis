package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GlobalBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String ip;
	protected int port;

	public GlobalBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		firePropertyChange("ip", this.ip, this.ip = ip);
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		firePropertyChange("port", this.port, this.port = port);
	}

}
