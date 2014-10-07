package dionis.models;

import dionis.beans.TunnelBean;

public class TunnelModel extends AbstractModel<TunnelBean> {
	
	private static TunnelModel instance = null;

	public static TunnelModel getInstance() {
		if (instance == null) {
			instance = new TunnelModel();
		}
		return instance;
	}
}
