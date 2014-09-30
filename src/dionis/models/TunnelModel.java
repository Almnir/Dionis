package dionis.models;

import dionis.xml.Tunnel;

public class TunnelModel extends AbstractModel<Tunnel> {
	
	private static TunnelModel instance = null;

	public static TunnelModel getInstance() {
		if (instance == null) {
			instance = new TunnelModel();
		}
		return instance;
	}
}
