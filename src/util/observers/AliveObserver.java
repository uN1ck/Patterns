package util.observers;

import actionObject.ActionObject;
import util.game.Game;

/**
 * Наблюдатель за состоянием здоровья объекта. Запускает метод удаления объекта из игры при его уничтожении
 */
public class AliveObserver implements ActionObjectObserver {
    private Game game;

    /**
     * Конструктор наблюдателя
     *
     * @param game экземпляр игры
     */
    public AliveObserver(Game game) {
        this.game = game;
    }

    @Override
    public void notifyEvent(ActionObject actionObject) {
        game.removeActionObject(actionObject);
    }

}
