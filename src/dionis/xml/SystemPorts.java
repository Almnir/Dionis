
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
 *         &lt;element name="SIO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="X25" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SYN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IPL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TCP" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "x25",
    "lan",
    "syn",
    "ipl",
    "tcp"
})
public class SystemPorts
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "SIO", required = true)
    protected String sio;
    @XmlElement(name = "X25", required = true)
    protected String x25;
    @XmlElement(name = "LAN", required = true)
    protected String lan;
    @XmlElement(name = "SYN", required = true)
    protected String syn;
    @XmlElement(name = "IPL", required = true)
    protected String ipl;
    @XmlElement(name = "TCP", required = true)
    protected String tcp;

    /**
     * Gets the value of the sio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIO() {
        return sio;
    }

    /**
     * Sets the value of the sio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIO(String value) {
        this.sio = value;
    }

    public boolean isSetSIO() {
        return (this.sio!= null);
    }

    /**
     * Gets the value of the x25 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX25() {
        return x25;
    }

    /**
     * Sets the value of the x25 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX25(String value) {
        this.x25 = value;
    }

    public boolean isSetX25() {
        return (this.x25 != null);
    }

    /**
     * Gets the value of the lan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLAN() {
        return lan;
    }

    /**
     * Sets the value of the lan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLAN(String value) {
        this.lan = value;
    }

    public boolean isSetLAN() {
        return (this.lan!= null);
    }

    /**
     * Gets the value of the syn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSYN() {
        return syn;
    }

    /**
     * Sets the value of the syn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSYN(String value) {
        this.syn = value;
    }

    public boolean isSetSYN() {
        return (this.syn!= null);
    }

    /**
     * Gets the value of the ipl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPL() {
        return ipl;
    }

    /**
     * Sets the value of the ipl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPL(String value) {
        this.ipl = value;
    }

    public boolean isSetIPL() {
        return (this.ipl!= null);
    }

    /**
     * Gets the value of the tcp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTCP() {
        return tcp;
    }

    /**
     * Sets the value of the tcp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTCP(String value) {
        this.tcp = value;
    }

    public boolean isSetTCP() {
        return (this.tcp!= null);
    }

}
