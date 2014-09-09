package dionis.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class AddressLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String rv = "";
		if (element instanceof String[]) {
			String[] data = (String[]) element;
			if (columnIndex == 0) {
				rv = data[0];
			} else if (columnIndex == 1) {
				rv = data[1];
			}
		}
		return rv;
	}

}
