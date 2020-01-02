package four;

/**
 * @description: 希尔排序：
 * 每隔一个间隔进行插入排序
 * 比如：间隔为2：间隔为2个数进行排序   1，3，5，7...下标进行插入排序
 * 间隔为3：1,4,7,10...下标进行插入排序
 * <p>
 * 时间复杂度：n一点三次方 空间复杂度:O(1) 不稳定
 * @author: xwy
 * @create: 7:34 PM 2019/11/28
 **/

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 6, 4, 3, 7, 2, 9, 8, 15};

        print(arr);
        sort(arr);

        System.out.println();
        print(arr);

    }

    public static void sort(int[] arr) {

        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap])
                        swop(arr, j, j - gap);
                }
            }
        }
    }

    private static void swop(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

}