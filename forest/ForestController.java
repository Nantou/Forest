package forest;

import mvc.Controller;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * フォレストコントローラ
 */

public class ForestController extends Controller {
    protected ForestView aView;

    protected ForestModel aModel;

    protected Point current;

    protected Point previous;

    /**
     * フォレストコントローラのコンストラクタ
     */
    public ForestController() {
        super();
        aView = null;
        aModel = null;
        return;
    }

    /**
     * マウスでクリックした部分のポインタにnodeが存在するかを確認する
     */
    public void mouseClicked(MouseEvent aMouseEvent) {
        Point aPoint = aMouseEvent.getPoint();
        aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
        // System.out.println(aPoint);
        aModel.printNodeName(aPoint, aMouseEvent);
        return;
    }

    public void mouseDragged(MouseEvent aMouseEvent) {
        Cursor aCursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
        Component aComponent = (Component) aMouseEvent.getSource();
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
