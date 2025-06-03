public class MergeSort {



    public static void mergeSort(int arr[],int si, int ei){

        //   base case 

        if(si == ei){

            return;
        }
        // to find the midddle of the array 
        int mid = si + (ei - si) / 2;
         
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+ 1, ei);
        merge(arr,si ,mid , ei );
    }

    public static void merge(int arr[],int si ,int mid ,  int ei){
       int temp[] = new int[ei - si + 1];
       int i = si ;
       int j = mid + 1;
       int k = 0;
       while (i <= mid && j <= ei ) {
           
        if(arr[i] < arr[j]){
            temp[k++] = arr[i++];
        }else{
            temp[k++] = arr[j++];
        }
       }

    //    copy the left part of the elemnt

       while (i <= mid) {
          temp[k++] = arr[i++];
       }

       while (j <= ei) {
        temp[k++] = arr[j++];
       }

        //  for (int o = 0; o < temp.length; o++) {
        //     System.out.print(temp[o] + " ");
        //  }

     for( k = 0 , i = si ; k < temp.length; k++ , i++){
           
        arr[i] = temp[k];
     }

       for (int f = 0; f < arr.length; f++) {
            System.out.print(arr[f] + " ");
         }
         System.out.println();

    }
    public static void main(String[] args) {
         int arr[] = {3,-1,2,5,4};
         mergeSort(arr, 0, arr.length - 1);
         for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
         }
    }
}