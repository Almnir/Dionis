package dionis.beans;

public class StandardFilterItemBean extends FilterItemBean implements
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
}
