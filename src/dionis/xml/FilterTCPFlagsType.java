
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilterTCPFlagsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FilterTCPFlagsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SYN"/>
 *     &lt;enumeration value="ACK"/>
 *     &lt;enumeration value="No"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FilterTCPFlagsType")
@XmlEnum
public enum FilterTCPFlagsType {

    SYN("SYN"),
    ACK("ACK"),
    @XmlEnumValue("No")
    NO("No");
    private final String value;

    FilterTCPFlagsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FilterTCPFlagsType fromValue(String v) {
        for (FilterTCPFlagsType c: FilterTCPFlagsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
