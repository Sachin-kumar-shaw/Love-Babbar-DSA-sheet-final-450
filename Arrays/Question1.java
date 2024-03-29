import java.util.*;

public class Question1 {
    // Method 1
    // By using extra array
    // t.c = O(n);
    // s.c = O(n);
    public static void reverse1(int[] arr) {
        int n = arr.length;
        int[] arr2 = new int[n];
        int j = 0;
        // fill the 2nd array with element in the first array in reverse order
        for (int i = n - 1; i >= 0; i--) {
            arr2[j++] = arr[i];
        }
        // copy the elements of arr2 in arr in same order
        for (int i = 0; i < n; i++) {
            arr[i] = arr2[i];
        }
    }

    // Method 2
    // By taking two pointer
    // t.c O(n) && S.c O(1)

    public static void reverse2(int[] arr) {
        int n = arr.length;
        int i = 0; // start pointer;
        int j = n - 1; // end pointer;
        while (i < j) {
            // swap the element in i and j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // method 3
    // by recursion
    // t.c = O(n) && s.c = O(1);
    public static void reverse3(int[] arr, int l, int h) {
        if (l < h) {
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            reverse3(arr, l + 1, h - 1);
        }
    }

    // method 4
    // by using extra stack
    // t.c = O(n) && s.c = O(n);
    public static void reverse4(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        // put all the elements in the stack from start to end
        for (int i = 0; i < n; i++) {
            st.push(arr[i]);
        }
        // pop out all elements and assign it to arr from start to end
        for (int i = 0; i < n; i++) {
            arr[i] = st.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        reverse3(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}