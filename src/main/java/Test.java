import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * @description:
 * @author: xwy
 * @create: 11:05 AM 2020/4/23
 **/


public class Test {
    public static void main(String[] args) {
        // 返回信息：
        Map<String, Object> result = new HashMap();
        result = forTest();
        System.out.println(result);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.size();
    }

    private static Map<String, Object> forTest() {
        Map<String, Object> result = new HashMap();
        int i = 0;
        int sum = 0;

        for (; i < 10; i++) {
            try {
                System.out.println("处理到了第" + i + "个");
                if (i == 5) {
                    result.put(i + "个", i);
                    continue;
                }
                if (i == 8) {
                    result.put(i + "个", i);
                    continue;
                }

                sum += i;

            } catch (Exception e) {
                result.put(i + "个", i);
                e.printStackTrace();
            }
        }
        result.put("sum",sum);
        return result;
    }
}