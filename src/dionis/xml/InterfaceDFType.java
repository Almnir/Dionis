
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InterfaceDFType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InterfaceDFType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Copy"/>
 *     &lt;enumeration value="Set"/>
 *     &lt;enumeration value="Reset"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterfaceDFType")
@XmlEnum
public enum InterfaceDFType {

    @XmlEnumValue("Copy")
    COPY("Copy"),
    @XmlEnumValue("Set")
    SET("Set"),
    @XmlEnumValue("Reset")
    RESET("Reset");
    private final String value;

    InterfaceDFType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterfaceDFType fromValue(String v) {
        for (InterfaceDFType c: InterfaceDFType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
