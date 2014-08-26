
package dionis.xml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="PAT" type="{}BooleanType"/>
 *         &lt;element name="Local">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{}IPType"/>
 *                   &lt;element name="Port" type="{}PortType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Global">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{}IPType"/>
 *                   &lt;element name="Port" type="{}PortType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Bits">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="32"/>
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
    "pat",
    "local",
    "global",
    "bits"
})
public class NATTableStatic
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "PAT", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    protected Boolean pat;
    @XmlElement(name = "Local", required = true)
    protected Local local;
    @XmlElement(name = "Global", required = true)
    protected Global global;
    @XmlElement(name = "Bits")
    protected byte bits;

    /**
     * Gets the value of the pat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isPAT() {
        return pat;
    }

    /**
     * Sets the value of the pat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAT(Boolean value) {
        this.pat = value;
    }

    public boolean isSetPAT() {
        return (this.pat!= null);
    }

    /**
     * Gets the value of the local property.
     * 
     * @return
     *     possible object is
     *     {@link Local }
     *     
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Sets the value of the local property.
     * 
     * @param value
     *     allowed object is
     *     {@link Local }
     *     
     */
    public void setLocal(Local value) {
        this.local = value;
    }

    public boolean isSetLocal() {
        return (this.local!= null);
    }

    /**
     * Gets the value of the global property.
     * 
     * @return
     *     possible object is
     *     {@link Global }
     *     
     */
    public Global getGlobal() {
        return global;
    }

    /**
     * Sets the value of the global property.
     * 
     * @param value
     *     allowed object is
     *     {@link Global }
     *     
     */
    public void setGlobal(Global value) {
        this.global = value;
    }

    public boolean isSetGlobal() {
        return (this.global!= null);
    }

    /**
     * Gets the value of the bits property.
     * 
     */
    public byte getBits() {
        return bits;
    }

    /**
     * Sets the value of the bits property.
     * 
     */
    public void setBits(byte value) {
        this.bits = value;
    }

    public boolean isSetBits() {
        return true;
    }

}
