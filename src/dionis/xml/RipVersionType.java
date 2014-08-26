
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RipVersionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RipVersionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ANY"/>
 *     &lt;enumeration value="RIP-1_and_RIP-2"/>
 *     &lt;enumeration value="RIP-2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RipVersionType")
@XmlEnum
public enum RipVersionType {

    ANY("ANY"),
    @XmlEnumValue("RIP-1_and_RIP-2")
    RIP_1_AND_RIP_2("RIP-1_and_RIP-2"),
    @XmlEnumValue("RIP-2")
    RIP_2("RIP-2");
    private final String value;

    RipVersionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RipVersionType fromValue(String v) {
        for (RipVersionType c: RipVersionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
