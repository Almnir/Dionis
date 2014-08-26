
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
 *         &lt;element name="Run" type="{}BooleanType"/>
 *         &lt;element name="Period" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Correction" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Servers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Server" type="{}IPType" maxOccurs="unbounded" minOccurs="0"/>
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
    "period",
    "correction",
    "servers"
})
public class SNTP
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Run", required = true)
    protected BooleanType run;
    @XmlElement(name = "Period")
    @XmlSchemaType(name = "unsignedShort")
    protected int period;
    @XmlElement(name = "Correction")
    @XmlSchemaType(name = "unsignedShort")
    protected int correction;
    @XmlElement(name = "Servers", required = true)
    protected SNTPServers servers;

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
     * Gets the value of the period property.
     * 
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     */
    public void setPeriod(int value) {
        this.period = value;
    }

    public boolean isSetPeriod() {
        return true;
    }

    /**
     * Gets the value of the correction property.
     * 
     */
    public int getCorrection() {
        return correction;
    }

    /**
     * Sets the value of the correction property.
     * 
     */
    public void setCorrection(int value) {
        this.correction = value;
    }

    public boolean isSetCorrection() {
        return true;
    }

    /**
     * Gets the value of the servers property.
     * 
     * @return
     *     possible object is
     *     {@link SNTPServers }
     *     
     */
    public SNTPServers getServers() {
        return servers;
    }

    /**
     * Sets the value of the servers property.
     * 
     * @param value
     *     allowed object is
     *     {@link SNTPServers }
     *     
     */
    public void setServers(SNTPServers value) {
        this.servers = value;
    }

    public boolean isSetServers() {
        return (this.servers!= null);
    }

}
