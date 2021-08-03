package cpm.eclpse.l;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//List l = new List(26);
		ListW_Head l = new ListW_Head(26);
		ArrayList<Integer> arL = new ArrayList<>(101);
		ArrayList<Integer> arL2 = new ArrayList<>(101);
		for (int i = 0; i < 10;) {
			arL2.add(i);
			arL2.add(0);

			l.insert(l.getSize(), i);
			l.insert(l.getSize(), 0);

			i += 2;
		}
		for (int i = 1; i < 6;) {
			arL2.remove(i);
			l.del(i);
			i += 1;
		}


		for (int i = 1; i < 10;) {
			arL2.add(i, i);
			l.insert(i, i);
			i += 2;
		}
		System.out.println(arL2.toString());

		for (int i = 0; l.getSize() > 0; i++) {
			System.out.print(" " + l.del(0));
		}

	}
}
