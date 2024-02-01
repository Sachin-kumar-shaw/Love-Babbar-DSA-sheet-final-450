import java.util.*;

public class Question2 {

    static class Pair {
        int min;
        int max;

        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

        Pair() {
            min = 0;
            max = 0;
        }
    }

    // method 1 by using sorting
    // t.c = O(nlog(n)) && s.c = O(1)
    public static Pair maxMin(int[] arr) {
        Arrays.sort(arr);
        return new Pair(arr[0], arr[arr.length - 1]);
    }

    // method 2 by using linear search
    // t.c = O(n) && s.c = O(1)
    public static Pair maxMin2(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return new Pair(arr[0], arr[0]);
        }
        Pair p = new Pair();
        // initialize p.max with max of first two elements and p.min with min of first
        // two elements
        if (arr[0] > arr[1]) {
            p.max = arr[0];
            p.min = arr[1];
        } else {
            p.max = arr[1];
            p.min = arr[0];
        }
        for (int i = 2; i < n; i++) {
            if (arr[i] > p.max) {
                p.max = arr[i];
            } else if (arr[i] < p.min) {
                p.min = arr[i];
            }
        }
        return p;
    }
    // method 3 divide the array in two parts and compare the max and min of the two
    // parts(by recursion)
    // t.c = O(n) && s.c = O(log(n))

    public static Pair minMax3(int[] arr, int l, int h) {
        if (l == h) {
            return new Pair(arr[l], arr[h]);
        }
        if (l + 1 == h) {
            Pair p = new Pair();
            if (arr[l] > arr[h]) {
                p.max = arr[l];
                p.min = arr[h];
            } else {
                p.max = arr[h];
                p.min = arr[l];
            }
            return p;
        }
        int mid = (l + h) / 2;
        Pair ans = new Pair();
        Pair mml = minMax3(arr, l, mid); // find max min of left subArray
        Pair mmr = minMax3(arr, mid, h); // find max min of right subArray
        if (mml.min > mmr.min) {
            ans.min = mmr.min;
        } else {
            ans.min = mml.min;
        }
        if (mml.max > mmr.max) {
            ans.max = mml.max;
        } else {
            ans.max = mmr.max;
        }
        return ans;
    }

    // method 4 compare in pair
    // t.c = O(n) && s.c = (1)

    public static Pair minMax4(int[] arr) {
        int n = arr.length;
        Pair ans = new Pair();
        if (n % 2 == 0) {
            // when number of elements is even then assign max and min element with max and
            // min of the first two elements and compare
            // them with max and min of next pair
            if (arr[0] > arr[1]) {
                ans.max = arr[0];
                ans.min = arr[1];
            } else {
                ans.max = arr[1];
                ans.min = arr[0];
            }
            for (int i = 2; i < n; i = i + 2) {
                if (arr[i] > arr[i + 1]) {
                    if (arr[i] > ans.max) {
                        ans.max = arr[i];
                    }
                    if (arr[i + 1] < ans.min) {
                        ans.min = arr[i + 1];
                    }
                } else {
                    if (arr[i + 1] > ans.max) {
                        ans.max = arr[i + 1];
                    }
                    if (arr[i] < ans.min) {
                        ans.min = arr[i];
                    }
                }
            }
        } else {
            ans.max = arr[0];
            ans.min = arr[1];
            for (int i = 1; i < n; i = i + 2) {
                if (arr[i] > arr[i + 1]) {
                    if (arr[i] > ans.max) {
                        ans.max = arr[i];
                    }
                    if (arr[i + 1] < ans.min) {
                        ans.min = arr[i + 1];
                    }
                } else {
                    if (arr[i + 1] > ans.max) {
                        ans.max = arr[i + 1];
                    }
                    if (arr[i] < ans.min) {
                        ans.min = arr[i];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 22, 14, 8, 17, 35, 3 };
        Pair ans = minMax4(arr);
        System.out.println("Min:" + ans.min + " Max:" + ans.max);
    }
}
