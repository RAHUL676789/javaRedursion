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


    public static int gridWays(int i , int j,int m , int n  ){
    //    base case 

          if(i == m -1  && j == n - 1){
            return 1;
          }

          if( i == m || j == n){
            return 0;
          }
        // recurison 

        // for right direction

      int w1 =   gridWays(i, j+1, m, n);
      int w2 =   gridWays(i+1, j, m, n);
      return w1+ w2;
    }



    public static int fact (int n){
        if(n == 1){
            return 1;
        }

        return n * fact(n-1);
    }

    public static int gridWaysTrick(int n,int m ){
       
     
        int mnm1 = fact(n - 1);
        int nm1 = fact(m - 1);
        int nmm1 = fact(n-1 + m - 1);
  
     
        return nmm1 /( nm1 * mnm1 ) ;

      
    }



    public static boolean isSafe(int sudoku[][], int row, int col,int digit){


        // for row check whether the given digit is in th erow 

        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i] == digit){
                return false;
            }
        }


        // check whether the column contain the same digit or not


        for (int i = 0; i < 9; i++) {
            if(sudoku[i][col] == digit){
                   return false;
            }
        }


        // check for whether the digit is in the same grid or not

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

       for (int i = sr ; i < sr+3; i++) {

        for (int j = sc ; j < sc + 3; j++) {
            if(sudoku[i][j] == digit){
                return false;
            }
        }
       }


       

    return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int  col){

          if(row == 9 && col == 0){
            return true;
          }

        // recusion 

        int nextRow = row, nextCol = col + 1;

        if(col+1 == 9){
            nextRow = row + 1;
            nextCol = 0;
        }


        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit = 1; digit <= 9 ; digit++){
                  
            // System.out.println(isSafe(sudoku, row, col,digit));
            if(isSafe(sudoku , row, col,digit )){
                sudoku[row][col] = digit;
               if( sudokuSolver(sudoku, nextRow, nextCol)){
                   return true;
               } 
            }
            sudoku[row][col] = 0;
        }


        return false;
    }

    
    public static void main(String[] args) {
    int[][] sudoku = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    if (sudokuSolver(sudoku, 0, 0)) {
        for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            System.out.print(sudoku[i][j] + " ");
        }
        System.out.println();
        }
    } else {
        System.out.println("No solution exists");
    }
       
    }
}