package forest;

import javax.swing.JLabel;
import java.util.ArrayList;

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

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }
}