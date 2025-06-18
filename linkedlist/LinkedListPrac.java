package linkedlist;

public class LinkedListPrac {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Linkedlist {
        public Node head;

        public Node addFirst(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return newNode;
            }
            newNode.next = head;
            head = newNode;
            return newNode;
        }

        public void printll() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("Null");
        }
    }

    // ✅ Function to find intersection
    public static Node generateInterSecNode(Node headA, Node headB) {
        Node l1 = headA;
        Node h2;

        while (l1 != null) {
            h2 = headB;
            while (h2 != null) {
                if (h2 == l1) {
                    return h2;
                }
                h2 = h2.next;
            }
            l1 = l1.next;
        }

        return null;
    }


    public static Node interSection(Node h1, Node h2){
      System.out.println("intes");
        Node headA = h1;
        Node headB = h2;

        while (headA != headB) {
            headA = headA == null ? headB : headA.next;
            headB = headB == null ? headA : headB.next;
        }

        return headA;
    }


    public static void deleMnodeAfterN(Node head,int n , int m){
                    
        Node h = head,t;

        while (h != null) {
            
             for( int i = 1 ; i < n && h!=null ; i++){
                h = h.next;
             }

             if(h == null) return;

              t= h.next;
             for(int j = 1; j<=m; j++){
               t= t.next;
             }

          h.next = t;
          h = t;
        }
    }



    public static void swapNodeInLinkedlist(int n , int m,Node head){

        Node prevX = null; Node currX = head;

        if(n == m) return;

        while (currX != null && currX.data != n) {
               prevX = currX;
              currX = currX.next;
         
        }

        Node prevY  = null; Node currY = head;
        while (currY != null && currY.data  != m) {
            prevY = currY;
            currY = currY.next;
        }
     
        if(currX == null && currY == null) return;

    }



    public static Node evenOdd(Node head){

        if(head == null) return null;

        Node dummyEvenHead = new Node(0);
        Node dummyOddHead = new Node(0);
        Node evenhead = dummyEvenHead;
        Node oddHead = dummyOddHead;

        Node current = head;
        while (current != null) {
             if (current.data % 2 == 0) {
                evenhead.next = current;
                evenhead = evenhead.next;
             }else{
                oddHead.next = current;
                oddHead = oddHead.next;
             }
             current = current.next;
        }

        oddHead.next = null;
        evenhead.next = dummyOddHead.next;
        return dummyEvenHead.next;

    }

    public static void main(String[] args) {
        Linkedlist ll1 = new Linkedlist();
        Linkedlist ll2 = new Linkedlist();

        
        ll1.addFirst(1);
        ll1.addFirst(2);
        ll1.addFirst(3);
        ll1.addFirst(4);
        ll1.addFirst(5);
        ll1.addFirst(6);
        ll1.addFirst(6);
        ll1.addFirst(8);
        ll1.printll();
       
        ll1.head =  evenOdd(ll1.head);
        System.out.println(ll1.head.data);
        ll1.printll();
        //  Creating first linked list: 10 -> 20
       
        //  Connecting intersection node to both lists
      
    }
}
