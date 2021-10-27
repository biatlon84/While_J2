package kiFont;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyLis extends KeyAdapter {
	CanvasMy cv;
	Graphics gr;

	public KeyLis(CanvasMy cv) {
		this.cv = cv;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.print(" " + e.getKeyCode());
		// System.out.print(" " + (short) (e.getKeyChar()));
		int bbb = 0;
		gr = cv.getGraphics();
		gr.setColor(cv.colorLetters);

		switch (e.getKeyCode()) {
		case 17:
			bbb = cv.getFontss().chengeF();
			cv.update(gr);
			cv.getFontss().write(40, 300, 2, 2, "" + bbb, gr);
			break;
		case 38:

			break;
		case 40:
			cv.clean();
			cv.update(gr);
			break;
		case 16:
			break;
		case 8:
			cv.remC();
			cv.update(gr);
			break;
		default:
			cv.getFontss().write(40 + cv.getSL() * 16, 400, 2, 2, new String("" + e.getKeyChar()), gr);
			cv.addChar(e.getKeyChar());

		}
	}

}
