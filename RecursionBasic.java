public class RecursionBasic {

    public static void descreasingNo(int n){
           if(n == 1){
            System.out.print(n + " ");
            return;
           }
         
           System.out.print(n + " ");
           descreasingNo(n-1);

           System.out.println("jais shree ram  " + n);
    }


    public static int printInc(int n){
        if(n == 1){
         
            return n;
        }

       System.out.println(printInc(n-1));
       return n;

    }


    public static long printfactorial(int n){
          if(n < 0){
            System.out.println("negative no canot have factorial");
            return 0;
          }
          if(n == 1 || n == 0){
            return 1;
          }

          long fn1 = printfactorial(n-1);
          long result = n + fn1;
          return result; 
    }


    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }

        int fibn = fib(n-1) + fib(n - 2);
        return fibn ;
    }
    

    public static Boolean sortedArray(int arr[], int i){
        if(i ==  arr.length-1){
          return true;
        }
        
        boolean isSoreted = arr[i] < arr[i+1] && sortedArray(arr, i+1);
    
          return isSoreted;
        
    }


    public static int firstOccurent(int arr[],int key, int i ){
        if(i > arr.length-1){
            return -1;
        }

        if(arr[i] == key){
            return i;
        }

       

        return firstOccurent(arr, key, i-1);
    }


    public static int lastOccurence(int arr[],int key,int i){
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);

        if(isFound == -1 && arr[i] == key){
            return i;
        }

        return isFound;
    }


    public static int BSTREC(int arr[],int si,int ei,int key){
        int mid = si + (ei - si)/2;
        System.out.println(mid + " " + si + " " + ei);
        if(arr[mid] == key){
             return mid;
        }

        if(si > ei){
            return -1;
        }

        if(arr[mid] > key){
           return BSTREC(arr, si, mid-1, key);
        }

        if(arr[mid] < key){
          return  BSTREC(arr, mid+1, ei, key);
        }

        return mid;
    }
    public static void main(String[] args) {
       int arr[] = {1,1,3,4,5,6,7,8,9,10};
     System.out.println(BSTREC(arr, 0, arr.length-1, 2));
    }
}
