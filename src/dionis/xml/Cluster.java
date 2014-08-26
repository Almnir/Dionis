
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
 *         &lt;element name="Mode" type="{}ClusterModeType"/>
 *         &lt;element name="Timer">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="60"/>
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
    "mode",
    "timer"
})
public class Cluster
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Mode", required = true)
    protected ClusterModeType mode;
    @XmlElement(name = "Timer")
    protected byte timer;

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterModeType }
     *     
     */
    public ClusterModeType getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterModeType }
     *     
     */
    public void setMode(ClusterModeType value) {
        this.mode = value;
    }

    public boolean isSetMode() {
        return (this.mode!= null);
    }

    /**
     * Gets the value of the timer property.
     * 
     */
    public byte getTimer() {
        return timer;
    }

    /**
     * Sets the value of the timer property.
     * 
     */
    public void setTimer(byte value) {
        this.timer = value;
    }

    public boolean isSetTimer() {
        return true;
    }

}
