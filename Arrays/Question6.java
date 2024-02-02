import java.util.*;

public class Question6 {
    // Find the Union and Intersection of the two sorted arrays.
    // -----------------------------------------------

    // Union and intersection by using two pointers
    // t.c = O(n+m) && s.c = O(n+m)

    void union(int[] a, int n, int[] b, int m) {
        int i, j, k = 0;
        i = j = k;
        int[] ans = new int[n + m];
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                ans[k++] = a[i++];
            } else if (b[j] < a[i]) {
                ans[k++] = b[j++];
            } else {
                ans[k++] = a[i++];
                j++;
            }
        }
        for (; i < n; i++) {
            ans[k++] = a[i];
        }
        for (; j < m; j++) {
            ans[k++] = b[j];
        }
        // ans = union of a and b;
    }

    // t.c = O(n+m) && s.c = O(lesser b/w m & n)
    void intersection(int[] a, int n, int[] b, int m) {
        int i, j, k = 0;
        i = j = k;
        int[] ans = new int[n + m];
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                i++;
            } else if (b[j] < a[i]) {
                j++;
            } else {
                ans[k++] = a[i++];
                j++;
            }
        }
        // ans = intersection of a and b
    }

    // -------------------------------------------
    // union by using set
    // t.c = O(n+m) && s.c = O(n+m)

    void union2(int[] a, int n, int[] b, int m) {
        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            st.add(b[i]);
        }
        // st contains union of a and b
    }
    // -------------------------------------------------------------------------
    // intersection by using set
    // t.c = O(n+m) && s.c = O(lesser b/w n && m)

    // The idea is to add elements of first array in a set. Then, iterate through
    // the second array
    // and check for each element whether it exists in the set. If an element is
    // present in set,
    // it means the element is present in both arrays and the element is added to
    // the output, and
    // its occurrence in the set is removed to avoid duplicates in the output.

    void intersection2(int[] a, int n, int[] b, int m) {
        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(a[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : result) {
            if (st.contains(num)) {
                result.add(num);
                st.remove(num);
            }
        }
        // result contains the intersection of a and b;
    }

    // -----------------------------------------------
    // by using two pointers , in previous two pointers solution we does'nt care
    // about the duplicate elements
    // but this time we also considered the duplicate elements
    // t.c and s.c is same as previous
    // To handle the duplicates, check for every element whether adjacent elements
    // are equal. This can be done by
    // incrementing i or j such that i or j directly move to the next distinct
    // element.
    // This ensures the duplicate elements are not considered again. We can perform
    // this operation in
    // place (i.e. without using any extra space).

    int nextDistinct(int[] arr, int i) {

        while (i < arr.length && i > 0) {
            if (arr[i] != arr[i - 1])
                return i;
            i++;
        }
        return i;
    }

    void union(int a[], int[] b) {
        // code here
        int n = a.length;
        int m = b.length;
        int i, j, k;
        int[] ans = new int[n + m];
        i = j = k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                ans[k++] = a[i];
                i = nextDistinct(a, i + 1);
            } else if (a[i] > b[j]) {
                ans[k++] = b[j];
                j = nextDistinct(b, j);
            } else {
                ans[k++] = a[i];
                i = nextDistinct(a, i + 1);
                j = nextDistinct(b, j + 1);
            }
        }
        while (i < n) {
            ans[k++] = a[i];
            i = nextDistinct(a, i + 1);
        }
        while (j < m) {
            ans[k++] = b[j];
            j = nextDistinct(b, j + 1);
        }

        for (int x = 0; x < k; x++) {
            System.out.println(ans[x]);
        }
    }

    void intersection(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i, j, k;
        int[] ans = new int[n + m];
        i = j = k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                i = nextDistinct(a, i + 1);
            } else if (a[i] > b[j]) {
                j = nextDistinct(b, j);
            } else {
                ans[k++] = a[i];
                i = nextDistinct(a, i + 1);
                j = nextDistinct(b, j + 1);
            }
        }
        for (int x = 0; x < k; x++) {
            System.out.println(ans[x]);
        }
    }

}
