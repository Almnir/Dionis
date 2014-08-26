
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DHCPType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DHCPType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Subnet"/>
 *     &lt;enumeration value="Host"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DHCPType")
@XmlEnum
public enum DHCPType {

    @XmlEnumValue("Subnet")
    SUBNET("Subnet"),
    @XmlEnumValue("Host")
    HOST("Host");
    private final String value;

    DHCPType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DHCPType fromValue(String v) {
        for (DHCPType c: DHCPType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
