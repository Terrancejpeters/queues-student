
package structures;

import java.util.NoSuchElementException;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List
 * structure to allow for unbounded size.
 *
 * @param <T>
 *            the elements stored in the stack
 */
public class Stack<T> {

	private Node<T> top;
	private int size = 0;

	/**
	 * {@inheritDoc}
	 */

	public T pop() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		Node<T> oldTop = top;
		top = top.getNext();
		size -= 1;
		return oldTop.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	
	public T peek() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		return top.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * {@inheritDoc}
	 */
	
	public int getSize() {
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	
	public void push(T elem) {
		top = new Node<T>(elem, top);
		size += 1;
	}

}
