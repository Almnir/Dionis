
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
 *         &lt;element name="Mon">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="From" type="{}UserSheduleType"/>
 *                   &lt;element name="To" type="{}UserSheduleType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Tue">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="From" type="{}UserSheduleType"/>
 *                   &lt;element name="To" type="{}UserSheduleType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Wed">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="From" type="{}UserSheduleType"/>
 *                   &lt;element name="To" type="{}UserSheduleType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Thu">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="From" type="{}UserSheduleType"/>
 *                   &lt;element name="To" type="{}UserSheduleType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Fri">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="From" type="{}UserSheduleType"/>
 *                   &lt;element name="To" type="{}UserSheduleType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Sat">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="From" type="{}UserSheduleType"/>
 *                   &lt;element name="To" type="{}UserSheduleType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Sun">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="From" type="{}UserSheduleType"/>
 *                   &lt;element name="To" type="{}UserSheduleType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
    "mon",
    "tue",
    "wed",
    "thu",
    "fri",
    "sat",
    "sun"
})
public class GroupSchedule
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Mon", required = true)
    protected GroupMon mon;
    @XmlElement(name = "Tue", required = true)
    protected GroupTue tue;
    @XmlElement(name = "Wed", required = true)
    protected GroupWed wed;
    @XmlElement(name = "Thu", required = true)
    protected GroupThu thu;
    @XmlElement(name = "Fri", required = true)
    protected GroupFri fri;
    @XmlElement(name = "Sat", required = true)
    protected GroupSat sat;
    @XmlElement(name = "Sun", required = true)
    protected GroupSun sun;

    /**
     * Gets the value of the mon property.
     * 
     * @return
     *     possible object is
     *     {@link GroupMon }
     *     
     */
    public GroupMon getMon() {
        return mon;
    }

    /**
     * Sets the value of the mon property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupMon }
     *     
     */
    public void setMon(GroupMon value) {
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
     *     {@link GroupTue }
     *     
     */
    public GroupTue getTue() {
        return tue;
    }

    /**
     * Sets the value of the tue property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupTue }
     *     
     */
    public void setTue(GroupTue value) {
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
     *     {@link GroupWed }
     *     
     */
    public GroupWed getWed() {
        return wed;
    }

    /**
     * Sets the value of the wed property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupWed }
     *     
     */
    public void setWed(GroupWed value) {
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
     *     {@link GroupThu }
     *     
     */
    public GroupThu getThu() {
        return thu;
    }

    /**
     * Sets the value of the thu property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupThu }
     *     
     */
    public void setThu(GroupThu value) {
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
     *     {@link GroupFri }
     *     
     */
    public GroupFri getFri() {
        return fri;
    }

    /**
     * Sets the value of the fri property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupFri }
     *     
     */
    public void setFri(GroupFri value) {
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
     *     {@link GroupSat }
     *     
     */
    public GroupSat getSat() {
        return sat;
    }

    /**
     * Sets the value of the sat property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupSat }
     *     
     */
    public void setSat(GroupSat value) {
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
     *     {@link GroupSun }
     *     
     */
    public GroupSun getSun() {
        return sun;
    }

    /**
     * Sets the value of the sun property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupSun }
     *     
     */
    public void setSun(GroupSun value) {
        this.sun = value;
    }

    public boolean isSetSun() {
        return (this.sun!= null);
    }

}
