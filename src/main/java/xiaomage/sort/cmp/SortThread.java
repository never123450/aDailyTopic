package xiaomage.sort.cmp;

/**
 * @description: 史上"最强"排序 - 休眠排序 这脑洞 牛逼
 * @author: xwy
 * @create: 12:34 PM 2020/8/9
 **/

public class SortThread extends Thread {

    private int value;

    public SortThread(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(value);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        int[] array = {10, 100, 50, 40, 90};
        for (int i = 0; i < array.length; i++) {
            new SortThread(array[i]).start();
        }
    }
}