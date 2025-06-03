package linkedlist;

// import java.nio.file.LinkOption;

// public package linkedlist;

public class LinkedList {

    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    // a single linked list contain only one head and only one tail so we have to
    // declare the head and tail inside the linkedlist class

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // first step iniitliaze the new node;
        Node newNode = new Node(data);
        size++;

        // if there is no node int he linkedlist
        if (head == null) {

            head = tail = newNode;
            return;

        }

        // if there is some node in the linked list

        newNode.next = head;
        head = newNode;
    }

    // add in the last opeartion in the linked list there are following steps to do

    public void addLast(int data) {

        // step 1 to initilize the new node`
        Node newNode = new Node(data);
        size++;
//  chek if there is no node in the linked list
        if (head == null) {
            head = tail = newNode;
            return;

        }

        //  add the node in to the last
        tail.next = newNode;
        tail = newNode;

    }


    // for printing all the data from the linkedlist

    public void printll() {
        if (head == null) {
            System.out.println("LL is empty");
        }
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ->  ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    //  add in the middle of any two node
    public void addInTheMiddle(int i, int data) {
        // check if the index is zero  means we have to add the new node into the first
        if(i == 0){
            addFirst(data);
            return;
        }
        
        // then create a new node to add into the linked list
        Node newNode = new Node(data);
        size++;
        Node temp = head;

        int index = 0;

        // loop while we are not reach to the index-1 means preveisou bcs we have break link and add the link between prev and next
       while (index < i - 1) {
        temp = temp.next;
        index++;
       }
      newNode.next = temp.next;
      temp.next = newNode;
    
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("the linked list is empyt");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }


    public int removeLast(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }
         Node temp  = head;
        for(int i = 0; i< size-2; i++){
            temp = temp.next;

        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }


    public int search(int key){
        
        int i = 0;
        Node temp = head;
        while (temp != null) {
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
            
        }
        return -1;
    }

    public int helper (Node h , int key){
        if(h == null){
            return - 1;
        }

       if(h.data ==  key){
        return 0;
       }

       int val = helper(h.next, key);
       if(val != -1){
        val = val + 1;
       }
       return val;
    }

    public int recursiveSearch(int key  ){
       return helper(head, key);
    }


    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr !=  null) {
            next = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = next;
        }

        head = prev;
    }



    public static int findAndRemoveNthFromLast(int n){
      Node prev = head;


      if(n > size){
        return Integer.MIN_VALUE;
      }

        if(n == size){
           head = prev.next;
           return prev.data;
        }
    
        for(int i = 1; i < size - n  ; i++){
          
            prev = prev.next;
        }
      
      
        prev.next = prev.next.next;

        return prev.next.data;

    }


    public static Node findMiddle(Node head){
        Node slow  = head;
        Node fast = head;
     
        while(fast != null && fast.next != null){
                  slow = slow.next;
                  fast = fast.next.next;
               
        }

        return slow;

    }


    public static boolean checkIsllPalindrome(){

        // base case 

        if(head == null || head.next == null){
            return true;
        }


        // step 2 to find the midd

        Node midNode = findMiddle(head);

        Node prev = null;
        Node curr = midNode;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right  = prev;
        Node left = head;

        while (right != null) {
            
            if(left.data != right.data){
                return false;
            }

            right = right.next;
            left = left.next;
        }

        return true;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
      ll.addFirst(1);
      ll.addFirst(2);
      ll.addFirst(3);
      ll.addFirst(2);
      ll.addFirst(1);

      System.out.println(ll.checkIsllPalindrome());
       


    

   

    }
}