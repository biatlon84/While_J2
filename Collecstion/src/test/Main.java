package test;

import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		ArrayList<conn_thread> ArLi = new ArrayList<conn_thread>();
		for (int i = 0; i < 9; i++) {
			ArLi.add(new conn_thread(i));
		}
		System.out.println(ArLi.size());
		ArLi.remove(3);
		ArLi.remove(4);
		ArLi.remove(5);
		for (int i = 0; i < 5; i++) {
			System.out.println(ArLi.get(i).test);
		}
		System.out.println(ArLi.size());
	}

}
