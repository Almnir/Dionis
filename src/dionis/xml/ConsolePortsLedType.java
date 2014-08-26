
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsolePortsLedType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConsolePortsLedType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pointer"/>
 *     &lt;enumeration value="Symbol"/>
 *     &lt;enumeration value="No"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConsolePortsLedType")
@XmlEnum
public enum ConsolePortsLedType {

    @XmlEnumValue("Pointer")
    POINTER("Pointer"),
    @XmlEnumValue("Symbol")
    SYMBOL("Symbol"),
    @XmlEnumValue("No")
    NO("No");
    private final String value;

    ConsolePortsLedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConsolePortsLedType fromValue(String v) {
        for (ConsolePortsLedType c: ConsolePortsLedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
