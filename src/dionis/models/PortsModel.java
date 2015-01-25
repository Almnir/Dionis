package dionis.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dionis.beans.SIOBean;
import dionis.beans.SYNBean;

/**
 * Модель, описывающая совокупность портов для табличного отображения
 * 
 * @author Ярных А.О.
 * 
 */
public class PortsModel {

	private List<Object> allPorts;
	private List<SIOBean> sios;
	private List<SYNBean> syns;

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

	public synchronized void setAllPorts(List<SIOBean> sioList,
			List<SYNBean> synList) {
		this.sios = sioList;
		this.syns = synList;
		this.allPorts.addAll(sioList);
		this.allPorts.addAll(synList);
	}

	public synchronized Object[] getAllPorts() {
		return allPorts.toArray();
	}

	public synchronized List<SIOBean> getSios() {
		return sios;
	}

	public synchronized void setSios(List<SIOBean> sios) {
		this.sios = sios;
		this.allPorts.clear();
		this.allPorts.addAll(sios);
		this.allPorts.addAll(this.syns);
	}

	public synchronized List<SYNBean> getSyns() {
		return syns;
	}

	public synchronized void setSyns(List<SYNBean> syns) {
		this.syns = syns;
		this.allPorts.clear();
		this.allPorts.addAll(this.sios);
		this.allPorts.addAll(syns);
	}
}
