
package dionis.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Static" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{}IPType"/>
 *                   &lt;element name="MAC" type="{}MACType"/>
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
    "_static"
})
public class ARPTable
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Static")
    protected List<ARPTableStatic> _static;

    /**
     * Gets the value of the static property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the static property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ARPTableStatic }
     * 
     * 
     */
    public List<ARPTableStatic> getStatic() {
        if (_static == null) {
            _static = new ArrayList<ARPTableStatic>();
        }
        return this._static;
    }

    public boolean isSetStatic() {
        return ((this._static!= null)&&(!this._static.isEmpty()));
    }

    public void unsetStatic() {
        this._static = null;
    }

}
