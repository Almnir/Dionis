package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class RemoteControlKeysBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private List<Integer> key;

	public RemoteControlKeysBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public List<Integer> getKey() {
		return key;
	}

	public void setKey(List<Integer> key) {
		firePropertyChange("key", this.key, this.key = key);
	}

}
