package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class HostsBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private List<HostBean> host;

	public HostsBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public List<HostBean> getHost() {
		return host;
	}

	public void setHost(List<HostBean> host) {
		firePropertyChange("host", this.host, this.host = host);
	}

}
