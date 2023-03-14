import linkedlist.Queue;
import stack.Stack;

public class TimeTest {
    public static void main(String[] args) {
        linkedlist.Queue q = new Queue();
        stack.Stack<String> s = new Stack<>();
        String message = "lynguyen";

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            q.enqueue(message);

            while (!q.isEmpty()) {
                message = q.dequeue();
                s.push(message);
            }

            System.out.println("Print the message:");
            System.out.print("[");
            while (!s.isEmpty()) {
                message = s.pop();
                System.out.print(message);
            }
            System.out.println("]");
        }

        long endTime = System.currentTimeMillis();
        double time = (endTime - startTime) / 10000.0;
        System.out.println("Runtime in seconds:" + time);
    }
}