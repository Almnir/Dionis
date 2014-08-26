
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
 *         &lt;element name="Mon" type="{}BooleanType"/>
 *         &lt;element name="Tue" type="{}BooleanType"/>
 *         &lt;element name="Wed" type="{}BooleanType"/>
 *         &lt;element name="Thu" type="{}BooleanType"/>
 *         &lt;element name="Fri" type="{}BooleanType"/>
 *         &lt;element name="Sat" type="{}BooleanType"/>
 *         &lt;element name="Sun" type="{}BooleanType"/>
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
    "mon",
    "tue",
    "wed",
    "thu",
    "fri",
    "sat",
    "sun"
})
public class Days
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Mon", required = true)
    protected BooleanType mon;
    @XmlElement(name = "Tue", required = true)
    protected BooleanType tue;
    @XmlElement(name = "Wed", required = true)
    protected BooleanType wed;
    @XmlElement(name = "Thu", required = true)
    protected BooleanType thu;
    @XmlElement(name = "Fri", required = true)
    protected BooleanType fri;
    @XmlElement(name = "Sat", required = true)
    protected BooleanType sat;
    @XmlElement(name = "Sun", required = true)
    protected BooleanType sun;

    /**
     * Gets the value of the mon property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getMon() {
        return mon;
    }

    /**
     * Sets the value of the mon property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setMon(BooleanType value) {
        this.mon = value;
    }

    public boolean isSetMon() {
        return (this.mon!= null);
    }

    /**
     * Gets the value of the tue property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getTue() {
        return tue;
    }

    /**
     * Sets the value of the tue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setTue(BooleanType value) {
        this.tue = value;
    }

    public boolean isSetTue() {
        return (this.tue!= null);
    }

    /**
     * Gets the value of the wed property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getWed() {
        return wed;
    }

    /**
     * Sets the value of the wed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setWed(BooleanType value) {
        this.wed = value;
    }

    public boolean isSetWed() {
        return (this.wed!= null);
    }

    /**
     * Gets the value of the thu property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getThu() {
        return thu;
    }

    /**
     * Sets the value of the thu property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setThu(BooleanType value) {
        this.thu = value;
    }

    public boolean isSetThu() {
        return (this.thu!= null);
    }

    /**
     * Gets the value of the fri property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getFri() {
        return fri;
    }

    /**
     * Sets the value of the fri property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setFri(BooleanType value) {
        this.fri = value;
    }

    public boolean isSetFri() {
        return (this.fri!= null);
    }

    /**
     * Gets the value of the sat property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSat() {
        return sat;
    }

    /**
     * Sets the value of the sat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSat(BooleanType value) {
        this.sat = value;
    }

    public boolean isSetSat() {
        return (this.sat!= null);
    }

    /**
     * Gets the value of the sun property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSun() {
        return sun;
    }

    /**
     * Sets the value of the sun property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSun(BooleanType value) {
        this.sun = value;
    }

    public boolean isSetSun() {
        return (this.sun!= null);
    }

}
