
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
 *         &lt;element name="Day" type="{}WeekDayType"/>
 *         &lt;element name="Houre">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="23"/>
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
    "day",
    "houre"
})
public class ScheduleItem
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Day", required = true)
    protected WeekDayType day;
    @XmlElement(name = "Houre")
    protected short houre;

    /**
     * Gets the value of the day property.
     * 
     * @return
     *     possible object is
     *     {@link WeekDayType }
     *     
     */
    public WeekDayType getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeekDayType }
     *     
     */
    public void setDay(WeekDayType value) {
        this.day = value;
    }

    public boolean isSetDay() {
        return (this.day!= null);
    }

    /**
     * Gets the value of the houre property.
     * 
     */
    public short getHoure() {
        return houre;
    }

    /**
     * Sets the value of the houre property.
     * 
     */
    public void setHoure(short value) {
        this.houre = value;
    }

    public boolean isSetHoure() {
        return true;
    }

}
