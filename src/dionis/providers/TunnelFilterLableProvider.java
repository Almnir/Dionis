package dionis.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dionis.models.TunnelFilterModel;
import dionis.xml.Tunnel;
import dionis.xml.TunnelFilter;
import dionis.xml.TunnelFilterSource;
import dionis.xml.TunnelFilterTarget;

/**
 * Класс-провайдер для отображения таблицы
 * 
 * @author Ярных А.О.
 *
 */
public class TunnelFilterLableProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String rv = "";
		if (element instanceof Tunnel) {
			TunnelFilter data = (TunnelFilter) element;
			switch (columnIndex) {
			case 0:
				// номер по порядку в модели
				rv = String.valueOf(TunnelFilterModel.getInstance().getData()
						.indexOf(data));
				break;
			case 1:
				// статус
				if (data.getStatus() != null) {
					rv = (data.isSetStatus()) ? data.getStatus().name() : "";
				}
				break;
			case 2:
				// отправитель
				TunnelFilterSource source = data.getSource();
				if (source != null) {
					if (data.isSetSource() && source.isSetIP()
							&& source.isSetBits()) {
						rv = source.getIP() + "/" + source.getBits();
					} else {
						rv = "";
					}
				}
				break;
			case 3:
				// получатель
				TunnelFilterTarget target = data.getTarget();
				if (target != null) {
					if (data.isSetTarget() && target.isSetIP()
							&& target.isSetBits()) {
						rv = target.getIP() + "/" + target.getBits();
					} else {
						rv = "";
					}
				}
				break;
			case 4:
				// протокол
				if (data.getProtocol() != null) {
					rv = (data.isSetProtocol()) ? data.getProtocol().name()
							: "";
				}
				break;
			case 5:
				// порты
				if (data.getPorts() != null) {
					if (data.isSetPorts()) {
						if (data.getPorts().isSetLow()) {
							rv = data.getPorts().getLow() + "-"; 
						} else {
							rv = "";
						}
						if (data.getPorts().isSetHigh()) {
							rv += data.getPorts().getHigh();
						} else {
							rv = rv.substring(0, rv.length()-1);
						}
					} else {
						rv = "";
					}
				}
				break;

			}
		}
		return rv;
	}

}
