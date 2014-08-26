package dionis.formatters;

/**
 * Задаём формат float значениям при маршализации/демаршализации
 *
 * @author FRiMEN
 */
public class FloatFormatter {
    public static String printFloat(float value) {
        String fl = String.valueOf(value);

        if (fl.endsWith(".0")) {
            fl = fl.substring(0, fl.length() - 2);
        }

        return fl;
    }

    public static Float parseFloat(String value) {
        return Float.valueOf(value);
    }
}
