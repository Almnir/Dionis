package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.ConsoleEditorType;
import dionis.xml.ConsoleKeyboardType;
import dionis.xml.ConsoleMonitoringType;
import dionis.xml.ConsolePortsLedType;
import dionis.xml.ConsoleTimeLedType;

public class ConsoleBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected ConsoleKeyboardType keyboard;
	protected ConsoleEditorType editor;
	protected ConsoleMonitoringType monitoring;
	protected ConsolePortsLedType portsLed;
	protected ConsoleTimeLedType timeLed;
	protected ScreenBlankingBean screenBlanking;
	protected AutoResetBean autoReset;

	public ConsoleBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public ConsoleKeyboardType getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(ConsoleKeyboardType keyboard) {
		firePropertyChange("keyboard", this.keyboard, this.keyboard = keyboard);
	}

	public ConsoleEditorType getEditor() {
		return editor;
	}

	public void setEditor(ConsoleEditorType editor) {
		firePropertyChange("editor", this.editor, this.editor = editor);
	}

	public ConsoleMonitoringType getMonitoring() {
		return monitoring;
	}

	public void setMonitoring(ConsoleMonitoringType monitoring) {
		firePropertyChange("monitoring", this.monitoring,
				this.monitoring = monitoring);
	}

	public ConsolePortsLedType getPortsLed() {
		return portsLed;
	}

	public void setPortsLed(ConsolePortsLedType portsLed) {
		firePropertyChange("portsLed", this.portsLed, this.portsLed = portsLed);
	}

	public ConsoleTimeLedType getTimeLed() {
		return timeLed;
	}

	public void setTimeLed(ConsoleTimeLedType timeLed) {
		firePropertyChange("timeLed", this.timeLed, this.timeLed = timeLed);
	}

	public ScreenBlankingBean getScreenBlanking() {
		return screenBlanking;
	}

	public void setScreenBlanking(ScreenBlankingBean screenBlanking) {
		screenBlanking.addPropertyChangeListener("inactive", this);
		screenBlanking.addPropertyChangeListener("text", this);
		screenBlanking.addPropertyChangeListener("awake", this);
		firePropertyChange("screenBlanking", this.screenBlanking,
				this.screenBlanking = screenBlanking);
	}

	public AutoResetBean getAutoReset() {
		return autoReset;
	}

	public void setAutoReset(AutoResetBean autoReset) {
		autoReset.addPropertyChangeListener("item", this);
		firePropertyChange("autoReset", this.autoReset,
				this.autoReset = autoReset);
	}

}
