package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class ElementsBean extends ModelObject implements
		PropertyChangeListener, Serializable {

	private static final long serialVersionUID = 0;

	private ElementBean element;

	public ElementsBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public ElementBean getElement() {
		return element;
	}

	public void setElement(ElementBean element) {
		element.addPropertyChangeListener("get", this);
		element.addPropertyChangeListener("send", this);
		firePropertyChange("element", this.element, this.element = element);
	}

}
