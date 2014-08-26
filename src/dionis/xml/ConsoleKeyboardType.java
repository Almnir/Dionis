
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsoleKeyboardType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConsoleKeyboardType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="яверты"/>
 *     &lt;enumeration value="йцукен"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConsoleKeyboardType")
@XmlEnum
public enum ConsoleKeyboardType {

    @XmlEnumValue("\u044f\u0432\u0435\u0440\u0442\u044b")
    ЯВЕРТЫ("\u044f\u0432\u0435\u0440\u0442\u044b"),
    @XmlEnumValue("\u0439\u0446\u0443\u043a\u0435\u043d")
    ЙЦУКЕН("\u0439\u0446\u0443\u043a\u0435\u043d");
    private final String value;

    ConsoleKeyboardType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConsoleKeyboardType fromValue(String v) {
        for (ConsoleKeyboardType c: ConsoleKeyboardType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
