package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ARPTableBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private List<ARPTableStaticBean> _static;

	public ARPTableBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public List<ARPTableStaticBean> get_static() {
		return _static;
	}

	public void set_static(List<ARPTableStaticBean> _static) {
		firePropertyChange("_static", this._static, this._static = _static);
	}

}
