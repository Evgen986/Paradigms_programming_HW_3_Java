package models;

import views.Observer;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс игрока - человека
 */
public class Player extends Gamer {

    public Player(String name) {
        super(name);
    }

    /**
     * Метод выбора ячейки для хода игрока
     * В методе реализованна проверка корректности ввода данных
     * и доступности выбранной ячейки для хода
     *
     * @param playingField поле для игры
     * @return целочисленное значение - ключ ячейки поля игры
     */
    @Override
    public int makeAMove(PlayingField playingField) {
        int value = 0;
        while (value == 0) {
            Scanner scanner = new Scanner(System.in);
            notifyObservers("Выберите клетку поля: ");
            try {
                value = scanner.nextInt();
                if (!playingField.getCell(value).equals(".")) {
                    value = 0;
                    notifyObservers("Данная клетку уже занята!\n");
                }
            } catch (InputMismatchException e) {
                value = 0;
                notifyObservers("Не корректный ввод!\n");
            } catch (NullPointerException e) {
                value = 0;
                notifyObservers("Такой клетки не существует!\n");
            }
        }
        return value;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
