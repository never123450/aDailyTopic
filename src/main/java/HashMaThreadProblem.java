import java.util.HashMap;
import java.util.Map;

public class HashMaThreadProblem {
    private static Map map = new HashMap<>();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("thread1_key" + i, "thread1_value" + i);
            }
        }).start();
        for (int i = 0; i < 1000; i++) {
            Object o = map.get("thread1_key" + i);
            if (o == null) {
                // 多线程情况下,put 的值有可能为空,因为假如有 2 个线程同时在操作一个地方的时候,
                // A线程有可能会霸占 B 线程的位置,导致B 的这个 key 值为空
                System.out.println("thread1_key" + i);
            }
        }

        // JDK7中HashMap并发put会造成循环链表，导致get时出现死循环
        
    }
}