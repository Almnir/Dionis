
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsoleScreenBlankingAwakeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConsoleScreenBlankingAwakeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Key"/>
 *     &lt;enumeration value="Output"/>
 *     &lt;enumeration value="Key+output"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConsoleScreenBlankingAwakeType")
@XmlEnum
public enum ConsoleScreenBlankingAwakeType {

    @XmlEnumValue("Key")
    KEY("Key"),
    @XmlEnumValue("Output")
    OUTPUT("Output"),
    @XmlEnumValue("Key+output")
    KEY_OUTPUT("Key+output");
    private final String value;

    ConsoleScreenBlankingAwakeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConsoleScreenBlankingAwakeType fromValue(String v) {
        for (ConsoleScreenBlankingAwakeType c: ConsoleScreenBlankingAwakeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
