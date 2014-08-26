
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InterfaceParametrsModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InterfaceParametrsModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Auto"/>
 *     &lt;enumeration value="100Full"/>
 *     &lt;enumeration value="100Half"/>
 *     &lt;enumeration value="10Full"/>
 *     &lt;enumeration value="10Half"/>
 *     &lt;enumeration value="Call"/>
 *     &lt;enumeration value="Receive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterfaceParametrsModeType")
@XmlEnum
public enum InterfaceParametrsModeType {

    @XmlEnumValue("Auto")
    AUTO("Auto"),
    @XmlEnumValue("100Full")
    X_100_FULL("100Full"),
    @XmlEnumValue("100Half")
    X_100_HALF("100Half"),
    @XmlEnumValue("10Full")
    X_10_FULL("10Full"),
    @XmlEnumValue("10Half")
    X_10_HALF("10Half"),
    @XmlEnumValue("Call")
    CALL("Call"),
    @XmlEnumValue("Receive")
    RECEIVE("Receive");
    private final String value;

    InterfaceParametrsModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterfaceParametrsModeType fromValue(String v) {
        for (InterfaceParametrsModeType c: InterfaceParametrsModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
