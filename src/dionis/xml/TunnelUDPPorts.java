
package dionis.xml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="Sender" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Receiver" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
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
    "sender",
    "receiver"
})
public class TunnelUDPPorts
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Sender")
    @XmlSchemaType(name = "unsignedShort")
    protected int sender;
    @XmlElement(name = "Receiver")
    @XmlSchemaType(name = "unsignedShort")
    protected int receiver;

    /**
     * Gets the value of the sender property.
     * 
     */
    public int getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     */
    public void setSender(int value) {
        this.sender = value;
    }

    public boolean isSetSender() {
        return true;
    }

    /**
     * Gets the value of the receiver property.
     * 
     */
    public int getReceiver() {
        return receiver;
    }

    /**
     * Sets the value of the receiver property.
     * 
     */
    public void setReceiver(int value) {
        this.receiver = value;
    }

    public boolean isSetReceiver() {
        return true;
    }

}
