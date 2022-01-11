package xiaomage.sort.cmp;


import xiaomage.sort.Sort;

/**
 * @description:
 * @author: xwy
 * @create: 下午4:45 2021/11/3
 **/

public class InsertionSort1<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }

}
