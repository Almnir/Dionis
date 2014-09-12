package dionis.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InterfaceFiltersBean {

	protected String input;
	protected String output;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public InterfaceFiltersBean() {
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		propertyChangeSupport.firePropertyChange("input", this.input,
				this.input = input);
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		propertyChangeSupport.firePropertyChange("output", this.output,
				this.output = output);
	}

}
