package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.ClusterModeType;

public class ClusterBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected ClusterModeType mode;
	protected byte timer;

	public ClusterBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public ClusterModeType getMode() {
		return mode;
	}

	public void setMode(ClusterModeType mode) {
		firePropertyChange("mode", this.mode, this.mode = mode);
	}

	public byte getTimer() {
		return timer;
	}

	public void setTimer(byte timer) {
		firePropertyChange("timer", this.timer, this.timer = timer);
	}

}
