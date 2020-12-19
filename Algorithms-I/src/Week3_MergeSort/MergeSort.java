package Week3_MergeSort;

//Recursive algorithm
//Top down merge sort
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper.TestClientMergeSort();
	}

	public static <T extends Comparable<T>> void sort(T[] arr, T[] aux, int lo, int hi) {
		// base case
		if (hi <= lo)
			return;

		// recursive sorting
		int mid = lo + (hi - lo) / 2;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid + 1, hi);

		if(!Helper.less(arr[mid+1], arr[mid])) return; //the arr is already sorted
		// merge the two halves
		merge(arr, aux, lo, mid, hi);
	}

	public static <T extends Comparable<T>> void merge(T[] arr, T[] aux, int lo, int mid, int hi) {
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
