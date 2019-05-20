package three.queue;

/**
 * @description: 使用数组实现队列
 * @author: xwy
 * @create: 9:29 PM 2019/5/20
 **/

public class ArrayQueue {

    //数组：items，数组大小：n
    private String[] items;
    private int n = 0;

    //head表示对头下标，tail表示队尾下标
    private int head = 0;
    private int tail;

    //申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        //如果tail == n表示队列已经满了
        if (tail == n) return false;
        //tail==n 表示队列末尾没有空间了
        if (tail == n) {
            // tail==n && head==0 表示整个队列都满了
            if (head == 0) return false;
            // tail==n && head!=0 表示head前面还可以存数据，队列没满
            // 数据迁移
            for (int i = head; i < tail; ++i) {
                items[i-head] = items[i];
            }
            //搬移完成后需要重新更新head和tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    //出队
    public String dequeue() {
        //如果 head==tail 表示队列为空
        if (head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }


}