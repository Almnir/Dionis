package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class NATTableBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	private List<NATTableStaticBean> _static;

	public NATTableBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public List<NATTableStaticBean> get_static() {
		return _static;
	}

	public void set_static(List<NATTableStaticBean> _static) {
		firePropertyChange("_static", this._static, this._static = _static);
	}

}
