package four;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 7:46 PM 2019/12/3
**/

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 6, 5, 4, 7, 3, 0};

        print(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println();
        print(arr);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = partition(arr, left, right);

        sort(arr, left, mid);//rightB:4  left:1

        sort(arr, mid + 1, right);

        print(arr);
    }

    /*
         选最后一个作为轴（pivot），一个指针从左往右，一个指针从右往左(从倒数第二个开始），
         当左边的数大于pivot，当右边的小于pivot，交换位置
         当left>=right 时完成一次循环，此时左边的数都小于pivot，右边的数都大于pivot
     */
    public static int partition(int[] arr, int left, int right) {

        int pivot = arr[right];//最后一个数为轴
        int rightB = right - 1;
        int leftB = left;

        while (leftB < rightB) {

            // 从左到右，如果小于轴，就一直往后移
            while (arr[leftB] <= pivot && leftB < rightB) {
                leftB++;
            }
            // 从右到左，如果大于轴，就一直往前移
            while (arr[rightB] > pivot && rightB > leftB) {
                rightB--;
            }

            System.out.println("rightB:" + rightB + "  leftB:" + leftB);
        }

        swop(arr, right, leftB);
        return leftB;

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