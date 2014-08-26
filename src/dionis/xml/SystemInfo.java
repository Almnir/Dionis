
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
 *         &lt;element name="Full_name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Release" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Service" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Dionis_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Dionis_key_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Ports">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SIO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="X25" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="LAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SYN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="IPL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TCP" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "fullName",
    "version",
    "release",
    "service",
    "dionisNumber",
    "dionisKeyCode",
    "ports"
})
public class SystemInfo
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Full_name", required = true)
    protected String fullName;
    @XmlElement(name = "Version", required = true)
    protected String version;
    @XmlElement(name = "Release", required = true)
    protected String release;
    @XmlElement(name = "Service", required = true)
    protected String service;
    @XmlElement(name = "Dionis_number", required = true)
    protected String dionisNumber;
    @XmlElement(name = "Dionis_key_code", required = true)
    protected String dionisKeyCode;
    @XmlElement(name = "Ports", required = true)
    protected SystemPorts ports;

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    public boolean isSetFullName() {
        return (this.fullName!= null);
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

    /**
     * Gets the value of the release property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelease() {
        return release;
    }

    /**
     * Sets the value of the release property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelease(String value) {
        this.release = value;
    }

    public boolean isSetRelease() {
        return (this.release!= null);
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

    public boolean isSetService() {
        return (this.service!= null);
    }

    /**
     * Gets the value of the dionisNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDionisNumber() {
        return dionisNumber;
    }

    /**
     * Sets the value of the dionisNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDionisNumber(String value) {
        this.dionisNumber = value;
    }

    public boolean isSetDionisNumber() {
        return (this.dionisNumber!= null);
    }

    /**
     * Gets the value of the dionisKeyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDionisKeyCode() {
        return dionisKeyCode;
    }

    /**
     * Sets the value of the dionisKeyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDionisKeyCode(String value) {
        this.dionisKeyCode = value;
    }

    public boolean isSetDionisKeyCode() {
        return (this.dionisKeyCode!= null);
    }

    /**
     * Gets the value of the ports property.
     * 
     * @return
     *     possible object is
     *     {@link SystemPorts }
     *     
     */
    public SystemPorts getPorts() {
        return ports;
    }

    /**
     * Sets the value of the ports property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemPorts }
     *     
     */
    public void setPorts(SystemPorts value) {
        this.ports = value;
    }

    public boolean isSetPorts() {
        return (this.ports!= null);
    }

}
