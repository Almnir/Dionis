
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PortsSIODirectionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PortsSIODirectionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Input"/>
 *     &lt;enumeration value="Output"/>
 *     &lt;enumeration value="Dynamic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PortsSIODirectionType")
@XmlEnum
public enum PortsSIODirectionType {

    @XmlEnumValue("Input")
    INPUT("Input"),
    @XmlEnumValue("Output")
    OUTPUT("Output"),
    @XmlEnumValue("Dynamic")
    DYNAMIC("Dynamic");
    private final String value;

    PortsSIODirectionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PortsSIODirectionType fromValue(String v) {
        for (PortsSIODirectionType c: PortsSIODirectionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
