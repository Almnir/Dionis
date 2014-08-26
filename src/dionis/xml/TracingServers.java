
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
 *         &lt;element name="Telnet" type="{}BooleanType"/>
 *         &lt;element name="TelnetD" type="{}BooleanType"/>
 *         &lt;element name="DNS" type="{}BooleanType"/>
 *         &lt;element name="DNSD" type="{}BooleanType"/>
 *         &lt;element name="DHCPD" type="{}BooleanType"/>
 *         &lt;element name="RIP" type="{}BooleanType"/>
 *         &lt;element name="HTTPGW" type="{}BooleanType"/>
 *         &lt;element name="IGMP" type="{}BooleanType"/>
 *         &lt;element name="SNMP" type="{}BooleanType"/>
 *         &lt;element name="ISAKMP" type="{}BooleanType"/>
 *         &lt;element name="SNTP" type="{}BooleanType"/>
 *         &lt;element name="DCP" type="{}BooleanType"/>
 *         &lt;element name="Cluster" type="{}BooleanType"/>
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
    "telnet",
    "telnetD",
    "dns",
    "dnsd",
    "dhcpd",
    "rip",
    "httpgw",
    "igmp",
    "snmp",
    "isakmp",
    "sntp",
    "dcp",
    "cluster"
})
public class TracingServers
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Telnet", required = true)
    protected BooleanType telnet;
    @XmlElement(name = "TelnetD", required = true)
    protected BooleanType telnetD;
    @XmlElement(name = "DNS", required = true)
    protected BooleanType dns;
    @XmlElement(name = "DNSD", required = true)
    protected BooleanType dnsd;
    @XmlElement(name = "DHCPD", required = true)
    protected BooleanType dhcpd;
    @XmlElement(name = "RIP", required = true)
    protected BooleanType rip;
    @XmlElement(name = "HTTPGW", required = true)
    protected BooleanType httpgw;
    @XmlElement(name = "IGMP", required = true)
    protected BooleanType igmp;
    @XmlElement(name = "SNMP", required = true)
    protected BooleanType snmp;
    @XmlElement(name = "ISAKMP", required = true)
    protected BooleanType isakmp;
    @XmlElement(name = "SNTP", required = true)
    protected BooleanType sntp;
    @XmlElement(name = "DCP", required = true)
    protected BooleanType dcp;
    @XmlElement(name = "Cluster", required = true)
    protected BooleanType cluster;

    /**
     * Gets the value of the telnet property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getTelnet() {
        return telnet;
    }

    /**
     * Sets the value of the telnet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setTelnet(BooleanType value) {
        this.telnet = value;
    }

    public boolean isSetTelnet() {
        return (this.telnet!= null);
    }

    /**
     * Gets the value of the telnetD property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getTelnetD() {
        return telnetD;
    }

    /**
     * Sets the value of the telnetD property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setTelnetD(BooleanType value) {
        this.telnetD = value;
    }

    public boolean isSetTelnetD() {
        return (this.telnetD!= null);
    }

    /**
     * Gets the value of the dns property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getDNS() {
        return dns;
    }

    /**
     * Sets the value of the dns property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setDNS(BooleanType value) {
        this.dns = value;
    }

    public boolean isSetDNS() {
        return (this.dns!= null);
    }

    /**
     * Gets the value of the dnsd property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getDNSD() {
        return dnsd;
    }

    /**
     * Sets the value of the dnsd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setDNSD(BooleanType value) {
        this.dnsd = value;
    }

    public boolean isSetDNSD() {
        return (this.dnsd!= null);
    }

    /**
     * Gets the value of the dhcpd property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getDHCPD() {
        return dhcpd;
    }

    /**
     * Sets the value of the dhcpd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setDHCPD(BooleanType value) {
        this.dhcpd = value;
    }

    public boolean isSetDHCPD() {
        return (this.dhcpd!= null);
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
     * Gets the value of the httpgw property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getHTTPGW() {
        return httpgw;
    }

    /**
     * Sets the value of the httpgw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setHTTPGW(BooleanType value) {
        this.httpgw = value;
    }

    public boolean isSetHTTPGW() {
        return (this.httpgw!= null);
    }

    /**
     * Gets the value of the igmp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getIGMP() {
        return igmp;
    }

    /**
     * Sets the value of the igmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setIGMP(BooleanType value) {
        this.igmp = value;
    }

    public boolean isSetIGMP() {
        return (this.igmp!= null);
    }

    /**
     * Gets the value of the snmp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSNMP() {
        return snmp;
    }

    /**
     * Sets the value of the snmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSNMP(BooleanType value) {
        this.snmp = value;
    }

    public boolean isSetSNMP() {
        return (this.snmp!= null);
    }

    /**
     * Gets the value of the isakmp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getISAKMP() {
        return isakmp;
    }

    /**
     * Sets the value of the isakmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setISAKMP(BooleanType value) {
        this.isakmp = value;
    }

    public boolean isSetISAKMP() {
        return (this.isakmp!= null);
    }

    /**
     * Gets the value of the sntp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSNTP() {
        return sntp;
    }

    /**
     * Sets the value of the sntp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSNTP(BooleanType value) {
        this.sntp = value;
    }

    public boolean isSetSNTP() {
        return (this.sntp!= null);
    }

    /**
     * Gets the value of the dcp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getDCP() {
        return dcp;
    }

    /**
     * Sets the value of the dcp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setDCP(BooleanType value) {
        this.dcp = value;
    }

    public boolean isSetDCP() {
        return (this.dcp!= null);
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

}
