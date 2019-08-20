package Week2_ElementarySorts;

import edu.princeton.cs.algs4.StdOut;

public class Shell {
	public static <T extends Comparable<T>> void sort(T[] a) {
		int N = a.length;

		// 3X-1 increment sequence
		int h = 1;
		while (h < N / 3) {
			h = h * 3 + 1;
		}

		// Sorting
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j -= h) {
					if (less(a[j], a[j - h])) {
						exchange(a, j, j - h);
					}
				}
			}
			// Next Increment
			h = h / 3;
			Helper.display(a);
			StdOut.println();
		}

		
	}

	private static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
