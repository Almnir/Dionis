package dionis.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dionis.beans.VLANBean;

public class ODILabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String rv = "";
		if (element instanceof VLANBean) {
			VLANBean bean = (VLANBean) element;
			switch (columnIndex) {
			case 0:
				rv = bean.getIp() + "/" + String.valueOf(bean.getBits());
				break;
			case 1:
				rv = String.valueOf(bean.getVnid());
				break;
			}
		}
		return rv;
	}
}
