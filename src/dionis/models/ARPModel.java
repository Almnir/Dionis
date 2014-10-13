package dionis.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ARPModel {
	private List<String[]> allARP;

	private static ARPModel instance = null;

	public static synchronized ARPModel getInstance() {
		if (instance == null) {
			instance = new ARPModel();
		}
		return instance;
	}

	private ARPModel() {
		this.allARP = Collections.synchronizedList(new ArrayList<String[]>());
	}

	public synchronized Object[] getAllARPArray() {
		return allARP.toArray();
	}

	public synchronized List<String[]> getAllARP() {
		return allARP;
	}

	public synchronized void setAllARP(List<String[]> allARP) {
		this.allARP = allARP;
	}

	public synchronized void removeARP(String[] obj) {
		this.allARP.remove(obj);
	}
}
