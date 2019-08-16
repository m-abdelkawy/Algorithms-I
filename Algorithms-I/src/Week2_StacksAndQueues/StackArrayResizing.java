package Week2_StacksAndQueues;

public class StackArrayResizing {
	String[] s;
	int N = 0;

	public StackArrayResizing() {
		s = new String[1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(String item) {
		if (N == s.length) {
			resizeArray(2 * s.length);
		}
		s[N++] = item;
	}

	public String pop() {
		String item = s[--N];
		s[N] = null;
		if (N > 0 && N == s.length / 4)
			resizeArray(s.length / 2);
		return item;
	}

	private void resizeArray(int capacity) {
		String[] temp = new String[capacity];

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
