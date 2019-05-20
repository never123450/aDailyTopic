package three.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 基于数组实现的LRU缓存
 * <p>
 * 1.空间复杂度为O(n)
 * 2.时间复杂度为O(n)
 * 3.不支持null的缓存
 * @author: xwy
 * @create: 4:27 PM 2019/5/16
 **/

public class LRUBasedArray<T> {

    private static final int DEFAULT_CAOACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;
    private boolean full;

    LRUBasedArray() {
        this(DEFAULT_CAOACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        count = 0;
        value = (T[]) new Object[capacity];
        holder = new HashMap<T, Integer>(capacity);
    }

    /**
     * 模拟访问某个值
     *
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("不能存入null！");
        }
        //查询缓存池中是否有这个值
        Integer index = holder.get(object);
        //如果没有
        if (index == null) {
            //判断是否是满的，满的就移除在缓存
            if (isFull()) {
                removeAndCache(object);
            } else {
                //不满就直接缓存
                cache(object, count);
            }
        } else {
            //如果缓存中有，就直接update
            update(index);
        }
    }

    /**
     * 缓存数据到头部，但要先右移
     *
     * @param object
     * @param count  数组右移的边界
     */
    private void cache(T object, int count) {
        rightShift(count);
        value[0] = object;
        holder.put(object, 0);
        count++;

    }

    /**
     * 缓存满的情况，踢出后，再缓存到数组头部
     *
     * @param object
     */
    private void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);
        cache(object, count);

    }

    /**
     * end左边的数据统一右移一位
     *
     * @param end
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    /**
     * 缓存中有指定的值就更新
     *
     * @param index
     */
    private void update(Integer index) {
        T target = value[index];
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 判断缓存是否是满的
     *
     * @return
     */
    public boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
//            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }

}