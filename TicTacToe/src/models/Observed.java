package models;

import views.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Интерфейс наблюдаемого объекта
 */

public interface Observed {
    List<Observer> observers = new ArrayList<>();

    /**
     * Добавление наблюдателя
     *
     * @param observer
     */
    void addObserver(Observer observer);

    /**
     * Удаление наблюдателя
     *
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * Уведомление наблюдателя
     *
     * @param message сообщение наблюдателю
     */
    void notifyObservers(String message);
}
