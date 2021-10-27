package com.miniT;

import java.awt.Color;
import java.awt.Graphics;

public class Car {
	// private
	public Color color14 = new Color(255, 255, 0);
	int stepY = 71;
	int ox;
	int oy;
	private int speed = 10;

	public void setSpeedUp(int x) {
		this.speed += x;
		System.out.print("up");
		if (this.speed < 100) {
			this.speed = 100;
		}
	}

	public void setSpeedDw(int x) {
		this.speed -= x;
		System.out.print("rthr");
		if (this.speed < 1) {
			this.speed = 1;
		}
	}

	public CanvasMy cv;
	En n = new En();

	public Car(CanvasMy cv2) {
		this.cv = cv2;
		// En n = new En();
		this.n.start();
		// this.gh = this.cv.getGraphics();
	}

	public void set(Graphics gh, int stepY, int ox, int oy) {
		this.ox = ox;
	}

	public void go() {

		Graphics gh = cv.getGraphics();
		cv.update(gh);
		// cv.repaint();
		gh.setColor(color14);

		if (oy < 103) {
			oy++;
		} else {
			oy = 0;
			stepY--;
			if (stepY < 0) {
				stepY = 71;
			}
		}
		if (Trak.getT().trak[ox][stepY + 7] != 0) {
			oy--;
		}

		gh.fillArc(60 + ox * 104, 630, 130, 130, 250, 40);
		Trak.getT().blok(gh, oy - 50, stepY, ox);
		Trak.getT().grid(gh, oy - 50);
		gh.fillArc(10, 7 * 104, 70, 70, 255, 30);
		// flushGraphics();
		cv.paintAll(gh);
		// cv.update(gh);
	}

	class En extends Thread {

		@Override
		public void run() {
			// uper.run();
			while (true) {
				try {
					Thread.currentThread().sleep(1000 / speed);
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
				go();

			}
		}

	}

	// public void setC(CanvasMy cv2) {
	// gh = cv2.getGraphics();

	// }
}
