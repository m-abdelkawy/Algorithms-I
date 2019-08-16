package Week2_StacksAndQueues;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;




public class StackArray<T> implements Iterable<T>{
	T[] s;
	int N = 0;

	public StackArray() {
		s = (T[])new Object[1];
	}
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T>{
		private int current = 0;
		public boolean hasNext(){
			StdOut.print("hasNext called!!");
			return (s.length > current && s[current] != null);
		}
		public void remove(){}
		public T next(){
			StdOut.print("next method called!!");
			return s[current++];
		}
//		public void reset(){
//			current = 0;
//		}
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(T item) {
		if (N == s.length) {
			resizeArray(2 * s.length);
		}
		s[N++] = item;
	}

	public T pop() {
		T item = s[--N];
		s[N] = null;
		if (N > 0 && N == s.length / 4)
			resizeArray(s.length / 2);
		return item;
	}

	private void resizeArray(int capacity) {
		T[] temp = (T[])new Object[capacity];

		if (s.length <= capacity) {
			for (int i = 0; i < s.length; i++) {
				temp[i] = s[i];
			}
		}
		else {
			for (int i = 0; i < temp.length; i++) {
				temp[i] = s[i];
			}
		}
		

		s = temp;
	}
}
