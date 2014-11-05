package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TracingInterfacesBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected TypeBean type;
	protected LevelBean level;

	public TracingInterfacesBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public TypeBean getType() {
		return type;
	}

	public void setType(TypeBean type) {
		type.addPropertyChangeListener("ethernet", this);
		type.addPropertyChangeListener("slipppp", this);
		type.addPropertyChangeListener("loopbackBroadcast", this);
		type.addPropertyChangeListener("x25", this);
		type.addPropertyChangeListener("arp", this);
		firePropertyChange("type", this.type, this.type = type);
	}

	public LevelBean getLevel() {
		return level;
	}

	public void setLevel(LevelBean level) {
		level.addPropertyChangeListener("channel", this);
		level.addPropertyChangeListener("iparp", this);
		level.addPropertyChangeListener("tcpudpicmp", this);
		level.addPropertyChangeListener("hexDump", this);
		firePropertyChange("level", this.level, this.level = level);
	}

}
