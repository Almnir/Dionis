
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InterfaceAuthorityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InterfaceAuthorityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="PAP"/>
 *     &lt;enumeration value="CHAP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterfaceAuthorityType")
@XmlEnum
public enum InterfaceAuthorityType {

    @XmlEnumValue("No")
    NO("No"),
    PAP("PAP"),
    CHAP("CHAP");
    private final String value;

    InterfaceAuthorityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterfaceAuthorityType fromValue(String v) {
        for (InterfaceAuthorityType c: InterfaceAuthorityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
