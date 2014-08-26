
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RipRouteVersionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RipRouteVersionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *     &lt;enumeration value="1"/>
 *     &lt;enumeration value="2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RipRouteVersionType")
@XmlEnum(Byte.class)
public enum RipRouteVersionType {

    @XmlEnumValue("1")
    RIP_1(((byte) 1)),
    @XmlEnumValue("2")
    RIP_2(((byte) 2));
    private final byte value;

    RipRouteVersionType(byte v) {
        value = v;
    }

    public byte value() {
        return value;
    }

    public static RipRouteVersionType fromValue(byte v) {
        for (RipRouteVersionType c: RipRouteVersionType.values()) {
            if (c.value == v) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.valueOf(v));
    }

}
