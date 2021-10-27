package com.miniT;

import java.awt.Color;
import java.awt.Graphics;

public class Trak {
	byte[][] trak = new byte[8][80];

	private Trak() {

		this.trak[5][10] = 1;
		this.trak[5][20] = 1;
		this.trak[5][30] = 1;
		this.trak[5][40] = 1;
		this.trak[5][50] = 1;
		this.trak[5][60] = 1;
		this.trak[5][70] = 1;
		this.trak[3][15] = 2;
		this.trak[3][25] = 2;
		this.trak[3][35] = 2;
		this.trak[3][45] = 2;
		this.trak[3][55] = 2;
		this.trak[3][65] = 2;

		// -----loop
		this.trak[3][3] = 2;
		this.trak[3][5] = 2;

		this.trak[3][75] = 2;
		this.trak[3][77] = 2;

		this.trak[5][7] = 1;
		this.trak[5][79] = 1;
		// -----loop
	}

	private static Trak tt = new Trak();
	public Color color10 = new Color(0, 255, 0);
	public Color color12 = new Color(255, 5, 0);
	public Color color14 = new Color(255, 255, 0);
	public Color color15 = new Color(255, 255, 255);
	public Color color02 = new Color(0, 99, 0);

	public static Trak getT() {
		return tt;
	}

	public void grid(Graphics gh, int shiftY) {
		int ca, cd, cl, ck;
		ck = 0;
		cl = 0;
		ca = 0;
		cd = 0;
		gh.setColor(color02);
		for (cd = 0; cd < 9; cd += 1) {
			ca = cd * 104;
			gh.drawLine(70 + ca, 10, 70 + ca, 841); // ||
			gh.drawLine(70, 50 + ca + shiftY, 901, shiftY + 50 + ca);// --
		}
	}

	public void blok(Graphics gh, int shiftY, int stepY, int ox) {
		int ca, x, resY;
		resY = 0;
		ca = 0;
		x = 0;
		for (x = 0; x < 8; x++) {
			for (int ii = 0; ii < 9; ii++) {
				ca = x * 104;
				// resY = (ii + (7 - stepY)) * 104 + shiftY;
				resY = (ii - 1) * 104 + shiftY + 40;
				if (trak[x][ii + stepY] == 1) {
					gh.setColor(color14);
					gh.drawString("" + stepY, 98 + ca, 25 + resY);
					if ((ox == x) && (trak[x][stepY + 7] != 0) && (stepY + 7 == ii + stepY)) {
						gh.setColor(color12);
					}
					gh.fillRect(89 + ca, 30 + resY, 66, 66);

				}
				if (trak[x][ii + stepY] == 2) {
					gh.setColor(color10);
					gh.drawString("" + stepY, 98 + ca, 25 + resY);
					if ((ox == x) && (trak[x][stepY + 7] != 0) && (stepY + 7 == ii + stepY)) {
						gh.setColor(color12);
					}
					gh.fillRect(89 + ca, 30 + resY, 66, 66);

				}
				if (trak[x][ii + stepY] == 3) {
					gh.setColor(color10);
					gh.drawString("" + stepY, 98 + ca, 25 + resY);
					if ((ox == x) && (trak[x][stepY + 8] != 0) && (stepY + 8 == ii + stepY)) {
						gh.setColor(color12);
					}
					gh.fillRect(89 + ca, 30 + resY, 66, 66);

				}

			}
		}
	}
}
