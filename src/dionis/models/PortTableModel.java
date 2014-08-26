package dionis.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PortTableModel {
	private static PortTableModel instance = null;

	List<String> portList;

	private PortTableModel() {
		this.portList = Collections.synchronizedList(new ArrayList<String>());
	}

	public static PortTableModel getInstance() {
		instance = new PortTableModel();
		return instance;
	}

	public static PortTableModel getNewInstance() {
		if (instance == null) {
			instance = new PortTableModel();
		}
		return instance;
	}
	
	
}
