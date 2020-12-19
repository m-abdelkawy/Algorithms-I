package Week3_MergeSort;

public class Helper {
	public static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	public static <T extends Comparable<T>> void display(T[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j]= temp; 
	}
	
	public static void TestClientMergeSort() {
		System.out.println("-------------------------------------------------------");
		System.out.println("   Selection Sort Test Client (Generic Version):");
		System.out.println("-------------------------------------------------------");
		System.out.print("Enter size of the Array: ");
		FastScanner scanner = new FastScanner(System.in);
		Integer size = scanner.nextInt();

		Integer[] arr = new Integer[size];

		for (int i = 0; i < size; i++) {
			//System.out.print("Enter Element No." + (i + 1) + ": ");
			arr[i] = scanner.nextInt();
		}
		
		Integer[] aux = new Integer[size];

		System.out.println("Before Sorting: ");
		Helper.display(arr);
		System.out.println();

		System.out.println("During Sorting: ");
		MergeSort.sort(arr, aux, 0, arr.length-1);
		System.out.println();

		System.out.println("After Sorting: ");
		Helper.display(arr);
		System.out.println();
	}
	
	public static void TestClientMergeSortNonRecursive() {
		System.out.println("-------------------------------------------------------");
		System.out.println("   Selection Sort Test Client (Generic Version):");
		System.out.println("-------------------------------------------------------");
		System.out.print("Enter size of the Array: ");
		FastScanner scanner = new FastScanner(System.in);
		Integer size = scanner.nextInt();

		Integer[] arr = new Integer[size];

		for (int i = 0; i < size; i++) {
			//System.out.print("Enter Element No." + (i + 1) + ": ");
			arr[i] = scanner.nextInt();
		}
		
		Integer[] aux = new Integer[size];

		System.out.println("Before Sorting: ");
		Helper.display(arr);
		System.out.println();

		System.out.println("During Sorting: ");
		MergeSortNonRecursive.sort(arr, aux);
		System.out.println();

		System.out.println("After Sorting: ");
		Helper.display(arr);
		System.out.println();
	}
}
