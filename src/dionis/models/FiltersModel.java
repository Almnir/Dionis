package dionis.models;

import dionis.beans.FiltersBean;

public class FiltersModel extends AbstractModel<FiltersBean> {

	private static FiltersModel instance = null;

	public static synchronized FiltersModel getInstance() {
		if (instance == null) {
			instance = new FiltersModel();
		}
		return instance;
	}
}
