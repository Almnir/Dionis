package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class LevelBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected BooleanType channel;
	protected BooleanType iparp;
	protected BooleanType tcpudpicmp;
	protected BooleanType hexDump;

	public LevelBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public BooleanType getChannel() {
		return channel;
	}

	public void setChannel(BooleanType channel) {
		firePropertyChange("channel", this.channel, this.channel = channel);
	}

	public BooleanType getIparp() {
		return iparp;
	}

	public void setIparp(BooleanType iparp) {
		firePropertyChange("iparp", this.iparp, this.iparp = iparp);
	}

	public BooleanType getTcpudpicmp() {
		return tcpudpicmp;
	}

	public void setTcpudpicmp(BooleanType tcpudpicmp) {
		firePropertyChange("tcpudpicmp", this.tcpudpicmp,
				this.tcpudpicmp = tcpudpicmp);
	}

	public BooleanType getHexDump() {
		return hexDump;
	}

	public void setHexDump(BooleanType hexDump) {
		firePropertyChange("hexDump", this.hexDump, this.hexDump = hexDump);
	}

}
