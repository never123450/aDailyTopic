package four;

/**
 * @description: 采用分治思想，递归的把数据平均分成2半，把每次分割之后的数据排序，然后再合并
 * 时间复杂度：O(nlog2n)  空间复杂度：O(1)  不稳定
 * @author: xwy
 * @create: 6:49 PM 2019/11/30
 * <p>
 * ??????????????
 **/

public class MergeSort {

    private void merge(int[] arr, int l, int mid, int r) {
        int aux[] = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int i = l, j = mid + 1;
        for (int k = 0; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

    // 递归使用归并排序，对arr[l...r]的范围进行排序
    private void _mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        _mergeSort(arr, l, mid);
        _mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void mergeSort(int[] arr, int n) {
        _mergeSort(arr, 0, n - 1);
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{90, 3, 2, 67, 44, -9, 87, 65, 11, 9, 2, 8};
        for (int n : a) {
            System.out.print(" " + n);
        }
        System.out.println();
        mergeSort.mergeSort(a, a.length);
        for (int n : a) {
            System.out.print(" " + n);
        }
    }


    // 另一种思路
    private void mergeSortBU(int[] arr, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对arr[i...i+sz+1]和arr[i+sz...i+2*sz+1]进行归并
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }


    private void _merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }

            if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

}