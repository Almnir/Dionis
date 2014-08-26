
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
 *         &lt;element name="Keyboard" type="{}ConsoleKeyboardType"/>
 *         &lt;element name="Editor" type="{}ConsoleEditorType"/>
 *         &lt;element name="Monitoring" type="{}ConsoleMonitoringType"/>
 *         &lt;element name="Ports_led" type="{}ConsolePortsLedType"/>
 *         &lt;element name="Time_led" type="{}ConsoleTimeLedType"/>
 *         &lt;element name="Screen_blanking">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Inactive">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                         &lt;maxInclusive value="30"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Text">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="22"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Awake" type="{}ConsoleScreenBlankingAwakeType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AutoReset">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Day" type="{}WeekDayType"/>
 *                             &lt;element name="Houre">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                   &lt;maxInclusive value="23"/>
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
    "keyboard",
    "editor",
    "monitoring",
    "portsLed",
    "timeLed",
    "screenBlanking",
    "autoReset"
})
public class Console
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Keyboard", required = true)
    protected ConsoleKeyboardType keyboard;
    @XmlElement(name = "Editor", required = true)
    protected ConsoleEditorType editor;
    @XmlElement(name = "Monitoring", required = true)
    protected ConsoleMonitoringType monitoring;
    @XmlElement(name = "Ports_led", required = true)
    protected ConsolePortsLedType portsLed;
    @XmlElement(name = "Time_led", required = true)
    protected ConsoleTimeLedType timeLed;
    @XmlElement(name = "Screen_blanking", required = true)
    protected ScreenBlanking screenBlanking;
    @XmlElement(name = "AutoReset", required = true)
    protected AutoReset autoReset;

    /**
     * Gets the value of the keyboard property.
     * 
     * @return
     *     possible object is
     *     {@link ConsoleKeyboardType }
     *     
     */
    public ConsoleKeyboardType getKeyboard() {
        return keyboard;
    }

    /**
     * Sets the value of the keyboard property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsoleKeyboardType }
     *     
     */
    public void setKeyboard(ConsoleKeyboardType value) {
        this.keyboard = value;
    }

    public boolean isSetKeyboard() {
        return (this.keyboard!= null);
    }

    /**
     * Gets the value of the editor property.
     * 
     * @return
     *     possible object is
     *     {@link ConsoleEditorType }
     *     
     */
    public ConsoleEditorType getEditor() {
        return editor;
    }

    /**
     * Sets the value of the editor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsoleEditorType }
     *     
     */
    public void setEditor(ConsoleEditorType value) {
        this.editor = value;
    }

    public boolean isSetEditor() {
        return (this.editor!= null);
    }

    /**
     * Gets the value of the monitoring property.
     * 
     * @return
     *     possible object is
     *     {@link ConsoleMonitoringType }
     *     
     */
    public ConsoleMonitoringType getMonitoring() {
        return monitoring;
    }

    /**
     * Sets the value of the monitoring property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsoleMonitoringType }
     *     
     */
    public void setMonitoring(ConsoleMonitoringType value) {
        this.monitoring = value;
    }

    public boolean isSetMonitoring() {
        return (this.monitoring!= null);
    }

    /**
     * Gets the value of the portsLed property.
     * 
     * @return
     *     possible object is
     *     {@link ConsolePortsLedType }
     *     
     */
    public ConsolePortsLedType getPortsLed() {
        return portsLed;
    }

    /**
     * Sets the value of the portsLed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsolePortsLedType }
     *     
     */
    public void setPortsLed(ConsolePortsLedType value) {
        this.portsLed = value;
    }

    public boolean isSetPortsLed() {
        return (this.portsLed!= null);
    }

    /**
     * Gets the value of the timeLed property.
     * 
     * @return
     *     possible object is
     *     {@link ConsoleTimeLedType }
     *     
     */
    public ConsoleTimeLedType getTimeLed() {
        return timeLed;
    }

    /**
     * Sets the value of the timeLed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsoleTimeLedType }
     *     
     */
    public void setTimeLed(ConsoleTimeLedType value) {
        this.timeLed = value;
    }

    public boolean isSetTimeLed() {
        return (this.timeLed!= null);
    }

    /**
     * Gets the value of the screenBlanking property.
     * 
     * @return
     *     possible object is
     *     {@link ScreenBlanking }
     *     
     */
    public ScreenBlanking getScreenBlanking() {
        return screenBlanking;
    }

    /**
     * Sets the value of the screenBlanking property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScreenBlanking }
     *     
     */
    public void setScreenBlanking(ScreenBlanking value) {
        this.screenBlanking = value;
    }

    public boolean isSetScreenBlanking() {
        return (this.screenBlanking!= null);
    }

    /**
     * Gets the value of the autoReset property.
     * 
     * @return
     *     possible object is
     *     {@link AutoReset }
     *     
     */
    public AutoReset getAutoReset() {
        return autoReset;
    }

    /**
     * Sets the value of the autoReset property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoReset }
     *     
     */
    public void setAutoReset(AutoReset value) {
        this.autoReset = value;
    }

    public boolean isSetAutoReset() {
        return (this.autoReset!= null);
    }

}
