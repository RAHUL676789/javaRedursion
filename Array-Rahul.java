import java.util.*;;

public class Array {
    

    public static void printSpiral(int arr[][]){
        int startRow = 0;
        int endRow = arr.length - 1;
        int startCol = 0;
        int endCol = arr[0].length - 1;


        while (startRow <= endRow && startCol <= endCol) {
            
            // print the top of the matrich


            for(int i = startRow; i<=endCol;i++){
                
                System.out.print(arr[startRow][i] + " ");
            }

            // pritn the right boundary of the matrics

            for(int i = startRow+1; i<=endRow;i++){
                System.out.print(arr[i][endCol] + " ");
            }

            // print the bottom boundary of the matrix

            for(int i = endCol - 1; i >= startCol ; i--){

                if(startRow == endRow){
                    break;
                }
                     System.out.print(arr[endRow][i] + " ");
            }

            // print the left boundary of the matrix

            for(int i = endRow - 1; i>startRow ; i--){
                if(endCol == startCol){
                    break;
                }
                System.out.print(arr[i][startCol] + " ");
            }
            startRow++;
            endCol--;
            startCol++;
            endRow--;
        }
    }


    public static int diagonalSum(int arr[][]){
       int sum = 0;

       for(int i = 0; i<arr.length;i++){
        sum +=arr[i][i];

        if(!(i == arr.length - 1- i)){
             sum+=arr[i][arr.length-1-i];
        }

       }

       return sum ;
    }

    public static Boolean stairCaseSearch(int arr[][],int key){
            
        int row = 0; int col = arr[0].length-1;

        while (row < arr.length && col >= 0) {
            
            if(arr[row][col] == key){
                System.out.println("key found the in the idx (" + row + "," + col + ")");
                return true;
            }
            else if(arr[row][col]> key){
                col--;
            }
            else if(arr[row][col] < key){
                row++;
            }
        }

        return false;
    }


    public static Boolean stariCaseSearch2(int arr[][],int key){
        int row = arr.length-1;
        int col = 0;

        while (row >= 0  && col < arr[0].length ) {
            if(arr[row][col] == key){
                System.out.println("key found the in the idx (" + row + "," + col + ")");
                return true;
            }
            else if(arr[row][col] < key){
                col++;
            }else if(arr[row][col] > key){
                row --;
            }

        
        }
        return false;
    }

    public static int printno7s(int arr[][]){
        int count = 0;
        for(int i = 0; i< arr.length ; i++){

            for(int j = 0; j<arr[0].length;j++){
                if(arr[i][j] == 7){
                   count++;
                }
            }
        }

        return count;
    }

    public static void transPoseArray(int arr[][]){

        int transpose [][] = new int[arr[0].length][arr.length];

        for(int i = 0; i<arr.length;i++){

            for(int j = 0; j<arr[0].length ; j++){
                transpose[j][i] = arr[i][j];
         }
        }
        printArr(transpose);
    }

    public static void printArr(int arr[][]){
        for(int i = 0; i<arr.length;i++){

            for(int j = 0; j<arr[0].length ; j++){
               System.out.print(arr[i][j] + " ");
         }
         System.out.println();
        }

    }


    public static String stringCompression(String str){
             StringBuilder sb = new StringBuilder("");
             Integer count = 1;

             for(int i = 0; i<str.length()-1;i++){
              
          
                while ( i < str.length() - 1 && str.charAt(i) == str.charAt(i+1) ) {
                 
                    count++;
                    i++;
                    
                }
                sb.append(str.charAt(i));
                if(count > 1){
                    sb.append(count);
                    count = 1;
                }
             }
         return sb.toString();


    }

    public static void isOddOrEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0){
            System.out.println("this is a even no");
        }else{
            System.out.println("this is a odd no");
        }
    }


    public static int getIthBit(int n , int bit){

        return n & (1 << bit);
    }

    public static void setIthBit(int n , int bit , int i){

        int bitMask = bit << i;
        System.out.println(n | bitMask);
    }
    public static int clearithBit(int n , int i){
        int bitMask = ~(1 << i);
        return n & bitMask;
    }


    public static int countSetBit(int n ){
        int count = 0;

        while( n > 0) {

            if((n & 1) != 0){
                count++;
            }
            n = n>>1;
        }
  
return count;
    }


    public static void swapWithoutThirdVarible(int a , int b){
        a = a ^ b;
        System.out.print(a);
        b = a ^ b;
        System.out.println(b);
        a = a ^ b;
      System.out.println(a);
      System.out.println(b);

        
    }
    public static void main(String[] args) {
       
       
    // System.out.println(   getIthBit(21, 2));
     swapWithoutThirdVarible(5,3);

    System.out.println(~(~9764)+1);

       
      }

     
    
}
