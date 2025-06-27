
package Stack;
import java.util.*;
public class StackP{


    public static void pushAtBottom(int data,Stack <Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);

    }


    public static String reverString(String str){
        Stack <Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length() ) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        return sb.toString();
    }


    public static void reverseStack(Stack <Integer> s){
               if(s.isEmpty()){
                return;
               }

               int top = s.pop();
               reverseStack(s);
               pushAtBottom(top, s);
               


    }


    public static void nextGreatherElement(int arr[]){
        Stack <Integer> s = new Stack<>();
        int ansArr[] = new int[arr.length];

        for(int i = arr.length -1 ; i >=0 ; i--){
            int nextGrethere ;
            while (!s.empty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            } 

            if(s.empty()){
                nextGrethere = -1;
            }else{
                nextGrethere = arr[s.peek()];
            }
            ansArr[i] = nextGrethere;
            s.push(i);
        }


        for(int i = 0; i<ansArr.length ; i++){
            System.out.print(ansArr[i] + " ");
        }

        
    }


    public static void NextGreatherLeft(int arr[]){
        Stack<Integer>s = new Stack<>();
        int nextGreatherLeft [] = new int[arr.length];

        for(int i = 0; i<arr.length;i++){

            while (!s.empty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

          if(s.empty()){
            nextGreatherLeft[i] = -1;
          }else{
            nextGreatherLeft[i] = arr[s.peek()];
          }

          s.push(i);
        }

          for(int i = 0; i<nextGreatherLeft.length ; i++){
            System.out.print(nextGreatherLeft[i] + " ");
        }
    }
    

    public static void nextSmaller(int arr[]){
        Stack <Integer> s = new Stack<>();
        int nextSmaller[] = new int[arr.length];

        for(int i = arr.length - 1; i>= 0 ; i--){

            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if(s.empty()){
                nextSmaller[i] = -1;
            }else{
                nextSmaller[i] = arr[s.peek()];
            }
            s.push(i);
        }

          for(int i = 0; i<nextSmaller.length ; i++){
            System.out.print(nextSmaller[i] + " ");
        }
    }


    public static void nextSmallerLeft(int arr[]){
       Stack <Integer> s = new Stack<>();
       int nextSmalletLeft [] = new int[arr.length];

       for(int i = 0 ; i < arr.length; i++){
        while (!s.empty() && arr[s.peek()] >= arr[i]) {
            s.pop();
        }

        if(s.empty()){
            nextSmalletLeft[i] = -1;
        }else{
            nextSmalletLeft[i] = arr[s.pop()];
        }
        s.push(i);
       }

           for(int i = 0; i<nextSmalletLeft.length ; i++){
            System.out.print(nextSmalletLeft[i] + " ");
        }
       
    }
    public static void main(String[] args) {
       int arr[] = {6,8,0,1,3};
       nextGreatherElement(arr);
       System.out.println();
       NextGreatherLeft(arr);
       System.out.println();
       nextSmaller(arr);
       System.out.println();
       nextSmallerLeft(arr);
    //    System.out.println( reverString("abc"));

    }
}