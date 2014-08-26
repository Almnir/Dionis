
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
 *         &lt;element name="Date_birthday" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Date_out" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Date_stat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Entries">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Dionis">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Time">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Dionis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Data_in">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Dionis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Data_out">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Dionis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Time_limit">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Dionis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Time_left">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Dionis" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dateBirthday",
    "dateOut",
    "dateStat",
    "entries",
    "time",
    "dataIn",
    "dataOut",
    "timeLimit",
    "timeLeft"
})
public class UserStatistics
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Date_birthday", required = true)
    protected String dateBirthday;
    @XmlElement(name = "Date_out", required = true)
    protected String dateOut;
    @XmlElement(name = "Date_stat", required = true)
    protected String dateStat;
    @XmlElement(name = "Entries", required = true)
    protected UserStatEntries entries;
    @XmlElement(name = "Time", required = true)
    protected UserStatTime time;
    @XmlElement(name = "Data_in", required = true)
    protected UserStatDataIn dataIn;
    @XmlElement(name = "Data_out", required = true)
    protected UserStatDataOut dataOut;
    @XmlElement(name = "Time_limit", required = true)
    protected UserStatTimeLimit timeLimit;
    @XmlElement(name = "Time_left", required = true)
    protected UserStatTimeLeft timeLeft;

    /**
     * Gets the value of the dateBirthday property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateBirthday() {
        return dateBirthday;
    }

    /**
     * Sets the value of the dateBirthday property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateBirthday(String value) {
        this.dateBirthday = value;
    }

    public boolean isSetDateBirthday() {
        return (this.dateBirthday!= null);
    }

    /**
     * Gets the value of the dateOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOut() {
        return dateOut;
    }

    /**
     * Sets the value of the dateOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOut(String value) {
        this.dateOut = value;
    }

    public boolean isSetDateOut() {
        return (this.dateOut!= null);
    }

    /**
     * Gets the value of the dateStat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateStat() {
        return dateStat;
    }

    /**
     * Sets the value of the dateStat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateStat(String value) {
        this.dateStat = value;
    }

    public boolean isSetDateStat() {
        return (this.dateStat!= null);
    }

    /**
     * Gets the value of the entries property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatEntries }
     *     
     */
    public UserStatEntries getEntries() {
        return entries;
    }

    /**
     * Sets the value of the entries property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatEntries }
     *     
     */
    public void setEntries(UserStatEntries value) {
        this.entries = value;
    }

    public boolean isSetEntries() {
        return (this.entries!= null);
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatTime }
     *     
     */
    public UserStatTime getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatTime }
     *     
     */
    public void setTime(UserStatTime value) {
        this.time = value;
    }

    public boolean isSetTime() {
        return (this.time!= null);
    }

    /**
     * Gets the value of the dataIn property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatDataIn }
     *     
     */
    public UserStatDataIn getDataIn() {
        return dataIn;
    }

    /**
     * Sets the value of the dataIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatDataIn }
     *     
     */
    public void setDataIn(UserStatDataIn value) {
        this.dataIn = value;
    }

    public boolean isSetDataIn() {
        return (this.dataIn!= null);
    }

    /**
     * Gets the value of the dataOut property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatDataOut }
     *     
     */
    public UserStatDataOut getDataOut() {
        return dataOut;
    }

    /**
     * Sets the value of the dataOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatDataOut }
     *     
     */
    public void setDataOut(UserStatDataOut value) {
        this.dataOut = value;
    }

    public boolean isSetDataOut() {
        return (this.dataOut!= null);
    }

    /**
     * Gets the value of the timeLimit property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatTimeLimit }
     *     
     */
    public UserStatTimeLimit getTimeLimit() {
        return timeLimit;
    }

    /**
     * Sets the value of the timeLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatTimeLimit }
     *     
     */
    public void setTimeLimit(UserStatTimeLimit value) {
        this.timeLimit = value;
    }

    public boolean isSetTimeLimit() {
        return (this.timeLimit!= null);
    }

    /**
     * Gets the value of the timeLeft property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatTimeLeft }
     *     
     */
    public UserStatTimeLeft getTimeLeft() {
        return timeLeft;
    }

    /**
     * Sets the value of the timeLeft property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatTimeLeft }
     *     
     */
    public void setTimeLeft(UserStatTimeLeft value) {
        this.timeLeft = value;
    }

    public boolean isSetTimeLeft() {
        return (this.timeLeft!= null);
    }

}
