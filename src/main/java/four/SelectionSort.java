package four;

/**
 * @description: 选择排序
 * 第一次循环拿到最小的值放在第一个位置上
 * 第二次循环拿到第二小的值放在第二个位置上
 * ....
 * <p>
 * 时间复杂度O(n²)   空间复杂度 O(1)  不稳定
 * @author: xwy
 * @create: 2:22 PM 2019/11/28
 **/

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 6, 4, 3, 7, 2, 9, 8, 5};

        print(arr);
        sort(arr);

        System.out.println();
        print(arr);

    }

    //选择排序
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) { // 如果最小位置的值大于arr中的值
                    //换位
                    swop(arr, minPos, j);
                }
            }
        }
    }

    private static void swop(int[] arr, int minPos, int j) {
        int temp = arr[minPos];
        arr[minPos] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}