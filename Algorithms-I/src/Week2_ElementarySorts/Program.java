package Week2_ElementarySorts;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Program {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Double[] a = new Double[n];

		for (int i = 0; i < n; i++) {
			a[i] = StdRandom.uniform();
		}
		
		for (int i = 0; i < n; i++) {
			StdOut.println(a[i]);
		}

		Selection.sort(a);

		for (int i = 0; i < n; i++) {
			StdOut.println(a[i]);
		}
	}

}
