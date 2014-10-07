package dionis.beans;

import java.util.List;

public class TunnelFiltersBean extends ModelObject {
	protected List<TunnelFilterBean> filter;

	public TunnelFiltersBean() {
	}

	public List<TunnelFilterBean> getFilter() {
		return filter;
	}

	public void setFilter(List<TunnelFilterBean> filter) {
		firePropertyChange("filter", this.filter, this.filter = filter);
	}
}
