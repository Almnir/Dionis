
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
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
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterfaceParametrType")
@XmlEnum
public enum InterfaceParametrType {

    SIO,
    VLAN,
    SYN;

    public String value() {
        return name();
    }

    public static InterfaceParametrType fromValue(String v) {
        return valueOf(v);
    }

}
