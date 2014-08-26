
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
 *         &lt;element name="Method" type="{}BooleanType"/>
 *         &lt;element name="SerNumber">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *               &lt;maxInclusive value="99999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Channel">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CryptoNumber">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Local">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *                         &lt;maxInclusive value="99999"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Remote">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *                         &lt;maxInclusive value="99999"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
    "method",
    "serNumber",
    "channel",
    "cryptoNumber"
})
public class TunnelEncryption
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Method", required = true)
    protected BooleanType method;
    @XmlElement(name = "SerNumber")
    protected long serNumber;
    @XmlElement(name = "Channel")
    protected short channel;
    @XmlElement(name = "CryptoNumber", required = true)
    protected CryptoNumber cryptoNumber;

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setMethod(BooleanType value) {
        this.method = value;
    }

    public boolean isSetMethod() {
        return (this.method!= null);
    }

    /**
     * Gets the value of the serNumber property.
     * 
     */
    public long getSerNumber() {
        return serNumber;
    }

    /**
     * Sets the value of the serNumber property.
     * 
     */
    public void setSerNumber(long value) {
        this.serNumber = value;
    }

    public boolean isSetSerNumber() {
        return true;
    }

    /**
     * Gets the value of the channel property.
     * 
     */
    public short getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     */
    public void setChannel(short value) {
        this.channel = value;
    }

    public boolean isSetChannel() {
        return true;
    }

    /**
     * Gets the value of the cryptoNumber property.
     * 
     * @return
     *     possible object is
     *     {@link CryptoNumber }
     *     
     */
    public CryptoNumber getCryptoNumber() {
        return cryptoNumber;
    }

    /**
     * Sets the value of the cryptoNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link CryptoNumber }
     *     
     */
    public void setCryptoNumber(CryptoNumber value) {
        this.cryptoNumber = value;
    }

    public boolean isSetCryptoNumber() {
        return (this.cryptoNumber!= null);
    }

}
