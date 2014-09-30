package dionis.models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dionis.beans.InterfaceRouteBean;

public class InterfaceRouteModel {

	private List<InterfaceRouteBean> data;

	private static InterfaceRouteModel instance = null;

	public static InterfaceRouteModel getInstance() {
		if (instance == null) {
			instance = new InterfaceRouteModel();
		}
		return instance;
	}

	private InterfaceRouteModel() {
		this.data = Collections
				.synchronizedList(new LinkedList<InterfaceRouteBean>());
	}

	public synchronized Object[] getDataArray() {
		return data.toArray();
	}

	public synchronized List<InterfaceRouteBean> getData() {
		return data;
	}

	public synchronized void setData(List<InterfaceRouteBean> data) {
		this.data = data;
	}

	public synchronized void addData(InterfaceRouteBean bean) {
		this.data.add(bean);
	}

	public synchronized void removeData(InterfaceRouteBean data) {
		this.data.remove(data);
	}
	
	public synchronized void removeAll() {
		this.data.clear();
	}
}
