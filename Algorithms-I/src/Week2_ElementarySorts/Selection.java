package Week2_ElementarySorts;

import edu.princeton.cs.algs4.StdOut;

public class Selection<T> {
	public static <T extends Comparable<T>> void sort(T[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			if (min != i)
				exchange(a, i, min);
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
