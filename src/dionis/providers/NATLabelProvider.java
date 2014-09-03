package dionis.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dionis.xml.NATTableStatic;

public class NATLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String rv = "";
		if (element instanceof NATTableStatic) {
			NATTableStatic table = (NATTableStatic) element;

			switch (columnIndex) {
			// если первая колонка
			case 0:
				rv = buildString(table.getLocal().getIP(),
						String.valueOf(table.getLocal().getPort()),
						String.valueOf(table.getBits()));
				break;
			// вторая колонка
			case 1:
				rv = buildString(table.getGlobal().getIP(),
						String.valueOf(table.getGlobal().getPort()),
						String.valueOf(table.getBits()));
				break;
			}
		}
		return rv;
	}

	private String buildString(String ip, String port, String bits) {
		StringBuilder sb = new StringBuilder();
		sb.append(ip).append(":");
		sb.append(port).append("/");
		sb.append(bits);
		return sb.toString();
	}
}
