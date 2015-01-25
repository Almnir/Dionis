
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InterfaceParametrsSlipMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InterfaceParametrsSlipMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Call"/>
 *     &lt;enumeration value="Receive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterfaceParametrsSlipMode")
@XmlEnum
public enum InterfaceParametrsSlipMode {

    @XmlEnumValue("Call")
    CALL("Call"),
    @XmlEnumValue("Receive")
    RECEIVE("Receive");
    private final String value;

    InterfaceParametrsSlipMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterfaceParametrsSlipMode fromValue(String v) {
        for (InterfaceParametrsSlipMode c: InterfaceParametrsSlipMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
