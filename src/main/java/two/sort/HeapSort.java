package two.sort;

/**
 * @description: 堆排序
 * @author: xwy
 * @create: 10:29 AM 2020/7/5
 **/

public class HeapSort {   //(1)
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = {19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10, 7};

        System.out.println("Before heap:");
        heapSort.printArray(array);

        heapSort.heapSort(array);

        System.out.println("After heap sort:");
        heapSort.printArray(array);
    }

    public void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            exchangeElements(array, 0, i);
            maxHeap(array, i, 0);
        }
    }

    private void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int half = (array.length - 1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    //length表示用于构造最大堆的数组长度元素数量
    private void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (index != largest) {
            exchangeElements(array, index, largest);

            maxHeap(array, heapSize, largest);
        }
    }

    public void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }


    //在数组a里进行2个下标元素交换
    public void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}