package dionis.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dionis.beans.InterfaceBean;

public class InterfaceModel {

	private List<InterfaceBean> data;

	private static InterfaceModel instance = null;

	public static InterfaceModel getInstance() {
		if (instance == null) {
			instance = new InterfaceModel();
		}
		return instance;
	}

	private InterfaceModel() {
		this.data = Collections
				.synchronizedList(new ArrayList<InterfaceBean>());
	}

	public synchronized Object[] getDataArray() {
		return data.toArray();
	}

	public synchronized List<InterfaceBean> getData() {
		return data;
	}

	public synchronized void setData(List<InterfaceBean> data) {
		this.data = data;
	}

	public synchronized void addData(InterfaceBean bean) {
		this.data.add(bean);
	}

	public synchronized void removeData(InterfaceBean data) {
		this.data.remove(data);
	}
}
