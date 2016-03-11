package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {

	private int size;
	protected Node<T> head;
	private Node<T> last;

	public Queue() {
		size = 0;// TODO 1
		head = null;
	}

	public Queue(Queue<T> other) {
		size = 0;
		head = other.head;

	}

	@Override
	public boolean isEmpty() {
		if (size <= 0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		// TODO 4
		return size;
	}

	@Override
	public void enqueue(T element) {
		size++;
		if (head == null) {
			head = new Node<T>(element, null);
		} else if (last == null) {
			last = new Node<T>(element, null);
			head.setNext(last);
		} else {
			Node<T> temp = new Node<T>(element, null);
			last.setNext(temp);
			last = temp;
		}
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		size--;
		if (head == null) {
			throw new NoSuchElementException("No object in Queue to dequeue");
		}
		Node<T> temp = head;
		head = head.getNext();

		return temp.getData();
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO 7
		if (head != null)
			return head.getData();
		else
			throw new NoSuchElementException("No objects in Queue");
	}

	public T get(int n) throws NoSuchElementException {
		Iterator<T> it = new listIterator<T>(head);
		if (n >= size || n < 0) {
			throw new NoSuchElementException("Greater than size");
		}
		T temp = it.next();
		int i = 0;
		while (i < n && it.hasNext()) {
			temp = it.next();
			i++;
		}
		return temp;
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {
		Stack<T> temp = new Stack<T>();
		for (int i = 0; i < size(); i++){
			temp.push(get(i));
		}
		Queue<T> rval = new Queue<T>();
		while (!temp.isEmpty()){
			rval.enqueue(temp.pop());
		}
		return rval;
		// TODO 8
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
	}
}
