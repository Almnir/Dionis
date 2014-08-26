
package dionis.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter4
    extends XmlAdapter<String, Float>
{


    public Float unmarshal(String value) {
        return (dionis.formatters.FloatFormatter.parseFloat(value));
    }

    public String marshal(Float value) {
        return (dionis.formatters.FloatFormatter.printFloat(value));
    }

}
