
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
 *         &lt;element name="IP" type="{}IPType"/>
 *         &lt;element name="Interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Wait" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Tag" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
    "ip",
    "interval",
    "wait",
    "tag"
})
public class Probe
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "IP", required = true)
    protected String ip;
    @XmlElement(name = "Interval")
    @XmlSchemaType(name = "unsignedShort")
    protected int interval;
    @XmlElement(name = "Wait")
    @XmlSchemaType(name = "unsignedShort")
    protected int wait;
    @XmlElement(name = "Tag")
    @XmlSchemaType(name = "unsignedByte")
    protected short tag;

    /**
     * Gets the value of the ip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIP() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIP(String value) {
        this.ip = value;
    }

    public boolean isSetIP() {
        return (this.ip!= null);
    }

    /**
     * Gets the value of the interval property.
     * 
     */
    public int getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     */
    public void setInterval(int value) {
        this.interval = value;
    }

    public boolean isSetInterval() {
        return true;
    }

    /**
     * Gets the value of the wait property.
     * 
     */
    public int getWait() {
        return wait;
    }

    /**
     * Sets the value of the wait property.
     * 
     */
    public void setWait(int value) {
        this.wait = value;
    }

    public boolean isSetWait() {
        return true;
    }

    /**
     * Gets the value of the tag property.
     * 
     */
    public short getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     */
    public void setTag(short value) {
        this.tag = value;
    }

    public boolean isSetTag() {
        return true;
    }

}
