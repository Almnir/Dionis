package dionis.beans;

import java.io.Serializable;
import java.util.Arrays;

import dionis.utils.Constants;
import dionis.xml.BooleanType;
import dionis.xml.FilterOperationType;

/**
 * Класс-бин расширенного фильтра
 * 
 * @author Ярных А.О.
 *
 */
public class ExtendedFilterItemBean extends FilterItemBean implements
		IFilterItem, Serializable {

	private static final long serialVersionUID = 0;

	/**
	 * Метод, возвращающий заполнение расширенной информации о бине фильтра
	 * 
	 * @return
	 */
	public String getExtendedDataField() {
		StringBuilder sb = new StringBuilder("[");
		ExtBean eb0 = ext.get(0);
		ExtBean eb1 = ext.get(1);
		ExtBean eb2 = ext.get(2);
		ExtBean eb3 = ext.get(3);
		// первый блок
		if (eb0.getOperation() != FilterOperationType.NOP
				&& eb0.getIp() == BooleanType.YES) {
			sb.append("(IP+");
			sb.append(eb0.getOffset());
			sb.append(Arrays.asList(Constants.FILTER_LOGIC).get(
					eb0.getOperation().ordinal()));
			sb.append(eb0.getData());
			sb.append(")");
			// если следующий блок имеет логическую операцию или признак блока
			// IP+
			if (eb1.getOperation() != FilterOperationType.NOP
					&& eb1.getIp() == BooleanType.YES) {
				// если есть логическая связь
				if (eb0.getLink() != null) {
					sb.append(eb0.getLink().name());
				}
			}
		}
		if (eb1.getOperation() != FilterOperationType.NOP
				&& eb1.getIp() == BooleanType.YES) {
			sb.append("(IP+");
			sb.append(eb1.getOffset());
			sb.append(Arrays.asList(Constants.FILTER_LOGIC).get(
					eb1.getOperation().ordinal()));
			sb.append(eb1.getData());
			sb.append(")");
			if (eb2.getOperation() != FilterOperationType.NOP
					&& eb2.getIp() == BooleanType.YES) {
				if (eb1.getLink() != null) {
					sb.append(eb1.getLink().name());
				}
			}
		}
		if (eb2.getOperation() != FilterOperationType.NOP
				&& eb2.getIp() == BooleanType.YES) {
			sb.append("(IP+");
			sb.append(eb2.getOffset());
			sb.append(Arrays.asList(Constants.FILTER_LOGIC).get(
					eb2.getOperation().ordinal()));
			sb.append(eb2.getData());
			sb.append(")");
			if (eb3.getOperation() != FilterOperationType.NOP
					&& eb3.getIp() == BooleanType.YES) {
				if (eb2.getLink() != null) {
					sb.append(eb2.getLink().name());
				}
			}
		}
		if (eb3.getOperation() != FilterOperationType.NOP
				&& eb3.getIp() == BooleanType.YES) {
			sb.append("(IP+");
			sb.append(eb3.getOffset());
			sb.append(Arrays.asList(Constants.FILTER_LOGIC).get(
					eb3.getOperation().ordinal()));
			sb.append(eb3.getData());
			sb.append(")");
		}
		sb.append("]");
		return sb.toString();
	}

}
