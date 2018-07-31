package forest;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        this.setFont(new Font("Arial", Font.PLAIN, 12));
        this.setText(this.nodename);
        this.setBorder(new LineBorder(Color.black, 1));
        this.setSize(this.getPreferredSize());
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

    public void setChildren(Node child) {
        this.children.add(child);
        Collections.sort(this.children,new Comparator<Node>(){
            @Override
            public int compare(Node node1, Node node2){
                return node1.getName().compareTo(node2.getName());
            }
        });
        return;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }
}