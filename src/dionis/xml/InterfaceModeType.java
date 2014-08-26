
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InterfaceModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InterfaceModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Static"/>
 *     &lt;enumeration value="Input"/>
 *     &lt;enumeration value="Output"/>
 *     &lt;enumeration value="Duplex"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterfaceModeType")
@XmlEnum
public enum InterfaceModeType {

    @XmlEnumValue("Static")
    STATIC("Static"),
    @XmlEnumValue("Input")
    INPUT("Input"),
    @XmlEnumValue("Output")
    OUTPUT("Output"),
    @XmlEnumValue("Duplex")
    DUPLEX("Duplex");
    private final String value;

    InterfaceModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterfaceModeType fromValue(String v) {
        for (InterfaceModeType c: InterfaceModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
