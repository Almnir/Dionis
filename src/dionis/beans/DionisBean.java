package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DionisBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String name;
	protected String type;
	protected ParametrsBean parametrs;
	protected InterfaceBean interfaces;
	protected FiltersBean filters;
	protected TunnelsBean tunnels;

	public DionisBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		firePropertyChange("type", this.type, this.type = type);
	}

	public ParametrsBean getParametrs() {
		return parametrs;
	}

	public void setParametrs(ParametrsBean parametrs) {
		parametrs.addPropertyChangeListener("ports", this);
		parametrs.addPropertyChangeListener("baseConsts", this);
		parametrs.addPropertyChangeListener("nat", this);
		parametrs.addPropertyChangeListener("arp", this);
		parametrs.addPropertyChangeListener("tracing", this);
		parametrs.addPropertyChangeListener("hosts", this);
		parametrs.addPropertyChangeListener("systemInfo", this);
		parametrs.addPropertyChangeListener("cryptography", this);
		parametrs.addPropertyChangeListener("console", this);
		parametrs.addPropertyChangeListener("remoteControl", this);
		parametrs.addPropertyChangeListener("logs", this);
		parametrs.addPropertyChangeListener("password", this);
		parametrs.addPropertyChangeListener("timeService", this);
		parametrs.addPropertyChangeListener("pingProbes", this);
		firePropertyChange("parametrs", this.parametrs,
				this.parametrs = parametrs);
	}

	public InterfaceBean getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(InterfaceBean interfaces) {
		interfaces.addPropertyChangeListener("name", this);
		interfaces.addPropertyChangeListener("type", this);
		interfaces.addPropertyChangeListener("mode", this);
		interfaces.addPropertyChangeListener("ip", this);
		interfaces.addPropertyChangeListener("nat", this);
		interfaces.addPropertyChangeListener("filters", this);
		interfaces.addPropertyChangeListener("mtu", this);
		interfaces.addPropertyChangeListener("port", this);
		interfaces.addPropertyChangeListener("timer", this);
		interfaces.addPropertyChangeListener("disableDatagrams", this);
		interfaces.addPropertyChangeListener("parametrs", this);
		interfaces.addPropertyChangeListener("routes", this);
		firePropertyChange("interfaces", this.interfaces,
				this.interfaces = interfaces);
	}

	public FiltersBean getFilters() {
		return filters;
	}

	public void setFilters(FiltersBean filters) {
		filters.addPropertyChangeListener("filter", this);
		firePropertyChange("filters", this.filters, this.filters = filters);
	}

	public TunnelsBean getTunnels() {
		return tunnels;
	}

	public void setTunnels(TunnelsBean tunnels) {
		tunnels.addPropertyChangeListener("tunnel", this);
		firePropertyChange("tunnels", this.tunnels, this.tunnels = tunnels);
	}

}
