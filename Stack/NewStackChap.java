package Stack;

import java.util.*;

public class NewStackChap {

    public static boolean validParenthesis(String str) {
        Stack<Character> ch = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character curr = str.charAt(i);

            if (curr == '(' || curr == '{' || curr == '[') {
                ch.push(curr);
            } else {

                if (ch.isEmpty()) {
                    return false;
                }
                if ((curr == ')' && ch.peek() == '(')
                        || (curr == '}' && ch.peek() == '{')
                        || (curr == ']' && ch.peek() == '[')) {
                    ch.pop();

                } else {
                    return false;
                }
            }

        }

        if (ch.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicat(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }

    public static int[] findNextSmallerRight(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextSmaller[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.empty()) {
                nextSmaller[i] = arr.length ;
            } else {
                nextSmaller[i] = s.peek();
            }

            s.push(i);
        }
        // for (int i = 0; i < nextSmaller.length; i++) {
        //     System.out.print(nextSmaller[i] + " ");
        // }
        System.out.println();
        return nextSmaller;
    }

    public static int[] findNextSmallerLeft(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextSmallerLeft[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.empty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = s.peek();
            }

            s.push(i);
        }

        // for (int i = 0; i < nextSmallerLeft.length; i++) {
        //     System.out.print(nextSmallerLeft[i] + " ");
        // }

        System.out.println();

        return nextSmallerLeft;
    }

    public static int maxAreaHistoGram(int arr[]) {
        int nsr[] = findNextSmallerRight(arr);
        int nsl[] = findNextSmallerLeft(arr);
        int maxArea[] = new int[arr.length];
        int maxAreaHisto = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int width = nsr[i] - nsl[i] - 1;
            System.out.print(width + " ");
            maxArea[i] = width * arr[i];

        }

        System.out.println();
        for (int i = 0; i < maxArea.length; i++) {
            System.out.print(maxArea[i] + " ");
            if (maxArea[i] > maxAreaHisto) {
                maxAreaHisto = maxArea[i];
            }
        }
        System.out.println();
        return maxAreaHisto;

    }

    public static void main(String[] args) {
        String s = "({[]})(){}[]";
        String str = "((a+b))";
        String str2 = "(a+b) ((c+d))";
        System.out.println(isDuplicat(str));
        System.out.println(isDuplicat(str2));
        int arr[] = { 2, 1, 5, 6, 2, 3 };
      findNextSmallerRight(arr);
      findNextSmallerLeft(arr);
        System.out.println();
        System.out.println(maxAreaHistoGram(arr));
    }

}
