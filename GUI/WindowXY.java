package GUI;

import java.awt.Point;
import java.awt.Toolkit;

public class WindowXY {

//得到屏幕中心
	public static Point getXY(int w, int h) {

		// 获得屏幕宽和高
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;

		int x = (width - w) / 2;
		int y = (height - h) / 2;

		Point p = new Point(x, y);
		return p;
	}

//得到鼠标点
	public static Point getXY(java.awt.Dimension d) {
		return getXY(d.width, d.height);
	}

}

