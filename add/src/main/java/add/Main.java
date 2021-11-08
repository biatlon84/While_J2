package add;

public class Main {
	public static int f = 0;
	public static long[] faAr = new long[800];
	private static int[] Array = new int[] { 1, 3, 5, 2, 4, 11, 0, 6, 4, 3, 8, 3, 2, 10, 2, 2, 1, 9, 1, 1, 7 };

//A011758 	Barker sequence of length 13.
	public static void main(String[] args) {
		// brackets(11);
		// System.out.println(test1(0));
		// System.out.println(test2(7, 3));
		// System.out.println(test3(8));
		// 44293
		// System.out.println(test4(72345));
		// System.out.println(test5(72345));
		// System.out.println(test6(44293, 2));
		// System.out.println(test7(72345, 2));
		// test8(72345, 2);
		// System.out.println(test9(65280, 255));
		// System.out.println(test10(new int[] { 4, 3, 3, 2, 2, 2, 1, 9, 1, 1 }));
		// int[] y = new int[] { 1, 3, 5, 2, 4, 6, 4, 3, 3, 2, 2, 2, 1, 9, 1, 1 };
		// test12(0, Array.length);
		// test11();
		// System.out.println(f);
		// merge(2, 3, 4);
		// System.out.println(Arrays.toString(Array));
	}

	public static void test12(int start, int end) {
		if (start >= end - 1) {
			return;
		}
		int z = end - start;
		z /= 2;
		test12(start, end - z);
		test12(start + z, end);
		merge(start, start + z, end);
	}

	public static void merge(int start, int mid, int end) {
		int pos = start;
		int[] arr2 = new int[Array.length];
		int first = start;
		int second = mid;
		while (true) {
			if ((first < mid) && (second < end)) {
				int f = Array[first];
				int s = Array[second];
				if (f < s) {
					arr2[pos] = f;
					first++;
				} else {
					arr2[pos] = s;
					second++;
				}
				pos++;
			} else {
				if (second < end) {
					int s = Array[second];
					arr2[pos] = s;
					second++;

				}
				if (first < mid) {
					int f = Array[first];
					arr2[pos] = f;
					first++;

				}
				pos++;
			}
			if (pos >= end)
				break;
		}
		for (pos--; pos >= start; pos--) {
			Array[pos] = arr2[pos];
		}
	}

	public static void test11() {
		ListMy l = new ListMy(6);
		for (int i = 0; i < 5; i++) {
			l.insert(l.getSize(), i + 1);
		}
		l.revers2();
		for (int i = 0; i < 5; i++) {
			System.out.println(l.del(0));
		}
	}

	public static int test10(int[] ar) {
		int count = 0;
		int countM = 0;
		int countMMax = 0;
		int levels = 4;
		int desi = (int) Math.pow(2, levels - 1);
		for (int ii = 0; ii < desi; ii++) {// solutions
			int pos = 0;
			countM = 0;
			for (int jj = 0; jj < levels; jj++) {// search down
				countM += ar[a000217(jj + 1) - pos - 1];
				if (((1 << jj) & ii) > 0) {
					pos++;
				}
			}
			if (countMMax < countM) {
				countMMax = countM;
			}
			System.out.println("solution ii " + ii + "an " + countM);
		}
		return countMMax;
	}

	public static int a000217(int n) {
		return n * (n + 1) / 2;
	}

	public static long A000108(int n) {
		return fa(2 * n) / (fa(n) * fa(n + 1));
	}

	public static int test9(int n, int g) {
//		if ((m <= 0) || (n <= 0)) {
//			f++;
//			return n;
//		}
//		if (g == 0) {
//			test9(test9(test9(n, 1, 2), 2, 3), 3, 5);
//		}
//		f++;
//		return test9(n - 1, g, m - 1);
		int count = 0;
		int buf = 0;
		buf = n ^ g;
		while (buf != 0) {
			buf = buf & (buf - 1);
			count++;
		}
		return count;
	}

	public static void test8(int n, int m) {
		if (m > n / 2) {
			System.out.print(n + "<");
			return;
		}
		if (n % m == 0) {
			System.out.print(m + " ");
			test8(n / m, m);
		} else {
			test8(n, m + 1);
		}
	}

	private static String test7(int n, int m) {
		if (m > n / 2) {
			return " " + n;
		}
		if (n % m == 0) {
			return m + " " + test7(n / m, m);
		} else {
			return test7(n, m + 1);
		}
	}

	private static String test6(int n, int m) {
		if ((n % m) == 0) {
			return (m) + "";
		}
		if (m > n / 2) {
			return "Yes";
		}
		return test6(n, m + 1);
	}

	private static int test5(int n) {
		if (n < 10) {
			return n;
		}
		System.out.println(n % 10);
		int z = n / 10;
		return test5(z);
	}

	private static int test4(int n) {
		if (n < 10) {
			return n;
		}
		int w = test4(n / 10);
		System.out.println(w);
		w = n % 10;
		return w;
	}

	private static String test3(int n) {
		if (n == 2)
			return "YES";
		int z = n / 2;
		if (n == (z * 2))
			return test3(z);
		return "NO";
	}

	private static void brackets(int n) {
		f = 0;
		bra(n, 0, 0, new char[n * 2]);
		System.out.println(f);
		System.out.println(A000108(n));
		return;
	}

	private static String test1(int n) {
		if (n == 1) {
			return "1";
		}
		String z = test1(n - 1);

		return z + " " + n;
	}

	private static String test2(int n, int m) {
		if (n == m) {
			return "" + m;
		}
		String z = n + "";
		if (n < m)
			z = z + " " + test2(n + 1, m);
		if (n > m)
			z = z + " " + test2(n - 1, m);
		return z;
	}

	private static void bra(int n, int st, int count, char[] ar) {
		if (count == n * 2) {
			// System.out.println(ar);
			f++;
			return;
		}
		if ((st < (n * 2 - count))) {
			ar[count] = '8';
			bra(n, st + 1, count + 1, ar);
		}
		if (st > 0) {
			ar[count] = '1';
			bra(n, st - 1, count + 1, ar);
		}
	}

	public static long fa(int n) {
		if (n <= 1)
			return 1;
		long z = faAr[n];
		if (z != 0) {
			return faAr[n];
		}
		z = fa(n - 1) * n;
		faAr[n] = z;
		return z;
	}
}
