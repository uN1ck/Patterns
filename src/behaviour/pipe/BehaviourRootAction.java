package behaviour.pipe;

public class BehaviourRootAction extends BehaviourPipeline {
    @Override
    protected void doAction() {
        System.out.println("Do nothing on behaviour");
    }
}
