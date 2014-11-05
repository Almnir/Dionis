package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class TracingRouteBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected BooleanType errors;
	protected BooleanType all;
	protected BooleanType detail;
	protected BooleanType hexDump;

	public TracingRouteBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public BooleanType getErrors() {
		return errors;
	}

	public void setErrors(BooleanType errors) {
		firePropertyChange("errors", this.errors, this.errors = errors);
	}

	public BooleanType getAll() {
		return all;
	}

	public void setAll(BooleanType all) {
		firePropertyChange("all", this.all, this.all = all);
	}

	public BooleanType getDetail() {
		return detail;
	}

	public void setDetail(BooleanType detail) {
		firePropertyChange("detail", this.detail, this.detail = detail);
	}

	public BooleanType getHexDump() {
		return hexDump;
	}

	public void setHexDump(BooleanType hexDump) {
		firePropertyChange("hexDump", this.hexDump, this.hexDump = hexDump);
	}

}
