package dionis.formatters;

/**
 * Задаём формат булевым значениям при маршализации/демаршализации
 *
 * @author FRiMEN
 */
public class BooleanFormatter {
    public static String printBoolean(boolean value) {
        return value ? "Yes" : "No";
    }

    public static Boolean parseBoolean(String value) {
        return value.equals("Yes") ? true : false;
    }
}
