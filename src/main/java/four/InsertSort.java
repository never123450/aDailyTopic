package four;

/**
 * @description: 插入排序
 * 每次都和前面的排好序的进行一一个从后往前比较，插入到前面排好序的数组中
 * <p>
 * 空间复杂度O(1)   时间复杂度O(n²)  稳定
 * @author: xwy
 * @create: 4:23 PM 2019/11/28
 **/

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 6, 4, 3, 7, 2, 9, 8, 15,1};

        print(arr);
        sort(arr);

        System.out.println();
        print(arr);

    }


    /*
        方法一：
        和前面排好序的一个一个从后到前进行比较，小于的话就交换位置
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swop(arr, j - 1, j);
                else
                    break;
            }
        }
    }


    /*
        方法二：
        使用一个临时变量存下当前的值
        与前面排好序的一个一个从后到前进行比较，小于的话就把这个排好序的值往后移一位
        最后把这个值插入到前面排好序的数据中
     */

    public static void sort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    public static void sort3(int[] arr) {
//        T e = arr[i];
//        int j; // j保存元素e应该插入的位置
//        for (j = i; j > 0 && arr[j-1] > e; j--)
//            arr[j] = arr[j-1];
//        arr[j] = e;



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