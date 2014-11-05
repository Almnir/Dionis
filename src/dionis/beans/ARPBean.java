package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ARPBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected Boolean proxy;
	protected ARPTableBean table;

	public ARPBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public Boolean getProxy() {
		return proxy;
	}

	public void setProxy(Boolean proxy) {
		firePropertyChange("proxy", this.proxy, this.proxy = proxy);
	}

	public ARPTableBean getTable() {
		return table;
	}

	public void setTable(ARPTableBean table) {
		table.addPropertyChangeListener("_static", this);
		firePropertyChange("table", this.table, this.table = table);
	}

}
