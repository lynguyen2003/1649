package linkedlist;
import java.util.NoSuchElementException;

public class Queue {
    public Node head;
    public Node tail;
    int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(String data) {
        if (data.length() > 250) {
            throw new IllegalArgumentException("Message should not exceed 250 characters");
        }
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!.");
        }
        String data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return data;
    }
}
