
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilterPortsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FilterPortsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Source"/>
 *     &lt;enumeration value="Target"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FilterPortsType")
@XmlEnum
public enum FilterPortsType {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Source")
    SOURCE("Source"),
    @XmlEnumValue("Target")
    TARGET("Target");
    private final String value;

    FilterPortsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FilterPortsType fromValue(String v) {
        for (FilterPortsType c: FilterPortsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
