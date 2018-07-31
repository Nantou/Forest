package forest;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import utility.StringUtility;

public class Forest extends Object {

    private ForestModel model;
    private ArrayList<Node> rootNodes;
    private HashMap <Integer,Node> nodes;
    private ArrayList<Branch> branches;
    private int underLine;
    
    public Forest(){
        this.model = null;
        this.rootNodes = new ArrayList<Node>();
        this.nodes = new HashMap<Integer,Node>();
        this.branches = new ArrayList<Branch>();
        this.underLine = 0;
    }

    public void readFile(File aFile) throws IOException {
        List<String> textList = StringUtility.readTextFromFile(aFile);
        System.out.println(textList.size());

        int type = 0;
        for (String tmp : textList)
        {
            tmp = tmp.replaceAll(" ", "");
            System.out.println("= " + tmp);
            if ( tmp.equals("nodes:") ) {type = 1;}
            if ( tmp.equals("branches:") ) {type = 2;}
            this.setTypeData(type, tmp);
        }
        return;
    }

    private void setTypeData(int type,String text){
        if ( text.equals("nodes:") ) {return;}
        if ( text.equals("nodes:") ) {return;}
        if ( text.equals("branches:") ) {return;}

        if (type == 0)
        {
        }
        else if (type == 1)
        {
            String[] tmp = text.split(",");
            int nodeNumber = Integer.parseInt(tmp[0]);
            String nodeName = tmp[1];
            Node aNode = new Node(nodeNumber, nodeName);
            this.nodes.put(nodeNumber, aNode);
        }
        else if (type == 2)
        {
            String[] tmp = text.split(",");
            Node parentNode = this.nodes.get( Integer.parseInt(tmp[0]) );
            Node childNode = this.nodes.get( Integer.parseInt(tmp[1]) );

            parentNode.setChildren(childNode);
            childNode.setParent(parentNode);
            this.nodes.put(Integer.parseInt(tmp[0]), parentNode);
            this.nodes.put(Integer.parseInt(tmp[1]), childNode);

            Branch aBranch = new Branch(parentNode, childNode);
            this.branches.add(aBranch);
        }
        else
        {
            System.err.println("===========不正な値です。============");
        }
    }

    public void setModel(ForestModel model) {
        this.model = model;
    }

    public void setRoot() {
        this.nodes.values().forEach((node)->{
            if(Objects.isNull(node.getParent())) rootNodes.add(node);
        });
        return;
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

    public int getUnderLine(){ return underLine; }

    public void visit(Node root, Point aPoint){
        if(root.getVisit() == false){ root.setLocation(aPoint); }
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException anException)
        {
            System.err.println(anException);
            throw new RuntimeException(anException.toString());
        }
        this.model.changed();

        int childY = aPoint.y;
        int count=0;
        for(Node childNode : root.getChildren())
        {
            while(childY <= this.underLine) {childY += 18;}
            this.visit(childNode,new Point(aPoint.x+root.getWidth() + 2, childY));
            childNode.setVisit(true);
            count++;
            if(root.getChildren().size() > count){
                childY += 2 + root.getHeight();
            }
        }

        if(this.underLine < childY) {this.underLine = childY;}
        if(root.getVisit() == false){root.setLocation( aPoint.x, (childY+aPoint.y+root.getHeight()) / 2 - (root.getHeight()/2) );}
        if(root.getParent()==null && root.getChildren().size()==1){ root.setLocation( aPoint.x, root.getChildren().get(0).getLocation().y);}
        return;
    }
}
