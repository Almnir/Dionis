package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TimeInterval2Bean extends ModelObject implements
		PropertyChangeListener {
    protected TimeInterval2BeginBean begin;
    protected TimeInterval2EndBean end;
    
	public TimeInterval2BeginBean getBegin() {
		return begin;
	}
	public void setBegin(TimeInterval2BeginBean begin) {
		begin.addPropertyChangeListener("begin", this);
		firePropertyChange("begin", this.begin, this.begin = begin);
	}
	public TimeInterval2EndBean getEnd() {
		return end;
	}
	public void setEnd(TimeInterval2EndBean end) {
		end.addPropertyChangeListener("end", this);
		firePropertyChange("end", this.end, this.end = end);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}
}
