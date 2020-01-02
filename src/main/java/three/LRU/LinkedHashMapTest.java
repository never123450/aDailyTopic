package three.LRU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> l = new LinkedHashMap<>();
        l.put(3, 11);
        l.put(1, 12);
        l.put(5, 23);
        l.put(2, 22);

        for (Map.Entry e : l.entrySet()) {
            System.out.print(e.getKey());
        }


        System.out.println();

        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        l = new LinkedHashMap<Integer, Integer>(10, (float) 0.75, true);
        l.put(3, 11);
        l.put(1, 12);
        l.put(5, 23);
        l.put(2, 22);


        l.put(3, 26); //1523
        l.get(5);//1235
        for (Map.Entry e : l.entrySet()) {
            System.out.print(e.getKey());
        }

        //从上面可以看出linkedHashMap已经支持了LRU缓存淘汰策略


    }
}