import java.util.*;

public class arrayCC {

    public static int search(int nums[], int target) {
        int min = minSearch(nums);
        System.out.println(min);

        if (nums[min] <= target && target <= nums[nums.length - 1]) {
            return search(nums, min, nums.length - 1, target);
        } else {
            return search(nums, 0, min, target);
        }

    }

    public static int search(int nums[], int left, int right, int target) {
        int l = left;
        int r = right;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int minSearch(int nums[]) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static int buyAndSell(int arr[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < arr.length; i++) {

            if (buyprice > arr[i]) {
                buyprice = arr[i];
            } else {
                int profit = arr[i] - buyprice;
                maxProfit = Math.max(maxProfit, profit);
            }

        }
        System.out.println(buyprice);
        return maxProfit;
    }

    public static int trappedWate(int arr[]) {
        int water = 0;

        int lefMaxBoundary[] = new int[arr.length];
        int rightMaxBoundary[] = new int[arr.length];

        lefMaxBoundary[0] = arr[0];

        for (int i = 1;i < arr.length; i++) {
            lefMaxBoundary[i] = Math.max(lefMaxBoundary[i - 1], arr[i]);
        }

        rightMaxBoundary[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >0; i--) {
            rightMaxBoundary[i] = Math.max(rightMaxBoundary[i+1], arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
           int waterLevel = Math.min(lefMaxBoundary[i],rightMaxBoundary[i]);
           water += waterLevel - arr[i];
        }

        return water;

    }

    public static void main(String[] args) {

        int arr[] = { 0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trappedWate(arr));

    }
}
