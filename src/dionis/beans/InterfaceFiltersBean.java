package dionis.beans;

public class InterfaceFiltersBean extends ModelObject {

	private static final long serialVersionUID = 0;
	
	protected String input;
	protected String output;

	public InterfaceFiltersBean() {
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		firePropertyChange("input", this.input, this.input = input);
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		firePropertyChange("output", this.output, this.output = output);
	}

}
