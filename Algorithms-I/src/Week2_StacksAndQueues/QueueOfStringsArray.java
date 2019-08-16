package Week2_StacksAndQueues;

import edu.princeton.cs.algs4.StdOut;


public class QueueOfStringsArray {
	String[] queue;
	int head, tail, capacity;
	
	public QueueOfStringsArray(int _capacity) {
		capacity = _capacity;
		queue = new String[capacity];
	}
	
	public boolean isEmpty(){
		return head == tail;
	}
	
	public boolean isFull(){
		return tail == capacity;
	}
	public void enqueue(String item){
		if(isFull()){
			StdOut.print("Queue is full");
			return;
		}
		queue[tail++] = item;
	}
	
	public String dequeue(){
		if(isEmpty()){
			StdOut.print("queue is empty!");
			return null;
		}
		String item = queue[head];
		for (int i = 0; i < tail - 1; i++) {
			queue[i] = queue[i+1];
		}
		queue[--tail] = null;
		return item;
	}
}
