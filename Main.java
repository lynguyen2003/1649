import java.util.Scanner;
import linkedlist.*;
import stack.Stack;

public class Main {
	public static void main(String[] args) {
		Queue queue = new Queue();
		Stack<String> messages = new Stack<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add messages to queue(enqueue):");
			System.out.println("2. Show all messages in queue");
            System.out.println("3. Remove messages from Queue(dequeue):");
            System.out.println("4. Add messages to stack(push):");
			System.out.println("5. Show all messages in Stack:");
            System.out.println("6. Remove messages from Stack (pop):");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
				case 1:
					System.out.println("Enter message:");
					String message = sc.nextLine();
					queue.enqueue(message);
					
					break;
				case 2:
					if (queue.isEmpty()) {
						System.out.println("Queue is Empty");
					} else {
						System.out.println("All messages in queue:");
						Node currentNode = queue.head;
						while (currentNode != null) {
							System.out.println(currentNode.data);
							currentNode = currentNode.next;
						}
					}
					break;
				case 3:
					try {
						String removedMessage = queue.dequeue();
						System.out.println("Removed message from front: " + removedMessage);
						System.out.println("Queue update:");
						Node currentNode = queue.head;
						while (currentNode != null) {
							System.out.println(currentNode.data);
							currentNode = currentNode.next;
						}
					} catch (IllegalStateException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Enter message:");
					String msg = sc.nextLine();
					messages.push(msg);
					break;
				case 5:
					if (messages.empty()) {
						System.out.println("Stack is empty.");
					} else {
						System.out.println("Messages in Stack:");
						Stack<String> tempStack = new Stack<>();
						while (!messages.empty()) {
							String msgS = messages.pop();
							System.out.println(msgS);
							tempStack.push(msgS);
						}
						while (!tempStack.empty()) {
							messages.push(tempStack.pop());
						}
					}
					break;
				case 6:
					if (messages.empty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        String removedMsg = messages.pop();
                        System.out.println("Message removed from Stack: " + removedMsg);
                    }
					break;
				case 7:
					System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
			}
		}	
	}
}
