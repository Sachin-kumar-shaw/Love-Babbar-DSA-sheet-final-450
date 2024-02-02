import java.util.Stack;

public class Question5 {
    // Move all the negative elements to one side of the array
    // we can solve this problem using an extra array

    // ----------------------------------------------------
    // by using Dutch national flag algorithm of two colours
    // t.c = O(n) && s.c = O(1)
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void segregateElements(int arr[], int n) {
        // Your code goes here
        // divide the array into three parts left side for negative elements
        // middle part for unknown elements and right side for positive elements

        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (arr[i] < 0) {
                i++;
            } else {
                swap(arr, i, j);
                j--;
            }
        }
    }

    // -------------------------------------------------
    // by using two pointers
    // t.c = O(n) && s.c = O(1)

    public void segregateElements_2(int arr[], int n) {
        // Your code goes here
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i < n && arr[i] < 0) {
                i++;
            }
            while (j >= 0 && arr[j] >= 0) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
    }
}
