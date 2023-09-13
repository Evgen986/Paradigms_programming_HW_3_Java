package views;

/**
 * Класс визуализации работы приложения
 * имплементирует интерфейс наблюдателя
 */

public class View implements Observer {
    @Override
    public void update(String message) {
        System.out.print(message);
    }
}
