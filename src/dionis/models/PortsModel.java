package dionis.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dionis.xml.SIO;
import dionis.xml.SYN;

/**
 * Модель, описывающая совокупность портов для табличного отображения
 * 
 * @author Ярных А.О.
 * 
 */
public class PortsModel {

	private List<Object> allPorts;
	private List<SIO> sios;
	private List<SYN> syns;

	private static PortsModel instance = null;

	public static synchronized PortsModel getInstance() {
		if (instance == null) {
			instance = new PortsModel();
		}
		return instance;
	}

	private PortsModel() {
		this.allPorts = Collections.synchronizedList(new ArrayList<Object>());
	}

	public synchronized void setAllPorts(List<SIO> sioList, List<SYN> synList) {
		this.sios = sioList;
		this.syns = synList;
		this.allPorts.addAll(sioList);
		this.allPorts.addAll(synList);
	}

	public synchronized Object[] getAllPorts() {
		return allPorts.toArray();
	}

	public synchronized List<SIO> getSios() {
		return sios;
	}

	public synchronized void setSios(List<SIO> sios) {
		this.sios = sios;
		this.allPorts.clear();
		this.allPorts.addAll(sios);
		this.allPorts.addAll(this.syns);
	}

	public synchronized List<SYN> getSyns() {
		return syns;
	}

	public synchronized void setSyns(List<SYN> syns) {
		this.syns = syns;
		this.allPorts.clear();
		this.allPorts.addAll(this.sios);
		this.allPorts.addAll(syns);
	}
}
