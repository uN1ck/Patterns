package JavaConsoleDraw;

import actionObject.ActionObject;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ActionObjectElement implements Composite {
    ActionObject ownerLink;
    PrintWriter pw;

    public ActionObjectElement(ActionObject owner) {
        ownerLink = owner;
        pw = new PrintWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public void addChild(Composite child) {

    }

    @Override
    public List<Composite> getChildren() {
        return new ArrayList<Composite>();
    }

    @Override
    public void removeChild(Composite child) {

    }

    @Override
    public void drawSelf() {
//        String result = "ActionObject: [ " + ownerLink.getProperty("name") + " ]\n Actions: \n";
//        for (SpecialAction current : ownerLink.getSpecialActions())
//            result += current.actionName() + "\n";
//        result += "Properties: \n";
//        for (Map.Entry current : ownerLink.getProperties().entrySet())
//            result += current.getKey() + " " + current.getValue() + "\n";
//        pw.print(result);
    }
}
