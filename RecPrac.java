public class RecPrac {
    
    public static void findAllOccurent(int arr[],int key,int si){
        if(si == arr.length){
            return;
        }

        if(arr[si] == key){
            System.out.println(si);
        }

        findAllOccurent(arr, key, si+1);
    }

    public static void numberToString(String arr[],int n,String result){
        // System.out.println(result);
        if(n <= 0){
            System.out.println(result);
            System.out.println("this si final result  " +  result);
            return;
        }
     
        int module = n % 10;
        result = arr[module] + " " + result ;
        numberToString(arr, n / 10, result);
      

    }

  public static int printAllcontigousSubString(String str,int i , int j , int n){
       
         if(n ==  1){
            return 1 ;
         }

         if(n <= 0){
            return 0;
         }

        //  System.out.println(str.substring(i, j+1));
    int res =  printAllcontigousSubString(str, i+1, j, n-1)+ printAllcontigousSubString(str, i, j-1, n-1) - printAllcontigousSubString(str, i+1, j-1, n-2);
   
    
   
    
    if(str.charAt(i) == str.charAt(j)){
        res++;
    }
  
 

      return res;
    }


    public static void TowerOfHanoi(int n , String source,String helper,String destination){
        if(n == 1){
            System.out.println("move the " + n + "  disk from " + source + " to  " + destination);
            return;
        }

        TowerOfHanoi(n-1, source, destination, helper);
        System.out.println("shift  the " + n + "  disk " + source + " to " + destination);
        TowerOfHanoi(n-1, helper, source, destination);
        // System.out.println("shift the " + n + "  disk " + source + " to " + destination);

    }

    public static void main(String[] args) {
      TowerOfHanoi(4, "A", "B", "C");
       
    }
}
