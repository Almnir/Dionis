
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsoleTimeLedType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConsoleTimeLedType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Current"/>
 *     &lt;enumeration value="Working"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConsoleTimeLedType")
@XmlEnum
public enum ConsoleTimeLedType {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Current")
    CURRENT("Current"),
    @XmlEnumValue("Working")
    WORKING("Working");
    private final String value;

    ConsoleTimeLedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConsoleTimeLedType fromValue(String v) {
        for (ConsoleTimeLedType c: ConsoleTimeLedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
