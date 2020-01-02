package four;

/**
 * @description: 冒泡排序
 * 相邻两个数进行比较，大的数往后移
 * 时间复杂度O(n²)   空间复杂度 O(1)  稳定
 * @author: xwy
 * @create: 4:08 PM 2019/11/28
 **/

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 6, 4, 3, 7, 2, 9, 8, 25};

        print(arr);
        sort(arr);

        System.out.println();
        print(arr);

    }


    /*
         小的数往前移
     */
//    public static void sort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    swop(arr, i, j);
//                }
//            }
//        }
//    }

    /*
       大的数往后移
       可以优化一下
       因为冒泡排序没循环完一次都会把最小的数据放到最前面，所以前面都是排好序的数据
       当前面的数据已经按从小到大的顺序排好了，就不用再循环排好的数据了
       设置一个flag，当arr[i] <= arr[j]时就不用继续循环了
    */
    public static void sort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1 && flag; i++) {
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swop(arr, j, j - 1);
                    flag = true;
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