package forest;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import javax.swing.JFrame;

public class Branch {
  private Node parentNode;
  private Node childrenNode;

  public void Branch(Node parentNode,Node childrenNode){
    this.parentNode = parentNode;
    this.childrenNode = childrenNode;
  }

  public Node getParentNode(){
    return parentNode;
  }

  public Node getChildrenNode(){
    return childrenNode;
  }
}
