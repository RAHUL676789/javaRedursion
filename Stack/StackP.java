
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
    
    public static void main(String[] args) {
        Stack <Integer> s =  new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        reverseStack(s);

        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
    //    System.out.println( reverString("abc"));

    }
}