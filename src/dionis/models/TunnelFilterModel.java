package dionis.models;

import dionis.beans.TunnelFilterBean;

public class TunnelFilterModel extends AbstractModel<TunnelFilterBean> {

	private static TunnelFilterModel instance = null;

	public static synchronized TunnelFilterModel getInstance() {
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
