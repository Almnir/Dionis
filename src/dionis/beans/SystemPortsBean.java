package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SystemPortsBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String sio;
	protected String x25;
	protected String lan;
	protected String syn;
	protected String ipl;
	protected String tcp;

	public SystemPortsBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public String getSio() {
		return sio;
	}

	public void setSio(String sio) {
		firePropertyChange("sio", this.sio, this.sio = sio);
	}

	public String getX25() {
		return x25;
	}

	public void setX25(String x25) {
		firePropertyChange("x25", this.x25, this.x25 = x25);
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		firePropertyChange("lan", this.lan, this.lan = lan);
	}

	public String getSyn() {
		return syn;
	}

	public void setSyn(String syn) {
		firePropertyChange("syn", this.syn, this.syn = syn);
	}

	public String getIpl() {
		return ipl;
	}

	public void setIpl(String ipl) {
		firePropertyChange("ipl", this.ipl, this.ipl = ipl);
	}

	public String getTcp() {
		return tcp;
	}

	public void setTcp(String tcp) {
		firePropertyChange("tcp", this.tcp, this.tcp = tcp);
	}

}
