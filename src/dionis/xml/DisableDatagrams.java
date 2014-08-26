
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
 *         &lt;element name="Not_tunneled" type="{}BooleanType"/>
 *         &lt;element name="DHCP" type="{}BooleanType"/>
 *         &lt;element name="Multicast" type="{}BooleanType"/>
 *         &lt;element name="Forward" type="{}BooleanType"/>
 *         &lt;element name="RIP" type="{}BooleanType"/>
 *         &lt;element name="Cluster" type="{}BooleanType"/>
 *         &lt;element name="IP-stat" type="{}BooleanType"/>
 *         &lt;element name="Proxy-ARP" type="{}BooleanType"/>
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
    "notTunneled",
    "dhcp",
    "multicast",
    "forward",
    "rip",
    "cluster",
    "ipStat",
    "proxyARP"
})
public class DisableDatagrams
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Not_tunneled", required = true)
    protected BooleanType notTunneled;
    @XmlElement(name = "DHCP", required = true)
    protected BooleanType dhcp;
    @XmlElement(name = "Multicast", required = true)
    protected BooleanType multicast;
    @XmlElement(name = "Forward", required = true)
    protected BooleanType forward;
    @XmlElement(name = "RIP", required = true)
    protected BooleanType rip;
    @XmlElement(name = "Cluster", required = true)
    protected BooleanType cluster;
    @XmlElement(name = "IP-stat", required = true)
    protected BooleanType ipStat;
    @XmlElement(name = "Proxy-ARP", required = true)
    protected BooleanType proxyARP;

    /**
     * Gets the value of the notTunneled property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getNotTunneled() {
        return notTunneled;
    }

    /**
     * Sets the value of the notTunneled property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setNotTunneled(BooleanType value) {
        this.notTunneled = value;
    }

    public boolean isSetNotTunneled() {
        return (this.notTunneled!= null);
    }

    /**
     * Gets the value of the dhcp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getDHCP() {
        return dhcp;
    }

    /**
     * Sets the value of the dhcp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setDHCP(BooleanType value) {
        this.dhcp = value;
    }

    public boolean isSetDHCP() {
        return (this.dhcp!= null);
    }

    /**
     * Gets the value of the multicast property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getMulticast() {
        return multicast;
    }

    /**
     * Sets the value of the multicast property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setMulticast(BooleanType value) {
        this.multicast = value;
    }

    public boolean isSetMulticast() {
        return (this.multicast!= null);
    }

    /**
     * Gets the value of the forward property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getForward() {
        return forward;
    }

    /**
     * Sets the value of the forward property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setForward(BooleanType value) {
        this.forward = value;
    }

    public boolean isSetForward() {
        return (this.forward!= null);
    }

    /**
     * Gets the value of the rip property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getRIP() {
        return rip;
    }

    /**
     * Sets the value of the rip property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setRIP(BooleanType value) {
        this.rip = value;
    }

    public boolean isSetRIP() {
        return (this.rip!= null);
    }

    /**
     * Gets the value of the cluster property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getCluster() {
        return cluster;
    }

    /**
     * Sets the value of the cluster property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setCluster(BooleanType value) {
        this.cluster = value;
    }

    public boolean isSetCluster() {
        return (this.cluster!= null);
    }

    /**
     * Gets the value of the ipStat property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getIPStat() {
        return ipStat;
    }

    /**
     * Sets the value of the ipStat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setIPStat(BooleanType value) {
        this.ipStat = value;
    }

    public boolean isSetIPStat() {
        return (this.ipStat!= null);
    }

    /**
     * Gets the value of the proxyARP property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getProxyARP() {
        return proxyARP;
    }

    /**
     * Sets the value of the proxyARP property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setProxyARP(BooleanType value) {
        this.proxyARP = value;
    }

    public boolean isSetProxyARP() {
        return (this.proxyARP!= null);
    }

}
