
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
 *         &lt;element name="log" type="{}BooleanType"/>
 *         &lt;element name="log_user" type="{}BooleanType"/>
 *         &lt;element name="log_send" type="{}BooleanType"/>
 *         &lt;element name="log_tcp" type="{}BooleanType"/>
 *         &lt;element name="log_sess" type="{}BooleanType"/>
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
    "log",
    "logUser",
    "logSend",
    "logTcp",
    "logSess"
})
public class Control
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(required = true)
    protected BooleanType log;
    @XmlElement(name = "log_user", required = true)
    protected BooleanType logUser;
    @XmlElement(name = "log_send", required = true)
    protected BooleanType logSend;
    @XmlElement(name = "log_tcp", required = true)
    protected BooleanType logTcp;
    @XmlElement(name = "log_sess", required = true)
    protected BooleanType logSess;

    /**
     * Gets the value of the log property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getLog() {
        return log;
    }

    /**
     * Sets the value of the log property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setLog(BooleanType value) {
        this.log = value;
    }

    public boolean isSetLog() {
        return (this.log!= null);
    }

    /**
     * Gets the value of the logUser property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getLogUser() {
        return logUser;
    }

    /**
     * Sets the value of the logUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setLogUser(BooleanType value) {
        this.logUser = value;
    }

    public boolean isSetLogUser() {
        return (this.logUser!= null);
    }

    /**
     * Gets the value of the logSend property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getLogSend() {
        return logSend;
    }

    /**
     * Sets the value of the logSend property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setLogSend(BooleanType value) {
        this.logSend = value;
    }

    public boolean isSetLogSend() {
        return (this.logSend!= null);
    }

    /**
     * Gets the value of the logTcp property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getLogTcp() {
        return logTcp;
    }

    /**
     * Sets the value of the logTcp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setLogTcp(BooleanType value) {
        this.logTcp = value;
    }

    public boolean isSetLogTcp() {
        return (this.logTcp!= null);
    }

    /**
     * Gets the value of the logSess property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanType }
     *     
     */
    public BooleanType getLogSess() {
        return logSess;
    }

    /**
     * Sets the value of the logSess property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanType }
     *     
     */
    public void setLogSess(BooleanType value) {
        this.logSess = value;
    }

    public boolean isSetLogSess() {
        return (this.logSess!= null);
    }

}
