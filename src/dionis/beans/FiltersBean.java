package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class FiltersBean extends ModelObject implements
PropertyChangeListener, Serializable {
	
	private static final long serialVersionUID = 0;
	
	private FilterBean filter;

	public FilterBean getFilter() {
		return filter;
	}

	public void setFilter(FilterBean filter) {
		filter.addPropertyChangeListener("filter", this);
		firePropertyChange("filter", this.filter, this.filter = filter);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

}
