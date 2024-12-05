import java.util.Arrays;
import java.util.Comparator;
import exceptions.ConsoleInactiveException;

public class PlayRoom {
    public static void main(String[] args) {
        Game.GameDisk[] physicalGames = {
                Game.getDisk("FIFA 24", Game.Genre.SPORT, "Футбольный симулятор"),
                Game.getDisk("Forza Horizon 5", Game.Genre.RACE, "Автосимулятор"),
                Game.getDisk("Call of Duty", Game.Genre.ACTION, "Шутер"),
                Game.getDisk("NBA 2K24", Game.Genre.SPORT, "Баскетбольный симулятор")
        };

        Game.VirtualGame[] virtualGames = {
                Game.getVirtualGame("GTA V", Game.Genre.ACTION, 5),
                Game.getVirtualGame("FIFA 23", Game.Genre.SPORT, 4),
                Game.getVirtualGame("Need for Speed", Game.Genre.RACE, 3),
                Game.getVirtualGame("Fortnite", Game.Genre.ACTION, 2)
        };

        Arrays.sort(physicalGames, Comparator.comparing(o -> o.getData().getGenre()));
        System.out.println("Физические игры (отсортированы по жанру):");
        for (Game.GameDisk game : physicalGames) {
            System.out.println(game.getData().getName() + " (" + game.getData().getGenre() + ")");
        }

        Arrays.sort(virtualGames, Comparator.comparingInt(Game.VirtualGame::getRating));
        System.out.println("\nВиртуальные игры (отсортированы по рейтингу):");
        for (Game.VirtualGame game : virtualGames) {
            System.out.println(game.getData().getName() + " (Рейтинг: " + game.getRating() + ")");
        }

        GameConsole console = new GameConsole(GameConsole.Brand.SONY, "PS5", "SN123456");
        console.powerOn();

        try {
            console.loadGame(physicalGames[0].getData());
            console.playGame();
            console.playGame();
        } catch (ConsoleInactiveException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}