
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsoleEditorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConsoleEditorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Norton"/>
 *     &lt;enumeration value="Dionis"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConsoleEditorType")
@XmlEnum
public enum ConsoleEditorType {

    @XmlEnumValue("Norton")
    NORTON("Norton"),
    @XmlEnumValue("Dionis")
    DIONIS("Dionis");
    private final String value;

    ConsoleEditorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConsoleEditorType fromValue(String v) {
        for (ConsoleEditorType c: ConsoleEditorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
