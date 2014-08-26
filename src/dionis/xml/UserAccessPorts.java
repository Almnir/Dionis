
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
 *         &lt;element name="SIO" type="{}BooleanType"/>
 *         &lt;element name="TCP_Telnet" type="{}BooleanType"/>
 *         &lt;element name="IP_PPP" type="{}BooleanType"/>
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
    "sio",
    "tcpTelnet",
    "ipppp"
})
public class UserAccessPorts
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "SIO", required = true)
    protected BooleanType sio;
    @XmlElement(name = "TCP_Telnet", required = true)
    protected BooleanType tcpTelnet;
    @XmlElement(name = "IP_PPP", required = true)
    protected BooleanType ipppp;

    /**
     * Gets the value of the sio property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSIO() {
        return sio;
    }

    /**
     * Sets the value of the sio property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSIO(BooleanType value) {
        this.sio = value;
    }

    public boolean isSetSIO() {
        return (this.sio!= null);
    }

    /**
     * Gets the value of the tcpTelnet property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getTCPTelnet() {
        return tcpTelnet;
    }

    /**
     * Sets the value of the tcpTelnet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setTCPTelnet(BooleanType value) {
        this.tcpTelnet = value;
    }

    public boolean isSetTCPTelnet() {
        return (this.tcpTelnet!= null);
    }

    /**
     * Gets the value of the ipppp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getIPPPP() {
        return ipppp;
    }

    /**
     * Sets the value of the ipppp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setIPPPP(BooleanType value) {
        this.ipppp = value;
    }

    public boolean isSetIPPPP() {
        return (this.ipppp!= null);
    }

}
