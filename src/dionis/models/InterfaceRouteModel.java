package dionis.models;

import java.util.LinkedList;

import dionis.beans.InterfaceRouteBean;

/**
 * Не-синглтон модель маршрутов интерфейсов
 * 
 * @author Ярных А.О.
 *
 */
public class InterfaceRouteModel extends AbstractModel<InterfaceRouteBean> {

	public Object getClone() {
		LinkedList<InterfaceRouteBean> linkedData = new LinkedList<InterfaceRouteBean>(
				getData());
		return linkedData.clone();
	}
}
