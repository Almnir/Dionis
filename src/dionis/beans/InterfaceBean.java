package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.InterfaceModeType;
import dionis.xml.InterfaceNatType;
import dionis.xml.InterfaceType;

public class InterfaceBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;
	
	protected String name;
	protected InterfaceType type;
	protected InterfaceModeType mode;
	protected InterfaceIPBean ip;
	protected InterfaceNatType nat;
	protected InterfaceFiltersBean filters;
	protected short mtu;
	protected String port;
	protected int timer;
	protected DisableDatagramsBean disableDatagrams;
	protected InterfaceParametrsBean parametrs;
	protected InterfaceRoutesBean routes;

	public InterfaceBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

	public InterfaceType getType() {
		return type;
	}

	public void setType(InterfaceType type) {
		firePropertyChange("type", this.type, this.type = type);
	}

	public InterfaceModeType getMode() {
		return mode;
	}

	public void setMode(InterfaceModeType mode) {
		firePropertyChange("mode", this.mode, this.mode = mode);
	}

	public InterfaceIPBean getIp() {
		return ip;
	}

	public void setIp(InterfaceIPBean ip) {
		ip.addPropertyChangeListener("local", this);
		ip.addPropertyChangeListener("remote", this);
		firePropertyChange("ip", this.ip, this.ip = ip);
	}

	public InterfaceNatType getNat() {
		return nat;
	}

	public void setNat(InterfaceNatType nat) {
		firePropertyChange("nat", this.nat, this.nat = nat);
	}

	public InterfaceFiltersBean getFilters() {
		return filters;
	}

	public void setFilters(InterfaceFiltersBean filters) {
		filters.addPropertyChangeListener("input", this);
		filters.addPropertyChangeListener("output", this);
		firePropertyChange("filters", this.filters, this.filters = filters);
	}

	public short getMtu() {
		return mtu;
	}

	public void setMtu(short mtu) {
		firePropertyChange("mtu", this.mtu, this.mtu = mtu);
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		firePropertyChange("port", this.port, this.port = port);
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		firePropertyChange("timer", this.timer, this.timer = timer);
	}

	public DisableDatagramsBean getDisableDatagrams() {
		return disableDatagrams;
	}

	public void setDisableDatagrams(DisableDatagramsBean disableDatagrams) {
		disableDatagrams.addPropertyChangeListener("notTunneled", this);
		disableDatagrams.addPropertyChangeListener("dhcp", this);
		disableDatagrams.addPropertyChangeListener("multicast", this);
		disableDatagrams.addPropertyChangeListener("forward", this);
		disableDatagrams.addPropertyChangeListener("rip", this);
		disableDatagrams.addPropertyChangeListener("cluster", this);
		disableDatagrams.addPropertyChangeListener("ipStat", this);
		disableDatagrams.addPropertyChangeListener("proxyARP", this);
		firePropertyChange("disableDatagrams", this.disableDatagrams,
				this.disableDatagrams = disableDatagrams);
	}

	public InterfaceParametrsBean getParametrs() {
		return parametrs;
	}

	public void setParametrs(InterfaceParametrsBean parametrs) {
		parametrs.addPropertyChangeListener("seq", this);
		parametrs.addPropertyChangeListener("chksum", this);
		parametrs.addPropertyChangeListener("tos", this);
		parametrs.addPropertyChangeListener("df", this);
		parametrs.addPropertyChangeListener("board", this);
		parametrs.addPropertyChangeListener("frame", this);
		parametrs.addPropertyChangeListener("buf", this);
		parametrs.addPropertyChangeListener("delay", this);
		parametrs.addPropertyChangeListener("interval", this);
		parametrs.addPropertyChangeListener("wait", this);
		parametrs.addPropertyChangeListener("type", this);
		parametrs.addPropertyChangeListener("ports", this);
		parametrs.addPropertyChangeListener("script", this);
		parametrs.addPropertyChangeListener("send", this);
		parametrs.addPropertyChangeListener("recv", this);
		parametrs.addPropertyChangeListener("media", this);
		parametrs.addPropertyChangeListener("mode", this);
		parametrs.addPropertyChangeListener("authLocal", this);
		parametrs.addPropertyChangeListener("authRemote", this);
		parametrs.addPropertyChangeListener("vnid", this);
		parametrs.addPropertyChangeListener("baseInterface", this);
		parametrs.addPropertyChangeListener("bandwidth", this);
		parametrs.addPropertyChangeListener("bandrecv", this);
		parametrs.addPropertyChangeListener("mac", this);
		parametrs.addPropertyChangeListener("vlaNs", this);
		firePropertyChange("parametrs", this.parametrs,
				this.parametrs = parametrs);
	}

	public InterfaceRoutesBean getRoutes() {
		return routes;
	}

	public void setRoutes(InterfaceRoutesBean routes) {
		routes.addPropertyChangeListener("route", this);
		firePropertyChange("routes", this.routes, this.routes = routes);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// firePropertyChange("ip", null, ip);
	}
}
