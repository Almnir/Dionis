package dionis.beans;

import dionis.xml.FilterPortsType;

public class FilterPortsBean extends ModelObject {

	protected int low;
	protected int high;
	protected FilterPortsType type;

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		firePropertyChange("low", this.low, this.low = low);
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		firePropertyChange("high", this.high, this.high = high);
	}

	public FilterPortsType getType() {
		return type;
	}

	public void setType(FilterPortsType type) {
		firePropertyChange("type", this.type, this.type = type);
	}
}
