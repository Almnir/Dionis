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
}
