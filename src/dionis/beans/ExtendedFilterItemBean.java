package dionis.beans;

import dionis.xml.BooleanType;

public class ExtendedFilterItemBean extends StandardFilterItemBean implements
		IFilterItem {

	public String getExtendedDataField() {
		StringBuilder sb = new StringBuilder("[");
		for (ExtBean eb : ext) {
			if (eb.getIp() == BooleanType.YES) {
				sb.append("(IP+");
				sb.append(eb.getOffset());
				sb.append(eb.getOperation().name());
				sb.append(eb.getData());
				sb.append(")");
				sb.append(eb.getLink().name());
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
