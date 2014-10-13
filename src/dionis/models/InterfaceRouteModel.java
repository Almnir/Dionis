package dionis.models;

import java.util.LinkedList;

import dionis.beans.InterfaceRouteBean;

public class InterfaceRouteModel extends AbstractModel<InterfaceRouteBean> {

	private static InterfaceRouteModel instance = null;

	public static synchronized InterfaceRouteModel getInstance() {
		if (instance == null) {
			instance = new InterfaceRouteModel();
		}
		return instance;
	}

	public Object getClone() {
		LinkedList<InterfaceRouteBean> linkedData = new LinkedList<InterfaceRouteBean>(
				getData());
		return linkedData.clone();
	}
}
