package forest;

import mvc.Model;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ForestModel extends Model {

    private Forest aForest;

    public ForestModel(File aFile) {
        super();
        this.aForest = new Forest();
        this.aForest.setModel(this);
        try{
            this.aForest.readFile(aFile);
        }catch (IOException anException){
            anException.printStackTrace();
        }
        aForest.setRoot();

        int y=0;
        HashMap<Integer,Node> nodes = this.getForest().getNodes();
        for (Node aNode : nodes.values())
        {
            aNode.setLocation(0,y);
            y += aNode.getSize().height+2;
        }
    }

    public Forest getForest() {
        return aForest;
    }

    public void printNodeName(Point aPoint, MouseEvent aMouseEvent){
        HashMap<Integer,Node> nodes = aForest.getNodes();
        nodes.forEach((key,node) -> {
            if (node.getLocation().x > aPoint.x || node.getLocation().x + node.getWidth() < aPoint.x) return;
            if (node.getLocation().y > aPoint.y || node.getLocation().y + node.getHeight() < aPoint.y) return;
        });
        return;
    }
}