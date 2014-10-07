package dionis.beans;

import dionis.xml.BooleanType;

public class TOSBean extends ModelObject {

	protected BooleanType copy;
	protected short value;

	public TOSBean() {
	}

	public void setCopy(BooleanType value) {
		firePropertyChange("copy", this.copy, this.copy = value);
	}

	public void setValue(short value) {
		firePropertyChange("value", this.value, this.value = value);
	}

	public BooleanType getCopy() {
		return copy;
	}

	public short getValue() {
		return value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TOSBean [");
		if (copy != null) {
			builder.append("copy=");
			builder.append(copy);
			builder.append(", ");
		}
		builder.append("value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}
