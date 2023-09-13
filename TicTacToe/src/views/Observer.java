package views;

/**
 * Интерфейс наблюдателя
 */

public interface Observer {
    /**
     * Получение сообщения от наблюдаемого объекта
     *
     * @param message
     */
    public void update(String message);
}
