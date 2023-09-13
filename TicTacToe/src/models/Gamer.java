package models;

/**
 * Абстрактный класс игрока
 * <p>
 * Не совсем уверен, стоило ли имплементировать Observed в абстрактном классе, или лучше
 * для каждого конкретного класса?
 */

public abstract class Gamer implements Observed {
    private String name;

    public Gamer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Абстрактный метод хода игрока
     *
     * @param playingField игровое поле
     * @return целочисленное значение - ключ ячейки игрового поля
     */
    public abstract int makeAMove(PlayingField playingField);
}
