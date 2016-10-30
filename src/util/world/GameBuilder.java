package util.world;


import actionObject.ActionObject;
import util.Game;

import java.util.List;
import java.util.Set;

/**
 * Интерфейс создателя игры, генерирует карту игры и базовые юниты игроков
 */
public interface GameBuilder {
    /**
     * Метод для генерации мира
     *
     * @return сгенерированная карта мира
     */
    World createWorld();

    /**
     * Метод генерации начального состава игроков
     *
     * @return начальный состав юнитов всех игроков
     */
    List<Set<ActionObject>> createPlayers();

    /**
     * Метод, позволяющий создать игру целиком, передав только экземпляр игры
     *
     * @param instance экземпляр игры
     */
    void createGame(Game instance);
}
