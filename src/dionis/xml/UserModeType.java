
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UserModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ANY"/>
 *     &lt;enumeration value="Terminal"/>
 *     &lt;enumeration value="PPP_SLIP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UserModeType")
@XmlEnum
public enum UserModeType {

    ANY("ANY"),
    @XmlEnumValue("Terminal")
    TERMINAL("Terminal"),
    PPP_SLIP("PPP_SLIP");
    private final String value;

    UserModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UserModeType fromValue(String v) {
        for (UserModeType c: UserModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
