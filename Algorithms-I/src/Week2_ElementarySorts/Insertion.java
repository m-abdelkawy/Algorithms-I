package Week2_ElementarySorts;

import edu.princeton.cs.algs4.StdOut;

public class Insertion {
	public static <T extends Comparable<T>> void sort(T[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j - 1])) {
					exchange(a, j, j - 1);
				} else {
					break;
				}
			}
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
