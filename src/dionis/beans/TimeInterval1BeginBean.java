package dionis.beans;

public class TimeInterval1BeginBean extends ModelObject {

	protected short hour;
	protected short minute;

	public short getHour() {
		return hour;
	}

	public void setHour(short hour) {
		firePropertyChange("hour", this.hour, this.hour = hour);
	}

	public short getMinute() {
		return minute;
	}

	public void setMinute(short minute) {
		firePropertyChange("minute", this.minute, this.minute = minute);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[Начало: ");
		builder.append(hour);
		builder.append(": ");
		builder.append(minute);
		builder.append("]");
		return builder.toString();
	}

}
