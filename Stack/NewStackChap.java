package Stack;
import java.util.*;

public class NewStackChap {

    public static boolean validParenthesis(String str){
        Stack <Character> ch = new Stack<>();

        for(int i = 0 ; i<str.length();i++){
            Character curr = str.charAt(i);

            if(curr == '(' || curr == '{' || curr == '['){
                ch.push(curr);
            }else{


                if(ch.isEmpty()){
                    return false;
                }
                if((curr == ')' && ch.peek() == '(')
                 || (curr == '}' && ch.peek() == '{') 
                 || (curr == ']' && ch.peek() == '[')){
                    ch.pop();

                }else{
                   return false;
                }
            }
            
        }

        if(ch.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "({[]})(){}[]";
        System.out.println(validParenthesis(s));
    }
    
}
