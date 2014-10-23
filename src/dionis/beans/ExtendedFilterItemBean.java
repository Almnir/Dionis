package dionis.beans;

import java.util.Arrays;

import dionis.utils.Constants;
import dionis.xml.BooleanType;

/**
 * Класс-бин расширенного фильтра
 * 
 * @author Ярных А.О.
 *
 */
public class ExtendedFilterItemBean extends FilterItemBean implements
		IFilterItem {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
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

	/**
	 * Метод, возвращающий заполнение расширенной информации о бине фильтра
	 * 
	 * @return
	 */
	public String getExtendedDataField() {
		StringBuilder sb = new StringBuilder("[");
		for (ExtBean eb : ext) {
			if (eb.getIp() == BooleanType.YES) {
				sb.append("(IP+");
				sb.append(eb.getOffset());
				sb.append(Arrays.asList(Constants.FILTER_LOGIC).get(
						eb.getOperation().ordinal()));
				sb.append(eb.getData());
				sb.append(")");
				// связь
				if (eb.getLink() != null) {
					sb.append(eb.getLink().name());
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
