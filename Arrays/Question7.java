public class Question7 {
    // Write a program to cyclically rotate an array by one.

    // ----------------------------------------------------------------
    // 1) last element ko kisse temp variable me store kardenge.
    // 2) index i me i-1 ka value copy karlenge.
    // 3) or first index me temp ka value rakh denge.

    // t.c = O(n) s.c = O(1)

    void rotateByOne(int[] arr, int n) {
        int temp = arr[n - 1];
        for (int i = n - 1; i > 0; i++) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }
}
