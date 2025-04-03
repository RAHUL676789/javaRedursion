public class Backtracking {

    public static void StringPermutaion(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // recursion

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            StringPermutaion(newStr, ans + curr);
        }
    }

    public static void subset(String str, String ans, int i) {

        if (i == str.length()) {

            if (ans == "") {
                System.out.print("Null");
            } else {

                System.out.println(ans);
            }
            return;
        }

        subset(str, ans + str.charAt(i), i + 1);
        subset(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        subset(str, "", 0);
    }
}