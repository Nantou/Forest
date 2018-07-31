package forest;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import javax.swing.JFrame;

public class Branch extends Object {
  
  private Node parentNode;
  private Node childrenNode;

  public Branch(Node parentNode,Node childrenNode){
    this.parentNode = parentNode;
    this.childrenNode = childrenNode;
  }

  public Node getParentNode(){
    return this.parentNode;
  }

  public Node getChildrenNode(){
    return this.childrenNode;
  }
}
