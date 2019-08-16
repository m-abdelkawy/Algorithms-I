package Week2_StacksAndQueues;

import edu.princeton.cs.algs4.StdOut;

public class QueueOfStringsResizeArray {
	String[] queue;
	int head, tail;

	public QueueOfStringsResizeArray() {
		queue = new String[1];
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public void enqueue(String item) {
		queue[tail++] = item;
		if(tail == queue.length){
			resizeArray(2 * queue.length);
		}
	}

	public String dequeue() {
		if (isEmpty()) {
			StdOut.print("queue is empty!");
			return null;
		}
		String item = queue[head];
		for (int i = 0; i < tail - 1; i++) {
			queue[i] = queue[i + 1];
		}
		queue[--tail] = null;
		if(tail == queue.length/4){
			resizeArray(queue.length/2);
		}
		return item;
	}
	
	public void resizeArray(int capacity){
		String[] temp = new String[capacity];
		if(capacity > queue.length){
			for (int i = 0; i < queue.length; i++) {
				temp[i] = queue[i];
			}
		}
		else {
			for (int i = 0; i < temp.length; i++) {
				temp[i] = queue[i];
			}
		}
		queue = temp;
	}
}
