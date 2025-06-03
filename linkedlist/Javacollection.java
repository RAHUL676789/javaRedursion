 package linkedlist;

class Javacollection {

    
    public static class Node {
    
        int data ;
        Node next ;

        public Node(int data){
            this.data  = data;
            this.next = null;
            
        }



    }


    public static Node head ;

    public  void addFirst(int data){
        Node nwNode = new Node(data);
        nwNode.next = head;
        head = nwNode;
        
    }
       public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static Node getMidNode(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node midNode = getMidNode(head);

        Node rightNode = midNode.next;
        midNode.next = null;

        Node right = mergeSort(rightNode);
        Node left = mergeSort(head);
        return merge(left,right);
    }


    public static Node merge(Node left , Node right){
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (left != null && right != null) {
            if(left.data < right.data){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        while(left != null){
              temp.next = left;
                left = left.next;
                temp = temp.next;
        }

         while(right != null){
                            temp.next = right;
                right = right.next;
                temp = temp.next;
        }


        return dummy.next;
        
    }

    public static Node findMiddle(Node head){
              
        Node slow  = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static Node reverSe(Node head){
        // System.out.println(head.data);
        Node prev = null;
        Node curr  = head;
        Node next ;
        while ( curr != null ) {
            next = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = next;
        }

      

    return  prev;
    

    }

    public static void zigZag(Node head){

        Node midNode = findMiddle(head);
        System.out.println(midNode.data);
        Node rightHead =  reverSe(midNode.next);
        midNode.next = null;
        Node leftHead = head;
        // printList(leftHead);
        // printList(rightHead);
      
        Node nextL = null;
        Node nextR = null;

        while (leftHead != null && rightHead != null) {
            
            nextL = leftHead.next;
            leftHead.next= rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;
             

            rightHead = nextR;
            leftHead = nextL;


        }



    }


    
    public static void main(String[] args) {
  
      Javacollection ll =new Javacollection();
    
    
    

      ll.addFirst(6);
            ll.addFirst(5);
              ll.addFirst(4);
              ll.addFirst(3);
              ll.addFirst(2);
      
        
    }
}