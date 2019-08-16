package Week2_StacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int size = 0;

	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	public Deque() {
		first = last;
	}

	public boolean isEmpty() {
		return (first == null && last == null);
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		if (isEmpty()) {
			first = new Node();
			first.item = item;

			last = first;
		} else {
			Node oldFirst = first;
			first = new Node();
			first.item = item;

			// if (!isEmpty())
			oldFirst.prev = first;
			first.next = oldFirst;
		}
		size++;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		if (isEmpty()) {
			last = new Node();
			last.item = item;
			first = last;
		} else {
			Node oldLast = last;
			last = new Node();
			last.item = item;

			last.prev = oldLast;
			// if (!isEmpty())
			oldLast.next = last;
		}
		size++;
	}

	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Item item = first.item;
			first = first.next;

			if (size == 1) {
				size--;
				first = null;
				last = first;
				return item;
			}
			size--;
			first.prev = null;
			return item;
		}
	}

	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Item item = last.item;
			last = last.prev;

			if (size == 1) {
				size--;
				last = null;
				first = last;
				return item;
			}
			size--;
			last.next = null;
			return item;
		}
	}

	public Iterator<Item> iterator() {
		return new ListItr();
	}

	private class ListItr implements Iterator<Item> {

		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		Deque<String> deque = new Deque<String>();
		deque.addFirst("BB");
		deque.addFirst("AA");
		deque.addLast("CC");
		deque.addLast("DD");

		Iterator<String> itr = deque.iterator();
		while (itr.hasNext()) {
			StdOut.println(itr.next());
		}

		StdOut.println("Size1: " + deque.size());

		StdOut.println("First Removed: " + deque.removeFirst());
		StdOut.println("Last Removed: " + deque.removeLast());

		itr = deque.iterator();
		while (itr.hasNext()) {
			StdOut.println(itr.next());
		}
		StdOut.println("Size2: " + deque.size());
		StdOut.println("isEmpty: " + deque.isEmpty());
		StdOut.println("First Removed BB: " + deque.removeFirst());
		StdOut.println("isEmpty: " + deque.isEmpty());
		StdOut.println("Size2: " + deque.size());
		itr = deque.iterator();
		while (itr.hasNext()) {
			StdOut.println(itr.next());
		}
		StdOut.println("First Removed CC: " + deque.removeLast());
		StdOut.println("isEmpty: " + deque.isEmpty());
		StdOut.println("Size2: " + deque.size());
		while (itr.hasNext()) {
			StdOut.println(itr.next());
		}
		deque.removeFirst();
		StdOut.println("isEmpty: " + deque.isEmpty());
		StdOut.println("Size2: " + deque.size());
	}
}

