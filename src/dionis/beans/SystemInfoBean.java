package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SystemInfoBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected String fullName;
	protected String version;
	protected String release;
	protected String service;
	protected String dionisNumber;
	protected String dionisKeyCode;
	protected SystemPortsBean ports;

	public SystemInfoBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		firePropertyChange("fullName", this.fullName, this.fullName = fullName);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		firePropertyChange("version", this.version, this.version = version);
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		firePropertyChange("release", this.release, this.release = release);
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		firePropertyChange("service", this.service, this.service = service);
	}

	public String getDionisNumber() {
		return dionisNumber;
	}

	public void setDionisNumber(String dionisNumber) {
		firePropertyChange("dionisNumber", this.dionisNumber,
				this.dionisNumber = dionisNumber);
	}

	public String getDionisKeyCode() {
		return dionisKeyCode;
	}

	public void setDionisKeyCode(String dionisKeyCode) {
		firePropertyChange("dionisKeyCode", this.dionisKeyCode,
				this.dionisKeyCode = dionisKeyCode);
	}

	public SystemPortsBean getPorts() {
		return ports;
	}

	public void setPorts(SystemPortsBean ports) {
		ports.addPropertyChangeListener("sio", this);
		ports.addPropertyChangeListener("x25", this);
		ports.addPropertyChangeListener("lan", this);
		ports.addPropertyChangeListener("syn", this);
		ports.addPropertyChangeListener("ipl", this);
		ports.addPropertyChangeListener("tcp", this);
		firePropertyChange("ports", this.ports, this.ports = ports);
	}

}
