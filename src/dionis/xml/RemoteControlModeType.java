
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RemoteControlModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RemoteControlModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Review"/>
 *     &lt;enumeration value="Management"/>
 *     &lt;enumeration value="Capture"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RemoteControlModeType")
@XmlEnum
public enum RemoteControlModeType {

    @XmlEnumValue("Review")
    REVIEW("Review"),
    @XmlEnumValue("Management")
    MANAGEMENT("Management"),
    @XmlEnumValue("Capture")
    CAPTURE("Capture");
    private final String value;

    RemoteControlModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RemoteControlModeType fromValue(String v) {
        for (RemoteControlModeType c: RemoteControlModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
