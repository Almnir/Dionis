
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
 *         &lt;element name="Errors" type="{}BooleanType"/>
 *         &lt;element name="All" type="{}BooleanType"/>
 *         &lt;element name="Detail" type="{}BooleanType"/>
 *         &lt;element name="HEX-dump" type="{}BooleanType"/>
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
    "errors",
    "all",
    "detail",
    "hexDump"
})
public class TracingRoute
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Errors", required = true)
    protected BooleanType errors;
    @XmlElement(name = "All", required = true)
    protected BooleanType all;
    @XmlElement(name = "Detail", required = true)
    protected BooleanType detail;
    @XmlElement(name = "HEX-dump", required = true)
    protected BooleanType hexDump;

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setErrors(BooleanType value) {
        this.errors = value;
    }

    public boolean isSetErrors() {
        return (this.errors!= null);
    }

    /**
     * Gets the value of the all property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getAll() {
        return all;
    }

    /**
     * Sets the value of the all property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setAll(BooleanType value) {
        this.all = value;
    }

    public boolean isSetAll() {
        return (this.all!= null);
    }

    /**
     * Gets the value of the detail property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setDetail(BooleanType value) {
        this.detail = value;
    }

    public boolean isSetDetail() {
        return (this.detail!= null);
    }

    /**
     * Gets the value of the hexDump property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getHEXDump() {
        return hexDump;
    }

    /**
     * Sets the value of the hexDump property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setHEXDump(BooleanType value) {
        this.hexDump = value;
    }

    public boolean isSetHEXDump() {
        return (this.hexDump!= null);
    }

}
