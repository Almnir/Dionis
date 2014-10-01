
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
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="IP">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Local" type="{}IPType"/>
 *                   &lt;element name="Remote" type="{}IPType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="UDP">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Title" type="{}BooleanType"/>
 *                   &lt;element name="Ports">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Sender" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="Receiver" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LZW" type="{}BooleanType"/>
 *         &lt;element name="Unused" type="{}BooleanType"/>
 *         &lt;element name="Blocked" type="{}BooleanType"/>
 *         &lt;element name="Encryption">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Method" type="{}BooleanType"/>
 *                   &lt;element name="SerNumber">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *                         &lt;maxInclusive value="99999"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Channel">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                         &lt;maxInclusive value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CryptoNumber">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Local">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *                                   &lt;maxInclusive value="99999"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Remote">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *                                   &lt;maxInclusive value="99999"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Filters" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Filter" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Status" type="{}FilterStatusType"/>
 *                             &lt;element name="Source">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="IP" type="{}IPType"/>
 *                                       &lt;element name="Bits">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                             &lt;maxInclusive value="32"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Target">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="IP" type="{}IPType"/>
 *                                       &lt;element name="Bits">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                             &lt;maxInclusive value="32"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Protocol" type="{}TunnelProtocolType"/>
 *                             &lt;element name="Ports">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Low" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="High" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
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
    "id",
    "ip",
    "udp",
    "lzw",
    "unused",
    "blocked",
    "encryption",
    "filters"
})
public class Tunnel
    implements Serializable, Cloneable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "ID")
    @XmlSchemaType(name = "unsignedShort")
    protected int id;
    @XmlElement(name = "IP", required = true)
    protected TunnelIP ip;
    @XmlElement(name = "UDP", required = true)
    protected UDP udp;
    @XmlElement(name = "LZW", required = true)
    protected BooleanType lzw;
    @XmlElement(name = "Unused", required = true)
    protected BooleanType unused;
    @XmlElement(name = "Blocked", required = true)
    protected BooleanType blocked;
    @XmlElement(name = "Encryption", required = true)
    protected TunnelEncryption encryption;
    @XmlElement(name = "Filters")
    protected TunnelFilters filters;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

    public boolean isSetID() {
        return true;
    }

    /**
     * Gets the value of the ip property.
     * 
     * @return
     *     possible object is
     *     {@link TunnelIP }
     *     
     */
    public TunnelIP getIP() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     * @param value
     *     allowed object is
     *     {@link TunnelIP }
     *     
     */
    public void setIP(TunnelIP value) {
        this.ip = value;
    }

    public boolean isSetIP() {
        return (this.ip!= null);
    }

    /**
     * Gets the value of the udp property.
     * 
     * @return
     *     possible object is
     *     {@link UDP }
     *     
     */
    public UDP getUDP() {
        return udp;
    }

    /**
     * Sets the value of the udp property.
     * 
     * @param value
     *     allowed object is
     *     {@link UDP }
     *     
     */
    public void setUDP(UDP value) {
        this.udp = value;
    }

    public boolean isSetUDP() {
        return (this.udp!= null);
    }

    /**
     * Gets the value of the lzw property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getLZW() {
        return lzw;
    }

    /**
     * Sets the value of the lzw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setLZW(BooleanType value) {
        this.lzw = value;
    }

    public boolean isSetLZW() {
        return (this.lzw!= null);
    }

    /**
     * Gets the value of the unused property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getUnused() {
        return unused;
    }

    /**
     * Sets the value of the unused property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setUnused(BooleanType value) {
        this.unused = value;
    }

    public boolean isSetUnused() {
        return (this.unused!= null);
    }

    /**
     * Gets the value of the blocked property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getBlocked() {
        return blocked;
    }

    /**
     * Sets the value of the blocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setBlocked(BooleanType value) {
        this.blocked = value;
    }

    public boolean isSetBlocked() {
        return (this.blocked!= null);
    }

    /**
     * Gets the value of the encryption property.
     * 
     * @return
     *     possible object is
     *     {@link TunnelEncryption }
     *     
     */
    public TunnelEncryption getEncryption() {
        return encryption;
    }

    /**
     * Sets the value of the encryption property.
     * 
     * @param value
     *     allowed object is
     *     {@link TunnelEncryption }
     *     
     */
    public void setEncryption(TunnelEncryption value) {
        this.encryption = value;
    }

    public boolean isSetEncryption() {
        return (this.encryption!= null);
    }

    /**
     * Gets the value of the filters property.
     * 
     * @return
     *     possible object is
     *     {@link TunnelFilters }
     *     
     */
    public TunnelFilters getFilters() {
        return filters;
    }

    /**
     * Sets the value of the filters property.
     * 
     * @param value
     *     allowed object is
     *     {@link TunnelFilters }
     *     
     */
    public void setFilters(TunnelFilters value) {
        this.filters = value;
    }

    public boolean isSetFilters() {
        return (this.filters!= null);
    }

    @Override
	public Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }
}
