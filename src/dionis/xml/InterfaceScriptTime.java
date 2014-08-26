
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
 *         &lt;element name="Connection">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Script">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="255"/>
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
    "connection",
    "script"
})
public class InterfaceScriptTime
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Connection")
    protected short connection;
    @XmlElement(name = "Script")
    protected short script;

    /**
     * Gets the value of the connection property.
     * 
     */
    public short getConnection() {
        return connection;
    }

    /**
     * Sets the value of the connection property.
     * 
     */
    public void setConnection(short value) {
        this.connection = value;
    }

    public boolean isSetConnection() {
        return true;
    }

    /**
     * Gets the value of the script property.
     * 
     */
    public short getScript() {
        return script;
    }

    /**
     * Sets the value of the script property.
     * 
     */
    public void setScript(short value) {
        this.script = value;
    }

    public boolean isSetScript() {
        return true;
    }

}
