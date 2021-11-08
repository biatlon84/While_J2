package com.epam.training.task_4;

public class print {

	public static void out(int[][] array) {
		int y = 0;
		int x = array.length;
		while (x != 0) {
			x /= 10;
			y++;
		}
		for (int i = 0; i < array.length; i++) {
			for (int ii = 0; ii < array[i].length; ii++) {
				System.out.printf("%" + y + "d ", array[i][ii]);
			}
			System.out.print("\n");
		}
	}

}
