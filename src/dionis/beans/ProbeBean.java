package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProbeBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String ip;
	protected int interval;
	protected int wait;
	protected short tag;

	public ProbeBean() {
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

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		firePropertyChange("interval", this.interval, this.interval = interval);
	}

	public int getWait() {
		return wait;
	}

	public void setWait(int wait) {
		firePropertyChange("wait", this.wait, this.wait = wait);
	}

	public short getTag() {
		return tag;
	}

	public void setTag(short tag) {
		firePropertyChange("tag", this.tag, this.tag = tag);
	}

}
