
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
 *         &lt;element name="Seq" type="{}BooleanType" minOccurs="0"/>
 *         &lt;element name="Chksum" type="{}BooleanType" minOccurs="0"/>
 *         &lt;element name="TOS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Copy" type="{}BooleanType"/>
 *                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DF" type="{}InterfaceDFType" minOccurs="0"/>
 *         &lt;element name="Board" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;maxInclusive value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Frame" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="Buf" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="Delay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="Interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="Wait" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="Type" type="{}InterfaceParametrType" minOccurs="0"/>
 *         &lt;element name="Ports" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Script" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Retries">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                         &lt;maxInclusive value="5"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Time">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Connection">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                   &lt;maxInclusive value="255"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Script">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                   &lt;maxInclusive value="255"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Address">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="189"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Elements">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Element" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Get">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;maxLength value="80"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="Send">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;maxLength value="80"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
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
 *         &lt;element name="Send" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Recv" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Media" type="{}InterfaceParametrsMediaType" minOccurs="0"/>
 *         &lt;element name="Mode" type="{}InterfaceParametrsModeType" minOccurs="0"/>
 *         &lt;element name="Auth_local" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Auth" type="{}InterfaceAuthorityType"/>
 *                   &lt;element name="Name">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Password">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Auth_remote" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Auth" type="{}InterfaceAuthorityType"/>
 *                   &lt;element name="Name">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Password">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="VNID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;maxInclusive value="4095"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Base_interface" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Bandwidth" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Bandrecv" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Mac" type="{}MACType" minOccurs="0"/>
 *         &lt;element name="VLANs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="VLAN" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IP" type="{}IPType"/>
 *                             &lt;element name="Bits">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                   &lt;maxInclusive value="32"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="VNID">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *                                   &lt;maxInclusive value="4095"/>
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
    "seq",
    "chksum",
    "tos",
    "df",
    "board",
    "frame",
    "buf",
    "delay",
    "interval",
    "wait",
    "type",
    "ports",
    "script",
    "send",
    "recv",
    "media",
    "mode",
    "authLocal",
    "authRemote",
    "vnid",
    "baseInterface",
    "bandwidth",
    "bandrecv",
    "mac",
    "vlaNs"
})
public class InterfaceParametrs
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Seq")
    protected BooleanType seq;
    @XmlElement(name = "Chksum")
    protected BooleanType chksum;
    @XmlElement(name = "TOS")
    protected TOS tos;
    @XmlElement(name = "DF")
    protected InterfaceDFType df;
    @XmlElement(name = "Board")
    protected Short board;
    @XmlElement(name = "Frame")
    @XmlSchemaType(name = "unsignedByte")
    protected Short frame;
    @XmlElement(name = "Buf")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer buf;
    @XmlElement(name = "Delay")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer delay;
    @XmlElement(name = "Interval")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer interval;
    @XmlElement(name = "Wait")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer wait;
    @XmlElement(name = "Type")
    protected InterfaceParametrType type;
    @XmlElement(name = "Ports")
    protected String ports;
    @XmlElement(name = "Script")
    protected Script script;
    @XmlElement(name = "Send")
    protected Integer send;
    @XmlElement(name = "Recv")
    protected Integer recv;
    @XmlElement(name = "Media")
    protected InterfaceParametrsMediaType media;
    @XmlElement(name = "Mode")
    protected InterfaceParametrsModeType mode;
    @XmlElement(name = "Auth_local")
    protected AuthLocal authLocal;
    @XmlElement(name = "Auth_remote")
    protected AuthRemote authRemote;
    @XmlElement(name = "VNID")
    protected Integer vnid;
    @XmlElement(name = "Base_interface")
    protected String baseInterface;
    @XmlElement(name = "Bandwidth")
    protected Integer bandwidth;
    @XmlElement(name = "Bandrecv")
    protected Integer bandrecv;
    @XmlElement(name = "Mac")
    protected String mac;
    @XmlElement(name = "VLANs")
    protected InterfaceVLANs vlaNs;

    /**
     * Gets the value of the seq property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getSeq() {
        return seq;
    }

    /**
     * Sets the value of the seq property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setSeq(BooleanType value) {
        this.seq = value;
    }

    public boolean isSetSeq() {
        return (this.seq!= null);
    }

    /**
     * Gets the value of the chksum property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getChksum() {
        return chksum;
    }

    /**
     * Sets the value of the chksum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setChksum(BooleanType value) {
        this.chksum = value;
    }

    public boolean isSetChksum() {
        return (this.chksum!= null);
    }

    /**
     * Gets the value of the tos property.
     * 
     * @return
     *     possible object is
     *     {@link TOS }
     *     
     */
    public TOS getTOS() {
        return tos;
    }

    /**
     * Sets the value of the tos property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOS }
     *     
     */
    public void setTOS(TOS value) {
        this.tos = value;
    }

    public boolean isSetTOS() {
        return (this.tos!= null);
    }

    /**
     * Gets the value of the df property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceDFType }
     *     
     */
    public InterfaceDFType getDF() {
        return df;
    }

    /**
     * Sets the value of the df property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceDFType }
     *     
     */
    public void setDF(InterfaceDFType value) {
        this.df = value;
    }

    public boolean isSetDF() {
        return (this.df!= null);
    }

    /**
     * Gets the value of the board property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getBoard() {
        return board;
    }

    /**
     * Sets the value of the board property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setBoard(Short value) {
        this.board = value;
    }

    public boolean isSetBoard() {
        return (this.board!= null);
    }

    /**
     * Gets the value of the frame property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getFrame() {
        return frame;
    }

    /**
     * Sets the value of the frame property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setFrame(Short value) {
        this.frame = value;
    }

    public boolean isSetFrame() {
        return (this.frame!= null);
    }

    /**
     * Gets the value of the buf property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBuf() {
        return buf;
    }

    /**
     * Sets the value of the buf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBuf(Integer value) {
        this.buf = value;
    }

    public boolean isSetBuf() {
        return (this.buf!= null);
    }

    /**
     * Gets the value of the delay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDelay() {
        return delay;
    }

    /**
     * Sets the value of the delay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDelay(Integer value) {
        this.delay = value;
    }

    public boolean isSetDelay() {
        return (this.delay!= null);
    }

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInterval(Integer value) {
        this.interval = value;
    }

    public boolean isSetInterval() {
        return (this.interval!= null);
    }

    /**
     * Gets the value of the wait property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWait() {
        return wait;
    }

    /**
     * Sets the value of the wait property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWait(Integer value) {
        this.wait = value;
    }

    public boolean isSetWait() {
        return (this.wait!= null);
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceParametrType }
     *     
     */
    public InterfaceParametrType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceParametrType }
     *     
     */
    public void setType(InterfaceParametrType value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Gets the value of the ports property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPorts() {
        return ports;
    }

    /**
     * Sets the value of the ports property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPorts(String value) {
        this.ports = value;
    }

    public boolean isSetPorts() {
        return (this.ports!= null);
    }

    /**
     * Gets the value of the script property.
     * 
     * @return
     *     possible object is
     *     {@link Script }
     *     
     */
    public Script getScript() {
        return script;
    }

    /**
     * Sets the value of the script property.
     * 
     * @param value
     *     allowed object is
     *     {@link Script }
     *     
     */
    public void setScript(Script value) {
        this.script = value;
    }

    public boolean isSetScript() {
        return (this.script!= null);
    }

    /**
     * Gets the value of the send property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSend() {
        return send;
    }

    /**
     * Sets the value of the send property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSend(Integer value) {
        this.send = value;
    }

    public boolean isSetSend() {
        return (this.send!= null);
    }

    /**
     * Gets the value of the recv property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecv() {
        return recv;
    }

    /**
     * Sets the value of the recv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecv(Integer value) {
        this.recv = value;
    }

    public boolean isSetRecv() {
        return (this.recv!= null);
    }

    /**
     * Gets the value of the media property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceParametrsMediaType }
     *     
     */
    public InterfaceParametrsMediaType getMedia() {
        return media;
    }

    /**
     * Sets the value of the media property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceParametrsMediaType }
     *     
     */
    public void setMedia(InterfaceParametrsMediaType value) {
        this.media = value;
    }

    public boolean isSetMedia() {
        return (this.media!= null);
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceParametrsModeType }
     *     
     */
    public InterfaceParametrsModeType getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceParametrsModeType }
     *     
     */
    public void setMode(InterfaceParametrsModeType value) {
        this.mode = value;
    }

    public boolean isSetMode() {
        return (this.mode!= null);
    }

    /**
     * Gets the value of the authLocal property.
     * 
     * @return
     *     possible object is
     *     {@link AuthLocal }
     *     
     */
    public AuthLocal getAuthLocal() {
        return authLocal;
    }

    /**
     * Sets the value of the authLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthLocal }
     *     
     */
    public void setAuthLocal(AuthLocal value) {
        this.authLocal = value;
    }

    public boolean isSetAuthLocal() {
        return (this.authLocal!= null);
    }

    /**
     * Gets the value of the authRemote property.
     * 
     * @return
     *     possible object is
     *     {@link AuthRemote }
     *     
     */
    public AuthRemote getAuthRemote() {
        return authRemote;
    }

    /**
     * Sets the value of the authRemote property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthRemote }
     *     
     */
    public void setAuthRemote(AuthRemote value) {
        this.authRemote = value;
    }

    public boolean isSetAuthRemote() {
        return (this.authRemote!= null);
    }

    /**
     * Gets the value of the vnid property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVNID() {
        return vnid;
    }

    /**
     * Sets the value of the vnid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVNID(Integer value) {
        this.vnid = value;
    }

    public boolean isSetVNID() {
        return (this.vnid!= null);
    }

    /**
     * Gets the value of the baseInterface property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseInterface() {
        return baseInterface;
    }

    /**
     * Sets the value of the baseInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseInterface(String value) {
        this.baseInterface = value;
    }

    public boolean isSetBaseInterface() {
        return (this.baseInterface!= null);
    }

    /**
     * Gets the value of the bandwidth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBandwidth() {
        return bandwidth;
    }

    /**
     * Sets the value of the bandwidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBandwidth(Integer value) {
        this.bandwidth = value;
    }

    public boolean isSetBandwidth() {
        return (this.bandwidth!= null);
    }

    /**
     * Gets the value of the bandrecv property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBandrecv() {
        return bandrecv;
    }

    /**
     * Sets the value of the bandrecv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBandrecv(Integer value) {
        this.bandrecv = value;
    }

    public boolean isSetBandrecv() {
        return (this.bandrecv!= null);
    }

    /**
     * Gets the value of the mac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMac() {
        return mac;
    }

    /**
     * Sets the value of the mac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMac(String value) {
        this.mac = value;
    }

    public boolean isSetMac() {
        return (this.mac!= null);
    }

    /**
     * Gets the value of the vlaNs property.
     * 
     * @return
     *     possible object is
     *     {@link InterfaceVLANs }
     *     
     */
    public InterfaceVLANs getVLANs() {
        return vlaNs;
    }

    /**
     * Sets the value of the vlaNs property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterfaceVLANs }
     *     
     */
    public void setVLANs(InterfaceVLANs value) {
        this.vlaNs = value;
    }

    public boolean isSetVLANs() {
        return (this.vlaNs!= null);
    }

}
