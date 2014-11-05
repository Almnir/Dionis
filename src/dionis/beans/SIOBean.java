package dionis.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import dionis.xml.PortsSIOControlType;
import dionis.xml.PortsSIODirectionType;
import dionis.xml.PortsSIOParityType;

public class SIOBean extends ModelObject implements PropertyChangeListener {

	private static final long serialVersionUID = 0;

	protected short number;
	protected Float speed;
	protected byte bits;
	protected PortsSIOControlType control;
	protected PortsSIOParityType parity;
	protected PortsSIODirectionType direction;
	protected Float stopBit;
	protected String modem;

	public SIOBean() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public short getNumber() {
		return number;
	}

	public void setNumber(short number) {
		firePropertyChange("number", this.number, this.number = number);
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		firePropertyChange("speed", this.speed, this.speed = speed);
	}

	public byte getBits() {
		return bits;
	}

	public void setBits(byte bits) {
		firePropertyChange("bits", this.bits, this.bits = bits);
	}

	public PortsSIOControlType getControl() {
		return control;
	}

	public void setControl(PortsSIOControlType control) {
		firePropertyChange("control", this.control, this.control = control);
	}

	public PortsSIOParityType getParity() {
		return parity;
	}

	public void setParity(PortsSIOParityType parity) {
		firePropertyChange("parity", this.parity, this.parity = parity);
	}

	public PortsSIODirectionType getDirection() {
		return direction;
	}

	public void setDirection(PortsSIODirectionType direction) {
		firePropertyChange("direction", this.direction,
				this.direction = direction);
	}

	public Float getStopBit() {
		return stopBit;
	}

	public void setStopBit(Float stopBit) {
		firePropertyChange("stopBit", this.stopBit, this.stopBit = stopBit);
	}

	public String getModem() {
		return modem;
	}

	public void setModem(String modem) {
		firePropertyChange("modem", this.modem, this.modem = modem);
	}

}
