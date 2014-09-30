package dionis.models;

import dionis.xml.TunnelFilter;

public class TunnelFilterModel extends AbstractModel<TunnelFilter> {

	private static TunnelFilterModel instance = null;

	public static TunnelFilterModel getInstance() {
		if (instance == null) {
			instance = new TunnelFilterModel();
		}
		return instance;
	}

	@Override
	public String toString() {
		String rv = "";
		for (Object obj : this.getData()) {
			rv += obj.toString();
			rv += " ";
		}
		return rv;
	}
}
