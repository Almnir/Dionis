package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import dionis.xml.BooleanType;
import dionis.xml.FilterProtocolType;
import dionis.xml.FilterStatusType;
import dionis.xml.FilterTCPFlagsType;

public class FilterItemBean extends ModelObject implements
		PropertyChangeListener {

	protected BooleanType block;
	protected BooleanType fix;
	protected FilterStatusType mode;
	protected FilterProtocolType protocol;
	protected FilterTCPFlagsType tcpFlags;
	protected FilterSourceBean source;
	protected FilterTargetBean target;
	protected FilterPortsBean ports;
	protected List<ExtBean> ext;
	protected BooleanType exclude;
	protected DaysBean days;
	protected DateBean date;
	protected TimeInterval1Bean timeInterval1;
	protected TimeInterval2Bean timeInterval2;

	public BooleanType getBlock() {
		return block;
	}

	public void setBlock(BooleanType block) {
		firePropertyChange("block", this.block, this.block = block);
	}

	public BooleanType getFix() {
		return fix;
	}

	public void setFix(BooleanType fix) {
		firePropertyChange("fix", this.fix, this.fix = fix);
	}

	public FilterStatusType getMode() {
		return mode;
	}

	public void setMode(FilterStatusType mode) {
		firePropertyChange("mode", this.mode, this.mode = mode);
	}

	public FilterProtocolType getProtocol() {
		return protocol;
	}

	public void setProtocol(FilterProtocolType protocol) {
		firePropertyChange("protocol", this.protocol, this.protocol = protocol);
	}

	public FilterTCPFlagsType getTcpFlags() {
		return tcpFlags;
	}

	public void setTcpFlags(FilterTCPFlagsType tcpFlags) {
		firePropertyChange("tcpFlags", this.tcpFlags, this.tcpFlags = tcpFlags);
	}

	public FilterSourceBean getSource() {
		return source;
	}

	public void setSource(FilterSourceBean source) {
		source.addPropertyChangeListener("source", this);
		firePropertyChange("source", this.source, this.source = source);
	}

	public FilterTargetBean getTarget() {
		return target;
	}

	public void setTarget(FilterTargetBean target) {
		target.addPropertyChangeListener("target", this);
		firePropertyChange("target", this.target, this.target = target);
	}

	public FilterPortsBean getPorts() {
		return ports;
	}

	public void setPorts(FilterPortsBean ports) {
		ports.addPropertyChangeListener("ports", this);
		firePropertyChange("ports", this.ports, this.ports = ports);
	}

	public List<ExtBean> getExt() {
		return ext;
	}

	public void setExt(List<ExtBean> ext) {
		firePropertyChange("ext", this.ext, this.ext = ext);
	}

	public BooleanType getExclude() {
		return exclude;
	}

	public void setExclude(BooleanType exclude) {
		firePropertyChange("exclude", this.exclude, this.exclude = exclude);
	}

	public DaysBean getDays() {
		return days;
	}

	public void setDays(DaysBean days) {
		days.addPropertyChangeListener("days", this);
		firePropertyChange("days", this.days, this.days = days);
	}

	public DateBean getDate() {
		return date;
	}

	public void setDate(DateBean date) {
		date.addPropertyChangeListener("date", this);
		firePropertyChange("date", this.date, this.date = date);
	}

	public TimeInterval1Bean getTimeInterval1() {
		return timeInterval1;
	}

	public void setTimeInterval1(TimeInterval1Bean timeInterval1) {
		timeInterval1.addPropertyChangeListener("timeInterval1", this);
		firePropertyChange("timeInterval1", this.timeInterval1,
				this.timeInterval1 = timeInterval1);
	}

	public TimeInterval2Bean getTimeInterval2() {
		return timeInterval2;
	}

	public void setTimeInterval2(TimeInterval2Bean timeInterval2) {
		timeInterval2.addPropertyChangeListener("timeInterval2", this);
		firePropertyChange("timeInterval2", this.timeInterval2,
				this.timeInterval2 = timeInterval2);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

}
