
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SNMPTrapVersionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SNMPTrapVersionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="v1"/>
 *     &lt;enumeration value="v2c"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SNMPTrapVersionType")
@XmlEnum
public enum SNMPTrapVersionType {

    @XmlEnumValue("v1")
    V_1("v1"),
    @XmlEnumValue("v2c")
    V_2_C("v2c");
    private final String value;

    SNMPTrapVersionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SNMPTrapVersionType fromValue(String v) {
        for (SNMPTrapVersionType c: SNMPTrapVersionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
