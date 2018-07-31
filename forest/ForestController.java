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

    protected Point current;

    protected Point previous;

    /**
     * フォレストコントローラのコンストラクタ
     */
    public ForestController() {
        super();
    }

    /**
     * マウスでクリックした部分のポインタにnodeが存在するかを確認する
     */
    public void mouseClicked(MouseEvent aMouseEvent) {
        Point aPoint = aMouseEvent.getPoint();
        aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
        ForestModel aModel = (ForestModel)(this.model);
        aModel.printNodeName(aPoint, aMouseEvent);
        return;
    }

    public void mouseDragged(MouseEvent aMouseEvent) {
        super.mouseDragged(aMouseEvent);

        return;
    }

}
