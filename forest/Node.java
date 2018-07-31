package forest;

import javax.swing.JLabel;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Node extends JLabel {
    private String nodename;
    private int nodenumber;
    private boolean visit;
    private Node parent;
    private ArrayList<Node> children;

    public Node(int number, String name) {
        this.nodename = name;
        this.nodenumber = number;
        this.parent = null;
        this.children = new ArrayList<Node>();
        this.visit = false;
    }

    public String getName() {
        return this.nodename;
    }

    public int getNumber() {
        return this.nodenumber;
    }

    public Node getParentNode() {
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
    }

    public void setChildren(Node children) {
        this.children.add(children);
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }
}