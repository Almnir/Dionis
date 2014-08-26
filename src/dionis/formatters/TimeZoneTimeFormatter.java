package dionis.formatters;

import java.util.TimeZone;

/**
 * Задаём формат смещению временных зон при маршализации/демаршализации
 * @author FRiMEN
 */
public class TimeZoneTimeFormatter {
    public static String printTimeZoneTime(TimeZone value) {
        return value.getID().substring(3);
    }

    public static TimeZone parseTimeZoneTime(String value) {
        return TimeZone.getTimeZone("GMT" + value);
    }
}
