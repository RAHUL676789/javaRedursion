// question no 1 given an array of nums size n find the majority element 

public class pracDivide {

    public static int majorityElement(int arr[], int lo, int hi) {
        if (lo == hi) {
            return arr[lo];
        }

        int mid = lo + (hi - lo) / 2;
        int left = majorityElement(arr, lo, mid);
        int right = majorityElement(arr, mid + 1, hi);
        
        if (right == left) {
            return left;
        }

        int leftCount = countInRange(arr, lo, hi, left);
        int rightCount = countInRange(arr, lo, hi, right);

        return leftCount > rightCount ? left : right;
    }

    public static int countInRange(int arr[], int lo, int hi, int key) {
        int count = 0;

        for (int i = lo; i < hi; i++) {
            if (arr[i] == key) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}