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


//    //TODO: перенести в метод
//    private ActionObjectBuilder baseUnit = new Builder();
//    private ActionObjectBuilder assaultUnit = new Builder();
//    private ActionObjectBuilder supplyUnit = new Builder();
//
//    private void initFactories() {
//        baseUnit.addAction(new SpecialActionMove(this), new HashMap<>());
//        assaultUnit = baseUnit.clone();
//        assaultUnit.setProperty("MoveMaximal", "5");
//        assaultUnit.setProperty("MoveRest", "5");
//        supplyUnit = assaultUnit.clone();
//
//        baseUnit.addAction(new SpecialActionGetSupplies(100), new HashMap<>());
//        baseUnit.setProperty("SupplyMaximal", "1000");
//        baseUnit.setProperty("SupplyCurrent", "1000");
//        baseUnit.addAction(new SpecialActionCreateAssultUnit(), new HashMap<>());
//        baseUnit.addAction(new SpecialActionCreateSupplyUnit(), new HashMap<>());
//
//        assaultUnit.addAction(new SpecialActionShoot(), new HashMap<>());
//        supplyUnit.addAction(new SpecialActionGetSupplies(100), new HashMap<>());
//        supplyUnit.setProperty("SupplyMaximal", "500");
//        supplyUnit.setProperty("SupplyCurrent", "500");
//
//    }