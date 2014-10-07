package dionis.beans;

public class TunnelFilterPortsBean extends ModelObject {

	protected int low;
	protected int high;

	public TunnelFilterPortsBean() {
	}

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
}
