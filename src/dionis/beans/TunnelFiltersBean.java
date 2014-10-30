package dionis.beans;

import java.util.List;

public class TunnelFiltersBean extends ModelObject {

	private static final long serialVersionUID = 0;
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
