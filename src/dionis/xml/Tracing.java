
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
 *         &lt;element name="Interfaces">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Type">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Ethernet" type="{}BooleanType"/>
 *                             &lt;element name="SLIP_PPP" type="{}BooleanType"/>
 *                             &lt;element name="Loopback_Broadcast" type="{}BooleanType"/>
 *                             &lt;element name="X.25" type="{}BooleanType"/>
 *                             &lt;element name="ARP" type="{}BooleanType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Level">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Channel" type="{}BooleanType"/>
 *                             &lt;element name="IP_ARP" type="{}BooleanType"/>
 *                             &lt;element name="TCP_UDP_ICMP" type="{}BooleanType"/>
 *                             &lt;element name="HEX-dump" type="{}BooleanType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Route">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Errors" type="{}BooleanType"/>
 *                   &lt;element name="All" type="{}BooleanType"/>
 *                   &lt;element name="Detail" type="{}BooleanType"/>
 *                   &lt;element name="HEX-dump" type="{}BooleanType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Servers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Telnet" type="{}BooleanType"/>
 *                   &lt;element name="TelnetD" type="{}BooleanType"/>
 *                   &lt;element name="DNS" type="{}BooleanType"/>
 *                   &lt;element name="DNSD" type="{}BooleanType"/>
 *                   &lt;element name="DHCPD" type="{}BooleanType"/>
 *                   &lt;element name="RIP" type="{}BooleanType"/>
 *                   &lt;element name="HTTPGW" type="{}BooleanType"/>
 *                   &lt;element name="IGMP" type="{}BooleanType"/>
 *                   &lt;element name="SNMP" type="{}BooleanType"/>
 *                   &lt;element name="ISAKMP" type="{}BooleanType"/>
 *                   &lt;element name="SNTP" type="{}BooleanType"/>
 *                   &lt;element name="DCP" type="{}BooleanType"/>
 *                   &lt;element name="Cluster" type="{}BooleanType"/>
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
    "interfaces",
    "route",
    "servers"
})
public class Tracing
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Interfaces", required = true)
    protected TracingInterfaces interfaces;
    @XmlElement(name = "Route", required = true)
    protected TracingRoute route;
    @XmlElement(name = "Servers", required = true)
    protected TracingServers servers;

    /**
     * Gets the value of the interfaces property.
     * 
     * @return
     *     possible object is
     *     {@link TracingInterfaces }
     *     
     */
    public TracingInterfaces getInterfaces() {
        return interfaces;
    }

    /**
     * Sets the value of the interfaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link TracingInterfaces }
     *     
     */
    public void setInterfaces(TracingInterfaces value) {
        this.interfaces = value;
    }

    public boolean isSetInterfaces() {
        return (this.interfaces!= null);
    }

    /**
     * Gets the value of the route property.
     * 
     * @return
     *     possible object is
     *     {@link TracingRoute }
     *     
     */
    public TracingRoute getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     * @param value
     *     allowed object is
     *     {@link TracingRoute }
     *     
     */
    public void setRoute(TracingRoute value) {
        this.route = value;
    }

    public boolean isSetRoute() {
        return (this.route!= null);
    }

    /**
     * Gets the value of the servers property.
     * 
     * @return
     *     possible object is
     *     {@link TracingServers }
     *     
     */
    public TracingServers getServers() {
        return servers;
    }

    /**
     * Sets the value of the servers property.
     * 
     * @param value
     *     allowed object is
     *     {@link TracingServers }
     *     
     */
    public void setServers(TracingServers value) {
        this.servers = value;
    }

    public boolean isSetServers() {
        return (this.servers!= null);
    }

}
