
package dionis.xml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="Run" type="{}BooleanType"/>
 *         &lt;element name="Serial" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Cache">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="32"/>
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
    "run",
    "serial",
    "number",
    "cache"
})
public class ISAKMP
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Run", required = true)
    protected BooleanType run;
    @XmlElement(name = "Serial")
    @XmlSchemaType(name = "unsignedShort")
    protected int serial;
    @XmlElement(name = "Number")
    @XmlSchemaType(name = "unsignedShort")
    protected int number;
    @XmlElement(name = "Cache")
    protected short cache;

    /**
     * Gets the value of the run property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getRun() {
        return run;
    }

    /**
     * Sets the value of the run property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setRun(BooleanType value) {
        this.run = value;
    }

    public boolean isSetRun() {
        return (this.run!= null);
    }

    /**
     * Gets the value of the serial property.
     * 
     */
    public int getSerial() {
        return serial;
    }

    /**
     * Sets the value of the serial property.
     * 
     */
    public void setSerial(int value) {
        this.serial = value;
    }

    public boolean isSetSerial() {
        return true;
    }

    /**
     * Gets the value of the number property.
     * 
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    public void setNumber(int value) {
        this.number = value;
    }

    public boolean isSetNumber() {
        return true;
    }

    /**
     * Gets the value of the cache property.
     * 
     */
    public short getCache() {
        return cache;
    }

    /**
     * Sets the value of the cache property.
     * 
     */
    public void setCache(short value) {
        this.cache = value;
    }

    public boolean isSetCache() {
        return true;
    }

}
