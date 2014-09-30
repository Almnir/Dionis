package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class InterfaceRoutesBean implements PropertyChangeListener {

	protected List<InterfaceRouteBean> route;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public InterfaceRoutesBean() {
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
	}

	public List<InterfaceRouteBean> getRoute() {
		return route;
	}

	public void setRoute(List<InterfaceRouteBean> route) {
		propertyChangeSupport.firePropertyChange("route", this.route,
				this.route = route);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (InterfaceRouteBean rt: route) {
			builder.append(rt.toString()).append(" ");
		}
		return builder.toString();
	}

}
