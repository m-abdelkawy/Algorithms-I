package Week2_ElementarySorts;

import edu.princeton.cs.algs4.StdRandom;

public class Shuffling {
	// For iteration i generate r(random int between 0 and i)
	// Swap a[r] and a[i]
	public static <T extends Comparable<T>> void shuffle(T[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int rInt = StdRandom.uniform(0, i+1);
				Helper.exchange(a, i, rInt);
		}
	}
}
