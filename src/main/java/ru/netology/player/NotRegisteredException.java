package ru.netology.player;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок " + name + " не зарегистрирован");
    }
}
