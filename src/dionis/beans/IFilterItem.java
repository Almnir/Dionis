package dionis.beans;

import java.util.List;

import dionis.xml.BooleanType;
import dionis.xml.FilterProtocolType;
import dionis.xml.FilterStatusType;
import dionis.xml.FilterTCPFlagsType;

/**
 * Интерфейс для правил фильтрации
 * 
 * @author Ярных А.О.
 *
 */
public interface IFilterItem {

	public abstract BooleanType getBlock();

	public abstract void setBlock(BooleanType block);

	public abstract BooleanType getFix();

	public abstract void setFix(BooleanType fix);

	public abstract FilterStatusType getMode();

	public abstract void setMode(FilterStatusType mode);

	public abstract FilterProtocolType getProtocol();

	public abstract void setProtocol(FilterProtocolType protocol);

	public abstract FilterTCPFlagsType getTcpFlags();

	public abstract void setTcpFlags(FilterTCPFlagsType tcpFlags);

	public abstract FilterSourceBean getSource();

	public abstract void setSource(FilterSourceBean source);

	public abstract FilterTargetBean getTarget();

	public abstract void setTarget(FilterTargetBean target);

	public abstract FilterPortsBean getPorts();

	public abstract void setPorts(FilterPortsBean ports);

	public abstract List<ExtBean> getExt();

	public abstract void setExt(List<ExtBean> ext);

	public abstract BooleanType getExclude();

	public abstract void setExclude(BooleanType exclude);

	public abstract DaysBean getDays();

	public abstract void setDays(DaysBean days);

	public abstract DateBean getDate();

	public abstract void setDate(DateBean date);

	public abstract TimeInterval1Bean getTimeInterval1();

	public abstract void setTimeInterval1(TimeInterval1Bean timeInterval1);

	public abstract TimeInterval2Bean getTimeInterval2();

	public abstract void setTimeInterval2(TimeInterval2Bean timeInterval2);

	public abstract void setParent(FiltersBean parent);

	public abstract FiltersBean getParent();

}