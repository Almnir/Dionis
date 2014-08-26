
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
 *         &lt;element name="IP">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Dionis">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
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
    "ip",
    "dionis"
})
public class AdminStatEntries
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "IP")
    protected int ip;
    @XmlElement(name = "Dionis")
    protected int dionis;

    /**
     * Gets the value of the ip property.
     * 
     */
    public int getIP() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     */
    public void setIP(int value) {
        this.ip = value;
    }

    public boolean isSetIP() {
        return true;
    }

    /**
     * Gets the value of the dionis property.
     * 
     */
    public int getDionis() {
        return dionis;
    }

    /**
     * Sets the value of the dionis property.
     * 
     */
    public void setDionis(int value) {
        this.dionis = value;
    }

    public boolean isSetDionis() {
        return true;
    }

}
