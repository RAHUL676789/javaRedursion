public class Divide{

    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void mergeSort(int arr[],int si , int ei){
   
            if(si>=ei){
                return;
            }
        // kaam 
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si,mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[],int si , int mid,int ei){
        int i = si ;
        int j = mid + 1;
        int k = 0;
        int temp []= new int[ei - si + 1];

        while (i <= mid && j <= ei) {
            
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }


        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= ei) {
            temp[k] = arr[j];
            k++;
            j++;
        }
     
        for( k = 0, i = si; k<temp.length; i++, k++){
            arr[i] = temp[k];
        }

    
    }


    public static void quickSort(int arr[], int si , int ei){

          if(si >= ei){
            return;
          }
        // kaam 

        int pivot = partion(arr, si , ei);
        quickSort(arr, si, pivot - 1);
        quickSort(arr, pivot + 1 , ei );
    }

    public static int partion(int arr[], int si , int ei){ 
        int pivot = arr[ei];
        int i = si - 1;

        for(int j = si; j<= ei ; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;

         return i;
    }
    public static void main(String[] args) {
         int arr []= {6,3,9,5,2,8};
         quickSort(arr, 0, arr.length - 1);
         printArr(arr);
    }   
}