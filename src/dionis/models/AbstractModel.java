package dionis.models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractModel<T> {

	private List<T> data;

	public AbstractModel() {
		this.setData(Collections.synchronizedList(new LinkedList<T>()));
	}

	public synchronized Object[] getDataArray() {
		return data.toArray();
	}

	public synchronized List<T> getData() {
		return data;
	}

	public synchronized void setData(List<T> data) {
		this.data = data;
	}

	public synchronized void addData(T element) {
		this.data.add(element);
	}

	public synchronized void removeData(T element) {
		this.data.remove(element);
	}
}
