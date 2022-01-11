package xiaomage.sort.cmp;


import xiaomage.sort.Sort;

/**
 * @description:
 * @author: xwy
 * @create: 下午2:36 2021/11/4
 **/

public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            T v = array[cur];
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }

}
