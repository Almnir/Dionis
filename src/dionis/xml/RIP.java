
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
 *         &lt;element name="Run" type="{}BooleanType"/>
 *         &lt;element name="Version" type="{}RipVersionType"/>
 *         &lt;element name="Routes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Route" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Address" type="{}IPType"/>
 *                             &lt;element name="Interaval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="Version" type="{}RipRouteVersionType"/>
 *                             &lt;element name="Domain" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="Tag" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="Gateway" type="{}IPType"/>
 *                             &lt;element name="Password">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="15"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Split_Horizon" type="{}BooleanType"/>
 *                             &lt;element name="Poisoned_Reverse" type="{}BooleanType"/>
 *                             &lt;element name="Broadcast" type="{}BooleanType"/>
 *                             &lt;element name="Auth" type="{}BooleanType"/>
 *                             &lt;element name="Local" type="{}BooleanType"/>
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
 *         &lt;element name="Filters">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Filter" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Address" type="{}IPType"/>
 *                             &lt;element name="Bits">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                   &lt;maxInclusive value="32"/>
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
 *         &lt;element name="Auth_list">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Auth" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Interface">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;minLength value="1"/>
 *                                   &lt;maxLength value="7"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Domain" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="Password">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="15"/>
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
 *         &lt;element name="Default" type="{}BooleanType"/>
 *         &lt;element name="Merge" type="{}BooleanType"/>
 *         &lt;element name="RIP-98" type="{}BooleanType"/>
 *         &lt;element name="TTL" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
    "run",
    "version",
    "routes",
    "filters",
    "authList",
    "_default",
    "merge",
    "rip98",
    "ttl"
})
public class RIP
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Run", required = true)
    protected BooleanType run;
    @XmlElement(name = "Version", required = true)
    protected RipVersionType version;
    @XmlElement(name = "Routes", required = true)
    protected RipRoutes routes;
    @XmlElement(name = "Filters", required = true)
    protected RipFilters filters;
    @XmlElement(name = "Auth_list", required = true)
    protected AuthList authList;
    @XmlElement(name = "Default", required = true)
    protected BooleanType _default;
    @XmlElement(name = "Merge", required = true)
    protected BooleanType merge;
    @XmlElement(name = "RIP-98", required = true)
    protected BooleanType rip98;
    @XmlElement(name = "TTL")
    @XmlSchemaType(name = "unsignedByte")
    protected short ttl;

    /**
     * Gets the value of the run property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getRun() {
        return run;
    }

    /**
     * Sets the value of the run property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setRun(BooleanType value) {
        this.run = value;
    }

    public boolean isSetRun() {
        return (this.run!= null);
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link RipVersionType }
     *     
     */
    public RipVersionType getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link RipVersionType }
     *     
     */
    public void setVersion(RipVersionType value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

    /**
     * Gets the value of the routes property.
     * 
     * @return
     *     possible object is
     *     {@link RipRoutes }
     *     
     */
    public RipRoutes getRoutes() {
        return routes;
    }

    /**
     * Sets the value of the routes property.
     * 
     * @param value
     *     allowed object is
     *     {@link RipRoutes }
     *     
     */
    public void setRoutes(RipRoutes value) {
        this.routes = value;
    }

    public boolean isSetRoutes() {
        return (this.routes!= null);
    }

    /**
     * Gets the value of the filters property.
     * 
     * @return
     *     possible object is
     *     {@link RipFilters }
     *     
     */
    public RipFilters getFilters() {
        return filters;
    }

    /**
     * Sets the value of the filters property.
     * 
     * @param value
     *     allowed object is
     *     {@link RipFilters }
     *     
     */
    public void setFilters(RipFilters value) {
        this.filters = value;
    }

    public boolean isSetFilters() {
        return (this.filters!= null);
    }

    /**
     * Gets the value of the authList property.
     * 
     * @return
     *     possible object is
     *     {@link AuthList }
     *     
     */
    public AuthList getAuthList() {
        return authList;
    }

    /**
     * Sets the value of the authList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthList }
     *     
     */
    public void setAuthList(AuthList value) {
        this.authList = value;
    }

    public boolean isSetAuthList() {
        return (this.authList!= null);
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setDefault(BooleanType value) {
        this._default = value;
    }

    public boolean isSetDefault() {
        return (this._default!= null);
    }

    /**
     * Gets the value of the merge property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getMerge() {
        return merge;
    }

    /**
     * Sets the value of the merge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setMerge(BooleanType value) {
        this.merge = value;
    }

    public boolean isSetMerge() {
        return (this.merge!= null);
    }

    /**
     * Gets the value of the rip98 property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getRIP98() {
        return rip98;
    }

    /**
     * Sets the value of the rip98 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setRIP98(BooleanType value) {
        this.rip98 = value;
    }

    public boolean isSetRIP98() {
        return (this.rip98 != null);
    }

    /**
     * Gets the value of the ttl property.
     * 
     */
    public short getTTL() {
        return ttl;
    }

    /**
     * Sets the value of the ttl property.
     * 
     */
    public void setTTL(short value) {
        this.ttl = value;
    }

    public boolean isSetTTL() {
        return true;
    }

}
