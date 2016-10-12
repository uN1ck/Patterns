package actionObject.actions;

import actionObject.ActionObject;
import actionObject.parts.SpecialPart;

public class SpecialActionGetSupplies implements SpecialAction {
    private String name = "GiveSupplies";

    /**
     * Метод передачи ресурсов от {@param target} к {@param owner}
     * если обе стороны обмена содержат в себе {@link actionObject.parts.SpecialPartTank}
     *
     * @param target Объект над которым выполняется действие
     * @param owner  Объект выполняющий действие
     */
    @Override
    public void doAction(ActionObject target, ActionObject owner) {
        SpecialPart from = target.getSpecialPartByName("PartTank");
        SpecialPart to = target.getSpecialPartByName("GaveSupplies");

        if (from != null && to != null) {
            int current = from.tryGiveValue(0);
            int overflow = to.tryGetValue(current);
            from.tryGetValue(overflow);
        }
    }

    @Override
    public String actionName() {
        return name;
    }

}

