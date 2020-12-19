package Week3_MergeSort;

//Bottom up merge sort
//http://www.codebytes.in/2014/10/bottom-up-merge-sort-java-implementation.html
public class MergeSortNonRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Helper.TestClientMergeSortNonRecursive();
	}

	public static <T extends Comparable<T>> void sort(T[] arr, T[] aux) {
		int N = arr.length;

		for (int size = 1; size < N; size *= 2) {
			for (int lo = 0; lo < N - size; lo += 2 * size) {
				merge(arr, aux, lo, lo + size - 1, Math.min(lo + 2 * size - 1, N - 1));
			}
		}
	}

	private static <T extends Comparable<T>> void merge(T[] arr, T[] aux, int lo, int mid, int hi) {
		// copy arr into aux

		for (int k = 0; k < aux.length; k++) {
			aux[k] = arr[k];
		}

		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				arr[k] = aux[j++];
			else if (j > hi)
				arr[k] = aux[i++];
			else if (Helper.less(aux[i], aux[j]))
				arr[k] = aux[i++];
			else
				arr[k] = aux[j++];
		}
	}

}
