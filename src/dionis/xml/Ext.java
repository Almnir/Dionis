
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
 *         &lt;element name="IP" type="{}BooleanType"/>
 *         &lt;element name="Offset" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="Operation" type="{}FilterOperationType"/>
 *         &lt;element name="Data">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="2"/>
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Link" type="{}FilterLinkType"/>
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
    "offset",
    "operation",
    "data",
    "link"
})
public class Ext
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "IP", required = true)
    protected BooleanType ip;
    @XmlElement(name = "Offset")
    @XmlSchemaType(name = "unsignedByte")
    protected short offset;
    @XmlElement(name = "Operation", required = true)
    protected FilterOperationType operation;
    @XmlElement(name = "Data", required = true)
    protected String data;
    @XmlElement(name = "Link", required = true)
    protected FilterLinkType link;

    /**
     * Gets the value of the ip property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getIP() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setIP(BooleanType value) {
        this.ip = value;
    }

    public boolean isSetIP() {
        return (this.ip!= null);
    }

    /**
     * Gets the value of the offset property.
     * 
     */
    public short getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     */
    public void setOffset(short value) {
        this.offset = value;
    }

    public boolean isSetOffset() {
        return true;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link FilterOperationType }
     *     
     */
    public FilterOperationType getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterOperationType }
     *     
     */
    public void setOperation(FilterOperationType value) {
        this.operation = value;
    }

    public boolean isSetOperation() {
        return (this.operation!= null);
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setData(String value) {
        this.data = value;
    }

    public boolean isSetData() {
        return (this.data!= null);
    }

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link FilterLinkType }
     *     
     */
    public FilterLinkType getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterLinkType }
     *     
     */
    public void setLink(FilterLinkType value) {
        this.link = value;
    }

    public boolean isSetLink() {
        return (this.link!= null);
    }

}
