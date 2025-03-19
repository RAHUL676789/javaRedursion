

import java.lang.reflect.Array;
import java.util.*;

public class BasicSort {



    public static void bubbleSort(int arr[]){
        for(int i = 0; i <arr.length - 1; i++){
               
            for(int j = 0; j<arr.length-1-i;j++){

                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static void printArr(int arr[]){
        for (int i = 0; i<arr.length ; i++) {
             System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int arr[]){

        for(int i = 0; i<arr.length; i++){
            int minPos = i;

            for(int j = i+1;j<arr.length;j++){
                if(arr[minPos] > arr[j]){
                            minPos = j;
                }
            }

            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }


    public static void insertionSort(int arr[]){

        for(int i = 1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;

            while (prev >= 0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }

            arr[prev+1] = curr;
        }
    }


    public static void countingSort(int arr[]){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }

        int count [] = new int[max + 1];

        for(int i = 0 ; i < arr.length; i++){
            count[arr[i]]++;
        }
        printArr(count);
int j = 0;
        for(int i = 0; i<count.length; i++){
            while (count[i] > 0) {
               
                arr[j] = i;
                count[i]--;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr =   { 5, 2, 3, 1,1, 4 };
    countingSort(arr);     
   printArr(arr);
}
}