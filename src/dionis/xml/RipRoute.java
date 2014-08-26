
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
 *         &lt;element name="Address" type="{}IPType"/>
 *         &lt;element name="Interaval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Version" type="{}RipRouteVersionType"/>
 *         &lt;element name="Domain" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Tag" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Gateway" type="{}IPType"/>
 *         &lt;element name="Password">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Split_Horizon" type="{}BooleanType"/>
 *         &lt;element name="Poisoned_Reverse" type="{}BooleanType"/>
 *         &lt;element name="Broadcast" type="{}BooleanType"/>
 *         &lt;element name="Auth" type="{}BooleanType"/>
 *         &lt;element name="Local" type="{}BooleanType"/>
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
    "address",
    "interaval",
    "version",
    "domain",
    "tag",
    "gateway",
    "password",
    "splitHorizon",
    "poisonedReverse",
    "broadcast",
    "auth",
    "local"
})
public class RipRoute
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "Interaval")
    @XmlSchemaType(name = "unsignedShort")
    protected int interaval;
    @XmlElement(name = "Version", required = true)
    protected RipRouteVersionType version;
    @XmlElement(name = "Domain")
    @XmlSchemaType(name = "unsignedShort")
    protected int domain;
    @XmlElement(name = "Tag")
    @XmlSchemaType(name = "unsignedShort")
    protected int tag;
    @XmlElement(name = "Gateway", required = true)
    protected String gateway;
    @XmlElement(name = "Password", required = true)
    protected String password;
    @XmlElement(name = "Split_Horizon", required = true)
    protected BooleanType splitHorizon;
    @XmlElement(name = "Poisoned_Reverse", required = true)
    protected BooleanType poisonedReverse;
    @XmlElement(name = "Broadcast", required = true)
    protected BooleanType broadcast;
    @XmlElement(name = "Auth", required = true)
    protected BooleanType auth;
    @XmlElement(name = "Local", required = true)
    protected BooleanType local;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    public boolean isSetAddress() {
        return (this.address!= null);
    }

    /**
     * Gets the value of the interaval property.
     * 
     */
    public int getInteraval() {
        return interaval;
    }

    /**
     * Sets the value of the interaval property.
     * 
     */
    public void setInteraval(int value) {
        this.interaval = value;
    }

    public boolean isSetInteraval() {
        return true;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link RipRouteVersionType }
     *     
     */
    public RipRouteVersionType getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link RipRouteVersionType }
     *     
     */
    public void setVersion(RipRouteVersionType value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

    /**
     * Gets the value of the domain property.
     * 
     */
    public int getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     */
    public void setDomain(int value) {
        this.domain = value;
    }

    public boolean isSetDomain() {
        return true;
    }

    /**
     * Gets the value of the tag property.
     * 
     */
    public int getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     */
    public void setTag(int value) {
        this.tag = value;
    }

    public boolean isSetTag() {
        return true;
    }

    /**
     * Gets the value of the gateway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * Sets the value of the gateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGateway(String value) {
        this.gateway = value;
    }

    public boolean isSetGateway() {
        return (this.gateway!= null);
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    public boolean isSetPassword() {
        return (this.password!= null);
    }

    /**
     * Gets the value of the splitHorizon property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSplitHorizon() {
        return splitHorizon;
    }

    /**
     * Sets the value of the splitHorizon property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSplitHorizon(BooleanType value) {
        this.splitHorizon = value;
    }

    public boolean isSetSplitHorizon() {
        return (this.splitHorizon!= null);
    }

    /**
     * Gets the value of the poisonedReverse property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getPoisonedReverse() {
        return poisonedReverse;
    }

    /**
     * Sets the value of the poisonedReverse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setPoisonedReverse(BooleanType value) {
        this.poisonedReverse = value;
    }

    public boolean isSetPoisonedReverse() {
        return (this.poisonedReverse!= null);
    }

    /**
     * Gets the value of the broadcast property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getBroadcast() {
        return broadcast;
    }

    /**
     * Sets the value of the broadcast property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setBroadcast(BooleanType value) {
        this.broadcast = value;
    }

    public boolean isSetBroadcast() {
        return (this.broadcast!= null);
    }

    /**
     * Gets the value of the auth property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getAuth() {
        return auth;
    }

    /**
     * Sets the value of the auth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setAuth(BooleanType value) {
        this.auth = value;
    }

    public boolean isSetAuth() {
        return (this.auth!= null);
    }

    /**
     * Gets the value of the local property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getLocal() {
        return local;
    }

    /**
     * Sets the value of the local property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setLocal(BooleanType value) {
        this.local = value;
    }

    public boolean isSetLocal() {
        return (this.local!= null);
    }

}
