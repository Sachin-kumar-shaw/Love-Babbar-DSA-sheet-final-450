// Find the "Kth" max and min element of an array 

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Question3 {
    // by using priorityQueue
    // t.c = O(nlog(k)) && s.c = O(k)
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    // by sorting
    // t.c = O(nlog(n)) && s.c = O(1)
    public static int kthSmallest2(int[] arr, int l, int r, int k) {
        // Your code here
        Arrays.sort(arr);
        return arr[k - 1];
    }

    // by using binary Search
    // t.c = nlog(maxele-minele) && s.c = O(1)
    static int count(int[] nums, int mid) {
        // function to calculate number of elements less
        // than equal to mid
        int cnt = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= mid)
                cnt++;

        return cnt;
    }

    static int kthSmallest(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        // calculate minimum and maximum the array.
        for (int i = 0; i < nums.length; i++) {
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }
        // Our answer range lies between minimum and maximum
        // element of the array on which Binary Search is
        // Applied
        while (low < high) {
            int mid = low + (high - low) / 2;
            /*
             * if the count of number of elements in the
             * array less than equal to mid is less than k
             * then increase the number. Otherwise decrement
             * the number and try to find a better answer.
             */
            if (count(nums, mid) < k)
                low = mid + 1;

            else
                high = mid;
        }

        return low;
    }

    // by using quickSort -- sorting the array till j == k-1
    // t.c = O(n^2) in worst case when tha array is already sorted and best case t.c
    // = nlog(n) && s.c = O(1)
    public static int partition(Integer[] arr, int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {

                // Swapping arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        // Swapping arr[i] and arr[r]
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }

    // This function returns k'th smallest element
    // in arr[l..r] using QuickSort based method.
    // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
    public static int kthSmallest(Integer[] arr, int l,
            int r, int K) {
        // If k is smaller than number of elements
        // in array
        if (K > 0 && K <= r - l + 1) {

            // Partition the array around last
            // element and get position of pivot
            // element in sorted array
            int pos = partition(arr, l, r);

            // If position is same as k
            if (pos - l == K - 1)
                return arr[pos];

            // If position is more, recur for
            // left subarray
            if (pos - l > K - 1)
                return kthSmallest(arr, l, pos - 1, K);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r,
                    K - pos + l - 1);
        }

        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }

    // by Counting sort
    // t.c = O(n+max_element) && s.c = O(max_element)

    // This function returns the kth smallest element in an
    // array
    static int kthSmallest(int[] arr, int n, int k) {
        // First, find the maximum element in the array
        int max_element = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max_element) {
                max_element = arr[i];
            }
        }

        // Create an array to store the frequency of each
        // element in the input array
        int[] freq = new int[max_element + 1];
        Arrays.fill(freq, 0);
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        // Keep track of the cumulative frequency of
        // elements in the input array
        int count = 0;
        for (int i = 0; i <= max_element; i++) {
            if (freq[i] != 0) {
                count += freq[i];
                if (count >= k) {
                    // If we have seen k or more elements,
                    // return the current element
                    return i;
                }
            }
        }
        return -1;
    }

}
