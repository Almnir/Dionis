package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class TimeInterval1Bean extends ModelObject implements
		PropertyChangeListener, Serializable {

	private static final long serialVersionUID = 0;

	protected TimeInterval1BeginBean begin;
	protected TimeInterval1EndBean end;

	public TimeInterval1BeginBean getBegin() {
		return begin;
	}

	public void setBegin(TimeInterval1BeginBean begin) {
		begin.addPropertyChangeListener("begin", this);
		firePropertyChange("begin", this.begin, this.begin = begin);
	}

	public TimeInterval1EndBean getEnd() {
		return end;
	}

	public void setEnd(TimeInterval1EndBean end) {
		end.addPropertyChangeListener("end", this);
		firePropertyChange("end", this.end, this.end = end);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

}
