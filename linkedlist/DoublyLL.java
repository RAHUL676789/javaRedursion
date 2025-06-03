package linkedlist;

public class DoublyLL {

    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }


    public static Node head ;
    public static Node tail ;
    public static int size = 0;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
           head = tail = newNode;
           return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void print(){
        Node temp = head;
        System.out.print("NUll<--");
        while (temp != null) {
            System.out.print(temp.data + "<-->");
            temp = temp.next;
        }
        System.out.println("Null");
    }


    public int  removeFirst(){

        if(head == null){
            System.out.println("DoublyLL is empy");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            head = tail = null;
            size--;
            return Integer.MIN_VALUE;
        }
          int val = head.data;
        head = head.next;
        head.prev = null;
        size--;


        return val;

    }

    public void addLast(int data){

        if(head == null ){
                  addFirst(data);
                  return;
        }

        Node newNode = new Node(data);
        tail.next =newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;


    }

    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next ;

        while (curr != null) {
             next = curr.next;
             curr.next = prev;
             curr.prev = next;

             prev = curr;
             curr = next;

        }

        head = prev;
    }

    public int removeLast(){

        if(tail == null){
            System.out.println("the DoublyLL is empty");
            return Integer.MIN_VALUE;
        }

         int val = tail.data;
        if(size == 1){
          
              head = tail = null;
              size--;
          
             return val;
           

        }else{
            
       Node temp = tail.prev;
        temp.next = null;
        tail = temp;
        size--;
     
        }

        return val;

    }
    public static void main(String[] args) {
        DoublyLL dll =new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(6);
        dll.addFirst(2);
        dll.addFirst(1);

        dll.print();
        dll.reverse();;
        dll.print();

    
    }
    

}