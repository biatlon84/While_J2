package com.miniT;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyLis extends KeyAdapter {
	CanvasMy cv;
	Graphics gh;
	int oj, oi, ox, oy;
	int stepY = 0;
	public Color col04 = new Color(100, 100, 0);
	private byte[][] trak;
	public Car car;

	public KeyLis(CanvasMy cv, Car car) {
		this.cv = cv;
		this.trak = Trak.getT().trak;

		this.car = car;

	}

	public void go2() {

	}

	@Override
	public void keyPressed(KeyEvent ke) {
		gh = cv.getGraphics();
		System.out.println("{" + ke.getKeyCode() + "} ");
		cv.update(gh);
		switch (ke.getKeyCode()) {
		case 32:
			// System.out.println(" oi " + oi + " oj " + oj);
			// System.out.println("�� ����� ���������!");
			// System.exit(0);

			car.setSpeedUp(5);

			break;
		case 40:
			if (oy < 103) {
				oy++;
			} else {
				oy = 0;
				stepY++;
				if (stepY > 7) {
					stepY = 0;
				}
			}
			if (trak[ox][stepY] != 0) {
				oy--;
			}
			break;
		case 38:
			if (oy > 1) {
				oy--;
			} else {
				oy = 104;

				stepY--;
				if (stepY < 0) {
					stepY = 7;
				}
			}
			if (trak[ox][stepY] != 0) {
				oy++;
			}
			break;
		case 39:

			if (ox < 7) {
				ox++;
			}
			if (trak[ox][stepY] != 0) {
				// ox--;
			}
			break;
		case 37:
			if (ox > 0) {
				ox--;
			}
			if (trak[ox][stepY] != 0) {
				// ox++;
			}
			break;
		case 91:
			// oi--;
			car.setSpeedDw(5);
			break;
		case 93:
			oi++;
			break;
		case 44:
			oj--;
			break;
		case 46:
			oj++;
			break;

		default:
		}
		car.set(gh, stepY, ox, oy);
	}
}
