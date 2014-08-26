
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PasswordGuessType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PasswordGuessType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="no"/>
 *     &lt;enumeration value="3"/>
 *     &lt;enumeration value="9"/>
 *     &lt;enumeration value=">20"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PasswordGuessType")
@XmlEnum
public enum PasswordGuessType {

    @XmlEnumValue("no")
    NO("no"),
    @XmlEnumValue("3")
    THREE("3"),
    @XmlEnumValue("9")
    NINE("9"),
    @XmlEnumValue(">20")
    MORE_THEN_TWENTY(">20");
    private final String value;

    PasswordGuessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PasswordGuessType fromValue(String v) {
        for (PasswordGuessType c: PasswordGuessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
