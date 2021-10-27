package solution;

import java.util.Scanner;

public class Main {

	public static char[] fild = new char[] { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
	public static byte cat = 0;

//t
	public static void main(String[] args) {
		int move = 10;
		char player = 'O';
		print();
		while (true) {
			Scanner sc = new Scanner(System.in);
			while ((move < 0 || move > 8 || fild[move] == 'O' || fild[move] == 'X')) {
				while (!sc.hasNextInt()) {
					System.out.println("int");
				}
				move = sc.nextInt() - 1;
				if (move < 0 || move > 8 || fild[move] == 'O' || fild[move] == 'X') {
					System.out.println("again");
				}
			}
			player = 'X';
			fild[move] = player;

			if (check(player)) {
				System.out.println("You have wan");
				break;
			}
			if (checkCat())
				return;
			player = 'O';
			while (fild[move] != ' ') {
				move = (int) (Math.random() * 9);
			}
			fild[move] = player;

			if (check(player)) {
				System.out.println("Comp have wan");
				break;
			}
			if (checkCat())
				return;
			print();
		}
		print();
	}

	public static boolean checkCat() {
		cat++;
		if (cat > 8) {
			System.out.println("Cat have wan");
			return true;
		}
		return false;
	}

	public static boolean check(char c) {
		byte[][] com = new byte[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
				{ 0, 4, 8 }, { 2, 4, 6 } };
		int count = 0;
		for (int j = 0; j < 8; j++) {
			count = 0;
			for (int i = 0; i < 3; i++) {
				count = fild[com[j][i]] == c ? count + 1 : count;
			}
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	public static void print() {
		for (int i = 0; i < 7; i++) {
			if (i % 2 == 1) {
				for (int j = 0; j < 7; j++) {
					if (j % 2 == 1) {
						System.out.print(fild[j / 2 + (i / 2) * 3]);
					} else {
						System.out.print("|");
					}
				}
			} else {
				System.out.print("+-+-+-+");
			}
			System.out.println("");
		}
	}

}
