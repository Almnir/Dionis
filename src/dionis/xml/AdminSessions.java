
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
 *         &lt;element name="PPP">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TCP">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="10"/>
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
    "ppp",
    "tcp"
})
public class AdminSessions
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "PPP")
    protected short ppp;
    @XmlElement(name = "TCP")
    protected short tcp;

    /**
     * Gets the value of the ppp property.
     * 
     */
    public short getPPP() {
        return ppp;
    }

    /**
     * Sets the value of the ppp property.
     * 
     */
    public void setPPP(short value) {
        this.ppp = value;
    }

    public boolean isSetPPP() {
        return true;
    }

    /**
     * Gets the value of the tcp property.
     * 
     */
    public short getTCP() {
        return tcp;
    }

    /**
     * Sets the value of the tcp property.
     * 
     */
    public void setTCP(short value) {
        this.tcp = value;
    }

    public boolean isSetTCP() {
        return true;
    }

}
