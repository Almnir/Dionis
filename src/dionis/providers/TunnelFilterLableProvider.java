package dionis.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dionis.beans.TunnelFilterBean;
import dionis.beans.TunnelFilterSourceBean;
import dionis.beans.TunnelFilterTargetBean;
import dionis.models.TunnelFilterModel;
import dionis.utils.Constants;

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
		if (element instanceof TunnelFilterBean) {
			TunnelFilterBean data = (TunnelFilterBean) element;
			switch (columnIndex) {
			case 0:
				// номер по порядку в модели (начиная с 1)
				rv = String.valueOf(TunnelFilterModel.getInstance().getData()
						.indexOf(data) + 1);
				break;
			case 1:
				// статус
				rv = Constants.FILTER_MODE[data.getStatus().ordinal()];
				break;
			case 2:
				// отправитель
				TunnelFilterSourceBean source = data.getSource();
				if (source != null) {
					if (data.getSource() != null && source.getIp() != null
							&& source.getBits() != 0) {
						rv = source.getIp() + "/" + source.getBits();
					} else {
						rv = "";
					}
				}
				break;
			case 3:
				// получатель
				TunnelFilterTargetBean target = data.getTarget();
				if (target != null) {
					if (data.getTarget() != null && target.getIp() != null
							&& target.getBits() != 0) {
						rv = target.getIp() + "/" + target.getBits();
					} else {
						rv = "";
					}
				}
				break;
			case 4:
				// протокол
				rv = (data.getProtocol()) != null ? data.getProtocol().name()
						: "";
				break;
			case 5:
				// порты
				if (data.getPorts() != null) {
					if (data.getPorts().getLow() != 0) {
						rv = data.getPorts().getLow() + "-";
					} else {
						rv = "";
					}
					if (data.getPorts().getHigh() != 0) {
						rv += data.getPorts().getHigh();
					} else {
						rv = !rv.equals("") ? rv.substring(0, rv.length() - 1) : "";
					}
				} else {
					rv = "";
				}
				break;

			}
		}
		return rv;
	}

}
