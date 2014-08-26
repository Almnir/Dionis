
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilterStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FilterStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Solve"/>
 *     &lt;enumeration value="Ban"/>
 *     &lt;enumeration value="Reset"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FilterStatusType")
@XmlEnum
public enum FilterStatusType {

    @XmlEnumValue("Solve")
    SOLVE("Solve"),
    @XmlEnumValue("Ban")
    BAN("Ban"),
    @XmlEnumValue("Reset")
    RESET("Reset");
    private final String value;

    FilterStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FilterStatusType fromValue(String v) {
        for (FilterStatusType c: FilterStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
