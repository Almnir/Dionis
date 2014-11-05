package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NATTableStaticBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected Boolean pat;
	protected LocalBean local;
	protected GlobalBean global;
	protected byte bits;

	public NATTableStaticBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public Boolean getPat() {
		return pat;
	}

	public void setPat(Boolean pat) {
		firePropertyChange("pat", this.pat, this.pat = pat);
	}

	public LocalBean getLocal() {
		return local;
	}

	public void setLocal(LocalBean local) {
		firePropertyChange("local", this.local, this.local = local);
	}

	public GlobalBean getGlobal() {
		return global;
	}

	public void setGlobal(GlobalBean global) {
		global.addPropertyChangeListener("ip", this);
		global.addPropertyChangeListener("port", this);
		firePropertyChange("global", this.global, this.global = global);
	}

	public byte getBits() {
		return bits;
	}

	public void setBits(byte bits) {
		firePropertyChange("bits", this.bits, this.bits = bits);
	}

}
