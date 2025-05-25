import java.util.*;

public class Arraylist {

    // function for the find the maximum water container ; we have given a arraylist
    // with the height of the bar/boundary we have to create a container with the
    // maximum water contain basicaly we have to find out the area of water between
    // to boundary/bar

    // we have wo difference approach to solve this proble find all the pairs with
    // maximum height and maximum width that means maximum area height are given and
    // width can be calculate by subtracting the ending boundary index - staarting
    // boundary index first of all we saw the bruce force approach where we find out
    // all the possible pairs

    public static int maxWaterContainer(ArrayList<Integer> height) {
        int maxWater = 0;

        for (int i = 0; i < height.size(); i++) {

            for (int j = i + 1; j < height.size(); j++) {

                int h = Math.min(height.get(i), height.get(j));
                int w = j - i;
                int containWater = h * w;
                maxWater = Math.max(containWater, maxWater);
            }
        }

        return maxWater;
    }

    // the second approach to calculate the maxwater trap by two pointer approach
    // where we have a left pointer and a right pointer basically in this type of
    // questioin we have find out how we can update the pointer suppose we have a
    // given largest height and larget width so the area would we larget so the next
    // step to calucalte with the larget height and larget width means if we have
    // height less then we have to update the height

    public static int uitilizeMaxWater(ArrayList<Integer> height) {
        int maxWater = 0;

        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {

            int h = Math.min(height.get(lp), height.get(rp));
            int w = rp - lp;
            int water = h * w;
            maxWater = Math.max(water, maxWater);

            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWater;

    }

    // question no 2 pair sum we have given a sorted arraylist and a target we have
    // to find out the pair with the target sum [1,2,3,4,5[ target = 5 pair = 2+3;

    // Approach we have two approach for this question one is bruce force approach
    // where we find out all the possible pair and ther sum if the sum is equl to
    // target then wen return true else we rerturn false;

    public static boolean pairSum(ArrayList<Integer> list, int target) {

        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // 2nd approach we have t notice that the arraylist is in sorted form if we
    // apply the two pointer approach then we notice that the sum of the current
    // both pointer can easily determine the the sum where exist

    public static boolean pairsum(ArrayList<Integer> ls, int target) {

        int lp = 0;
        int rp = ls.size() - 1;

        while (lp != rp) {
            if (ls.get(lp) + ls.get(rp) == target) {
                return true;
            } else if (ls.get(lp) + ls.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }

        return false;
    }

    // same question for sorted and rotated arraylist

    // the formula is to updateing the lp and rp is simple first of all we have to
    // find out the pivot element or least element in the arraylist bcs we statrted
    // the left pointer with the least element and rp with most eleement in the
    // arraylist

    public static boolean sortedPairSum(ArrayList<Integer> ls, int target) {
        int bp = -1;
        int n = ls.size();

        System.out.println(n);
        System.out.println(ls);

        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i) > ls.get(i + 1)) {
                bp = i;
                break;
            }
        }

        int lp = bp + 1;
        int rp = bp;

        while (lp != rp) {
            System.out.println(rp + " " + lp);
            if (ls.get(rp) + ls.get(lp) == target) {
                return true;
            } else if (ls.get(rp) + ls.get(lp) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }

        return false;
    }

    // question no 3 for monotone of arraylist an arraylist in a monoton for all i
    // <= j list.get(i) >= list.get(j) is a increasing montonous while for all i<= j
    // list.get(i)<= list.get(j) is descreasing monotonous

    public static boolean monotous(ArrayList<Integer> list) {
        boolean inc = true;
        boolean desc = true;

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i) < list.get(i + 1)) {
                desc = false;
            }
            if (list.get(i) > list.get(i + 1)) {
                inc = false;
            }

        }

        return inc || desc;

        // for increasing monotounous

    }

    // question no 4 the question is find all the lonely no in the given list a
    // lonely is the that no with no repetatioin and no adjacent no present in the
    // list

    public static ArrayList lonely(ArrayList<Integer> ls) {
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(ls);

        for (int i = 0; i < ls.size(); i++) {
            int dup = 0;
            boolean noAdjacent = false;

            int currElement = ls.get(i);

            for (int j = 0; j < ls.size(); j++) {
                if (currElement == 6) {
                    System.out.println(noAdjacent);
                    System.out.println(ls.get(j));
                    ;
                }
                if (ls.get(j) == currElement - 1) {
                    noAdjacent = true;
                }

                if (ls.get(j) == currElement + 1) {
                    noAdjacent = true;
                }
                if (ls.get(j) % currElement == 0) {
                    dup = dup + 1;
                }
            }

            if (dup < 2 && !noAdjacent) {
                result.add(currElement);
            }

        }

        return result;
    }

    // second approach and optimize approach

    public static ArrayList lonelyoptimize(ArrayList<Integer> lis) {
        Collections.sort(lis);
        ArrayList<Integer> re = new ArrayList<>();

        for (int i = 1; i < lis.size() - 1; i++) {
            if (lis.get(i - 1) + 1 < lis.get(i) && lis.get(i) + 1 < lis.get(i + 1)) {
                re.add(lis.get(i));
            }
        }

        return re;
    }

    // question no 4 most frequent no of following key

    public static int mostFrequent(ArrayList<Integer> ls, int key) {

        int target = 0;
        int frq = 0;

        for (int i = 0; i < ls.size() - 1; i++) {

            if (ls.get(i) == key) {
                int newTarget = ls.get(i + 1);
                if (frq == 0) {
                    target = newTarget;
                }

                if (target == newTarget) {
                    frq = frq + 1;
                } else {
                    frq = frq - 1;
                }

            }
            // System.out.println(target);

        }

        return target;
    }

    // second approah ya method for counting the most frequent ocuurence element
    // after a key

    public static int mostFrequentSecond(ArrayList<Integer> ls, int key) {
        int arr[] = new int[10];
        int ans = 0;

        for (int i = 0; i < ls.size(); i++) {

            if (ls.get(i) == key) {
                arr[ls.get(i + 1) -1]++;
            }
        }

        // System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
 int max = Integer.MIN_VALUE;

        for(int i = 0; i < 10; i++){
            if(arr[i] > max){
             max = arr[i];
             ans = i + 1;

            }
        
        }
        System.out.println(ans);
        return ans;
    }




    // question no 5 for a beautiful arraylist the  An Arraylist nums of size n is beautiful if:
//  Sample Input 1 : n = 4
//  Sample Output 1 :  [2,1,4,3]
//  nums is a permutation of the integers in the range [1, n].
//  For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums.get(k) == nums.get(i) +
//  nums.get(j).
//  Given the integer n, return any beautiful arraylist nums of size n. There will be at least one valid
//  answer for the given n.
//  Sample Input 2 : n = 5
//  Sample Output 2 :  [3,1,2,5,4]
//  Constraints :
//  ● 1 <= n <= 100



// solution approach to solve this problem we have analyze a mathamtical rule that if there are three  no and two are even then the average of those no will be even and if two no are odd the the average of the thodse two no wil be even so we have to arrange them in such order so that they manage the rule of the question..



public static ArrayList<Integer> beautifulArrayList(int n ){
    ArrayList<Integer>ans = new ArrayList<>();

    ans.add(1);

    for (int i = 2; i <=n ; i++) {
        ArrayList<Integer>temp = new ArrayList<>();
          for(int e : ans){
            if(2*e-1<=n )temp.add(2*e-1);
        }
        for(int e : ans){
            if(2*e<=n)temp.add(2*e);

        }

  
        ans = temp;
    }


    return ans;

    
}



// second approach with divide and conquer


public static ArrayList<Integer> beautiful(int n ){
    ArrayList<Integer>ans =  new ArrayList<>();
    divideandConq(1,1,ans,n);
    return ans;
}


public static void divideandConq(int start,int inc , ArrayList<Integer>res,int n){
      
    if(start + n >  n){
        res.add(start);
        return;
    }
     System.out.println(res);
    divideandConq(start, 2*inc, res, n);
    divideandConq(start+inc, 2*inc, res, n);
}

    public static void main(String args[]) {

       System.out.println( beautiful(5));
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        // System.out.print(uitilizeMaxWater(height));

        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);

        ArrayList<Integer> ls2 = new ArrayList<>();
        ls2.add(15);
        ls2.add(9);
        ls2.add(6);
        ls2.add(8);
        ls2.add(6);
        ls2.add(10);

        ArrayList<Integer> ls3 = new ArrayList<>();
        ls3.add(2);
        ls3.add(2);
        ls3.add(2);
        ls3.add(2);
        ls3.add(3);
        // ls3.add(3);

        // System.out.println(sortedPairSum(ls2, 16));
        // System.out.println(mostFrequentSecond(ls3, 2));

        // there are some inbuild function related to arraylist the basic difference
        // between an array and arraylist is to array has fixed length while the
        // arraylist has dynamic length array can directly use primary datatype value
        // while the arraylist cannot use it.

        // basic syntax to defining the arraylist

        // Arraylist class datatype name = new keyword classname callya paranthensit;

        ArrayList<Integer> list = new ArrayList<>();

        // operations

        // 1 add operation add operationi basically use to add or insert a value into
        // the arraylist [1,2,3].add(5) = [1,2,3,5];

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        // System.out.print(list);

        // 2 remove operation = remove opeartion or remove method take a index value to
        // removing the value from that index

        // list.remove(1);
        // list.remove(2);
        // System.out.print(list);

        // 3 operation set opeeartion = used to set the value at the particular index
        // [1,2,3,4].set(3,5) means index no 3 has to set the value 5 = [1,2,3,5];

        // list.set(2, 5);

        // 4 operation contains contains takes a value and return if the value exist in
        // the arraylist its return true else false;

        // list.contains(3);

        // 5 opeartion get() = to retrieve the value from a partuclar index ;

        // questioin no 1 print the arraylist in the reverse order

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        // here i going to use size() method of arraylist to find the total length of
        // the arraylist

        // for (int i = list2.size() - 1; i >= 0; i--) {
        // System.out.print(list2.get(i) + " ");
        // }
    }

}