import services.GameService;

/**
 * Точка входа в программу. Логика программы инкапсулированна от пользователя.
 */

public class Main {
    public static void main(String[] args) {
        GameService service = new GameService();
        service.startGame();
    }
}