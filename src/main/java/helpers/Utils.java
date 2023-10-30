package helpers;

import java.security.SecureRandom;

public class Utils {

    /**
     * Возвращение рандомного значения из enum типов.
     *
     * @param clazz - enum.
     */
    public <T extends Enum<?>> T getRandomEnumValue(Class<T> clazz) {
        int x = new SecureRandom().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
