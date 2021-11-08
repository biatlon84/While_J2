package fds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

//	public static void main(String[] args) {
//		String s = "";
//		Scanner in = new Scanner(System.in);
//		s = in.nextLine();
//		int n = Integer.parseInt(s);
//		String[] strArr = in.nextLine().split("[ ]");
//		s = in.nextLine();
//		int k = Integer.parseInt(s);
//		if (k > n) {
//			k = n;
//		}
//		int[] intArr = new int[n];
//		long average = 0;
//		for (int i = 0; i < n; i++) {
//			intArr[i] = Integer.parseInt(strArr[i]);
//		}
//		for (int i = 0; i < k; i++) {
//			average += intArr[i];
//		}
//		System.out.print(((double) average / k) + " ");
//		for (int i = k; i < n; i++) {
//			average -= intArr[i - k];
//			average += intArr[i];
//			System.out.print(((double) average / k) + " ");
//		}
//	}

//	public static void main(String[] args) {
//
//		File y = new File("/home/kwas/t.txt");
//		File out = new File("/home/kwas/t2.txt");
//		BufferedReader in = null;
//		BufferedWriter bufW = null;
//		int n = 0;
//		int k = 0;
//		try {
//			FileWriter w = new FileWriter(out);
//			bufW = new BufferedWriter(w);
//		} catch (IOException e2) {
//			e2.printStackTrace();
//		}
//		try {
//			in = new BufferedReader(new FileReader(y));
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		String[] strArr = null;
//		try {
//			n = Integer.parseInt(in.readLine());
//
//			strArr = in.readLine().split("[ ]");
//			k = Integer.parseInt(in.readLine());
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if (k > n) {
//			k = n;
//		}
//		int[] intArr = new int[n];
//		long average = 0;
//		for (int i = 0; i < n; i++) {
//
//			intArr[i] = Integer.parseInt(strArr[i]);
//		}
//		for (int i = 0; i < k; i++) {
//			average += intArr[i];
//		}
//		try {
//			bufW.write(((double) average / k) + " ");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		for (int i = k; i < n; i++) {
//			average -= intArr[i - k];
//			average += intArr[i];
//			try {
//				bufW.write(((double) average / k) + " ");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		try {
//			bufW.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {

		File y = new File("/home/kwas/t.txt");
		File out = new File("/home/kwas/t2.txt");
		BufferedReader in = null;
		BufferedWriter bufW = null;
		int n = 0;
		int k = 0;
		try {
			FileWriter w = new FileWriter(out);
			bufW = new BufferedWriter(w);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			in = new BufferedReader(new FileReader(y));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String[] strArr = null;
		try {
			n = Integer.parseInt(in.readLine());

			strArr = in.readLine().split("[ ]");
			k = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[] intArr = new int[n];

		for (int i = 0; i < n; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		// -----
		int z = 0;
		int x = 0;
		int f = 0;
		boolean fine = true;
		int end = n - 1;

		int start = 0;
		Arrays.sort(intArr);
		while (true) {
			f = intArr[start] + intArr[end];
			if (k == f) {
				x = intArr[end];
				z = intArr[start];
				fine = true;
				break;
			}
			// System.out.println(" " + (start) + " " + (end) + " = " + f);
			if (f > k) {
				end--;
			}
			if (f < k) {
				start++;
			}
			if (start >= end) {
				fine = false;
				break;
			}
		}
		// ------
		try {
			if (fine == true) {
				bufW.write(z + " ");
				bufW.write(x + " ");
			} else {
				bufW.write("None");
			}
			bufW.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
