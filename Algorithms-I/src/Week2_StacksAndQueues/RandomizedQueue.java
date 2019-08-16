package Week2_StacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] queue;
	private int head, tail;

	public RandomizedQueue() {
		queue = (Item[]) new Object[1];
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public int size() {
		return tail - head;
	}

	public void enqueue(Item item) {
		if (item == null)
			throw new IllegalArgumentException();

		queue[tail++] = item;
		if (tail == queue.length) {
			resizeArray(2 * queue.length);
		}
	}

	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();

		int random = StdRandom.uniform(head, tail);

		Item item = queue[random];
		// for (int i = random; i < tail - 1; i++) {
		// queue[i] = queue[i + 1];
		// }
		queue[random] = queue[--tail];
		if (tail <= queue.length / 4) {
			resizeArray(queue.length / 2);
		}
		return item;
	}

	public Item sample() {
		if (isEmpty())
			throw new NoSuchElementException();

		return queue[StdRandom.uniform(head, tail)];
	}

	private void resizeArray(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		if (capacity > queue.length) {
			for (int i = 0; i < queue.length; i++) {
				temp[i] = queue[i];
			}
		} else {
			for (int i = 0; i < temp.length; i++) {
				temp[i] = queue[i];
			}
		}
		queue = temp;
	}

	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		 private final int[] indices = new int[tail - head];
		private int current = head;

		public ArrayIterator() {
			for (int i = 0; i < indices.length; i++) {
				indices[i] = i;
			}
		}
		public boolean hasNext() {
			return current < indices.length;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();

			return queue[indices[current++]];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// unit testing (required)
	public static void main(String[] args) {
		// Randomized Queue
		RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
		randomizedQueue.enqueue("AA");
		randomizedQueue.enqueue("BB");
		randomizedQueue.enqueue("CC");
		randomizedQueue.enqueue("DD");

		Iterator<String> itr = randomizedQueue.iterator();
		while (itr.hasNext()) {
			StdOut.println(itr.next());
		}

		StdOut.println("Size1: " + randomizedQueue.size());

		StdOut.println("random Removed1: " + randomizedQueue.dequeue());
		itr = randomizedQueue.iterator();
		while (itr.hasNext()) {
			StdOut.println(itr.next());
		}

		StdOut.println("Size2: " + randomizedQueue.size());

		StdOut.println("random Removed2: " + randomizedQueue.dequeue());
		itr = randomizedQueue.iterator();
		while (itr.hasNext()) {
			StdOut.println(itr.next());
		}

		StdOut.println("Size3: " + randomizedQueue.size());

		StdOut.println("random sample: " + randomizedQueue.sample());
		itr = randomizedQueue.iterator();
		while (itr.hasNext()) {
			StdOut.println(itr.next());
		}

		StdOut.println("Size4: " + randomizedQueue.size());

	}
}
