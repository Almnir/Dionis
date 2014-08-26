
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
 *         &lt;element name="Bits">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="33"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Gateway" type="{}IPType"/>
 *         &lt;element name="Metric" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
    "bits",
    "gateway",
    "metric",
    "tag"
})
public class InterfaceRoute
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "IP", required = true)
    protected String ip;
    @XmlElement(name = "Bits")
    protected short bits;
    @XmlElement(name = "Gateway", required = true)
    protected String gateway;
    @XmlElement(name = "Metric")
    @XmlSchemaType(name = "unsignedByte")
    protected short metric;
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
     * Gets the value of the bits property.
     * 
     */
    public short getBits() {
        return bits;
    }

    /**
     * Sets the value of the bits property.
     * 
     */
    public void setBits(short value) {
        this.bits = value;
    }

    public boolean isSetBits() {
        return true;
    }

    /**
     * Gets the value of the gateway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * Sets the value of the gateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGateway(String value) {
        this.gateway = value;
    }

    public boolean isSetGateway() {
        return (this.gateway!= null);
    }

    /**
     * Gets the value of the metric property.
     * 
     */
    public short getMetric() {
        return metric;
    }

    /**
     * Sets the value of the metric property.
     * 
     */
    public void setMetric(short value) {
        this.metric = value;
    }

    public boolean isSetMetric() {
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
