
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
 *         &lt;element name="Low" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="High" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
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
    "low",
    "high"
})
public class TunnelFilterPorts
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Low")
    @XmlSchemaType(name = "unsignedShort")
    protected int low;
    @XmlElement(name = "High")
    @XmlSchemaType(name = "unsignedShort")
    protected int high;

    /**
     * Gets the value of the low property.
     * 
     */
    public int getLow() {
        return low;
    }

    /**
     * Sets the value of the low property.
     * 
     */
    public void setLow(int value) {
        this.low = value;
    }

    public boolean isSetLow() {
        return true;
    }

    /**
     * Gets the value of the high property.
     * 
     */
    public int getHigh() {
        return high;
    }

    /**
     * Sets the value of the high property.
     * 
     */
    public void setHigh(int value) {
        this.high = value;
    }

    public boolean isSetHigh() {
        return true;
    }

}
