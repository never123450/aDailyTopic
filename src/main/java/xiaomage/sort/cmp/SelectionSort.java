package xiaomage.sort.cmp;


import xiaomage.sort.Sort;

/**
 * @description:
 * @author: xwy
 * @create: 下午2:52 2021/11/3
 **/

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {

        for (int end = array.length - 1; end > 0; end--) {
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(max, begin) < 0) {
                    max = begin;
                }
            }
            swap(max, end);
        }
        // 7 5 10 1 4 2 10
    }

}
