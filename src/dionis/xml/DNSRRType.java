
package dionis.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DNSRRType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DNSRRType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="NS"/>
 *     &lt;enumeration value="CNAME"/>
 *     &lt;enumeration value="PTR"/>
 *     &lt;enumeration value="MX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DNSRRType")
@XmlEnum
public enum DNSRRType {

    A,
    NS,
    CNAME,
    PTR,
    MX;

    public String value() {
        return name();
    }

    public static DNSRRType fromValue(String v) {
        return valueOf(v);
    }

}
