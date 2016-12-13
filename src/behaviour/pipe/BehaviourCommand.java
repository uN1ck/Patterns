package behaviour.pipe;

/**
 * Интерфейс коммнады поведения, является текущим состоянием в машине состояний поведения класса
 */
public interface BehaviourCommand {

    /**
     * Метод вызывающий выполненеи комманды
     */
    BehaviourCommand doAction();

}
