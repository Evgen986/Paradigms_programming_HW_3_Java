package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс поля для игры
 */

public class PlayingField {
    private Map<Integer, String> field = new HashMap<>();

    public PlayingField() {
        for (int i = 1; i < 10; i++) {
            field.put(i, ".");
        }
    }

    public Map<Integer, String> getField() {
        return field;
    }

    /**
     * Заполнение игрового поля участниками
     *
     * @param key    ключ ячейки игрового поля
     * @param marker маркер участника (Х или О)
     */
    public void fillInField(int key, String marker) {
        this.field.put(key, marker);
    }

    /**
     * Получение значения ячейки игрового поля
     *
     * @param key ключ ячейки игрового поля
     * @return значение по полученному ключу
     */
    public String getCell(int key) {
        return field.get(key);
    }

    /**
     * Подготовка игрового поля для печати
     *
     * @return игровое поле в строковом представлении
     */
    public String printField() {
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 9; i > 0; i--) {
            builder.append(" | ").append(field.get(i)).append(" | ");
            count++;
            if (count == 3) {
                result.append(builder.reverse()).append("\n");
                builder.setLength(0);
                count = 0;
            }
        }
        result.setLength(result.length() - 2);
        result.append("\n ===================\n");
        return result.toString();
    }
}
