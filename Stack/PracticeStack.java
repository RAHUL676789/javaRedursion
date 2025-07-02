package Stack;
import java.util.*;

public class PracticeStack {

    public static class Node {
        Character data;
        Node next;

        public Node(Character data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static int size = 0;

   public void addFirst(Character data) {
    Node newNode = new Node(data);
    newNode.next = head; // works even if head is null
    head = newNode;
    size++;
}


    public static Node findMid() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow; // returns node just before mid (for odd/even)
    }

    public static boolean isPalindrome() {
        Stack<Character> s = new Stack<>();

        Node mid = findMid();
        Node temp = head;

        // Push first half into stack
        while (temp != mid) {
            s.push(temp.data);
            temp = temp.next;
        }

        // If list size is odd, skip middle node
        if (size % 2 != 0) {
            temp = temp.next;
        }

        // Compare stack with second half
        while (temp != null) {
            if (s.pop() != temp.data) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PracticeStack pr = new PracticeStack();
        pr.addFirst('a');
        pr.addFirst('b');
        pr.addFirst('c');
        pr.addFirst('b');
        pr.addFirst('a');

        Node temp = head;
        System.out.print("LinkedList: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println("\nIs Palindrome: " + isPalindrome());
    }
}
