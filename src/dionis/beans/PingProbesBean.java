package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class PingProbesBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private List<ProbeBean> probe;

	public PingProbesBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public List<ProbeBean> getProbe() {
		return probe;
	}

	public void setProbe(List<ProbeBean> probe) {
		firePropertyChange("probe", this.probe, this.probe = probe);
	}

}
