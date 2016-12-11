package behaviour.pipe;

public class BehaviourNone implements BehaviourCommand {
    public BehaviourNone(){

    }
    /**
     * Метод вызывающий выполненеи комманды
     */
    @Override
    public BehaviourCommand doAction() {
        return null;
    }

}
