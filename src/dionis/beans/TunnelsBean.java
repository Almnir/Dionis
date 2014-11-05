package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class TunnelsBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private List<TunnelBean> tunnel;

	public TunnelsBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public List<TunnelBean> getTunnel() {
		return tunnel;
	}

	public void setTunnel(List<TunnelBean> tunnel) {
		firePropertyChange("tunnel", this.tunnel, this.tunnel = tunnel);
	}

}
