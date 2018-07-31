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
        Map<Integer,Node> nodes = this.aForest.getNodes();
        nodes.forEach(ForestModel::setNodeLocation);
    }

    private static void setNodeLocation(Integer key, Node node) {
        int y = key.intValue() * node.getSize().height + 2;
        node.setLocation(0, y);
    }

    public Forest getForest() {
        return aForest;
    }

    public void printNodeName(Point aPoint, MouseEvent aMouseEvent){
        System.out.println("test");
        HashMap<Integer,Node> nodes = aForest.getNodes();
        nodes.forEach((key,node) -> {
            System.out.println("node");
            if (node.getLocation().x > aPoint.x || node.getLocation().x + node.getWidth() < aPoint.x) return;
            if (node.getLocation().y > aPoint.y || node.getLocation().y + node.getHeight() < aPoint.y) return;
            System.out.println(node.getName());
        });
        return;
    }
}