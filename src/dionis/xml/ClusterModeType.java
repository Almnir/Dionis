
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClusterModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Master"/>
 *     &lt;enumeration value="Slave"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClusterModeType")
@XmlEnum
public enum ClusterModeType {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("Master")
    MASTER("Master"),
    @XmlEnumValue("Slave")
    SLAVE("Slave");
    private final String value;

    ClusterModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClusterModeType fromValue(String v) {
        for (ClusterModeType c: ClusterModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
