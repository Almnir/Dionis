
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InterfaceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InterfaceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SLIP"/>
 *     &lt;enumeration value="CSLIP"/>
 *     &lt;enumeration value="PPP"/>
 *     &lt;enumeration value="GRE"/>
 *     &lt;enumeration value="VLAN"/>
 *     &lt;enumeration value="ODI"/>
 *     &lt;enumeration value="Factor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterfaceType")
@XmlEnum
public enum InterfaceType {

    SLIP("SLIP"),
    CSLIP("CSLIP"),
    PPP("PPP"),
    GRE("GRE"),
    VLAN("VLAN"),
    ODI("ODI"),
    @XmlEnumValue("Factor")
    FACTOR("Factor");
    private final String value;

    InterfaceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterfaceType fromValue(String v) {
        for (InterfaceType c: InterfaceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
