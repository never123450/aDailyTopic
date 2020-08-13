package xiaomage.sort;

import xiaomage.Asserts;
import xiaomage.sort.cmp.*;
import xiaomage.sort.tools.Integers;

import java.util.Arrays;

/**
 *
 * @description: 冒泡排序 测试
 *
 * @author: xwy
 *
 * @create: 6:40 AM 2020/8/6
**/

public class Main {

    public static void main(String[] args) {
        Integer[] array = {7, 3, 5, 8, 6, 7, 4, 5};

        testSorts(array,
//				new RadixSort()
//				new InsertionSort1(),
//				new InsertionSort2(),
                new InsertionSort3(),
                new SelectionSort(),
                new HeapSort(),
                new MergeSort(),
                new BubbleSort3(),
                new QuickSort(),
                new ShellSort()
        );
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

    static void selectionSort(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (array[maxIndex] <= array[begin]) {
                    maxIndex = begin;
                }
            }
            int tmp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = tmp;
        }

        // 8 10 9 10
    }

    /**
     * 常规冒泡排序(稳定算法)
     *
     * @param array
     */
    static void bubbleSort1(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序 优化1：如果序列已经完全有序，可以提前终止冒泡排序 (稳定算法 原地算法 )
     *
     * @param array
     */
    static void bubbleSort2(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    /**
     * 冒泡排序 优化2：如果序列尾部已经局部有序，可以记录最后一次交换的位置，减少比较次数 (稳定算法 原地算法 )
     *
     * @param array
     */
    static void bubbleSort3(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            // sortedIndex的初始值在数组完全有序的时候有用
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }

}
