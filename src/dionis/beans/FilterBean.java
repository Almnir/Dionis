package dionis.beans;

import java.util.List;

public class FilterBean extends ModelObject {

	protected String name;
	protected List<? extends FilterItemBean> item;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

	public List<? extends FilterItemBean> getItem() {
		return item;
	}

	public void setItem(List<? extends FilterItemBean> item) {
		firePropertyChange("item", this.item, this.item = item);
	}

}
