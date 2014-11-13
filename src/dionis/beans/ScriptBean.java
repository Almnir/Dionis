package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class ScriptBean extends ModelObject implements PropertyChangeListener,
		Serializable {

	private static final long serialVersionUID = 0;

	protected short retries;
	protected InterfaceScriptTimeBean time;
	protected String address;
	protected ElementsBean elements;

	public ScriptBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public short getRetries() {
		return retries;
	}

	public void setRetries(short retries) {
		firePropertyChange("retries", this.retries, this.retries = retries);
	}

	public InterfaceScriptTimeBean getTime() {
		return time;
	}

	public void setTime(InterfaceScriptTimeBean time) {
		time.addPropertyChangeListener("connection", this);
		time.addPropertyChangeListener("script", this);
		firePropertyChange("time", this.time, this.time = time);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ElementsBean getElements() {
		return elements;
	}

	public void setElements(ElementsBean elements) {
		elements.addPropertyChangeListener("element", this);
		firePropertyChange("elements", this.elements, this.elements = elements);
	}

}
