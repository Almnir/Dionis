
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
 *         &lt;element name="Channel" type="{}BooleanType"/>
 *         &lt;element name="IP_ARP" type="{}BooleanType"/>
 *         &lt;element name="TCP_UDP_ICMP" type="{}BooleanType"/>
 *         &lt;element name="HEX-dump" type="{}BooleanType"/>
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
    "channel",
    "iparp",
    "tcpudpicmp",
    "hexDump"
})
public class Level
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Channel", required = true)
    protected BooleanType channel;
    @XmlElement(name = "IP_ARP", required = true)
    protected BooleanType iparp;
    @XmlElement(name = "TCP_UDP_ICMP", required = true)
    protected BooleanType tcpudpicmp;
    @XmlElement(name = "HEX-dump", required = true)
    protected BooleanType hexDump;

    /**
     * Gets the value of the channel property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setChannel(BooleanType value) {
        this.channel = value;
    }

    public boolean isSetChannel() {
        return (this.channel!= null);
    }

    /**
     * Gets the value of the iparp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getIPARP() {
        return iparp;
    }

    /**
     * Sets the value of the iparp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setIPARP(BooleanType value) {
        this.iparp = value;
    }

    public boolean isSetIPARP() {
        return (this.iparp!= null);
    }

    /**
     * Gets the value of the tcpudpicmp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getTCPUDPICMP() {
        return tcpudpicmp;
    }

    /**
     * Sets the value of the tcpudpicmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setTCPUDPICMP(BooleanType value) {
        this.tcpudpicmp = value;
    }

    public boolean isSetTCPUDPICMP() {
        return (this.tcpudpicmp!= null);
    }

    /**
     * Gets the value of the hexDump property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getHEXDump() {
        return hexDump;
    }

    /**
     * Sets the value of the hexDump property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setHEXDump(BooleanType value) {
        this.hexDump = value;
    }

    public boolean isSetHEXDump() {
        return (this.hexDump!= null);
    }

}
