import java.awt.Point;


public class ForestController extends ForestController
{
    protected ForestView view;

    protected ForestModel model;

    protected Point current;

    protected Point previous;

    public ForestController()
    {
        super();
        view = null;
        model = null;
        return;        
    }

    public void mouseClicked(MouseEvent aMouseEvent)
    {
        Point aPoint = aMouseEvent.getPoint();
        aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
        System.out.println(aPoint);
        /*このあたりで他のところにメッセージを投げる*/
        return;
    }

    public void mouseDragged(MouseEvent aMouseEvent)
    {
        Cursor aCursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
        Component aComponent = (Component)aMouseEvent.getSource();
        aComponent.setCursor(aCursor);
        current = aMouseEvent.getPoint();
        int x = current.x - previous.x;
        int y = current.y - previous.y;
        Point point = new Point(x, y);
        view.scrollBy(point);
        view.repaint();
        previous = current;
        return;
    }

}