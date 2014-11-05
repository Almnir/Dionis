package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class TypeBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected BooleanType ethernet;
	protected BooleanType slipppp;
	protected BooleanType loopbackBroadcast;
	protected BooleanType x25;
	protected BooleanType arp;

	public TypeBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public BooleanType getEthernet() {
		return ethernet;
	}

	public void setEthernet(BooleanType ethernet) {
		firePropertyChange("ethernet", this.ethernet, this.ethernet = ethernet);
	}

	public BooleanType getSlipppp() {
		return slipppp;
	}

	public void setSlipppp(BooleanType slipppp) {
		firePropertyChange("slipppp", this.slipppp, this.slipppp = slipppp);
	}

	public BooleanType getLoopbackBroadcast() {
		return loopbackBroadcast;
	}

	public void setLoopbackBroadcast(BooleanType loopbackBroadcast) {
		firePropertyChange("loopbackBroadcast", this.loopbackBroadcast,
				this.loopbackBroadcast = loopbackBroadcast);
	}

	public BooleanType getX25() {
		return x25;
	}

	public void setX25(BooleanType x25) {
		firePropertyChange("x25", this.x25, this.x25 = x25);
	}

	public BooleanType getArp() {
		return arp;
	}

	public void setArp(BooleanType arp) {
		firePropertyChange("arp", this.arp, this.arp = arp);
	}

}
