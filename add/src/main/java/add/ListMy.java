package add;

import java.util.Arrays;

public class ListMy {
	private int[] valu;
	private int[] empt;
	private int[] next;
	private int head = 0;
	private int ste = -1;

	public int getSize() {
		return size;
	}

	private int size = 0;

	public void revers2() {
		int temp = head;
		int nex = 0;
		int curr = next[head];
		int fin = curr;
		for (int i = 0; i < size; i++) {

			nex = next[curr];

			next[curr] = temp;
			if (nex < 0) {
				break;
			}
			temp = curr;
			curr = nex;
		}
		next[head] = curr;
		next[fin] = -1;
	}

	public void revers() {
		if (size < 2) {
			return;
		}
		int[] bufArr = new int[size];
		int curr = next[head];
		for (int i = 0; i < size; i++) {
			bufArr[i] = curr;
			curr = next[curr];
		}

		for (int i = size - 2; i >= 0; i--) {
			next[bufArr[i + 1]] = bufArr[i];
		}
		next[bufArr[0]] = -1;
		next[head] = bufArr[size - 1];
	}

	public ListMy(int z) {

		this.valu = new int[z];
		this.empt = new int[z];
		this.next = new int[z];
		int n = empt.length;
		for (int i = 0; i < n; i++) {
			empt[i] = n - i - 1;
			ste++;
		}
		Arrays.fill(next, -1);
		ste--;
	}

	public void insert(int inx, int val) {
		if (size < inx) {
			return;
		}
		if (ste > empt.length) {
			return;
		}
		int pos = head;
		for (int i = 0; i < inx; i++) {
			pos = next[pos];
		}
		int e = empt[ste];
		ste--;
		next[e] = next[pos];
		next[pos] = e;
		size++;
		valu[e] = val;
	}

	public int del(int inx) {

		if (inx >= size) {
			return -77;
		}
		int pos = head;
		for (int i = 0; i < inx; i++) {
			pos = next[pos];
		}
		int bu = next[pos];
		next[pos] = next[bu];
		next[bu] = -1;
		ste++;
		empt[ste] = bu;
		size--;
		return valu[bu];
	}

}
