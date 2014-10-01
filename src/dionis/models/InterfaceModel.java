package dionis.models;

import dionis.beans.InterfaceBean;

public class InterfaceModel extends AbstractModel<InterfaceBean>{

	private static InterfaceModel instance = null;

	public static InterfaceModel getInstance() {
		if (instance == null) {
			instance = new InterfaceModel();
		}
		return instance;
	}

}
