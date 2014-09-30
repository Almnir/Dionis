package dionis.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dionis.beans.InterfaceRouteBean;

public class InterfaceRouteLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String rv = "";
		if (element instanceof InterfaceRouteBean) {
			InterfaceRouteBean irb = (InterfaceRouteBean) element;
			switch (columnIndex) {
			case 0:
				rv = irb.getIp() + "/" + String.valueOf(irb.getBits());
				break;
			case 1:
				rv = irb.getGateway();
				break;

			case 2:
				rv = String.valueOf(irb.getMetric());
				break;

			case 3:
				rv = String.valueOf(irb.getTag());
				break;
			}
		}
		return rv;
	}

}
