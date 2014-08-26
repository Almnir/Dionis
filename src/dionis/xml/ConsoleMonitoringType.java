
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsoleMonitoringType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConsoleMonitoringType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Close"/>
 *     &lt;enumeration value="No_password"/>
 *     &lt;enumeration value="Open"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConsoleMonitoringType")
@XmlEnum
public enum ConsoleMonitoringType {

    @XmlEnumValue("Close")
    CLOSE("Close"),
    @XmlEnumValue("No_password")
    NO_PASSWORD("No_password"),
    @XmlEnumValue("Open")
    OPEN("Open");
    private final String value;

    ConsoleMonitoringType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConsoleMonitoringType fromValue(String v) {
        for (ConsoleMonitoringType c: ConsoleMonitoringType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
