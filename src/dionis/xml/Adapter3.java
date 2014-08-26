
package dionis.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter3
    extends XmlAdapter<String, Boolean>
{


    public Boolean unmarshal(String value) {
        return (dionis.formatters.BooleanFormatter.parseBoolean(value));
    }

    public String marshal(Boolean value) {
        return (dionis.formatters.BooleanFormatter.printBoolean(value));
    }

}
