package dionis.beans;

import java.util.List;

public class VLANsBean extends ModelObject {

	private static final long serialVersionUID = 0;
	protected List<VLANBean> vlan;

	public VLANsBean() {
	}

	public List<VLANBean> getVlan() {
		return vlan;
	}

	public void setVlan(List<VLANBean> vlan) {
		firePropertyChange("vlan", this.vlan, this.vlan = vlan);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VLANsBean [");
		if (vlan != null) {
			builder.append("vlan=");
			builder.append(vlan);
		}
		builder.append("]");
		return builder.toString();
	}
}
