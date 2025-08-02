import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetecttheLoop_with_loping {

    public static boolean Detect(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Loop detected
            }
        }
        return false; // No loop
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null, tail = null;
        Node[] nodes = new Node[n]; // store node references to create loop later

        for (int i = 0; i < n; i++) {
            System.out.print("Enter data for node " + (i + 1) + ": ");
            int data = sc.nextInt();
            Node newnode = new Node(data);
            nodes[i] = newnode;

            if (head == null) {
                head = newnode;
                tail = newnode;
            } else {
                tail.next = newnode;
                tail = newnode;
            }
        }

        // Ask if user wants to create a loop
        System.out.print("Enter index to connect the last node to (0-based index, -1 for no loop): ");
        int loopIndex = sc.nextInt();

        if (loopIndex >= 0 && loopIndex < n) {
            tail.next = nodes[loopIndex]; // create loop
            System.out.println("Loop created at index " + loopIndex);
        } else {
            System.out.println("No loop created.");
        }

        boolean result = Detect(head);
        System.out.println("Loop detected: " + result);
    }
}
