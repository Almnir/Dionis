package dionis.beans;

import dionis.xml.BooleanType;

public class SheduleFilterItemBean extends FilterItemBean implements
		IFilterItem {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (days.getMon() == BooleanType.YES) {
			sb.append("Пн");
		}
		if (days.getTue() == BooleanType.YES) {
			sb.append("Вт");
		}
		if (days.getFri() == BooleanType.YES) {
			sb.append("Ср");
		}
		if (days.getThu() == BooleanType.YES) {
			sb.append("Чт");
		}
		if (days.getFri() == BooleanType.YES) {
			sb.append("Пт");
		}
		if (days.getSat() == BooleanType.YES) {
			sb.append("Сб");
		}
		if (days.getSun() == BooleanType.YES) {
			sb.append("Вс");
		}
		sb.append(" ");
		if (date != null) {
			sb.append(date.getBegin().getDay()).append("/").append(date.getBegin().getMonth()).append("/").append(date.getBegin().getYear());
			sb.append("-");
			sb.append(date.getEnd().getDay()).append("/").append(date.getEnd().getMonth()).append("/").append(date.getEnd().getYear());
			sb.append(" ");
		}
		sb.append(timeInterval1.getBegin()).append("-").append(timeInterval1.getEnd());
		sb.append(" ");
		sb.append(timeInterval2.getBegin()).append("-").append(timeInterval2.getEnd());
		return sb.toString();
	}
}
