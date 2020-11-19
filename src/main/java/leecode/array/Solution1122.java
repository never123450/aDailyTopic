package leecode.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @description: https://leetcode-cn.com/problems/relative-sort-array/
 * 数组的相对排序
 * @author: xwy
 * @create: 16:33 2020/11/19
 **/

public class Solution1122 {

    // 普通的方法
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List result = new ArrayList<Integer>();
        List differ = new ArrayList<Integer>();
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    result.add(arr1[j]);
                }
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                differ.add(arr1[i]);
        }


        if (differ.size() > 0) {
            // 对 differ 排序
            List<Integer> integers = bubbleSort(differ);
            result.addAll(integers);
        }


        int[] arr = new int[arr1.length];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = (int) result.get(i);
        }
        return arr;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*
     * 冒泡排序。
     */
    private List<Integer> bubbleSort(List differ) {
        int[] arr = new int[differ.size()];
        for (int i = 0; i < differ.size(); i++) {
            arr[i] = (int) differ.get(i);
        }
        for (int x = 0; x < arr.length - 1; x++) {//控制外循环次数
            for (int y = 0; y < arr.length - 1 - x; y++) {//-1是为了避免角标越界异常，-x是为了减少外循环次数
                if (arr[y] > arr[y + 1]) {//判断两个相邻元素的大小
                    swap(arr, y, y + 1);
                }
            }
        }
        differ.clear();
        for (int i = 0; i < arr.length; i++) {
            differ.add(arr[i]);
        }
        return differ;
    }

    // 计数排序
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int i : arr1) {
            upper = Math.max(i, upper);
        }
        int[] frequency = new int[upper + 1];
        for (int i : arr1) {
            frequency[i]++;
        }
        int[] result = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            for (int j = 0; j < frequency[i]; j++) {
                result[index++] = i;
            }
            frequency[i] = 0;
        }

        for (int i = 0; i <= upper; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                result[index++] = i;
            }
        }
        return result;
    }

    // 使用 Map
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) list.add(num);
        for (int i = 0; i < arr2.length; i++)
            map.put(arr2[i], i);

        Collections.sort(list, (x, y) -> {
            if (map.containsKey(x) || map.containsKey(y))
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++)
            arr1[i] = list.get(i);
        return arr1;
    }

    public int[] relativeSortArray3(int[] arr1, int[] arr2) {
        Map<Integer, Integer> numPostions = IntStream.range(0, arr2.length).boxed().collect(Collectors.toMap(i -> arr2[i], i -> i));
        return Arrays.stream(arr1).boxed().sorted((o1, o2) -> {
            int a1 = numPostions.getOrDefault(o1, 1001);
            int a2 = numPostions.getOrDefault(o2, 1001);
            if (a1 != 1001 || a2 != 1001) {
                return a1 - a2;
            }

            return o1 - o2;
        }).mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        Solution1122 solution1122 = new Solution1122();
        int[] arr1 = {28, 6, 22, 8, 44, 17}, arr2 = {22, 28, 8, 6};
        int[] ints = solution1122.relativeSortArray1(arr1, arr2);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}