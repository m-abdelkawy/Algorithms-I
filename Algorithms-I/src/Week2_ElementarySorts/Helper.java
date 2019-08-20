package Week2_ElementarySorts;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Helper {
	public static <T> void display(T[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			StdOut.print(a[i] + "\t");
		}
	}

	public static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	public static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void TestClientSelectionSort() {
		StdOut.println("-------------------------------------------------------");
		StdOut.println("   Selection Sort Test Client (Generic Version):");
		StdOut.println("-------------------------------------------------------");
		StdOut.print("Enter size of the Array: ");
		int size = StdIn.readInt();

		Integer[] arr = new Integer[size];

		for (int i = 0; i < size; i++) {
			StdOut.print("Enter Element No." + (i + 1) + ": ");
			arr[i] = StdIn.readInt();
		}

		StdOut.println("Before Sorting: ");
		Helper.display(arr);
		StdOut.println();

		StdOut.println("During Sorting: ");
		Selection.sort(arr);
		StdOut.println();

		StdOut.println("After Sorting: ");
		Helper.display(arr);
		StdOut.println();
	}

	public static void TestClientInsertionSort() {
		StdOut.println("-------------------------------------------------------");
		StdOut.println("   Insertion Sort Test Client (Generic Version):");
		StdOut.println("-------------------------------------------------------");
		StdOut.print("Enter size of the Array: ");
		int size = StdIn.readInt();

		Integer[] arr = new Integer[size];

		for (int i = 0; i < size; i++) {
			StdOut.print("Enter Element No." + (i + 1) + ": ");
			arr[i] = StdIn.readInt();
		}

		StdOut.println("Before Sorting: ");
		Helper.display(arr);
		StdOut.println();

		StdOut.println("During Sorting: ");
		Insertion.sort(arr);
		StdOut.println();

		StdOut.println("After Sorting: ");
		Helper.display(arr);
		StdOut.println();
	}

	public static void TestClientShellSort() {
		StdOut.println("-------------------------------------------------------");
		StdOut.println("   Shell Sort Test Client (Generic Version):");
		StdOut.println("-------------------------------------------------------");
		StdOut.print("Enter size of the Array: ");
		int size = StdIn.readInt();

		Integer[] arr = new Integer[size];

		for (int i = 0; i < size; i++) {
			StdOut.print("Enter Element No." + (i + 1) + ": ");
			arr[i] = StdIn.readInt();
		}

		StdOut.println("Before Sorting: ");
		Helper.display(arr);
		StdOut.println();

		StdOut.println("During Sorting: ");
		Shell.sort(arr);
		StdOut.println();

		StdOut.println("After Sorting: ");
		Helper.display(arr);
		StdOut.println();
	}
}
