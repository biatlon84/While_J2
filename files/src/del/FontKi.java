package del;

import java.awt.Graphics;

public class FontKi implements Fontsss {

	private short[][] tu2;
	private int fonf = 0;

	public FontKi() {
		FileAc file = new FileAc();
		this.tu2 = file.getF("1.dat");
	}

	public void write(int X, int Y, int x1, int y1, String s, Graphics g) {
		// g.drawLine(220, 220, 100, 100);
		if (s == null) {
			return;
		}
		short[] ss = new short[s.length()];
		for (int i = 0; i < s.length(); i++) {
			ss[i] = (short) s.charAt(i);
		}

		for (int I = 0; I < ss.length; I++) {
			for (int J = 0; J < 13; J++) {
				for (int K = 0; K < 8; K++) {
					if (((tu2[(ss[I])][J]) & (short) (1 << K)) != 0) {
						g.drawLine(X - K * x1, Y + J * y1, (X - K * x1) + 1, (Y + J * y1) + 1);
					}

				}
			}

			X = X + 8 * x1;

		}

	}

	public int chengeF() {
		fonf++;
		if (fonf > 9) {
			fonf = 0;
		}
		FileAc file = new FileAc();
		this.tu2 = file.getF("" + fonf + ".dat");
		return fonf;

	}

}
