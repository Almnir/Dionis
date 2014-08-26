
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PortSpeedType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PortSpeedType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *     &lt;enumeration value="50"/>
 *     &lt;enumeration value="75"/>
 *     &lt;enumeration value="110"/>
 *     &lt;enumeration value="134.5"/>
 *     &lt;enumeration value="150"/>
 *     &lt;enumeration value="300"/>
 *     &lt;enumeration value="600"/>
 *     &lt;enumeration value="1200"/>
 *     &lt;enumeration value="1800"/>
 *     &lt;enumeration value="2000"/>
 *     &lt;enumeration value="2400"/>
 *     &lt;enumeration value="3600"/>
 *     &lt;enumeration value="4800"/>
 *     &lt;enumeration value="7200"/>
 *     &lt;enumeration value="9600"/>
 *     &lt;enumeration value="14400"/>
 *     &lt;enumeration value="19200"/>
 *     &lt;enumeration value="38400"/>
 *     &lt;enumeration value="57600"/>
 *     &lt;enumeration value="115200"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PortSpeedType")
@XmlEnum(Float.class)
public enum PortSpeedType {

    @XmlEnumValue("50")
    X_50(50.0F),
    @XmlEnumValue("75")
    X_75(75.0F),
    @XmlEnumValue("110")
    X_110(110.0F),
    @XmlEnumValue("134.5")
    X_134_5(134.5F),
    @XmlEnumValue("150")
    X_150(150.0F),
    @XmlEnumValue("300")
    X_300(300.0F),
    @XmlEnumValue("600")
    X_600(600.0F),
    @XmlEnumValue("1200")
    X_1200(1200.0F),
    @XmlEnumValue("1800")
    X_1800(1800.0F),
    @XmlEnumValue("2000")
    X_2000(2000.0F),
    @XmlEnumValue("2400")
    X_2400(2400.0F),
    @XmlEnumValue("3600")
    X_3600(3600.0F),
    @XmlEnumValue("4800")
    X_4800(4800.0F),
    @XmlEnumValue("7200")
    X_7200(7200.0F),
    @XmlEnumValue("9600")
    X_9600(9600.0F),
    @XmlEnumValue("14400")
    X_14400(14400.0F),
    @XmlEnumValue("19200")
    X_19200(19200.0F),
    @XmlEnumValue("38400")
    X_38400(38400.0F),
    @XmlEnumValue("57600")
    X_57600(57600.0F),
    @XmlEnumValue("115200")
    X_115200(115200.0F);
    private final float value;

    PortSpeedType(float v) {
        value = v;
    }

    public float value() {
        return value;
    }

    public static PortSpeedType fromValue(float v) {
        for (PortSpeedType c: PortSpeedType.values()) {
            if (c.value == v) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.valueOf(v));
    }

}
