
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
 *         &lt;element name="SIO" maxOccurs="99" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Number">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                         &lt;maxInclusive value="99"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Speed" type="{}PortSpeedType"/>
 *                   &lt;element name="Bits">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                         &lt;minInclusive value="7"/>
 *                         &lt;maxInclusive value="8"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Control" type="{}PortsSIOControlType"/>
 *                   &lt;element name="Parity" type="{}PortsSIOParityType"/>
 *                   &lt;element name="Direction" type="{}PortsSIODirectionType"/>
 *                   &lt;element name="Stop-bit" type="{}PortStopBitType"/>
 *                   &lt;element name="Modem">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="78"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SYN" maxOccurs="99" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Number">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="99"/>
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
    "sio",
    "syn"
})
public class Ports
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "SIO")
    protected List<SIO> sio;
    @XmlElement(name = "SYN")
    protected List<SYN> syn;

    /**
     * Gets the value of the sio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSIO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SIO }
     * 
     * 
     */
    public List<SIO> getSIO() {
        if (sio == null) {
            sio = new ArrayList<SIO>();
        }
        return this.sio;
    }

    public boolean isSetSIO() {
        return ((this.sio!= null)&&(!this.sio.isEmpty()));
    }

    public void unsetSIO() {
        this.sio = null;
    }

    /**
     * Gets the value of the syn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the syn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSYN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SYN }
     * 
     * 
     */
    public List<SYN> getSYN() {
        if (syn == null) {
            syn = new ArrayList<SYN>();
        }
        return this.syn;
    }

    public boolean isSetSYN() {
        return ((this.syn!= null)&&(!this.syn.isEmpty()));
    }

    public void unsetSYN() {
        this.syn = null;
    }

}
