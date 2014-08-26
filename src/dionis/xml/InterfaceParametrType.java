
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InterfaceParametrType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InterfaceParametrType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SIO"/>
 *     &lt;enumeration value="VLAN"/>
 *     &lt;enumeration value="SYN"/>
 *     &lt;enumeration value="Call"/>
 *     &lt;enumeration value="Receive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterfaceParametrType")
@XmlEnum
public enum InterfaceParametrType {

    SIO("SIO"),
    VLAN("VLAN"),
    SYN("SYN"),
    @XmlEnumValue("Call")
    CALL("Call"),
    @XmlEnumValue("Receive")
    RECEIVE("Receive");
    private final String value;

    InterfaceParametrType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterfaceParametrType fromValue(String v) {
        for (InterfaceParametrType c: InterfaceParametrType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
