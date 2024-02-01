import java.util.Stack;

public class Question5 {
    // Move all the negative elements to one side of the array
    // we can solve this problem using an extra array

    // ----------------------------------------------------
    // by using temporary array
    // t.c = O(n) && s.c = O(n)

    public void segregateElements(int arr[], int n) {
        // Your code goes here
        int temp[] = new int[n];
        int i = 0;
        int j = 0;
        for (; j < n; j++) {
            if (arr[j] >= 0) {
                temp[i++] = arr[j];
            }
        }
        for (j = 0; j < n; j++) {
            if (arr[j] < 0) {
                temp[i++] = arr[j];
            }
        }
        for (i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    // -------------------------------------------------
    // by using two stack one for negative and one for positive elements
    // t.c = O(n) && s.c = O(n)

    public void segregateElements_2(int arr[], int n) {
        // Your code goes here
        Stack<Integer> neg = new Stack<>();
        Stack<Integer> pos = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                neg.push(arr[i]);
            } else {
                pos.push(arr[i]);
            }
        }
        int i = n - 1;
        while (!neg.isEmpty()) {
            arr[i--] = neg.pop();
        }
        while (!pos.isEmpty()) {
            arr[i--] = pos.pop();
        }
    }
}
