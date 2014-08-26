
package dionis.xml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Number">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Speed" type="{}PortSpeedType"/>
 *         &lt;element name="Bits">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *               &lt;minInclusive value="7"/>
 *               &lt;maxInclusive value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Control" type="{}PortsSIOControlType"/>
 *         &lt;element name="Parity" type="{}PortsSIOParityType"/>
 *         &lt;element name="Direction" type="{}PortsSIODirectionType"/>
 *         &lt;element name="Stop-bit" type="{}PortStopBitType"/>
 *         &lt;element name="Modem">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="78"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "number",
    "speed",
    "bits",
    "control",
    "parity",
    "direction",
    "stopBit",
    "modem"
})
public class SIO
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Number")
    protected short number;
    @XmlElement(name = "Speed", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    protected Float speed;
    @XmlElement(name = "Bits")
    protected byte bits;
    @XmlElement(name = "Control", required = true)
    protected PortsSIOControlType control;
    @XmlElement(name = "Parity", required = true)
    protected PortsSIOParityType parity;
    @XmlElement(name = "Direction", required = true)
    protected PortsSIODirectionType direction;
    @XmlElement(name = "Stop-bit", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    protected Float stopBit;
    @XmlElement(name = "Modem", required = true)
    protected String modem;

    /**
     * Gets the value of the number property.
     * 
     */
    public short getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    public void setNumber(short value) {
        this.number = value;
    }

    public boolean isSetNumber() {
        return true;
    }

    /**
     * Gets the value of the speed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Float getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpeed(Float value) {
        this.speed = value;
    }

    public boolean isSetSpeed() {
        return (this.speed!= null);
    }

    /**
     * Gets the value of the bits property.
     * 
     */
    public byte getBits() {
        return bits;
    }

    /**
     * Sets the value of the bits property.
     * 
     */
    public void setBits(byte value) {
        this.bits = value;
    }

    public boolean isSetBits() {
        return true;
    }

    /**
     * Gets the value of the control property.
     * 
     * @return
     *     possible object is
     *     {@link PortsSIOControlType }
     *     
     */
    public PortsSIOControlType getControl() {
        return control;
    }

    /**
     * Sets the value of the control property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortsSIOControlType }
     *     
     */
    public void setControl(PortsSIOControlType value) {
        this.control = value;
    }

    public boolean isSetControl() {
        return (this.control!= null);
    }

    /**
     * Gets the value of the parity property.
     * 
     * @return
     *     possible object is
     *     {@link PortsSIOParityType }
     *     
     */
    public PortsSIOParityType getParity() {
        return parity;
    }

    /**
     * Sets the value of the parity property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortsSIOParityType }
     *     
     */
    public void setParity(PortsSIOParityType value) {
        this.parity = value;
    }

    public boolean isSetParity() {
        return (this.parity!= null);
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link PortsSIODirectionType }
     *     
     */
    public PortsSIODirectionType getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortsSIODirectionType }
     *     
     */
    public void setDirection(PortsSIODirectionType value) {
        this.direction = value;
    }

    public boolean isSetDirection() {
        return (this.direction!= null);
    }

    /**
     * Gets the value of the stopBit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Float getStopBit() {
        return stopBit;
    }

    /**
     * Sets the value of the stopBit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopBit(Float value) {
        this.stopBit = value;
    }

    public boolean isSetStopBit() {
        return (this.stopBit!= null);
    }

    /**
     * Gets the value of the modem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModem() {
        return modem;
    }

    /**
     * Sets the value of the modem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModem(String value) {
        this.modem = value;
    }

    public boolean isSetModem() {
        return (this.modem!= null);
    }

}
