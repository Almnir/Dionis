package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.PasswordGuessType;

public class PasswordBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected PasswordGuessType send;
	protected PasswordGuessType freez;

	public PasswordBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public PasswordGuessType getSend() {
		return send;
	}

	public void setSend(PasswordGuessType send) {
		firePropertyChange("send", this.send, this.send = send);
	}

	public PasswordGuessType getFreez() {
		return freez;
	}

	public void setFreez(PasswordGuessType freez) {
		firePropertyChange("freez", this.freez, this.freez = freez);
	}

}
