package lintcode;

public class PeekPositions {

    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     * @date 2019年03月28日13:21:15
     */
    public int findPeak(int[] A) {

        // write your code here
        if(A==null || A.length<3){
            return 0;
        }
        int pre = 1, last = A.length-2;
        while (pre+1<last){
            int mid = pre+(last-pre)/2;
            if(A[mid]>A[mid+1]){
                last = mid;
            }else{
                pre = mid;
            }
        }
        if(A[pre]<A[last]){
            return last;
        }else{
            return pre;
        }

    }

    public static void main(String[] args) {
        PeekPositions p = new PeekPositions();
        int [] a = {1, 2, 1, 3, 4, 5, 7, 6};
        System.out.println(p.findPeak(a));
    }

}