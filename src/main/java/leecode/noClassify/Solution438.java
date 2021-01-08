package leecode.noClassify;

import java.util.*;

/**
 * @description: https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * 找到字符串中所有字母异位词
 * @author: xwy
 * @create: 4:17 PM 2020/9/8
 **/

public class Solution438 {



    /*

        // 滑动窗口算法框架
        void slidingWindow(string s, string t) {
            unordered_map<char, int> need, window;
            for (char c : t) need[c]++;

            int left = 0, right = 0;
            int valid = 0;
            while (right < s.size()) {
                // c 是将移入窗口的字符
                char c = s[right];
                // 右移窗口
                right++;
                // 进行窗口内数据的一系列更新
                ...

                // debug 输出的位置
                printf("window: [%d, %d)\n", left, right);

                // 判断左侧窗口是否要收缩
                while (window needs shrink) {
                    // d 是将移出窗口的字符
                    char d = s[left];
                    // 左移窗口
                    left++;
                    // 进行窗口内数据的一系列更新
                    ...
                }
            }
        }

     */


    /*

         vector<int> findAnagrams(string s, string t) {
            unordered_map<char, int> need, window;
            for (char c : t) need[c]++;

            int left = 0, right = 0;
            int valid = 0;
            vector<int> res; // 记录结果
            while (right < s.size()) {
                char c = s[right];
                right++;
                // 进行窗口内数据的一系列更新
                if (need.count(c)) {
                    window[c]++;
                    if (window[c] == need[c])
                        valid++;
                }
                // 判断左侧窗口是否要收缩
                while (right - left >= t.size()) {
                    // 当窗口符合条件时，把起始索引加入 res
                    if (valid == need.size())
                        res.push_back(left);
                    char d = s[left];
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.count(d)) {
                        if (window[d] == need[d])
                            valid--;
                        window[d]--;
                    }
                }
            }
            return res;
        }

     */

    public List<Integer> findAnagrams(String s, String t) {
        Map<String, Integer> need = new HashMap(), window = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            need.put(String.valueOf(s.charAt(i)), need.get(s.charAt(i)) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();//记录结果
        while (right < s.length()) {
            char c = s.charAt(right);
            // 进行窗口内数据的一系列更新操作
            if (need.containsKey(String.valueOf(c))) {
                window.put(String.valueOf(c), window.get(c) + 1);
                if (window.get(c) == need.get(c)) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时,把起始索引加入 res
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                // 进行窗口内数据的一系列更新
                if (need.containsKey(String.valueOf(d))) {
                    if (window.get(String.valueOf(d)) == need.get(String.valueOf(d))) {
                        valid--;
                    }
                    window.put(String.valueOf(d), window.get(d) + 1);
                }
            }
        }
        return res;
    }


}