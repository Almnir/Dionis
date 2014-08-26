
package dionis.xml;

import java.util.TimeZone;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, TimeZone>
{


    public TimeZone unmarshal(String value) {
        return (dionis.formatters.TimeZoneTimeFormatter.parseTimeZoneTime(value));
    }

    public String marshal(TimeZone value) {
        return (dionis.formatters.TimeZoneTimeFormatter.printTimeZoneTime(value));
    }

}
