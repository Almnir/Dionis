
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
 *         &lt;element name="IP" type="{}IPType"/>
 *         &lt;element name="MSS">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;minInclusive value="512"/>
 *               &lt;maxInclusive value="8192"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Window">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;minInclusive value="1024"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TTL">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TCB">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;minInclusive value="16"/>
 *               &lt;maxInclusive value="450"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TCBBuf">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *               &lt;minInclusive value="8"/>
 *               &lt;maxInclusive value="64"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Proxy">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;minInclusive value="8"/>
 *               &lt;maxInclusive value="225"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Cluster">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Mode" type="{}ClusterModeType"/>
 *                   &lt;element name="Timer">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="60"/>
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
    "ip",
    "mss",
    "window",
    "ttl",
    "tcb",
    "tcbBuf",
    "proxy",
    "cluster"
})
public class BaseConsts
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "IP", required = true)
    protected String ip;
    @XmlElement(name = "MSS")
    protected short mss;
    @XmlElement(name = "Window")
    protected int window;
    @XmlElement(name = "TTL")
    protected short ttl;
    @XmlElement(name = "TCB")
    protected short tcb;
    @XmlElement(name = "TCBBuf")
    protected byte tcbBuf;
    @XmlElement(name = "Proxy")
    protected short proxy;
    @XmlElement(name = "Cluster", required = true)
    protected Cluster cluster;

    /**
     * Gets the value of the ip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIP() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIP(String value) {
        this.ip = value;
    }

    public boolean isSetIP() {
        return (this.ip!= null);
    }

    /**
     * Gets the value of the mss property.
     * 
     */
    public short getMSS() {
        return mss;
    }

    /**
     * Sets the value of the mss property.
     * 
     */
    public void setMSS(short value) {
        this.mss = value;
    }

    public boolean isSetMSS() {
        return true;
    }

    /**
     * Gets the value of the window property.
     * 
     */
    public int getWindow() {
        return window;
    }

    /**
     * Sets the value of the window property.
     * 
     */
    public void setWindow(int value) {
        this.window = value;
    }

    public boolean isSetWindow() {
        return true;
    }

    /**
     * Gets the value of the ttl property.
     * 
     */
    public short getTTL() {
        return ttl;
    }

    /**
     * Sets the value of the ttl property.
     * 
     */
    public void setTTL(short value) {
        this.ttl = value;
    }

    public boolean isSetTTL() {
        return true;
    }

    /**
     * Gets the value of the tcb property.
     * 
     */
    public short getTCB() {
        return tcb;
    }

    /**
     * Sets the value of the tcb property.
     * 
     */
    public void setTCB(short value) {
        this.tcb = value;
    }

    public boolean isSetTCB() {
        return true;
    }

    /**
     * Gets the value of the tcbBuf property.
     * 
     */
    public byte getTCBBuf() {
        return tcbBuf;
    }

    /**
     * Sets the value of the tcbBuf property.
     * 
     */
    public void setTCBBuf(byte value) {
        this.tcbBuf = value;
    }

    public boolean isSetTCBBuf() {
        return true;
    }

    /**
     * Gets the value of the proxy property.
     * 
     */
    public short getProxy() {
        return proxy;
    }

    /**
     * Sets the value of the proxy property.
     * 
     */
    public void setProxy(short value) {
        this.proxy = value;
    }

    public boolean isSetProxy() {
        return true;
    }

    /**
     * Gets the value of the cluster property.
     * 
     * @return
     *     possible object is
     *     {@link Cluster }
     *     
     */
    public Cluster getCluster() {
        return cluster;
    }

    /**
     * Sets the value of the cluster property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cluster }
     *     
     */
    public void setCluster(Cluster value) {
        this.cluster = value;
    }

    public boolean isSetCluster() {
        return (this.cluster!= null);
    }

}
