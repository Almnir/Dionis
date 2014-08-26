
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PortsSIOControlType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PortsSIOControlType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="XON/XOFF"/>
 *     &lt;enumeration value="RTS/CTS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PortsSIOControlType")
@XmlEnum
public enum PortsSIOControlType {

    @XmlEnumValue("XON/XOFF")
    XON_XOFF("XON/XOFF"),
    @XmlEnumValue("RTS/CTS")
    RTS_CTS("RTS/CTS");
    private final String value;

    PortsSIOControlType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PortsSIOControlType fromValue(String v) {
        for (PortsSIOControlType c: PortsSIOControlType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
