package four;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: xwy
 * @create: 7:46 PM 2019/12/3
 **/

public class CountSort {

    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 2, 5, 2, 5, 2, 4, 3, 6, 4, 4, 7, 8, 8, 8, 4, 4, 4};

        print(arr);

        sort(arr);

    }


    /*
     有2个问题：
        1.如果数据值有5-10之间的数，0-4之间没有值，就会浪费一半的空间
        2.不稳定
     */
    public static void sort(int[] arr) {

        int[] count = new int[10];//这个数的长度就是数据最大的那个数，这里都是10以内的
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println();
        for (int j = 0; j < count.length; j++) {
            System.out.print(count[j] + "个" + j + "    ");
        }

        System.out.println();

        // 不稳定
//        for (int j = 0; j < count.length; j++) {
//            if (count[j] != 0) {
//                for (int k = 0; k < count[j]; k++) {
//                    System.out.print(j+"  ");
//                }
//            }
//        }


        // 稳定

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        System.out.println(Arrays.toString(count));

        int [] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
            System.out.println("arr["+i+"]:"+arr[i]+" count[arr["+i+"]]:"+count[arr[i]]+" result[--count[arr["+i+"]]]"+result[count[arr[i]]]);
        }
        System.out.println();
        print(result);
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