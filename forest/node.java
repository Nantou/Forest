package forest;

import javax.swing.JLabel;
import java.util.ArrayList;

public class Node extends JLabel {
    private String nodeName;
    private int nodeNumber;
    private boolean visit;
    private Node parent;
    private ArrayList<Node> children;

    public Node(int number, String name) {
        this.nodeName = name;
        this.nodeNumber = number;
        this.parent = null;
        this.children = new ArrayList<Node>();
        this.visit = false;
    }

    public String getName() {
        return this.nodeName;
    }

    public int getNumber() {
        return this.nodeNumber;
    }

    public Node getParent() {
        return this.parent;
    }

    public ArrayList<Node> getChildren() {
        return this.children;
    }

    public boolean getVisit() {
        return this.visit;
    }

    public void setParent(Node parent) {
        this.parent = parent;
        return;
    }

    public void setChildren(Node children) {
        this.children.add(children);
        return;
    }

    public void setVisit(boolean flag) {
        this.visit = flag;
        return;
    }

}