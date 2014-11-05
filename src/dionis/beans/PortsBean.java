package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class PortsBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected List<SIOBean> sio;
	protected List<SYNBean> syn;

	public PortsBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public List<SIOBean> getSio() {
		return sio;
	}

	public void setSio(List<SIOBean> sio) {
		firePropertyChange("sio", this.sio, this.sio = sio);
	}

	public List<SYNBean> getSyn() {
		return syn;
	}

	public void setSyn(List<SYNBean> syn) {
		firePropertyChange("syn", this.syn, this.syn = syn);
	}

}
