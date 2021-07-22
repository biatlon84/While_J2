package del;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class CanvasMy extends Canvas {
	private KeyLis kL;
	private Fontsss fon;
	private String str = "";
	public Color colorLetters = new Color(200, 200, 200);

	public int getSL() {
		return str.length();
	}

	public Fontsss getFontss() {
		return fon;
	}

	public void addChar(char C) {
		this.str = this.str + C;
	}

	public CanvasMy() {
		this.kL = new KeyLis(this);
		this.addKeyListener(kL);
		fon = new FontKi();
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(colorLetters);
		fon.write(40, 400, 2, 2, str, g);
	}

	public void remC() {
		this.str = str.substring(0, str.length() - 1);
	}

	public void clean() {
		this.str = "";
	}
}
