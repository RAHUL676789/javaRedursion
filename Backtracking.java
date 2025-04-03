public class Backtracking {


    static int count = 0;

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



    public static void printChess(String chess[][]){
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + " ");
            }

            System.out.println(" ");
            // System.out.println(" ");

        }
        System.out.println();
    }



    public static boolean isSafe(String chess[][],int row, int col){

        // check whole column 

        for(int j = 0 ; j < chess.length;j++){
         
            if(chess[j][col] == "Q"){
                return false;
            }
        }

        // check for row 


        for(int i = 0 ; i < chess[0].length ; i++ ){
             if(chess[row][i] == "Q"){
                return false;
             }
        }


        // check right diagonal up

        for(int i = row - 1 ,  k = col + 1  ; i>= 0  && k < chess[0].length ; i--,k++){
                  
            if(chess[i][k] == "Q"){
                return false;
            }
        }


        // check for left diagonal up

         for(int i = row - 1 ,k = col - 1 ; i >= 0 && k >= 0 ; i--,k--){
            if(chess[i][k] == "Q"){
                return false;
            }
         }


        //  check right diagona for bottom 

        for(int i = row + 1 , k = col+1 ; i < chess.length && k < chess[0].length; i++,k++){
          
            if(chess[i][k] == "Q"){
                return false;
            }
        }


        // chekc for left bottom diagonal


        for(int i = row +1, k = col -1; i < chess.length && k >= 0 ; i++ , k--){
            if(chess[i][k] == "Q"){
                return false;
            }
        }

        return true;
    }

    public static boolean nQueen(String chess[][],int row ){
        
        if(row == chess.length ){
         
            count++;
            return true ;
        }

      
        
        for(int col = 0; col<chess.length; col++){
                 
           if(isSafe(chess,row,col)){
            chess[row][col] = "Q";
           if( nQueen(chess, row+1)){
               printChess(chess);
               return true;
           };
                // totalWay++;
                
            
            chess[row][col] = "X"; 
           
           }
        
        }

        

     return false;
      
    }

    public static void main(String[] args) {
        String chess[][] = new String[8][8];
       
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = "X";
            }
        }
      System.out.println(nQueen(chess, 0));
      System.out.println(count);
       
    }
}