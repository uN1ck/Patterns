package behaviour.pipe;

public class BehaviourNullAction extends BehaviourPipeline {
    @Override
    protected void doAction() {
        System.out.println("Do nothing on behaviour");
    }
}
