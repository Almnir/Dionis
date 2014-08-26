
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
 *         &lt;element name="Hidden" type="{}BooleanType"/>
 *         &lt;element name="Status" type="{}DNSZoneStatusType"/>
 *         &lt;element name="DNS">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="62"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Administrator">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="62"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Serial" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Refresh" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Retry" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Expire" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Minimum" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "hidden",
    "status",
    "dns",
    "administrator",
    "serial",
    "refresh",
    "retry",
    "expire",
    "minimum"
})
public class Header
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Hidden", required = true)
    protected BooleanType hidden;
    @XmlElement(name = "Status", required = true)
    protected DNSZoneStatusType status;
    @XmlElement(name = "DNS", required = true)
    protected String dns;
    @XmlElement(name = "Administrator", required = true)
    protected String administrator;
    @XmlElement(name = "Serial")
    protected int serial;
    @XmlElement(name = "Refresh")
    protected int refresh;
    @XmlElement(name = "Retry")
    protected int retry;
    @XmlElement(name = "Expire")
    protected int expire;
    @XmlElement(name = "Minimum")
    protected int minimum;

    /**
     * Gets the value of the hidden property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getHidden() {
        return hidden;
    }

    /**
     * Sets the value of the hidden property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setHidden(BooleanType value) {
        this.hidden = value;
    }

    public boolean isSetHidden() {
        return (this.hidden!= null);
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link DNSZoneStatusType }
     *     
     */
    public DNSZoneStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link DNSZoneStatusType }
     *     
     */
    public void setStatus(DNSZoneStatusType value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Gets the value of the dns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDNS() {
        return dns;
    }

    /**
     * Sets the value of the dns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDNS(String value) {
        this.dns = value;
    }

    public boolean isSetDNS() {
        return (this.dns!= null);
    }

    /**
     * Gets the value of the administrator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdministrator() {
        return administrator;
    }

    /**
     * Sets the value of the administrator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdministrator(String value) {
        this.administrator = value;
    }

    public boolean isSetAdministrator() {
        return (this.administrator!= null);
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
     * Gets the value of the refresh property.
     * 
     */
    public int getRefresh() {
        return refresh;
    }

    /**
     * Sets the value of the refresh property.
     * 
     */
    public void setRefresh(int value) {
        this.refresh = value;
    }

    public boolean isSetRefresh() {
        return true;
    }

    /**
     * Gets the value of the retry property.
     * 
     */
    public int getRetry() {
        return retry;
    }

    /**
     * Sets the value of the retry property.
     * 
     */
    public void setRetry(int value) {
        this.retry = value;
    }

    public boolean isSetRetry() {
        return true;
    }

    /**
     * Gets the value of the expire property.
     * 
     */
    public int getExpire() {
        return expire;
    }

    /**
     * Sets the value of the expire property.
     * 
     */
    public void setExpire(int value) {
        this.expire = value;
    }

    public boolean isSetExpire() {
        return true;
    }

    /**
     * Gets the value of the minimum property.
     * 
     */
    public int getMinimum() {
        return minimum;
    }

    /**
     * Sets the value of the minimum property.
     * 
     */
    public void setMinimum(int value) {
        this.minimum = value;
    }

    public boolean isSetMinimum() {
        return true;
    }

}
