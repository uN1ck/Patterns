package actionObject.actions;

import actionObject.ActionObject;
import util.observers.ActionObjectObserver;

public class SpecialActionLive extends SpecialAction {

    private int health;
    private ActionObjectObserver dieEvent;

    /**
     * Конструктор основного компонента юнита - его жизни. Хранит показатель текущего здоровья и наблюдателя за состоянием объекта
     *
     * @param health                       текущее состояние здоровья
     * @param dieEventActionObjectObserver наблюдатель за состоянием здоровья объекта
     */
    public SpecialActionLive(int health, ActionObjectObserver dieEventActionObjectObserver) {
        this.health = health;
        this.dieEvent = dieEventActionObjectObserver;
    }

    /**
     * Метод активного специального действия юнита
     *
     * @param target Объект над которым выполняется действие
     * @param owner  Объект выполняющий действие
     */
    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        SpecialActionShoot damageDealer = (SpecialActionShoot) owner.getSpecialActionByName(SpecialActionShoot.class.getSimpleName());
        this.health -= damageDealer.getDamage();
        if (this.health <= 0)
            dieEvent.notifyEvent(target);
    }

}
