package dionis.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressModel {
	private List<String[]> allAddress;
	
	/** Так называемый "draconian pattern" для синглтона в многопоточном приложении **/
	private static AddressModel instance = null;

	public static synchronized AddressModel getInstance() {
		if (instance == null) {
			instance = new AddressModel();
		}
		return instance;
	}

	private AddressModel() {
		this.allAddress = Collections
				.synchronizedList(new ArrayList<String[]>());
	}

	public synchronized Object[] getAllAddressArray() {
		return allAddress.toArray();
	}

	public synchronized List<String[]> getAllAddress() {
		return allAddress;
	}

	public synchronized void setAllAddress(List<String[]> allAddress) {
		this.allAddress = allAddress;
	}

	public synchronized void removeAddress(String[] obj) {
		this.allAddress.remove(obj);
	}

}
