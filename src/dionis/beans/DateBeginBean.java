package dionis.beans;

public class DateBeginBean extends ModelObject {

	protected byte day;
	protected byte month;
	protected short year;

	public byte getDay() {
		return day;
	}

	public void setDay(byte day) {
		firePropertyChange("day", this.day, this.day = day);
	}

	public byte getMonth() {
		return month;
	}

	public void setMonth(byte month) {
		firePropertyChange("month", this.month, this.month = month);
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		firePropertyChange("year", this.year, this.year = year);
	}

}
