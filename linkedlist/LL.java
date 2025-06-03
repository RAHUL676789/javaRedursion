package linkedlist;

import java.security.PublicKey;

public class LL {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;

            // we are initilize the next with null value bcs we suppose there is no next
            // node or there is only single node in the linkedlist

            this.next = null;
        }
    }

    // each linkedlist have two important thing or pointer one is head which is
    // pointing to the first node of the linked list and another one is tail node
    // which is pointing to the last node of the linked list

    public static Node head;
    public static Node tail;

    // each linked list have their own size
    public static int size;

    // operation in linkedlist we have major four operetion in linked add remove
    // find print now we will saw the add operation there is two type of add
    // operation in linked list we can add a node in the linked list in the head
    // side and another is tail side

    // add first opeation

    public void addFirst(int data) {

        // for add int the first there is some steps

        // first step to create a node with data;

        Node newNode = new Node(data);
        size++;

        // check if there is another node or the ll is empty if its empty then assign
        // head = tail = newnode;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // if the there is exitense of node so assign the newnode.next to head and head
        // to newnode

        newNode.next = head;
        head = newNode;
    }

    // second add operation is to add in the last

    public void addLast(int data) {

        // check if there is no node in the linked list
        if (head == null) {
            addFirst(data);
            return;
        }

        // if there is some node in the linked list

        Node newNode = new Node(data);
        size++;
        tail.next = newNode;
        tail = newNode;

    }


    // third operation to print the linked list
    public void print() {

        // check if there is any node or not
        if (head == null) {
            System.out.println("the ll is empty --->null");
            return;
        }

        // assign head to a temp variable
        Node temp = head;

        while (temp != null) {
            // print the temp.data 
            System.out.print(temp.data + "-->");
            // increase the temp to its next
            temp = temp.next;

        }
        System.out.println("NUll");

    }


    // four operation is to remove a node from first

    public int removeFirst(){

        // check if there is existence of any node or not

        if(head == null){
            System.out.println("the linked list is empyt there is no existence of not");
            return Integer.MIN_VALUE;
        }

        // you can store the head value to the temp for futher use

        Node temp = head;

        if(head.next == null){
            head = tail = null;
            size--;
            return temp.data;
        }


        // move head to its next then garbage collectore automatically remove the node
      
        head = temp.next;
          size--;
        return temp.data;
    }


    
    // 5th operation to remove the element from the last of the linked list


    public int removeLast(){


        // check if there is any node in the linked list


        if(head == null){
            System.out.println("the ll is empty");
            return Integer.MIN_VALUE;
        }

        if(head.next == null){
         int val =   removeFirst();
         return val;

        }
        Node prev = head;
  
        for (int i = 0; i < size - 2; i++) {
             prev = prev.next;
        }
      System.out.println(prev.data);
        prev.next = null;

        tail = prev;
        size--;
        return 0;
    }


    public int search(int key){


        //check if the current linkedlist is empty or not

        if(head == null){
            System.out.println("the linked list i empty");
            return Integer.MIN_VALUE;
        }

        Node temp = head;
        int i = 0;

        while (temp != null) {
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }

        return Integer.MIN_VALUE;
    }


    public int helper(Node head,int key){
        // base case kya hamre head == null 

        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }

        int r = helper(head.next, key);
        if(r != -1){
            r = r+1;
        }
        return r;
    }


    public int recursiveSearch(int key){
        int i = helper(head,key);
        return i;
    }



    public void addInTheMiddle(int i, int data){
        if(i == 0){
            addFirst(data);
            return;
        }

        int index = 0;
        Node prev = head;
        while (index < i - 1) {
            prev = prev.next;
            index++;
        }

        Node  newNode = new Node(data);
        size++;
        newNode.next = prev.next;
        prev.next = newNode;
    }


    public void reverse(){

        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
             next = curr.next;
             curr.next=prev;
             prev=curr;
             curr= next;
        }

        head =  prev;
    }


    public void findAndRemoveNthFromLast(int n ){
          
        if(n == size){
            removeFirst();
            return;
        }

        int i = 0;
        Node prev = head;
        while (i < size - n - 1) {
            prev = prev.next;
            i++;
        }
          System.out.println(prev.data);
        prev.next = prev.next.next;
        return;
    }


    // question is to check is the linkelist is palindrome or not
    
    public Node middle(Node h){
        Node slow = h.next;
        Node fast = h.next;

        while (fast != null && fast.next !=  null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
   
    public boolean checkIsllPalindrome(){

        if(head == null || head.next == null){
            return true;
        }

        Node middNode = middle(head);

        Node prev = null;
        Node right = middNode;
        Node left = head;

        while (right != null) {
            Node next = right.next;
            right.next = prev;
            prev = right;
            right = next;
        }

        right = prev;

        while (right != null) {
           if(right.data != left.data){
            return false;
           } 
        }

        return true;
    }



public static boolean isCycle(Node h){

    Node slow = h;
    Node fast = h;

    while (fast != null && fast.next != null) {
         
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast){
            return true;
        }
    }

    return false;

}


public static void removeCycle(){
    Node slow = head;
    Node fast = head;

    boolean cycle = false;


    while (fast != null && fast.next != null) {
         
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast){
            cycle = true;
            break;
        }
    }


    if(cycle = false){
        return;
    }

    slow = head;
    Node prev = null;

    while (slow != fast) {
        prev = fast;
         slow = slow.next;
         fast = fast.next;
    }

    prev.next = null;

}
    public static void main(String[] args) {
        LL ll = new LL();
         head = new Node(1);
         Node temp  = new Node(2);
         head.next = temp;
         head.next.next = new Node(3);
         head.next.next.next = temp;
        //  head.next.next.next = head;
   System.out.print(  isCycle(head));
   removeCycle();
   System.out.println(
    
   );
   System.out.print(isCycle(head));

    //    ll.reverse();
    // //    ll.print();
    //    ll.findAndRemoveNthFromLast(3);
    //    ll.print();
    }
}