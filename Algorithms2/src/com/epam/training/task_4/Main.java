package com.epam.training.task_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {

		// System.out.println(chekStr("абвгдеёжзийклмнопрстуфхцчшщьыъэюя",
		// "бабгдеёжзийклмнопрстуфхцчшщьыъэюя"));
		System.out.println(
				Arrays.toString(chekTime(new int[] { 0, 2, 2, 2, 5, 6, 7 }, new int[] { 12, 2, 2, 2, 9, 10, 11 })));
	}

	public static boolean chekStr(String tea, String tea2) {
		if (tea.equals(tea2)) {
			return true;
		}
		if (tea.length() != tea2.length()) {
			return false;
		}

		HashSet<Character> set = new HashSet<Character>();
		HashSet<Character> set2 = new HashSet<Character>();

		for (Character c : tea.toCharArray()) {
			set.add(c);
		}
		for (Character c : tea2.toCharArray()) {
			set2.add(c);
		}
		if ((set.size() == 33) && (set2.size() == 33)) {
			return false;
		}

		boolean possible = true;

		for (int i = 0; i < tea.length(); i++) {
			for (int ii = i + 1; ii < tea.length(); ii++) {
				if (tea.charAt(i) == tea.charAt(ii)) {
					if (tea2.charAt(i) != tea2.charAt(ii)) {
						possible = false;
					}
				}
			}
		}

		return possible;
	}

	public static int[] chekTime(int[] arrayStart, int[] arrayEnd) {
		ArrayList<TimePoint> com = new ArrayList<TimePoint>();
		int count = 0;
		for (int i = 0; i < arrayStart.length; i++) {
			com.add(new TimePoint(arrayStart[i], true));
			com.add(new TimePoint(arrayEnd[i], false));
		}
		Collections.sort(com);
		int[] max = new int[2];
		for (int i = 0; i < arrayStart.length * 2; i++) {
			if (com.get(i).start) {
				count++;
			} else {
				count--;
			}
			// System.out.println(com.get(i).time + " " + count + " " + com.get(i).start);
			if (count > max[0]) {
				max[0] = count;
				max[1] = com.get(i).time;
			}
		}
		return max;
	}
}

class TimePoint implements Comparable<TimePoint> {
	int time;
	boolean start;

	public TimePoint(int time, boolean start) {
		super();
		this.time = time;
		this.start = start;
	}

	@Override
	public int compareTo(TimePoint o) {
		int w = this.time > o.time ? 1 : this.time == o.time ? 0 : -1;
		if (w == 0) {
			if (this.start && (!o.start)) {
				w = -1;
			}
			if ((!this.start) && (o.start)) {
				w = 1;
			}
		}
		return w;
	}

	@Override
	public String toString() {
		return time + " " + (this.start ? -1 : -8);
	}

}
