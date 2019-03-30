package lintcode;


/**
 * public class SVNRepo {
 * public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */

/**
 * @description: https://www.lintcode.com/problem/first-bad-version/description
 * @create: 2019年03月30日17:47:14
 **/

public class FindFirstBadVersion {

    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here

        int start = 1;
        int end = n;
        int res = -1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (SVNRepo.isBadVersion(mid)) {
                end = mid-1;
                res = mid;
            } else {
                start = mid + 1;
            }
        }

        return res;


// 		int lo = 1;
// 		int hi = n;
// 		while (lo<hi) {
// 			int mid = lo + ((hi - lo) >> 1);
// 			if (SVNRepo.isBadVersion(mid)) {
// 				hi = mid;
// 			}
// 			else {
// 				lo = mid + 1;
// 			}
// 		}
// 		return lo;
    }


    //无具体实现
    static class SVNRepo {
        public static boolean isBadVersion(int k) {
            return false;
        }
    }
}



