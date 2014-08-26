
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilterOperationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FilterOperationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOP"/>
 *     &lt;enumeration value="=="/>
 *     &lt;enumeration value="!="/>
 *     &lt;enumeration value=">"/>
 *     &lt;enumeration value=">="/>
 *     &lt;enumeration value="&lt;"/>
 *     &lt;enumeration value="&lt;="/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FilterOperationType")
@XmlEnum
public enum FilterOperationType {

    NOP("NOP"),
    @XmlEnumValue("==")
    EQUAL("=="),
    @XmlEnumValue("!=")
    NOT_EQUAL("!="),
    @XmlEnumValue(">")
    MORE(">"),
    @XmlEnumValue(">=")
    MORE_EQUAL(">="),
    @XmlEnumValue("<")
    LESS("<"),
    @XmlEnumValue("<=")
    LESS_EQUAL("<=");
    private final String value;

    FilterOperationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FilterOperationType fromValue(String v) {
        for (FilterOperationType c: FilterOperationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
