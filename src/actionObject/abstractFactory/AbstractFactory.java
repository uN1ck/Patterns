package actionObject.abstractFactory;

import actionObject.ActionObject;

/**
 * Абстаркная фабрика юнитов
 */
public interface AbstractFactory {
    /**
     * Создать абстрактного юнита
     * @return созданный юнит
     */
    ActionObject createUnit();

}
