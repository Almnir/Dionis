
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
 *         &lt;element name="Inactive">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Text">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="22"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Awake" type="{}ConsoleScreenBlankingAwakeType"/>
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
    "inactive",
    "text",
    "awake"
})
public class ScreenBlanking
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Inactive")
    protected short inactive;
    @XmlElement(name = "Text", required = true)
    protected String text;
    @XmlElement(name = "Awake", required = true)
    protected ConsoleScreenBlankingAwakeType awake;

    /**
     * Gets the value of the inactive property.
     * 
     */
    public short getInactive() {
        return inactive;
    }

    /**
     * Sets the value of the inactive property.
     * 
     */
    public void setInactive(short value) {
        this.inactive = value;
    }

    public boolean isSetInactive() {
        return true;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    public boolean isSetText() {
        return (this.text!= null);
    }

    /**
     * Gets the value of the awake property.
     * 
     * @return
     *     possible object is
     *     {@link ConsoleScreenBlankingAwakeType }
     *     
     */
    public ConsoleScreenBlankingAwakeType getAwake() {
        return awake;
    }

    /**
     * Sets the value of the awake property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsoleScreenBlankingAwakeType }
     *     
     */
    public void setAwake(ConsoleScreenBlankingAwakeType value) {
        this.awake = value;
    }

    public boolean isSetAwake() {
        return (this.awake!= null);
    }

}
