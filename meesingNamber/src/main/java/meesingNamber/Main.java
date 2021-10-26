package meesingNamber;

public class Main {

	public static int[] data = new int[] { 1, 7, 4, 6, 3, 0, 0, 5, };
	public static int[] array = new int[4];
	public static boolean[] b = new boolean[2];

	public static void main(String args[]) {

		for (int x : data) {
			array[x / b.length]++;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] < b.length) {
				System.out.print(chek(i));
			}
		}
	}

	public static int chek(int band) {
		for (int x : data) {
			if (x / b.length == band) {
				b[x % b.length] = true;
			}
		}
		for (int j = 0; j < b.length; j++) {
			if (b[j] == false) {
				return j + b.length * band;
			}
		}
		return 0;
	}

}
