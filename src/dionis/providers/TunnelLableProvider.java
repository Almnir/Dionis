package dionis.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dionis.models.TunnelFilterModel;
import dionis.models.TunnelModel;
import dionis.xml.BooleanType;
import dionis.xml.Tunnel;
import dionis.xml.TunnelFilter;
import dionis.xml.TunnelFilterSource;
import dionis.xml.TunnelFilterTarget;
import dionis.xml.TunnelFilters;

public class TunnelLableProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String rv = "";
		if (element instanceof Tunnel) {
			Tunnel data = (Tunnel) element;
			switch (columnIndex) {
			case 0:
				// номер по порядку в модели
				rv = String.valueOf(TunnelModel.getInstance().getData()
						.indexOf(data));
				break;
			case 1:
				// идентификатор
				rv = String.valueOf(data.getID());
				break;
			case 2:
				// заголовок
				if (data.getUDP() != null && data.isSetUDP()) {
					if (data.getUDP().getTitle() == BooleanType.YES) {
						rv = "UDP["
								+ String.valueOf(data.getUDP().getPorts()
										.getSender())
								+ ", "
								+ String.valueOf(data.getUDP().getPorts()
										.getReceiver()) + "]";
					} else {
						rv = "TNL";
					}
				}
				break;
			case 3:
				// локальный IP
				if (data.getIP() != null && data.isSetIP()) {
					rv = data.getIP().isSetLocal() ? data.getIP().getLocal()
							: "";
				}
				break;
			case 4:
				// удалённый IP
				if (data.getIP() != null && data.isSetIP()) {
					rv = data.getIP().isSetRemote() ? data.getIP().getRemote()
							: "";
				}
				break;
			case 5:
				// шифрование
				if (data.getEncryption() != null && data.isSetEncryption()) {
					if (data.getEncryption().isSetMethod()
							&& data.getEncryption().getMethod() == BooleanType.YES) {
						StringBuilder sb = new StringBuilder();
						sb.append("(")
								.append(data.getEncryption().isSetSerNumber() ? data
										.getEncryption().getSerNumber() : 0)
								.append(")");
						sb.append(" ")
								.append(data.getEncryption().getCryptoNumber()
										.isSetLocal() ? data.getEncryption()
										.getCryptoNumber().getLocal() : 0)
								.append(".");
						sb.append(
								data.getEncryption().isSetChannel() ? data
										.getEncryption().getChannel() : 0)
								.append("->");
						sb.append(data.getEncryption().getCryptoNumber()
								.isSetRemote() ? data.getEncryption()
								.getCryptoNumber().getRemote() : 0);
						rv = sb.toString();
					} else {
						rv = "Нет";
					}
				}
				break;
			case 6:
				// сжатие
				if (data.getLZW() != null && data.isSetLZW()) {
					if (data.getLZW() == BooleanType.YES) {
						rv = "Да";
					} else {
						rv = "Нет";
					}
				}
				break;
			case 7:
				// правила отбора
				if (data.getFilters() != null && data.isSetFilters()) {
					System.out.println("yes");
					StringBuilder sb = new StringBuilder();
					for (TunnelFilter filter : data.getFilters().getFilter()) {
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
						sb.append(filter.getSource().getIP()).append("/")
								.append(filter.getSource().getBits());
						sb.append(" ");
						sb.append(filter.getTarget().getIP()).append("/")
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
