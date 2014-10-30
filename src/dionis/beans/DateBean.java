package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class DateBean extends ModelObject implements PropertyChangeListener,
		Serializable {
	private static final long serialVersionUID = 0;

	private boolean dateBlock;
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

	public boolean isDateBlock() {
		return dateBlock;
	}

	public void setDateBlock(boolean dateBlock) {
		firePropertyChange("dateBlock", this.dateBlock,
				this.dateBlock = dateBlock);
	}

}
