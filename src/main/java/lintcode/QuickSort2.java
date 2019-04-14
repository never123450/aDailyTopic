package lintcode;

/**
 *
 * @description://www.lintcodom/problem/sort-integers-ii/description'
 *
 * @author:
 *
 * @create:  2019年04月14日12:44:07
**/

public class QuickSort2 {

    public int partition(int[] arr, int l, int r) {

        int v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++)
            if (arr[i] < v) {
                j++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    public void sort(int[] arr, int l, int r) {

        if (l >= r)
            return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public void sort(int[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        sort(A);
    }

}