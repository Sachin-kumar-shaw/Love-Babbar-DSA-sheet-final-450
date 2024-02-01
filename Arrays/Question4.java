public class Question4 {
    // Given an array which consists of only 0, 1 and 2. Sort the array without
    // using any sorting algo
    // also called Dutch National Flag problem.The problem was proposed by Edsger
    // Dijkstra
    // -------------------------------------------------------------------
    // by using the pointer Approach
    // t.c = O(n) && s.c = O(1)

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // from left fill the array with 0 and from fill the array with 2
    public static void sort012(int arr[], int n) {
        // code here
        int l = 0;
        int m = 0;
        int h = n - 1;
        while (m <= h) {
            if (arr[m] == 0) {
                swap(arr, l, m);
                l++;
                m++;
            } else if (arr[m] == 1) {
                m++;
            } else {
                swap(arr, m, h);
                h--;
            }
        }
    }

    // --------------------------------------------------------
    // by using pointers but this approach takes more time than previous approach
    // t.c = O(2n) ~= O(n) && s.c = O(1)

    public static void sort012_2(int arr[], int n) {
        // code here
        int i = 0;
        int j = n - 1;
        while (i < j) { // In this loop we carry all the 2's to the right side
            while (arr[i] != 2) {
                i++;
            }
            while (arr[j] == 2) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        i = 0;
        while (i < j) { // In this loop we carry all the 1's to the right of 0's
            while (arr[i] == 0) {
                i++;
            }
            while (arr[j] == 1) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
    }

    // -------------------------------------------
    // by keeping the counts of o's , 1's and 2's
    // t.c = O(2n) && s.c = O(1)

    public static void sort012_3(int a[], int n) {
        // code here
        int zero, one, two;
        zero = one = two = 0;
        for (int i = 0; i < n; i++) { // In this loop we count the numbers of each elements
            if (a[i] == 0)
                zero++;
            else if (a[i] == 1)
                one++;
            else
                two++;
        }
        for (int i = 0; i < n; i++) {
            if (zero > 0) {
                a[i] = 0;
                zero--;
            } else if (one > 0) { // we place 0's ,1's and 2's in the array according to the counts
                a[i] = 1;
                one--;
            } else {
                a[i] = 2;
                two--;
            }
        }
    }

}
