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

//        if (nums.length <= 0) {
//            return -1;
//        }
//
//        int start = 0;
//        int end = nums.length - 1;
//        System.out.println("start:"+start);
//        System.out.println("end:"+end);
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            System.out.println("mid:"+mid);
//            if (target > nums[mid]) {
//                start = mid + 1;
//                System.out.println("target > nums[mid]");
//                System.out.println("start:"+start);
//                System.out.println("end:"+end);
//                System.out.println("nums[start]:"+nums[start]);
//                System.out.println("nums[end]:"+nums[end]);
//            } else if (target < nums[mid]) {
//                end = mid - 1;
//                System.out.println("target <= nums[mid]");
//                System.out.println("start:"+start);
//                System.out.println("end:"+end);
//                System.out.println("nums[start]:"+nums[start]);
//                System.out.println("nums[end]:"+nums[end]);
//            }else {
//                end = mid;
//                start = mid;
//                System.out.println("target <= nums[mid]");
//                System.out.println("start:"+start);
//                System.out.println("end:"+end);
//                System.out.println("nums[start]:"+nums[start]);
//                System.out.println("nums[end]:"+nums[end]);
//            }
//        }
//
//        System.out.println("执行完了");
//        return end;

        int start = 0;
        int end = nums.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] >= target) {
                end = mid - 1;
                res = mid;
            } else {
                start = mid + 1;
            }
        }

        if (res != -1 && nums[res] != target) {
            return -1;
        }

        return res;
    }

    public static void main(String[] args) {
        FindTarget findTarget = new FindTarget();
        int nums[] = {4, 4, 5, 7, 7, 7, 8, 9, 9, 10};
        int target = 9;
        System.out.println(findTarget.binarySearch(nums, target));
    }


}