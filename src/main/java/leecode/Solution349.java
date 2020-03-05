package leecode;/// Leetcode 349. Intersection of Two Arrays
/// https://leetcode.com/problems/intersection-of-two-arrays/description/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
//        TreeSet<Integer> set = new TreeSet<>();
//        for(int num: nums1)
//            set.add(num);
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int num: nums2){
//            if(set.contains(num)){
//                list.add(num);
//                set.remove(num);
//            }
//        }
//
//        int[] res = new int[list.size()];
//        for(int i = 0 ; i < list.size() ; i ++)
//            res[i] = list.get(i);
//        return res;


        TreeSet set = new TreeSet();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (Iterator iter = set.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next()); //459
        }

        TreeSet set1 = new TreeSet();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set1.add(nums2[i]);
            }
        }

        System.out.println();
        for (Iterator iter = set1.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next());// 49
        }

        int[] res = new int[set1.size()];
        int j=0;
        for (Iterator iter = set1.iterator(); iter.hasNext(); ) {
            res[j] = (int) iter.next();
            j++;
        }

        return res;

    }

    public static void main(String[] args) {
        Solution349 solution349 = new Solution349();
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        int[] intersection = solution349.intersection(num1, num2);
        System.out.println();
        for(int i : intersection){
            System.out.print(i);
        }
    }
}
