package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @description: https://www.lintcode.com/problem/majority-element/description
 *
 * @author: xwy
 *
 * @create: 2019年04月5日12:30:37
**/

public class MajorityNumber {

    public int findmajorityNumber(ArrayList<Integer> nums) {

        int count = 1;
        int cur = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i).equals(cur)) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cur = nums.get(i);
                    count = 1;
                }
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3};
        Integer[] nums2 = {2, 1, 2, 1, 2};
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(nums1));
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(Arrays.asList(nums2));
        MajorityNumber majorityNumber = new MajorityNumber();
        System.out.println(majorityNumber.findmajorityNumber(arrayList1));
        System.out.println(majorityNumber.findmajorityNumber(arrayList2));
    }
}