package two.sort;

public class InsertSort {
    /**
     * ֱ插入排序 复杂度n平方
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        //插入排序开始
        for (int i = 1; i < a.length; i++) {

            int temp = a[i];  //新遍历的值，等待插入到前面的的数组有序
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的数往后移一步
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;//
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
