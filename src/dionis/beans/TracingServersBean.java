package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.BooleanType;

public class TracingServersBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected BooleanType telnet;
	protected BooleanType telnetD;
	protected BooleanType dns;
	protected BooleanType dnsd;
	protected BooleanType dhcpd;
	protected BooleanType rip;
	protected BooleanType httpgw;
	protected BooleanType igmp;
	protected BooleanType snmp;
	protected BooleanType isakmp;
	protected BooleanType sntp;
	protected BooleanType dcp;
	protected BooleanType cluster;

	public TracingServersBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public BooleanType getTelnet() {
		return telnet;
	}

	public void setTelnet(BooleanType telnet) {
		firePropertyChange("telnet", this.telnet, this.telnet = telnet);
	}

	public BooleanType getTelnetD() {
		return telnetD;
	}

	public void setTelnetD(BooleanType telnetD) {
		firePropertyChange("telnetD", this.telnetD, this.telnetD = telnetD);
	}

	public BooleanType getDns() {
		return dns;
	}

	public void setDns(BooleanType dns) {
		firePropertyChange("dns", this.dns, this.dns = dns);
	}

	public BooleanType getDnsd() {
		return dnsd;
	}

	public void setDnsd(BooleanType dnsd) {
		firePropertyChange("dnsd", this.dnsd, this.dnsd = dnsd);
	}

	public BooleanType getDhcpd() {
		return dhcpd;
	}

	public void setDhcpd(BooleanType dhcpd) {
		firePropertyChange("dhcpd", this.dhcpd, this.dhcpd = dhcpd);
	}

	public BooleanType getRip() {
		return rip;
	}

	public void setRip(BooleanType rip) {
		firePropertyChange("rip", this.rip, this.rip = rip);
	}

	public BooleanType getHttpgw() {
		return httpgw;
	}

	public void setHttpgw(BooleanType httpgw) {
		firePropertyChange("httpgw", this.httpgw, this.httpgw = httpgw);
	}

	public BooleanType getIgmp() {
		return igmp;
	}

	public void setIgmp(BooleanType igmp) {
		firePropertyChange("igmp", this.igmp, this.igmp = igmp);
	}

	public BooleanType getSnmp() {
		return snmp;
	}

	public void setSnmp(BooleanType snmp) {
		firePropertyChange("snmp", this.snmp, this.snmp = snmp);
	}

	public BooleanType getIsakmp() {
		return isakmp;
	}

	public void setIsakmp(BooleanType isakmp) {
		firePropertyChange("isakmp", this.isakmp, this.isakmp = isakmp);
	}

	public BooleanType getSntp() {
		return sntp;
	}

	public void setSntp(BooleanType sntp) {
		firePropertyChange("sntp", this.sntp, this.sntp = sntp);
	}

	public BooleanType getDcp() {
		return dcp;
	}

	public void setDcp(BooleanType dcp) {
		firePropertyChange("dcp", this.dcp, this.dcp = dcp);
	}

	public BooleanType getCluster() {
		return cluster;
	}

	public void setCluster(BooleanType cluster) {
		firePropertyChange("cluster", this.cluster, this.cluster = cluster);
	}

}
