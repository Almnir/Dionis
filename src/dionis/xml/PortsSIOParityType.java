
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PortsSIOParityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PortsSIOParityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="ODD"/>
 *     &lt;enumeration value="EVEN"/>
 *     &lt;enumeration value="MARK"/>
 *     &lt;enumeration value="SPACE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PortsSIOParityType")
@XmlEnum
public enum PortsSIOParityType {

    NONE,
    ODD,
    EVEN,
    MARK,
    SPACE;

    public String value() {
        return name();
    }

    public static PortsSIOParityType fromValue(String v) {
        return valueOf(v);
    }

}
