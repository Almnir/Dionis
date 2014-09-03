package dionis.providers;

import java.text.DecimalFormat;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import dionis.models.PortsModel;
import dionis.xml.SIO;
import dionis.xml.SYN;

public class PortLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String rv = "";
		switch (columnIndex) {
		// если первая колонка
		case 0:
			if (element instanceof SIO) {
				SIO sio = (SIO) element;
				rv = "SIO_"
						+ String.valueOf(PortsModel.getInstance().getSios()
								.indexOf(sio));
			}
			if (element instanceof SYN) {
				SYN syn = (SYN) element;
				rv = "SYN_"
						+ String.valueOf(PortsModel.getInstance().getSyns()
								.indexOf(syn));
			}
			break;
		// вторая колонка
		case 1:
			if (element instanceof SIO) {
				SIO sio = (SIO) element;
				StringBuffer secondColumn = new StringBuffer();
				if (sio.isSetSpeed()) {
					String df = new DecimalFormat("#.#").format(sio.getSpeed())
							.replaceAll(",", ".");
					secondColumn.append(df);
				} else {
					secondColumn.append("");
				}
				secondColumn.append(" ");
				secondColumn.append(sio.isSetBits() ? String.valueOf(sio
						.getBits()) : "");
				secondColumn.append(" ");
				secondColumn.append(sio.isSetParity() ? String.valueOf(sio
						.getParity().name()) : "");
				secondColumn.append(" ");
				if (sio.isSetStopBit()) {
					String df = new DecimalFormat("#.#").format(
							sio.getStopBit()).replaceAll(",", ".");
					secondColumn.append(df);
				} else {
					secondColumn.append("");
				}
				secondColumn.append(" ");
				secondColumn.append(
						sio.isSetControl() ? String.valueOf(sio.getControl()
								.name()) : "").append(" ");
				secondColumn.append(
						sio.isSetDirection() ? String.valueOf(sio
								.getDirection().name()) : "").append(" ");
				secondColumn.append(sio.isSetModem() ? String.valueOf(sio
						.getModem()) : "");
				secondColumn.append(" ");
				rv = secondColumn.toString();
			}
			break;
		}
		return rv;
	}

}
