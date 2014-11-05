package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.ConsoleScreenBlankingAwakeType;

public class ScreenBlankingBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected short inactive;
	protected String text;
	protected ConsoleScreenBlankingAwakeType awake;

	public ScreenBlankingBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public short getInactive() {
		return inactive;
	}

	public void setInactive(short inactive) {
		firePropertyChange("inactive", this.inactive, this.inactive = inactive);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		firePropertyChange("text", this.text, this.text = text);
	}

	public ConsoleScreenBlankingAwakeType getAwake() {
		return awake;
	}

	public void setAwake(ConsoleScreenBlankingAwakeType awake) {
		firePropertyChange("awake", this.awake, this.awake = awake);
	}

}
