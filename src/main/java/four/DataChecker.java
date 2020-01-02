package four;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: 验证自己的算法是否正确
 * 和   Arrays.sort(arr) 进行比较
 * @author: xwy
 * @create: 4:08 PM 2019/11/28
 **/

public class DataChecker {
    static int[] generateRandomArray() {
        Random r = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }

    static void check() {
        boolean same = true;

        for (int times = 0; times < 10; times++) {

            int[] arr = generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);

            Arrays.sort(arr);

//        SelectionSort.sort(arr2);
//        BubbleSort.sort(arr2);
//        InsertSort.sort2(arr2);
            ShellSort.sort(arr2);

            for (int i = 0; i < arr2.length; i++) {
                if (arr[i] != arr2[i]) {
                    same = false;
                }
            }

        }
        System.out.println(same ? "right" : "wrong");

    }

    public static void main(String[] args) {
        check();
    }
}