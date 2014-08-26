
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
 *         &lt;element name="IP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Dionis" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dionis"
})
public class UserStatDataOut
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "IP", required = true)
    protected String ip;
    @XmlElement(name = "Dionis", required = true)
    protected String dionis;

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
     * Gets the value of the dionis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDionis() {
        return dionis;
    }

    /**
     * Sets the value of the dionis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDionis(String value) {
        this.dionis = value;
    }

    public boolean isSetDionis() {
        return (this.dionis!= null);
    }

}
