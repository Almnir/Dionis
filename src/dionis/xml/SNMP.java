
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
 *         &lt;element name="Run" type="{}BooleanType"/>
 *         &lt;element name="Packetsize">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;minInclusive value="484"/>
 *               &lt;maxInclusive value="4096"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sysContact">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="127"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sysLocation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="127"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Communitys">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Community" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Password">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="63"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Filter">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;minLength value="1"/>
 *                                   &lt;maxLength value="8"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Read_only" type="{}BooleanType"/>
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
 *         &lt;element name="Traps">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Trap" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Address" type="{}IPType"/>
 *                             &lt;element name="Port" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="Version" type="{}SNMPTrapVersionType"/>
 *                             &lt;element name="Password">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="63"/>
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
    "packetsize",
    "sysContact",
    "sysLocation",
    "communitys",
    "traps"
})
public class SNMP
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Run", required = true)
    protected BooleanType run;
    @XmlElement(name = "Packetsize")
    protected int packetsize;
    @XmlElement(required = true)
    protected String sysContact;
    @XmlElement(required = true)
    protected String sysLocation;
    @XmlElement(name = "Communitys", required = true)
    protected Communitys communitys;
    @XmlElement(name = "Traps", required = true)
    protected Traps traps;

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
     * Gets the value of the packetsize property.
     * 
     */
    public int getPacketsize() {
        return packetsize;
    }

    /**
     * Sets the value of the packetsize property.
     * 
     */
    public void setPacketsize(int value) {
        this.packetsize = value;
    }

    public boolean isSetPacketsize() {
        return true;
    }

    /**
     * Gets the value of the sysContact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysContact() {
        return sysContact;
    }

    /**
     * Sets the value of the sysContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysContact(String value) {
        this.sysContact = value;
    }

    public boolean isSetSysContact() {
        return (this.sysContact!= null);
    }

    /**
     * Gets the value of the sysLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysLocation() {
        return sysLocation;
    }

    /**
     * Sets the value of the sysLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysLocation(String value) {
        this.sysLocation = value;
    }

    public boolean isSetSysLocation() {
        return (this.sysLocation!= null);
    }

    /**
     * Gets the value of the communitys property.
     * 
     * @return
     *     possible object is
     *     {@link Communitys }
     *     
     */
    public Communitys getCommunitys() {
        return communitys;
    }

    /**
     * Sets the value of the communitys property.
     * 
     * @param value
     *     allowed object is
     *     {@link Communitys }
     *     
     */
    public void setCommunitys(Communitys value) {
        this.communitys = value;
    }

    public boolean isSetCommunitys() {
        return (this.communitys!= null);
    }

    /**
     * Gets the value of the traps property.
     * 
     * @return
     *     possible object is
     *     {@link Traps }
     *     
     */
    public Traps getTraps() {
        return traps;
    }

    /**
     * Sets the value of the traps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Traps }
     *     
     */
    public void setTraps(Traps value) {
        this.traps = value;
    }

    public boolean isSetTraps() {
        return (this.traps!= null);
    }

}
