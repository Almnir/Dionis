
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogsPartsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LogsPartsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Current"/>
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="A_day"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LogsPartsType")
@XmlEnum
public enum LogsPartsType {

    @XmlEnumValue("Current")
    CURRENT("Current"),
    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("A_day")
    A_DAY("A_day");
    private final String value;

    LogsPartsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LogsPartsType fromValue(String v) {
        for (LogsPartsType c: LogsPartsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
