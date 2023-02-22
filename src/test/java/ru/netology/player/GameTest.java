package ru.netology.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testIfFirstPlayerStronger() {
        Game game = new Game();
        Player petya = new Player(1, "Petya", 45);
        Player kolya = new Player(2, "Kolya", 25);
        game.register(petya);
        game.register(kolya);
        int expected = 1;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfSecondPlayerStronger() {
        Game game = new Game();
        Player petya = new Player(1, "Petya", 125);
        Player kolya = new Player(2, "Kolya", 126);
        game.register(petya);
        game.register(kolya);
        int expected = 2;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfPlayerIdenticallyStronger() {
        Game game = new Game();
        Player petya = new Player(1, "Petya", 125);
        Player kolya = new Player(2, "Kolya", 125);
        game.register(petya);
        game.register(kolya);
        int expected = 0;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfFirstPlayerNot() {
        Game game = new Game();
        Player petya = new Player(1, "Petya", 125);
        Player kolya = new Player(2, "Kolya", 125);
        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Petya", "Kolya")
                );
    }

    @Test
    public void testIfSecondPlayerNot() {
        Game game = new Game();
        Player petya = new Player(1, "Petya", 125);
        Player kolya = new Player(2, "Kolya", 125);
        game.register(petya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Petya", "Kolya")
        );
    }

    @Test
    public void testIfPlayersNot() {
        Game game = new Game();
        Player petya = new Player(1, "Petya", 125);
        Player kolya = new Player(2, "Kolya", 125);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Petya", "Kolya")
        );
    }

}