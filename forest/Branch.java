package forest;

public class Branch extends Object {

    private Node parentNode;
    private Node childrenNode;

    public Branch(Node parentNode,Node childrenNode){

    }

    public Node getParentNode() {
        return this.parentNode;
    }

    public Node getChildrenNode() {
        return this.childrenNode;
    }
}
