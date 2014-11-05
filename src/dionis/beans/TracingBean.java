package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TracingBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected TracingInterfacesBean interfaces;
	protected TracingRouteBean route;
	protected TracingServersBean servers;

	public TracingBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public TracingInterfacesBean getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(TracingInterfacesBean interfaces) {
		interfaces.addPropertyChangeListener("type", this);
		interfaces.addPropertyChangeListener("level", this);
		firePropertyChange("interfaces", this.interfaces,
				this.interfaces = interfaces);
	}

	public TracingRouteBean getRoute() {
		return route;
	}

	public void setRoute(TracingRouteBean route) {
		route.addPropertyChangeListener("errors", this);
		route.addPropertyChangeListener("all", this);
		route.addPropertyChangeListener("detail", this);
		route.addPropertyChangeListener("hexDump", this);
		firePropertyChange("route", this.route, this.route = route);
	}

	public TracingServersBean getServers() {
		return servers;
	}

	public void setServers(TracingServersBean servers) {
		servers.addPropertyChangeListener("telnet", this);
		servers.addPropertyChangeListener("telnetD", this);
		servers.addPropertyChangeListener("dns", this);
		servers.addPropertyChangeListener("dnsd", this);
		servers.addPropertyChangeListener("dhcpd", this);
		servers.addPropertyChangeListener("rip", this);
		servers.addPropertyChangeListener("httpgw", this);
		servers.addPropertyChangeListener("igmp", this);
		servers.addPropertyChangeListener("snmp", this);
		servers.addPropertyChangeListener("isakmp", this);
		servers.addPropertyChangeListener("sntp", this);
		servers.addPropertyChangeListener("dcp", this);
		servers.addPropertyChangeListener("cluster", this);
		firePropertyChange("servers", this.servers, this.servers = servers);
	}

}
