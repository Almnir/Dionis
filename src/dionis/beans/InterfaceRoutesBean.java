package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class InterfaceRoutesBean extends ModelObject implements
		PropertyChangeListener {

	protected List<InterfaceRouteBean> route;

	public InterfaceRoutesBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
	}

	public List<InterfaceRouteBean> getRoute() {
		return route;
	}

	public void setRoute(List<InterfaceRouteBean> route) {
		firePropertyChange("route", this.route, this.route = route);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (InterfaceRouteBean rt : route) {
			builder.append(rt.toString()).append(" ");
		}
		return builder.toString();
	}

}
