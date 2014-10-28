package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import dionis.xml.BooleanType;
import dionis.xml.FilterProtocolType;
import dionis.xml.FilterStatusType;
import dionis.xml.FilterTCPFlagsType;

/**
 * Корневой класс бина для правил
 * 
 * @author Ярных А.О.
 *
 */
public class FilterItemBean extends ModelObject implements
		PropertyChangeListener, IFilterItem {

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

	private FiltersBean parent;
	
	@Override
	public BooleanType getBlock() {
		return block;
	}

	@Override
	public void setBlock(BooleanType block) {
		firePropertyChange("block", this.block, this.block = block);
	}

	@Override
	public BooleanType getFix() {
		return fix;
	}

	@Override
	public void setFix(BooleanType fix) {
		firePropertyChange("fix", this.fix, this.fix = fix);
	}

	@Override
	public FilterStatusType getMode() {
		return mode;
	}

	@Override
	public void setMode(FilterStatusType mode) {
		firePropertyChange("mode", this.mode, this.mode = mode);
	}

	@Override
	public FilterProtocolType getProtocol() {
		return protocol;
	}

	@Override
	public void setProtocol(FilterProtocolType protocol) {
		firePropertyChange("protocol", this.protocol, this.protocol = protocol);
	}

	@Override
	public FilterTCPFlagsType getTcpFlags() {
		return tcpFlags;
	}

	@Override
	public void setTcpFlags(FilterTCPFlagsType tcpFlags) {
		firePropertyChange("tcpFlags", this.tcpFlags, this.tcpFlags = tcpFlags);
	}

	@Override
	public FilterSourceBean getSource() {
		return source;
	}

	@Override
	public void setSource(FilterSourceBean source) {
		source.addPropertyChangeListener("source", this);
		firePropertyChange("source", this.source, this.source = source);
	}

	@Override
	public FilterTargetBean getTarget() {
		return target;
	}

	@Override
	public void setTarget(FilterTargetBean target) {
		target.addPropertyChangeListener("target", this);
		firePropertyChange("target", this.target, this.target = target);
	}

	@Override
	public FilterPortsBean getPorts() {
		return ports;
	}

	@Override
	public void setPorts(FilterPortsBean ports) {
		ports.addPropertyChangeListener("ports", this);
		firePropertyChange("ports", this.ports, this.ports = ports);
	}

	@Override
	public List<ExtBean> getExt() {
		return ext;
	}

	@Override
	public void setExt(List<ExtBean> ext) {
		firePropertyChange("ext", this.ext, this.ext = ext);
	}

	@Override
	public BooleanType getExclude() {
		return exclude;
	}

	@Override
	public void setExclude(BooleanType exclude) {
		firePropertyChange("exclude", this.exclude, this.exclude = exclude);
	}

	@Override
	public DaysBean getDays() {
		return days;
	}

	@Override
	public void setDays(DaysBean days) {
		days.addPropertyChangeListener("days", this);
		firePropertyChange("days", this.days, this.days = days);
	}

	@Override
	public DateBean getDate() {
		return date;
	}

	@Override
	public void setDate(DateBean date) {
		date.addPropertyChangeListener("date", this);
		firePropertyChange("date", this.date, this.date = date);
	}

	@Override
	public TimeInterval1Bean getTimeInterval1() {
		return timeInterval1;
	}

	@Override
	public void setTimeInterval1(TimeInterval1Bean timeInterval1) {
		timeInterval1.addPropertyChangeListener("timeInterval1", this);
		firePropertyChange("timeInterval1", this.timeInterval1,
				this.timeInterval1 = timeInterval1);
	}

	@Override
	public TimeInterval2Bean getTimeInterval2() {
		return timeInterval2;
	}

	@Override
	public void setTimeInterval2(TimeInterval2Bean timeInterval2) {
		timeInterval2.addPropertyChangeListener("timeInterval2", this);
		firePropertyChange("timeInterval2", this.timeInterval2,
				this.timeInterval2 = timeInterval2);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public FiltersBean getParent() {
		return parent;
	}

	public void setParent(FiltersBean parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (getBlock() == BooleanType.YES) {
			sb.append("X");
		}
		if (getFix() == BooleanType.YES) {
			sb.append("!");
		}
		sb.append(" ");
		// адрес_отправителя/значащих_бит адрес_получателя/значащих_бит протокол
		// порт-порт отправителя(получателя/все)
		sb.append(getSource().getIp()).append("/")
				.append(getSource().getBits()).append(" ");
		sb.append(getTarget().getIp()).append("/")
				.append(getTarget().getBits()).append(" ");
		sb.append(getProtocol()).append(" ");
		sb.append(getPorts().getLow()).append("-").append(getPorts().getHigh())
				.append(" ");
		String portsType = "";
		switch (getPorts().getType()) {
		case ALL:
			portsType = "Все";
			break;

		case SOURCE:
			portsType = "Отправителя";
			break;

		case TARGET:
			portsType = "Получателя";
			break;
		}
		sb.append(portsType);
		return sb.toString();
	}
	
}
