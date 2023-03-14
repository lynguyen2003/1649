package stack;
import java.util.EmptyStackException;

public class Stack<E> {
    private int topIndex; 
	public static final int CAPACITY = 1000;
	private E[] data;

	// constructs stack with default 
	public Stack() {
		this(CAPACITY);
    }

	public Stack(int capacity) { // constructs stack with given capacity
        topIndex = -1;
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }
	
	public int size() {
        return (topIndex + 1);
    }

	public boolean isEmpty() {
		return (topIndex == -1);
	}

	public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++topIndex] = e; // increment topIndex before storing new item
    }

	public E pop() throws EmptyStackException {
        if (empty()) throw new EmptyStackException();
        E answer = data[topIndex];
        data[topIndex] = null; // dereference to help garbage collection
        topIndex--;
        return answer;
    }
	public boolean empty() {
        return (topIndex == -1);
    }
}
