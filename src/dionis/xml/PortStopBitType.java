
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PortStopBitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PortStopBitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *     &lt;enumeration value="1"/>
 *     &lt;enumeration value="1.5"/>
 *     &lt;enumeration value="2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PortStopBitType")
@XmlEnum(Float.class)
public enum PortStopBitType {

    @XmlEnumValue("1")
    X_1(1.0F),
    @XmlEnumValue("1.5")
    X_1_5(1.5F),
    @XmlEnumValue("2")
    X_2(2.0F);
    private final float value;

    PortStopBitType(float v) {
        value = v;
    }

    public float value() {
        return value;
    }

    public static PortStopBitType fromValue(float v) {
        for (PortStopBitType c: PortStopBitType.values()) {
            if (c.value == v) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.valueOf(v));
    }

}
