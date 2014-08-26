
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogsModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LogsModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Cyclic"/>
 *     &lt;enumeration value="Continuous"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LogsModeType")
@XmlEnum
public enum LogsModeType {

    @XmlEnumValue("Cyclic")
    CYCLIC("Cyclic"),
    @XmlEnumValue("Continuous")
    CONTINUOUS("Continuous");
    private final String value;

    LogsModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LogsModeType fromValue(String v) {
        for (LogsModeType c: LogsModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
