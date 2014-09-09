package dionis.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dionis.xml.Interface;

public class InterfaceModel {

	private List<Interface> data;

	private static InterfaceModel instance = null;

	public static InterfaceModel getInstance() {
		if (instance == null) {
			instance = new InterfaceModel();
		}
		return instance;
	}

	private InterfaceModel() {
		this.data = Collections.synchronizedList(new ArrayList<Interface>());
	}

	public synchronized Object[] getDataArray() {
		return data.toArray();
	}

	public synchronized List<Interface> getData() {
		return data;
	}

	public synchronized void setData(List<Interface> data) {
		this.data = data;
	}

	public synchronized void removeData(Interface data) {
		this.data.remove(data);
	}
}
