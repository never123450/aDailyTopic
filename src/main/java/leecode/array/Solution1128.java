package leecode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 * 等价多米勒骨牌的数量
 * @author: xwy
 * @create: 08:44 2021/1/27
 **/

public class Solution1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        // 为了避免哈希表自动扩容，根据题目的数据范围，设置哈希表初始化的大小为 100
        // Pair 类重写了 hashCode() 和 equals() 方法
        Map<Pair, Integer> freq = new HashMap<>(100);
        for (int[] dominoe : dominoes) {
            Pair key = new Pair(dominoe[0], dominoe[1]);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        // 根据组合数公式 C_n^2 = (n * (n - 1)) / 2 计算等价骨牌能够组成的组合数，再求和
        int count = 0;
        for (int f : freq.values()) {
            count += (f * (f - 1)) / 2;
        }
        return count;
    }

    private class Pair {

        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        /**
         * 让有序数对 [a, b] 和 [b, a] 认为是相等的对象
         *
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return key == pair.key && value == pair.value || key == pair.value && value == pair.key;
        }

        /**
         * 让相同的数对映射到同一个位置
         *
         * @return
         */
        @Override
        public int hashCode() {
            if (key > value) {
                return value * 10 + key;
            }
            return key * 10 + value;
        }
    }

    public int numEquivDominoPairs1(int[][] dominoes) {
        int[] nums = new int[100];
        int result = 0;
        for (int[] dominoe : dominoes) {
            int val = 0;
            if (dominoe[0] > dominoe[1]) {
                val = dominoe[1] * 10 + dominoe[0];
            }else {
                val = dominoe[0] * 10 + dominoe[1];
            }
            result += nums[val];
            nums[val]++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1128 solution1128 = new Solution1128();
        int dominoes[][] = {{1,2},{2,1},{2,1},{5,6}};
        int i = solution1128.numEquivDominoPairs1(dominoes);
        System.out.println(i);
    }

}