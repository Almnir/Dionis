package dionis.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dionis.xml.NATTableStatic;

public class NATAddressModel {
	
	private List<NATTableStatic> natTable;
	
	private static NATAddressModel instance = null;

	public static NATAddressModel getInstance() {
		if (instance == null) {
			instance = new NATAddressModel();
		}
		return instance;
	}

	private NATAddressModel() {
		this.natTable = Collections.synchronizedList(new ArrayList<NATTableStatic>());
	}

	public synchronized Object[] getNatTableArray() {
		return natTable.toArray();
	}
	
	public synchronized List<NATTableStatic> getNatTable() {
		return natTable;
	}

	public synchronized void setNatTable(List<NATTableStatic> natTable) {
		this.natTable = natTable;
	}
	
	public synchronized void removeNatTable(NATTableStatic table) {
		this.natTable.remove(table);
	}
}
