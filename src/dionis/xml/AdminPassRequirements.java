
package dionis.xml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Min_length">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Period" type="{}PassChangePeriodType"/>
 *         &lt;element name="Not_name" type="{}BooleanType"/>
 *         &lt;element name="Both_registers" type="{}BooleanType"/>
 *         &lt;element name="Letters_and_numbers" type="{}BooleanType"/>
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
    "minLength",
    "period",
    "notName",
    "bothRegisters",
    "lettersAndNumbers"
})
public class AdminPassRequirements
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Min_length")
    protected short minLength;
    @XmlElement(name = "Period", required = true)
    protected PassChangePeriodType period;
    @XmlElement(name = "Not_name", required = true)
    protected BooleanType notName;
    @XmlElement(name = "Both_registers", required = true)
    protected BooleanType bothRegisters;
    @XmlElement(name = "Letters_and_numbers", required = true)
    protected BooleanType lettersAndNumbers;

    /**
     * Gets the value of the minLength property.
     * 
     */
    public short getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     * 
     */
    public void setMinLength(short value) {
        this.minLength = value;
    }

    public boolean isSetMinLength() {
        return true;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link PassChangePeriodType }
     *     
     */
    public PassChangePeriodType getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link PassChangePeriodType }
     *     
     */
    public void setPeriod(PassChangePeriodType value) {
        this.period = value;
    }

    public boolean isSetPeriod() {
        return (this.period!= null);
    }

    /**
     * Gets the value of the notName property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getNotName() {
        return notName;
    }

    /**
     * Sets the value of the notName property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setNotName(BooleanType value) {
        this.notName = value;
    }

    public boolean isSetNotName() {
        return (this.notName!= null);
    }

    /**
     * Gets the value of the bothRegisters property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getBothRegisters() {
        return bothRegisters;
    }

    /**
     * Sets the value of the bothRegisters property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setBothRegisters(BooleanType value) {
        this.bothRegisters = value;
    }

    public boolean isSetBothRegisters() {
        return (this.bothRegisters!= null);
    }

    /**
     * Gets the value of the lettersAndNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getLettersAndNumbers() {
        return lettersAndNumbers;
    }

    /**
     * Sets the value of the lettersAndNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setLettersAndNumbers(BooleanType value) {
        this.lettersAndNumbers = value;
    }

    public boolean isSetLettersAndNumbers() {
        return (this.lettersAndNumbers!= null);
    }

}
