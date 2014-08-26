
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
 *         &lt;element name="Get">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Send">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
    "get",
    "send"
})
public class Element
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Get", required = true)
    protected String get;
    @XmlElement(name = "Send", required = true)
    protected String send;

    /**
     * Gets the value of the get property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGet() {
        return get;
    }

    /**
     * Sets the value of the get property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGet(String value) {
        this.get = value;
    }

    public boolean isSetGet() {
        return (this.get!= null);
    }

    /**
     * Gets the value of the send property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSend() {
        return send;
    }

    /**
     * Sets the value of the send property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSend(String value) {
        this.send = value;
    }

    public boolean isSetSend() {
        return (this.send!= null);
    }

}
