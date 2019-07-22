package GUI;

import java.awt.Point;
import java.awt.Toolkit;

public class WindowXY {

//�õ���Ļ����
	public static Point getXY(int w, int h) {

		// �����Ļ��͸�
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;

		int x = (width - w) / 2;
		int y = (height - h) / 2;

		Point p = new Point(x, y);
		return p;
	}

//�õ�����
	public static Point getXY(java.awt.Dimension d) {
		return getXY(d.width, d.height);
	}

}

