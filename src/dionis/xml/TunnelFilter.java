
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
 *         &lt;element name="Status" type="{}FilterStatusType"/>
 *         &lt;element name="Source">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{}IPType"/>
 *                   &lt;element name="Bits">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                         &lt;maxInclusive value="32"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Target">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{}IPType"/>
 *                   &lt;element name="Bits">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                         &lt;maxInclusive value="32"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Protocol" type="{}TunnelProtocolType"/>
 *         &lt;element name="Ports">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Low" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="High" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
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
    "status",
    "source",
    "target",
    "protocol",
    "ports"
})
public class TunnelFilter
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Status", required = true)
    protected FilterStatusType status;
    @XmlElement(name = "Source", required = true)
    protected TunnelFilterSource source;
    @XmlElement(name = "Target", required = true)
    protected TunnelFilterTarget target;
    @XmlElement(name = "Protocol", required = true)
    protected TunnelProtocolType protocol;
    @XmlElement(name = "Ports", required = true)
    protected TunnelFilterPorts ports;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link FilterStatusType }
     *     
     */
    public FilterStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterStatusType }
     *     
     */
    public void setStatus(FilterStatusType value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link TunnelFilterSource }
     *     
     */
    public TunnelFilterSource getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link TunnelFilterSource }
     *     
     */
    public void setSource(TunnelFilterSource value) {
        this.source = value;
    }

    public boolean isSetSource() {
        return (this.source!= null);
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link TunnelFilterTarget }
     *     
     */
    public TunnelFilterTarget getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link TunnelFilterTarget }
     *     
     */
    public void setTarget(TunnelFilterTarget value) {
        this.target = value;
    }

    public boolean isSetTarget() {
        return (this.target!= null);
    }

    /**
     * Gets the value of the protocol property.
     * 
     * @return
     *     possible object is
     *     {@link TunnelProtocolType }
     *     
     */
    public TunnelProtocolType getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link TunnelProtocolType }
     *     
     */
    public void setProtocol(TunnelProtocolType value) {
        this.protocol = value;
    }

    public boolean isSetProtocol() {
        return (this.protocol!= null);
    }

    /**
     * Gets the value of the ports property.
     * 
     * @return
     *     possible object is
     *     {@link TunnelFilterPorts }
     *     
     */
    public TunnelFilterPorts getPorts() {
        return ports;
    }

    /**
     * Sets the value of the ports property.
     * 
     * @param value
     *     allowed object is
     *     {@link TunnelFilterPorts }
     *     
     */
    public void setPorts(TunnelFilterPorts value) {
        this.ports = value;
    }

    public boolean isSetPorts() {
        return (this.ports!= null);
    }

}
