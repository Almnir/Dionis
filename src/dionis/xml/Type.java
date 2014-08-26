
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
 *         &lt;element name="Ethernet" type="{}BooleanType"/>
 *         &lt;element name="SLIP_PPP" type="{}BooleanType"/>
 *         &lt;element name="Loopback_Broadcast" type="{}BooleanType"/>
 *         &lt;element name="X.25" type="{}BooleanType"/>
 *         &lt;element name="ARP" type="{}BooleanType"/>
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
    "ethernet",
    "slipppp",
    "loopbackBroadcast",
    "x25",
    "arp"
})
public class Type
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Ethernet", required = true)
    protected BooleanType ethernet;
    @XmlElement(name = "SLIP_PPP", required = true)
    protected BooleanType slipppp;
    @XmlElement(name = "Loopback_Broadcast", required = true)
    protected BooleanType loopbackBroadcast;
    @XmlElement(name = "X.25", required = true)
    protected BooleanType x25;
    @XmlElement(name = "ARP", required = true)
    protected BooleanType arp;

    /**
     * Gets the value of the ethernet property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getEthernet() {
        return ethernet;
    }

    /**
     * Sets the value of the ethernet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setEthernet(BooleanType value) {
        this.ethernet = value;
    }

    public boolean isSetEthernet() {
        return (this.ethernet!= null);
    }

    /**
     * Gets the value of the slipppp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSLIPPPP() {
        return slipppp;
    }

    /**
     * Sets the value of the slipppp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSLIPPPP(BooleanType value) {
        this.slipppp = value;
    }

    public boolean isSetSLIPPPP() {
        return (this.slipppp!= null);
    }

    /**
     * Gets the value of the loopbackBroadcast property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getLoopbackBroadcast() {
        return loopbackBroadcast;
    }

    /**
     * Sets the value of the loopbackBroadcast property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setLoopbackBroadcast(BooleanType value) {
        this.loopbackBroadcast = value;
    }

    public boolean isSetLoopbackBroadcast() {
        return (this.loopbackBroadcast!= null);
    }

    /**
     * Gets the value of the x25 property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getX25() {
        return x25;
    }

    /**
     * Sets the value of the x25 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setX25(BooleanType value) {
        this.x25 = value;
    }

    public boolean isSetX25() {
        return (this.x25 != null);
    }

    /**
     * Gets the value of the arp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getARP() {
        return arp;
    }

    /**
     * Sets the value of the arp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setARP(BooleanType value) {
        this.arp = value;
    }

    public boolean isSetARP() {
        return (this.arp!= null);
    }

}
