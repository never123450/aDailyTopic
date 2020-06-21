package two.sort;

//归并排序
public class MergeSort {
    public void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            //分组，到最后会分成每个数据都是一组
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
            merge(a, left, middle, right);//合并
        }
    }

    private void merge(int[] a, int left, int middle, int right) {
        int[] tmpArray = new int[a.length];
        int rightStart = middle + 1;
        int tmp = left;
        int third = left;
        //比较左右2边排好序的小数组相应下标位置的数组大小，小的先放进数组
        while (left <= middle && rightStart <= right) {
            if (a[left] <= a[rightStart]) {
                tmpArray[third++] = a[left++];
            } else {
                tmpArray[third++] = a[rightStart++];
            }
        }
        //左边的数组还有数据，需要把左边数组剩下的拷贝到新数组
        while (left <= middle) {
            tmpArray[third++] = a[left++];
        }
        //右边还有数据，把右边剩下的数据拷贝到新数组
        while (rightStart <= right) {
            tmpArray[third++] = a[rightStart++];
        }
        //把排序后的数组放回a中
        while (tmp <= right) {
            a[tmp] = tmpArray[tmp++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{90, 3, 2, 67, 44, -9, 87, 65, 11, 9, 2, 8};
        for (int n : a) {
            System.out.print(" " + n);
        }
        System.out.println();
        mergeSort.mergeSort(a, 0, a.length - 1);
        for (int n : a) {
            System.out.print(" " + n);
        }
    }





}
