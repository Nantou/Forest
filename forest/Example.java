package forest;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import javax.swing.JFrame;

/**
 * 例題プログラム
 */
public class Example extends Object {
	/**
	 * 引数からファイルを呼び出し、呼び出したファイルをモデルへと渡し、、コントローラとビューを作成する。
	 * その後アニメーションのフレームを生成し、その上にMVCをのせてアニメーションを走らせる。
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

		JFrame aWindow = new JFrame("forest");
		aWindow.getContentPane.add(aView);
		aWindow.setLayout(null);
		aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aWindow.setMinimumSize(new Dimension(400, 300));
		aWindow.setSize(800, 600);
		aWindow.setVisible(true);

		return;
	}
}
