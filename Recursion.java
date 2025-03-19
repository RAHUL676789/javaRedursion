public class Recursion {


    // this is a tillig problem in which we have given a 2*n floor we have to fill
    // the floow with 2 *1 tilles find all the possible ways that can filled the floo
    public static int tillingProblem(int n){

        // we have tha base case if we have 0 length then we have only one way to not fillign the floow that a ways another is if we have 2 * 1 floor and we have 2 *1 tile then there is only one way to fill the floor
        if(n == 0 || n == 1){
            return 1;
        }

        //  for each n value we have a choice should we have to filled the floor with horizontal allignment or vertical allign ment and the total ways are the sum of vertical allginment and horizontal allignment 

        //  for n -> 3 it will call two call two call stack for n-1 if we filled the floor vertical and n - 2 for if we filed the floor horizontal 
        // n = 3 tillingproble(2) and tilignproble(1);
        // tillingproblem(2)->tilingproble(1) return 1; tilingproble(0) return 1;
        // and the result will be 1+1; and it return to n = 3 result = 2 and another side of tree n-2 tillingproblem call(1) return 1; hit the base case
        //so the final answer will 3
       return tillingProblem(n-1) + tillingProblem(n-2);
    }


    /*
     * we have an another similar problem where we have n number of people going to party find out the ways where the people can stand or paired or in single manner onece a person makes paired with someone he cant make another pair with anuone
     * 
     * suppose we have 2 people than they have only two choice either they can stand alone either they can pairedup with each other
     * 
     * another case we have only one person then there is no choice he has only one way to stand
     * 
     * those are our bases if we have n=1 or n=2 total ways are n
     */

    public static int frdPairing(int n){

/*
 * this is our base case where n = 1 or n = 2  total ways are n 
 */
        if(n== 2 || n == 1){
            return  n;
        }

        /*
         * now we have to calculate the total ways for if people decide to calculate stand along  call the same function for n-1 person
         */
        int fnm1 = frdPairing(n-1);

        /*
         * anothe case is when person decide to paired up with someone then they have n -1 choice to paring if person have n - 1 choice then how much chance have for n - 2 person 
         */
        int fnm2 = (n-1) * frdPairing(n - 2);

        /*
         * finally we will calculate the total no of ways to stand then return the result
         */
        int result = fnm1 + fnm2;

    return result;
    }

    /*
    third question is to remove the duplicate character from a given string 

     */
 
 public static String removeDuplicate(String str,boolean map[],int si,String newStr){
          
    /*
     * we follow simple approach to remove duplicate strign in a given string 
     * str.char(si) - 'a' krte hai to hme 0 to 25 ki value milti hai jo ki har ek char k index v samjh sakte hai to isi k afayda uthake hue hm hr index ke liye chekc krenge ki current char phle aa chika hai ya nhi agr aa gya hai to thek nhi to fir se hm new str me add kr denge
     */
          if(si == str.length()){
            System.out.println(newStr);
            return newStr;
          }

          if(map[str.charAt(si) - 'a'] == true){
              newStr =   removeDuplicate(str, map, si+1, newStr);
          }else{
            map[str.charAt(si) - 'a'] = true;
            newStr = newStr + str.charAt(si);
            // System.out.println(newStr);
            newStr =  removeDuplicate(str, map, si+1, newStr);

          }

        return newStr;

     }



     public static void binaryString(int n  , int lp , String bs){
        if(n == 0){
            System.out.println(bs);
            return;
        }

        binaryString(n-1, 0, bs+"0");
        if(lp == 0){
        binaryString(n-1, 1, bs+"1");
         }
     }
    
    public static void main(String[] args) {
     
      
      binaryString(3, 0, "");
    }
}
