package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import dionis.xml.BooleanType;

public class LogsScheduleBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected BooleanType use;
	protected List<ScheduleItemBean> item;

	public LogsScheduleBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public BooleanType getUse() {
		return use;
	}

	public void setUse(BooleanType use) {
		firePropertyChange("use", this.use, this.use = use);
	}

	public List<ScheduleItemBean> getItem() {
		return item;
	}

	public void setItem(List<ScheduleItemBean> item) {
		firePropertyChange("item", this.item, this.item = item);
	}

}
