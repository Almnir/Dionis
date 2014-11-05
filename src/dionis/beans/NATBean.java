package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NATBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String overload;
	protected int limit;
	protected byte size;
	protected NATTableBean table;

	public NATBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public String getOverload() {
		return overload;
	}

	public void setOverload(String overload) {
		firePropertyChange("overload", this.overload, this.overload = overload);
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		firePropertyChange("limit", this.limit, this.limit = limit);
	}

	public byte getSize() {
		return size;
	}

	public void setSize(byte size) {
		firePropertyChange("size", this.size, this.size = size);
	}

	public NATTableBean getTable() {
		return table;
	}

	public void setTable(NATTableBean table) {
		table.addPropertyChangeListener("_static", this);
		firePropertyChange("table", this.table, this.table = table);
	}

}
