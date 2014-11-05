package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class AutoResetBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private List<AutoResetItemBean> item;

	public AutoResetBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public List<AutoResetItemBean> getItem() {
		return item;
	}

	public void setItem(List<AutoResetItemBean> item) {
		firePropertyChange("item", this.item, this.item = item);
	}

}
