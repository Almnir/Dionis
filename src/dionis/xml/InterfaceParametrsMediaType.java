
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InterfaceParametrsMediaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InterfaceParametrsMediaType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Optical"/>
 *     &lt;enumeration value="Twisted_pair"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterfaceParametrsMediaType")
@XmlEnum
public enum InterfaceParametrsMediaType {

    @XmlEnumValue("Optical")
    OPTICAL("Optical"),
    @XmlEnumValue("Twisted_pair")
    TWISTED_PAIR("Twisted_pair");
    private final String value;

    InterfaceParametrsMediaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterfaceParametrsMediaType fromValue(String v) {
        for (InterfaceParametrsMediaType c: InterfaceParametrsMediaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
