package two.greedy;

import java.util.Arrays;

/**
 * @description: 贪心算法 背包问题
 * @author: xwy
 * @create: 10:08 PM 2020/7/7
 **/

public class GreedyPackage {
    private int MAX_WEIGHT = 40;
    private int[] weights = new int[]{35, 30, 60, 50, 40, 10, 25};
    private int[] values = new int[]{10, 40, 30, 50, 35, 40, 30};

    private void packageGreedy(int capacity, int weights[], int[] values) {
        int n = weights.length;
        double[] r = new double[n];//性价比数组
        int[] index = new int[n];//按照性价比排序物品的下标
        for (int i = 0; i < n; i++) {
            r[i] = (double) values[i] / weights[i];
            index[i] = i;//默认排序
        }
        System.out.println("重量：" + Arrays.toString(weights));
        System.out.println("价值：" + Arrays.toString(values));
        System.out.println("性价比：" + Arrays.toString(r));

        double temp = 0;//对性价比进行排序 降序
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (r[i] < r[j]) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                    // 性价比下标也得排序
                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }

        //排序后的重量和价值分别存到数组
        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for (int i = 0; i < n; i++) {
            w1[i] = weights[index[i]];
            v1[i] = values[index[i]];
        }

        int[] x = new int[n];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (w1[i] < capacity) {
                //还可以装得下
                x[i] = 1;//表示该物品被装了
                maxValue += v1[i];
                System.out.println("物品 " + w1[i] + " 被放进背包   " + "价值：" + v1[i]);
                capacity = capacity - w1[i];
            }
        }
        System.out.println("总共放下物品的数量：" + Arrays.toString(x));
        System.out.println("最大价值：" + maxValue);
    }

    public static void main(String[] args) {
        GreedyPackage greedyPackage = new GreedyPackage();
        greedyPackage.packageGreedy(greedyPackage.MAX_WEIGHT, greedyPackage.weights, greedyPackage.values);
    }
}
