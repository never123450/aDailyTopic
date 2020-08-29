package xiaomage.greed;

import java.util.Arrays;

/**
 * @description: 贪心算法  最优装载问题
 * @author: xwy
 * @create: 1:51 PM 2020/8/22
 **/

public class Pirate {
    public static void main(String[] args) {
        int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        Arrays.sort(weights);

        int capacity = 30, weight = 0, count = 0;

        for(int i=weights.length-1;i>0 && weight<capacity;i--){
        //for (int i = 0; i < weights.length && weight < capacity; i++) {
            int newWeight = weight + weights[i];
            if (newWeight <= capacity) {
                weight = newWeight;
                count++;
                System.out.println(weights[i]);
            }
        }

        System.out.println("一共选了" + count + "件古董");
    }
}
