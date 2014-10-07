package dionis.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dionis.beans.TunnelBean;
import dionis.beans.TunnelFilterBean;
import dionis.models.TunnelModel;
import dionis.xml.BooleanType;

public class TunnelLableProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String rv = "";
		if (element instanceof TunnelBean) {
			TunnelBean data = (TunnelBean) element;
			switch (columnIndex) {
			case 0:
				// номер по порядку в модели (начинать с 1)
				rv = String.valueOf(TunnelModel.getInstance().getData()
						.indexOf(data) + 1);
				break;
			case 1:
				// идентификатор
				rv = String.valueOf(data.getId());
				break;
			case 2:
				// заголовок
				if (data.getUdp() != null) {
					if (data.getUdp().getTitle() == BooleanType.YES) {
						rv = "Udp["
								+ String.valueOf(data.getUdp().getPorts()
										.getSender())
								+ ", "
								+ String.valueOf(data.getUdp().getPorts()
										.getReceiver()) + "]";
					} else {
						rv = "TNL";
					}
				}
				break;
			case 3:
				// локальный IP
				if (data.getIp() != null) {
					rv = data.getIp().getLocal().isEmpty() ? data.getIp()
							.getLocal() : "";
				}
				break;
			case 4:
				// удалённый IP
				if (data.getIp() != null) {
					rv = data.getIp().getRemote();
				}
				break;
			case 5:
				// шифрование
				if (data.getEncryption() != null) {
					if (data.getEncryption().getMethod() != null
							&& data.getEncryption().getMethod() == BooleanType.YES) {
						StringBuilder sb = new StringBuilder();
						sb.append("(")
								.append(data.getEncryption().getSerNumber())
								.append(")");
						sb.append(" ")
								.append(data.getEncryption().getCryptoNumber()
										.getLocal()).append(".");
						sb.append(data.getEncryption().getChannel()).append(
								"->");
						sb.append(data.getEncryption().getCryptoNumber()
								.getRemote());
						rv = sb.toString();
					} else {
						rv = "Нет";
					}
				}
				break;
			case 6:
				// сжатие
				if (data.getLzw() != null) {
					if (data.getLzw() == BooleanType.YES) {
						rv = "Да";
					} else {
						rv = "Нет";
					}
				}
				break;
			case 7:
				// правила отбора
				if (data.getFilters() != null) {
					StringBuilder sb = new StringBuilder();
					for (TunnelFilterBean filter : data.getFilters()
							.getFilter()) {
						sb.append("[");
						switch (filter.getStatus()) {
						case SOLVE:
							sb.append("разрешить");
							break;
						case BAN:
							sb.append("запретить");
							break;
						case RESET:
							sb.append("сбросить");
							break;
						}
						sb.append(" ");
						sb.append(filter.getSource().getIp()).append("/")
								.append(filter.getSource().getBits());
						sb.append(" ");
						sb.append(filter.getTarget().getIp()).append("/")
								.append(filter.getTarget().getBits());
						sb.append(" ");
						sb.append(filter.getProtocol().name());
						sb.append(" ");
						sb.append(filter.getPorts().getLow()).append("-")
								.append(filter.getPorts().getHigh());
						sb.append("] ");
					}
					rv = sb.toString();
				}
				break;
			}
		}
		return rv;
	}
}
