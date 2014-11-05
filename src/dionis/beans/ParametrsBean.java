package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ParametrsBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected PortsBean ports;
	protected BaseConstsBean baseConsts;
	protected NATBean nat;
	protected ARPBean arp;
	protected TracingBean tracing;
	protected HostsBean hosts;
	protected SystemInfoBean systemInfo;
	protected CryptographyBean cryptography;
	protected ConsoleBean console;
	protected RemoteControlBean remoteControl;
	protected LogsBean logs;
	protected PasswordBean password;
	protected TimeServiceBean timeService;
	protected PingProbesBean pingProbes;

	public ParametrsBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public PortsBean getPorts() {
		return ports;
	}

	public void setPorts(PortsBean ports) {
		ports.addPropertyChangeListener("sio", this);
		ports.addPropertyChangeListener("syn", this);
		firePropertyChange("ports", this.ports, this.ports = ports);
	}

	public BaseConstsBean getBaseConsts() {
		return baseConsts;
	}

	public void setBaseConsts(BaseConstsBean baseConsts) {
		baseConsts.addPropertyChangeListener("ip", this);
		baseConsts.addPropertyChangeListener("mss", this);
		baseConsts.addPropertyChangeListener("window", this);
		baseConsts.addPropertyChangeListener("ttl", this);
		baseConsts.addPropertyChangeListener("tcb", this);
		baseConsts.addPropertyChangeListener("tcbBuf", this);
		baseConsts.addPropertyChangeListener("proxy", this);
		baseConsts.addPropertyChangeListener("cluster", this);
		firePropertyChange("baseConsts", this.baseConsts,
				this.baseConsts = baseConsts);
	}

	public NATBean getNat() {
		return nat;
	}

	public void setNat(NATBean nat) {
		nat.addPropertyChangeListener("overload", this);
		nat.addPropertyChangeListener("limit", this);
		nat.addPropertyChangeListener("size", this);
		nat.addPropertyChangeListener("table", this);
		firePropertyChange("nat", this.nat, this.nat = nat);
	}

	public ARPBean getArp() {
		return arp;
	}

	public void setArp(ARPBean arp) {
		arp.addPropertyChangeListener("proxy", this);
		arp.addPropertyChangeListener("table", this);
		firePropertyChange("arp", this.arp, this.arp = arp);
	}

	public TracingBean getTracing() {
		return tracing;
	}

	public void setTracing(TracingBean tracing) {
		tracing.addPropertyChangeListener("interfaces", this);
		tracing.addPropertyChangeListener("route", this);
		tracing.addPropertyChangeListener("servers", this);
		firePropertyChange("tracing", this.tracing, this.tracing = tracing);
	}

	public HostsBean getHosts() {
		return hosts;
	}

	public void setHosts(HostsBean hosts) {
		hosts.addPropertyChangeListener("host", this);
		firePropertyChange("hosts", this.hosts, this.hosts = hosts);
	}

	public SystemInfoBean getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(SystemInfoBean systemInfo) {
		systemInfo.addPropertyChangeListener("fullName", this);
		systemInfo.addPropertyChangeListener("version", this);
		systemInfo.addPropertyChangeListener("release", this);
		systemInfo.addPropertyChangeListener("service", this);
		systemInfo.addPropertyChangeListener("dionisNumber", this);
		systemInfo.addPropertyChangeListener("dionisKeyCode", this);
		systemInfo.addPropertyChangeListener("ports", this);
		firePropertyChange("systemInfo", this.systemInfo,
				this.systemInfo = systemInfo);
	}

	public CryptographyBean getCryptography() {
		return cryptography;
	}

	public void setCryptography(CryptographyBean cryptography) {
		cryptography.addPropertyChangeListener("initialized", this);
		cryptography.addPropertyChangeListener("kernel", this);
		cryptography.addPropertyChangeListener("encryption", this);
		cryptography.addPropertyChangeListener("keep", this);
		cryptography.addPropertyChangeListener("keys", this);
		firePropertyChange("cryptography", this.cryptography,
				this.cryptography = cryptography);
	}

	public ConsoleBean getConsole() {
		return console;
	}

	public void setConsole(ConsoleBean console) {
		console.addPropertyChangeListener("keyboard", this);
		console.addPropertyChangeListener("editor", this);
		console.addPropertyChangeListener("monitoring", this);
		console.addPropertyChangeListener("portsLed", this);
		console.addPropertyChangeListener("timeLed", this);
		console.addPropertyChangeListener("screenBlanking", this);
		console.addPropertyChangeListener("autoReset", this);
		firePropertyChange("console", this.console, this.console = console);
	}

	public RemoteControlBean getRemoteControl() {
		return remoteControl;
	}

	public void setRemoteControl(RemoteControlBean remoteControl) {
		remoteControl.addPropertyChangeListener("user", this);
		remoteControl.addPropertyChangeListener("password", this);
		remoteControl.addPropertyChangeListener("mode", this);
		remoteControl.addPropertyChangeListener("reload", this);
		remoteControl.addPropertyChangeListener("upload", this);
		remoteControl.addPropertyChangeListener("download", this);
		remoteControl.addPropertyChangeListener("keys", this);
		firePropertyChange("remoteControl", this.remoteControl,
				this.remoteControl = remoteControl);
	}

	public LogsBean getLogs() {
		return logs;
	}

	public void setLogs(LogsBean logs) {
		logs.addPropertyChangeListener("control", this);
		logs.addPropertyChangeListener("mode", this);
		logs.addPropertyChangeListener("size", this);
		logs.addPropertyChangeListener("schedule", this);
		logs.addPropertyChangeListener("renameTo", this);
		logs.addPropertyChangeListener("parts", this);
		firePropertyChange("logs", this.logs, this.logs = logs);
	}

	public PasswordBean getPassword() {
		return password;
	}

	public void setPassword(PasswordBean password) {
		password.addPropertyChangeListener("send", this);
		password.addPropertyChangeListener("freez", this);
		firePropertyChange("password", this.password, this.password = password);
	}

	public TimeServiceBean getTimeService() {
		return timeService;
	}

	public void setTimeService(TimeServiceBean timeService) {
		timeService.addPropertyChangeListener("zone", this);
		timeService.addPropertyChangeListener("name", this);
		timeService.addPropertyChangeListener("summerName", this);
		timeService.addPropertyChangeListener("initialized", this);
		timeService.addPropertyChangeListener("summer", this);
		timeService.addPropertyChangeListener("auto", this);
		timeService.addPropertyChangeListener("sntp", this);
		firePropertyChange("timeService", this.timeService,
				this.timeService = timeService);
	}

	public PingProbesBean getPingProbes() {
		return pingProbes;
	}

	public void setPingProbes(PingProbesBean pingProbes) {
		pingProbes.addPropertyChangeListener("probe", this);
		firePropertyChange("pingProbes", this.pingProbes,
				this.pingProbes = pingProbes);
	}

}
