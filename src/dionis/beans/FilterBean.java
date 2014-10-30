package dionis.beans;

import java.io.Serializable;
import java.util.List;

public class FilterBean extends ModelObject implements Serializable {

	private static final long serialVersionUID = 0;
	
	protected String name;
	protected List<IFilterItem> item;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

	public List<IFilterItem> getItem() {
		return item;
	}

	public void setItem(List<IFilterItem> item) {
		firePropertyChange("item", this.item, this.item = item);
	}

}
