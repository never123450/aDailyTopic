package xiaomage.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 桶排序
 * @author: xwy
 * @create: 下午3:14 2021/11/10
 **/

public class BucketSort extends Sort<Double> {

    @Override
    protected void sort() {
        List<Double>[] buckets = new List[array.length];
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = (int) (array[i] * array.length);
            List<Double> bucket = buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(array[i]);
        }
        // 对每个桶进行排序
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            buckets[i].sort(null);
            for (Double d : buckets[i]) {
                array[index++] = d;
            }
        }
    }
}