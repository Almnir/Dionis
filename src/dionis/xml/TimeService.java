
package dionis.xml;

import java.io.Serializable;
import java.util.TimeZone;
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
 *         &lt;element name="Zone" type="{}TimeServiceZoneType"/>
 *         &lt;element name="Name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Summer_name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Initialized" type="{}BooleanType"/>
 *         &lt;element name="Summer" type="{}BooleanType"/>
 *         &lt;element name="Auto" type="{}BooleanType"/>
 *         &lt;element name="SNTP" type="{}BooleanType"/>
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
    "zone",
    "name",
    "summerName",
    "initialized",
    "summer",
    "auto",
    "sntp"
})
public class TimeService
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Zone", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected TimeZone zone;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Summer_name", required = true)
    protected String summerName;
    @XmlElement(name = "Initialized", required = true)
    protected BooleanType initialized;
    @XmlElement(name = "Summer", required = true)
    protected BooleanType summer;
    @XmlElement(name = "Auto", required = true)
    protected BooleanType auto;
    @XmlElement(name = "SNTP", required = true)
    protected BooleanType sntp;

    /**
     * Gets the value of the zone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public TimeZone getZone() {
        return zone;
    }

    /**
     * Sets the value of the zone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZone(TimeZone value) {
        this.zone = value;
    }

    public boolean isSetZone() {
        return (this.zone!= null);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the summerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummerName() {
        return summerName;
    }

    /**
     * Sets the value of the summerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummerName(String value) {
        this.summerName = value;
    }

    public boolean isSetSummerName() {
        return (this.summerName!= null);
    }

    /**
     * Gets the value of the initialized property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getInitialized() {
        return initialized;
    }

    /**
     * Sets the value of the initialized property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setInitialized(BooleanType value) {
        this.initialized = value;
    }

    public boolean isSetInitialized() {
        return (this.initialized!= null);
    }

    /**
     * Gets the value of the summer property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSummer() {
        return summer;
    }

    /**
     * Sets the value of the summer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSummer(BooleanType value) {
        this.summer = value;
    }

    public boolean isSetSummer() {
        return (this.summer!= null);
    }

    /**
     * Gets the value of the auto property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getAuto() {
        return auto;
    }

    /**
     * Sets the value of the auto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setAuto(BooleanType value) {
        this.auto = value;
    }

    public boolean isSetAuto() {
        return (this.auto!= null);
    }

    /**
     * Gets the value of the sntp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSNTP() {
        return sntp;
    }

    /**
     * Sets the value of the sntp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSNTP(BooleanType value) {
        this.sntp = value;
    }

    public boolean isSetSNTP() {
        return (this.sntp!= null);
    }

}
