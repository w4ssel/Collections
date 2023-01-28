import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    @Test

    public void shouldWinPlayer1() {

        Player player1 = new Player(1, "Правая рука", 10);
        Player player2 = new Player(1, "Левая рука", 8);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Правая рука", "Левая рука");
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldWinPlayer2() {

        Player player1 = new Player(1, "Правая рука", 10);
        Player player2 = new Player(1, "Левая рука", 18);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Правая рука", "Левая рука");
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldDraw() {

        Player player1 = new Player(1, "Правая рука", 10);
        Player player2 = new Player(1, "Левая рука", 10);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Правая рука", "Левая рука");
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void Player1IsNotRegistered() {
        Player player1 = new Player(1, "Правая рука", 10);
        Player player2 = new Player(1, "Левая рука", 10);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Правая нога", "Левая рука");
        });
    }

    @Test

    public void Player2IsNotRegistered() {
        Player player1 = new Player(1, "Правая рука", 10);
        Player player2 = new Player(1, "Левая рука", 10);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Правая рука", "Левая нога");
        });
    }
}
