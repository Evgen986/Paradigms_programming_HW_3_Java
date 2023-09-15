package services;

import models.Computer;
import models.Gamer;
import models.Player;
import models.PlayingField;
import views.Observer;
import views.View;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Контроллер работы приложения
 */
public class GameService {
    private PlayingField playingField;
    private Observer view;

    {
        playingField = new PlayingField();
        view = new View();
    }

    public GameService() {
    }

    /**
     * Основной метод запуска игры
     */
    public void startGame() {
        game(gameType(choseGameType()));
    }

    /**
     * Формирование списка игроков
     *
     * @param type тип выбранной игры
     * @return список игроков
     */
    private List<Gamer> gameType(int type) {
        List<Gamer> gamers = new ArrayList<>();
        switch (type) {
            case 1 -> {
                view.update("Введите ваше имя: ");
                String name = new Scanner(System.in).nextLine();
                Player player = new Player(name);
                player.addObserver(view);
                gamers.add(player);
                gamers.add(new Computer(1));
                return gamers;
            }
            case 2 -> {
                view.update("Игрок 1 - введите ваше имя: ");
                String namePlayer1 = new Scanner(System.in).nextLine();
                view.update("Игрок 2 - введите ваше имя: ");
                String namePlayer2 = new Scanner(System.in).nextLine();
                Player player1 = new Player(namePlayer1);
                player1.addObserver(view);
                gamers.add(player1);
                Player player2 = new Player(namePlayer2);
                player2.addObserver(view);
                gamers.add(player2);
                return gamers;
            }
            case 3 -> {
                gamers.add(new Computer(1));
                gamers.add(new Computer(2));
                return gamers;
            }
        }
        return gamers;
    }

    /**
     * Выбор типа игры:
     * 1 - игра Человек против компьютера
     * 2 - игра Человек против Человека
     * 3 - игра Компьютер против Компьютера
     * В методе реализована проверка на корректность ввода данных
     *
     * @return целочисленное значение
     */
    private int choseGameType() {
        int value = 0;
        while (value == 0) {
            Scanner scanner = new Scanner(System.in);
            view.update("""
                    Выберите тип игры:
                    1 - Игрок против компьютера;
                    2 - Игрок против игрока;
                    3 - Компьютер против компьютера;
                    Ваш выбор:\s""");
            try {
                value = scanner.nextInt();
                switch (value) {
                    case 1, 2, 3 -> {
                        return value;
                    }
                    default -> {
                        view.update("Введите число от 1 до 3\n");
                        value = 0;
                    }
                }
            } catch (InputMismatchException e) {
                value = 0;
                view.update("Не корректный ввод!\n");
            }
        }
        return value;
    }

    /**
     * Логика проведения игры
     *
     * @param gamers список игроков
     */
    private void game(List<Gamer> gamers) {
        boolean flag = true;
        int count = 1;
        while (flag) {
            printNumbersField();
            while (true) {
                gamerOneMove(gamers.get(0).makeAMove(playingField));
                printField();
                if (checkWinner()) {
                    view.update("У нас есть победитель! " + gamers.get(0).getName() + " поздравляем!\n");
                    break;
                } else if (checkDraw()) {
                    view.update("У нас ничья!\n");
                    break;
                }
                gamerTwoMove(gamers.get(1).makeAMove(playingField));
                printField();
                if (checkWinner()) {
                    view.update("У нас есть победитель! " + gamers.get(1).getName() + " поздравляем!\n");
                    break;
                } else if (checkDraw()) {
                    view.update("У нас ничья!\n");
                    break;
                }
                view.update("  ==== раунд " + ++count + " ==== \n");
            }
            flag = checkAnswer();
            playingField = new PlayingField();
            count = 1;
        }
        view.update("Спасибо за игру!\n");
    }

    /**
     * Печать таблицы с заполненными ячейками
     */
    private void printField() {
        view.update(playingField.printField());
    }

    /**
     * Печать таблицы с нумерацией ячеек
     */
    private void printNumbersField() {
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 9; i > 0; i--) {
            builder.append(" | ").append(i).append(" | ");
            count++;
            if (count == 3) {
                result.append(builder.reverse()).append("\n");
                builder.setLength(0);
                count = 0;
            }
        }
        result.setLength(result.length() - 2);
        result.append("\n ===================\n");
        view.update(result.toString());
    }

    /**
     * Ход первого игрока
     *
     * @param value целочисленное значение
     */
    private void gamerOneMove(int value) {
        playingField.fillInField(value, "X");
    }

    /**
     * Ход второго игрока
     *
     * @param value целочисленное значение
     */
    private void gamerTwoMove(int value) {
        playingField.fillInField(value, "O");
    }

    /**
     * Проверка победителя
     *
     * @return булево значение true - условие победы выполнено, false - не выполнено
     */
    private boolean checkWinner() {
        return playingField.getCell(1).equals("O") && playingField.getCell(2).equals("O") && playingField.getCell(3).equals("O") ||
                (playingField.getCell(1).equals("X") && playingField.getCell(2).equals("X") && playingField.getCell(3).equals("X")) ||
                (playingField.getCell(4).equals("O") && playingField.getCell(5).equals("O") && playingField.getCell(6).equals("O")) ||
                (playingField.getCell(4).equals("X") && playingField.getCell(5).equals("X") && playingField.getCell(6).equals("X")) ||
                (playingField.getCell(7).equals("O") && playingField.getCell(8).equals("O") && playingField.getCell(9).equals("O")) ||
                (playingField.getCell(7).equals("X") && playingField.getCell(8).equals("X") && playingField.getCell(9).equals("X")) ||
                (playingField.getCell(1).equals("O") && playingField.getCell(5).equals("O") && playingField.getCell(9).equals("O")) ||
                (playingField.getCell(1).equals("X") && playingField.getCell(5).equals("X") && playingField.getCell(9).equals("X")) ||
                (playingField.getCell(3).equals("O") && playingField.getCell(5).equals("O") && playingField.getCell(7).equals("O")) ||
                (playingField.getCell(3).equals("X") && playingField.getCell(5).equals("X") && playingField.getCell(7).equals("X")) ||
                (playingField.getCell(3).equals("O") && playingField.getCell(6).equals("O") && playingField.getCell(9).equals("O")) ||
                (playingField.getCell(3).equals("X") && playingField.getCell(6).equals("X") && playingField.getCell(9).equals("X")) ||
                (playingField.getCell(2).equals("O") && playingField.getCell(5).equals("O") && playingField.getCell(8).equals("O")) ||
                (playingField.getCell(2).equals("X") && playingField.getCell(5).equals("X") && playingField.getCell(8).equals("X")) ||
                (playingField.getCell(1).equals("O") && playingField.getCell(4).equals("O") && playingField.getCell(7).equals("O")) ||
                (playingField.getCell(1).equals("X") && playingField.getCell(4).equals("X") && playingField.getCell(7).equals("X"));
    }

    /**
     * Проверка ничей
     *
     * @return булево значение true - ничья, false - отсутствие ничьей
     */
    private boolean checkDraw() {
        return !playingField.getField().containsValue(".");
    }

    /**
     * Запрос пользователя для продолжения игры
     * В методе реализована проверка корректности ввода
     *
     * @return булево значение true - продолжить, false - прекратить игру
     */
    private boolean checkAnswer() {
        while (true) {
            view.update("Хотите сыграть еще раз? (Y/N): ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("y")) return true;
            else if (answer.equals("n")) return false;
            else view.update("Я вас не понимаю...\n");
        }
    }
}
