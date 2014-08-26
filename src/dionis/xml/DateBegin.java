
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
 *         &lt;element name="Day" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
    "month",
    "year"
})
public class DateBegin
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Day")
    protected byte day;
    @XmlElement(name = "Month")
    protected byte month;
    @XmlElement(name = "Year")
    protected short year;

    /**
     * Gets the value of the day property.
     * 
     */
    public byte getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     */
    public void setDay(byte value) {
        this.day = value;
    }

    public boolean isSetDay() {
        return true;
    }

    /**
     * Gets the value of the month property.
     * 
     */
    public byte getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     */
    public void setMonth(byte value) {
        this.month = value;
    }

    public boolean isSetMonth() {
        return true;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public short getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(short value) {
        this.year = value;
    }

    public boolean isSetYear() {
        return true;
    }

}
