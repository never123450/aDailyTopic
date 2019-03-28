package lintcode;

public class BinarySearch457 {
    /**
     * @param nums   : An integer array sorted in ascending order
     * @param target : An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here

        int start = 0;
        int end = nums.length-1 ;

        if (nums.length <= 0){
            return -1;
        }
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,5,6,6,6};
        int target = 5;
        BinarySearch457 b = new BinarySearch457();
        int tar = b.findPosition(nums,target);
        System.out.println(tar);
    }
}