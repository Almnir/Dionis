
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
 *         &lt;element name="Send" type="{}PasswordGuessType"/>
 *         &lt;element name="Freez" type="{}PasswordGuessType"/>
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
    "send",
    "freez"
})
public class Password
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Send", required = true)
    protected PasswordGuessType send;
    @XmlElement(name = "Freez", required = true)
    protected PasswordGuessType freez;

    /**
     * Gets the value of the send property.
     * 
     * @return
     *     possible object is
     *     {@link PasswordGuessType }
     *     
     */
    public PasswordGuessType getSend() {
        return send;
    }

    /**
     * Sets the value of the send property.
     * 
     * @param value
     *     allowed object is
     *     {@link PasswordGuessType }
     *     
     */
    public void setSend(PasswordGuessType value) {
        this.send = value;
    }

    public boolean isSetSend() {
        return (this.send!= null);
    }

    /**
     * Gets the value of the freez property.
     * 
     * @return
     *     possible object is
     *     {@link PasswordGuessType }
     *     
     */
    public PasswordGuessType getFreez() {
        return freez;
    }

    /**
     * Sets the value of the freez property.
     * 
     * @param value
     *     allowed object is
     *     {@link PasswordGuessType }
     *     
     */
    public void setFreez(PasswordGuessType value) {
        this.freez = value;
    }

    public boolean isSetFreez() {
        return (this.freez!= null);
    }

}
