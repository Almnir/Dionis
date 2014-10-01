package dionis.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dionis.beans.InterfaceBean;
import dionis.models.InterfaceModel;

public class InterfaceLableProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String rv = "";
		if (element instanceof InterfaceBean) {
			InterfaceBean ib = (InterfaceBean) element;
			switch (columnIndex) {
			case 0:
				// номер по порядку
				int index = InterfaceModel.getInstance().getData().indexOf(ib);
				rv = String.valueOf(index + 1);
				break;
			case 1:
				rv = ib.getName();
				break;

			case 2:
				rv = (ib.getType() != null) ? ib.getType().name() : "";
				break;

			case 3:
				rv = (ib.getMode() != null) ? ib.getMode().name() : "";
				break;
			case 4:
				rv = ib.getIp().getLocal();
				break;
			case 5:
				rv = ib.getIp().getRemote();
				break;
			case 6:
				rv = (ib.getNat() != null) ? ib.getNat().name() : "";
				break;
			case 7:
				rv = ib.getFilters().getInput();
				break;
			case 8:
				rv = ib.getFilters().getOutput();
				break;
			case 9:
				rv = String.valueOf(ib.getMtu());
				break;
			case 10:
				rv = ib.getPort();
				break;
			case 11:
				rv = String.valueOf(ib.getTimer());
				break;
			case 12:
				rv = ib.getParametrs().toString();
				break;
			case 13:
				rv = ib.getRoutes().toString();
				break;
			}
		}
		return rv;
	}

}
