package forest;

import mvc.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * 例題プログラム
 */
public class Example extends Object {
	/**
	 * 引数からファイルを呼び出し、呼び出したファイルをモデルへと渡し、コントローラとビューを作成する。その後アニメーションのフレームを生成し、その上にMVCをのせてアニメーションを走らせる。
	 */
	public static void main(String[] arguments) {
		// 引数が無い（樹状整列データファイルの在り処がわからない）をチェックする。
		if (arguments.length < 1) {
			System.exit(1);
		}

		// 第1引数で指定された樹状整列データファイルの存在をチェックする。
		File aFile = new File(arguments[0]);
		// if (!(aFile.exists())) {
		// System.err.println("'" + aFile + "' does not exist.");
		// System.exit(1);
		// }

		// MVCを作成する。
		ForestModel aModel = new ForestModel(aFile);
		ForestController aController = new ForestController();
		ForestView aView = new ForestView(aModel, aController);

		JFrame aWindow = new JFrame("Forest");
		aWindow.getContentPane().add(aView);
		aWindow.setLayout(null);
		aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int titleBarHeight = aWindow.getInsets().top;
		aWindow.getContentPane().setBackground(new Color(255,255,255));
		Point aPoint = new Point(800, 800);
		aWindow.setMinimumSize(new Dimension(aPoint.x, aPoint.y + titleBarHeight));
		aWindow.setResizable(true);
		aWindow.setSize(aPoint.x, aPoint.y + titleBarHeight);
		aWindow.setLocation(0, 0);
		aWindow.setVisible(true);
		aWindow.toFront();

		ArrayList<Node> roots = aModel.getForest().getRoot();
		for(Node node : roots)
		{
			aModel.getForest().visit(node, new Point(0,aModel.getForest().getUnderLine()) );
		}

		return;
	}
}
