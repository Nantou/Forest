package forest;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Forest extends Object {

    private ForestModel model;
    private ArrayList<Node> rootNodes;
    private HashMap <Integer,Node> nodes;
    private ArrayList<Branch> branches;
    private int underLine;

    public Forest(){

    }

    public void readText(File file){

    }

    private void setTypeData(int type,System text){

    }

    public void setModel(ForestModel model) {
        this.model = model;
    }

    public void setRoot(ArrayList<Node> rootNodes) {
        this.rootNodes = rootNodes;
    }

    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }

    public ArrayList<Node> getRoot() {
        return rootNodes;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void visit(Node root, Point aPoint){

    }
}
