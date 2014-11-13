package dionis.models;

import java.util.LinkedList;

import dionis.beans.VLANBean;

public class ODIModel extends AbstractModel<VLANBean> {

	@Override
	public Object clone() throws CloneNotSupportedException {
		LinkedList<VLANBean> linkedData = new LinkedList<VLANBean>(getData());
		return linkedData.clone();
	}
}
