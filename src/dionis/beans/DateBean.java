package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DateBean extends ModelObject implements PropertyChangeListener {
	protected DateBeginBean begin;
	protected DateEndBean end;

	public DateBeginBean getBegin() {
		return begin;
	}

	public void setBegin(DateBeginBean begin) {
		begin.addPropertyChangeListener("begin", this);
		firePropertyChange("begin", this.begin, this.begin = begin);
	}

	public DateEndBean getEnd() {
		return end;
	}

	public void setEnd(DateEndBean end) {
		end.addPropertyChangeListener("end", this);
		firePropertyChange("end", this.end, this.end = end);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

}
