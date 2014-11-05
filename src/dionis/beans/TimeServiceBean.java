package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.TimeZone;

import dionis.xml.BooleanType;

public class TimeServiceBean extends ModelObject implements
		PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected TimeZone zone;
	protected String name;
	protected String summerName;
	protected BooleanType initialized;
	protected BooleanType summer;
	protected BooleanType auto;
	protected BooleanType sntp;

	public TimeServiceBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public TimeZone getZone() {
		return zone;
	}

	public void setZone(TimeZone zone) {
		firePropertyChange("zone", this.zone, this.zone = zone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

	public String getSummerName() {
		return summerName;
	}

	public void setSummerName(String summerName) {
		firePropertyChange("summerName", this.summerName,
				this.summerName = summerName);
	}

	public BooleanType getInitialized() {
		return initialized;
	}

	public void setInitialized(BooleanType initialized) {
		firePropertyChange("initialized", this.initialized,
				this.initialized = initialized);
	}

	public BooleanType getSummer() {
		return summer;
	}

	public void setSummer(BooleanType summer) {
		firePropertyChange("summer", this.summer, this.summer = summer);
	}

	public BooleanType getAuto() {
		return auto;
	}

	public void setAuto(BooleanType auto) {
		firePropertyChange("auto", this.auto, this.auto = auto);
	}

	public BooleanType getSntp() {
		return sntp;
	}

	public void setSntp(BooleanType sntp) {
		firePropertyChange("sntp", this.sntp, this.sntp = sntp);
	}

}
