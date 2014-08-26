
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserActionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UserActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="d"/>
 *     &lt;enumeration value="n"/>
 *     &lt;enumeration value="m"/>
 *     &lt;enumeration value="e"/>
 *     &lt;enumeration value="a"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UserActionType")
@XmlEnum
public enum UserActionType {

    @XmlEnumValue("d")
    D("d"),
    @XmlEnumValue("n")
    N("n"),
    @XmlEnumValue("m")
    M("m"),
    @XmlEnumValue("e")
    E("e"),
    @XmlEnumValue("a")
    A("a");
    private final String value;

    UserActionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UserActionType fromValue(String v) {
        for (UserActionType c: UserActionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
