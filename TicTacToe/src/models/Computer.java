package models;

import views.Observer;

import java.util.Random;

/**
 * Класс искусственного интеллекта
 */

public class Computer extends Gamer {

    public Computer(int num) {
        super("Компьютер %d".formatted(num));
    }

    /**
     * Метод выбора ячейки для хода искусственного интеллекта
     * В первую очередь ИИ проверят возможность победить,
     * после пытается предотвратить победу игрока,
     * в случае отсутствия первых двух вариантов ИИ выбирает случайный ключ ячейки игрового поля
     *
     * @param playingField поле для игры
     * @return целочисленное значение - ключ ячейки поля игры
     */
    @Override
    public int makeAMove(PlayingField playingField) {
        // Для проверки 2-х "0" в ряд
        // Проверка клетки 3
        if (((playingField.getCell(1).equals("O") && playingField.getCell(2).equals("O")) ||
                (playingField.getCell(7).equals("O") && playingField.getCell(5).equals("O")) ||
                (playingField.getCell(6).equals("O") && playingField.getCell(9).equals("O"))) &&
                playingField.getCell(3).equals(".")) return 3;
            // Проверка клетки 6
        else if (((playingField.getCell(4).equals("O") && playingField.getCell(5).equals("O")) ||
                (playingField.getCell(3).equals("O") && playingField.getCell(9).equals("O"))) &&
                playingField.getCell(6).equals(".")) return 6;
            // Проверка клетки 9
        else if (((playingField.getCell(7).equals("O") && playingField.getCell(8).equals("O")) ||
                (playingField.getCell(1).equals("O") && playingField.getCell(5).equals("O")) ||
                (playingField.getCell(3).equals("O") && playingField.getCell(6).equals("O"))) &&
                playingField.getCell(9).equals(".")) return 9;
            // Проверка клетки 2
        else if (((playingField.getCell(5).equals("O") && playingField.getCell(8).equals("O")) ||
                (playingField.getCell(1).equals("O") && playingField.getCell(3).equals("O"))) &&
                playingField.getCell(2).equals(".")) return 2;
            // Проверка клетки 5
        else if (((playingField.getCell(2).equals("O") && playingField.getCell(8).equals("O")) ||
                (playingField.getCell(4).equals("O") && playingField.getCell(6).equals("O")) ||
                (playingField.getCell(3).equals("O") && playingField.getCell(7).equals("O")) ||
                (playingField.getCell(1).equals("O") && playingField.getCell(9).equals("O"))) &&
                playingField.getCell(5).equals(".")) return 5;
            // Проверка клетки 8
        else if (((playingField.getCell(7).equals("O") && playingField.getCell(9).equals("O")) ||
                (playingField.getCell(2).equals("O") && playingField.getCell(5).equals("O"))) &&
                playingField.getCell(8).equals(".")) return 8;
            // Проверка клетки 1
        else if (((playingField.getCell(2).equals("O") && playingField.getCell(3).equals("O")) ||
                (playingField.getCell(5).equals("O") && playingField.getCell(9).equals("O")) ||
                (playingField.getCell(4).equals("O") && playingField.getCell(7).equals("O"))) &&
                playingField.getCell(1).equals(".")) return 1;
            // Проверка клетки 4
        else if (((playingField.getCell(1).equals("O") && playingField.getCell(7).equals("O")) ||
                (playingField.getCell(5).equals("O") && playingField.getCell(6).equals("O"))) &&
                playingField.getCell(4).equals(".")) return 4;
            // Проверка клетки 7
        else if (((playingField.getCell(1).equals("O") && playingField.getCell(4).equals("O")) ||
                (playingField.getCell(5).equals("O") && playingField.getCell(3).equals("O")) ||
                (playingField.getCell(8).equals("O") && playingField.getCell(9).equals("O"))) &&
                playingField.getCell(7).equals(".")) return 7;
            // Для проверки 2-х "Х" в ряд
            // Проверка клетки 3
        else if (((playingField.getCell(1).equals("X") && playingField.getCell(2).equals("X")) ||
                (playingField.getCell(7).equals("X") && playingField.getCell(5).equals("X")) ||
                (playingField.getCell(6).equals("X") && playingField.getCell(9).equals("X"))) &&
                playingField.getCell(3).equals(".")) return 3;
            // Проверка клетки 6
        else if (((playingField.getCell(4).equals("X") && playingField.getCell(5).equals("X")) ||
                (playingField.getCell(3).equals("X") && playingField.getCell(9).equals("X"))) &&
                playingField.getCell(6).equals(".")) return 6;
            // Проверка клетки 9
        else if (((playingField.getCell(7).equals("X") && playingField.getCell(8).equals("X")) ||
                (playingField.getCell(1).equals("X") && playingField.getCell(5).equals("X")) ||
                (playingField.getCell(3).equals("X") && playingField.getCell(6).equals("X"))) &&
                playingField.getCell(9).equals(".")) return 9;
            // Проверка клетки 2
        else if (((playingField.getCell(5).equals("X") && playingField.getCell(8).equals("X")) ||
                (playingField.getCell(1).equals("X") && playingField.getCell(3).equals("X"))) &&
                playingField.getCell(2).equals(".")) return 2;
            // Проверка клетки 5
        else if (((playingField.getCell(2).equals("X") && playingField.getCell(8).equals("X")) ||
                (playingField.getCell(4).equals("X") && playingField.getCell(6).equals("X")) ||
                (playingField.getCell(3).equals("X") && playingField.getCell(7).equals("X")) ||
                (playingField.getCell(1).equals("X") && playingField.getCell(9).equals("X"))) &&
                playingField.getCell(5).equals(".")) return 5;
            // Проверка клетки 8
        else if (((playingField.getCell(7).equals("X") && playingField.getCell(9).equals("X")) ||
                (playingField.getCell(2).equals("X") && playingField.getCell(5).equals("X"))) &&
                playingField.getCell(8).equals(".")) return 8;
            // Проверка клетки 1
        else if (((playingField.getCell(2).equals("X") && playingField.getCell(3).equals("X")) ||
                (playingField.getCell(5).equals("X") && playingField.getCell(9).equals("X")) ||
                (playingField.getCell(4).equals("X") && playingField.getCell(7).equals("X"))) &&
                playingField.getCell(1).equals(".")) return 1;
            // Проверка клетки 4
        else if (((playingField.getCell(1).equals("X") && playingField.getCell(7).equals("X")) ||
                (playingField.getCell(5).equals("X") && playingField.getCell(6).equals("X"))) &&
                playingField.getCell(4).equals(".")) return 4;
            // Проверка клетки 7
        else if (((playingField.getCell(1).equals("X") && playingField.getCell(4).equals("X")) ||
                (playingField.getCell(5).equals("X") && playingField.getCell(3).equals("X")) ||
                (playingField.getCell(8).equals("X") && playingField.getCell(9).equals("X"))) &&
                playingField.getCell(7).equals(".")) return 7;
            // Выбор рандомного значения с проверкой свободна ли выбранная клетка
        else {
            Random random = new Random();
            int choseComputer = 0;
            boolean flag = true;
            while (flag) {
                choseComputer = random.nextInt(1, 10);
                if (playingField.getCell(choseComputer).equals(".")) flag = false;
            }
            return choseComputer;
        }
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers(String message) {

    }
}
