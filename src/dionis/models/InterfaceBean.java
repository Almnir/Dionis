package dionis.models;

import dionis.xml.DisableDatagrams;
import dionis.xml.InterfaceFilters;
import dionis.xml.InterfaceIP;
import dionis.xml.InterfaceModeType;
import dionis.xml.InterfaceNatType;
import dionis.xml.InterfaceParametrs;
import dionis.xml.InterfaceRoutes;
import dionis.xml.InterfaceType;

public class InterfaceBean extends ModelObject {

    protected String name;
    protected InterfaceType type;
    protected InterfaceModeType mode;
    protected InterfaceIP ip;
    protected InterfaceNatType nat;
    protected InterfaceFilters filters;
    protected short mtu;
    protected String port;
    protected int timer;
    protected DisableDatagrams disableDatagrams;
    protected InterfaceParametrs parametrs;
    protected InterfaceRoutes routes;
    
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
	public InterfaceIP getIp() {
		return ip;
	}
	public void setIp(InterfaceIP ip) {
		firePropertyChange("ip", this.ip, this.ip = ip);
	}
	public InterfaceNatType getNat() {
		return nat;
	}
	public void setNat(InterfaceNatType nat) {
		firePropertyChange("nat", this.nat, this.nat = nat);
	}
	public InterfaceFilters getFilters() {
		return filters;
	}
	public void setFilters(InterfaceFilters filters) {
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
	public DisableDatagrams getDisableDatagrams() {
		return disableDatagrams;
	}
	public void setDisableDatagrams(DisableDatagrams disableDatagrams) {
		firePropertyChange("disableDatagrams", this.disableDatagrams, this.disableDatagrams = disableDatagrams);
	}
	public InterfaceParametrs getParametrs() {
		return parametrs;
	}
	public void setParametrs(InterfaceParametrs parametrs) {
		firePropertyChange("parametrs", this.parametrs, this.parametrs = parametrs);
	}
	public InterfaceRoutes getRoutes() {
		return routes;
	}
	public void setRoutes(InterfaceRoutes routes) {
		firePropertyChange("routes", this.routes, this.routes = routes);
	}
}
