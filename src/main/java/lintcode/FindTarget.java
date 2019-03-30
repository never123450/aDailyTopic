package lintcode;

public class FindTarget {

    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     * @from : https://www.lintcode.com/problem/first-position-of-target/description
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here

//        int start = 0;
//        int end = nums.length - 1;
//        int res = -1;
//
//        while (start <= end) {
//            int mid = start + ((end - start) >> 1);
//            if (nums[mid] >= target) {
//                end = mid - 1;
//                res = mid;
//            } else {
//                start = mid + 1;
//            }
//        }
//
//        if (res != -1 && nums[res] != target) {
//            return -1;
//        }

        int start = 0;
        int end = nums.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                //如果找到了就看他前一个是否等于target，如果等于再向前移一个再判断是否相等...
                res = mid;
                if (mid > 0 && nums[mid - 1] == target) {
                    end = mid - 1;
                    res = end;
                } else {
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindTarget findTarget = new FindTarget();
        int nums[] = {1, 2, 3, 3, 4, 5, 10};
        int target = 6;
        System.out.println(findTarget.binarySearch(nums, target));
    }


}