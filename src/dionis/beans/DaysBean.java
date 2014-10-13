package dionis.beans;

import dionis.xml.BooleanType;

public class DaysBean extends ModelObject {
	protected BooleanType mon;
	protected BooleanType tue;
	protected BooleanType wed;
	protected BooleanType thu;
	protected BooleanType fri;
	protected BooleanType sat;
	protected BooleanType sun;

	public BooleanType getMon() {
		return mon;
	}

	public void setMon(BooleanType mon) {
		firePropertyChange("mon", this.mon, this.mon = mon);
	}

	public BooleanType getTue() {
		return tue;
	}

	public void setTue(BooleanType tue) {
		firePropertyChange("tue", this.tue, this.tue = tue);
	}

	public BooleanType getWed() {
		return wed;
	}

	public void setWed(BooleanType wed) {
		firePropertyChange("wed", this.wed, this.wed = wed);
	}

	public BooleanType getThu() {
		return thu;
	}

	public void setThu(BooleanType thu) {
		firePropertyChange("thu", this.thu, this.thu = thu);
	}

	public BooleanType getFri() {
		return fri;
	}

	public void setFri(BooleanType fri) {
		firePropertyChange("fri", this.fri, this.fri = fri);
	}

	public BooleanType getSat() {
		return sat;
	}

	public void setSat(BooleanType sat) {
		firePropertyChange("sat", this.sat, this.sat = sat);
	}

	public BooleanType getSun() {
		return sun;
	}

	public void setSun(BooleanType sun) {
		firePropertyChange("sun", this.sun, this.sun = sun);
	}
}
