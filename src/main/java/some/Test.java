package some;

public class Test {
    public static void main(String[] args) {
//        long[][] a = new long[1000][1000];
//        for (int i=0;i<a.length;i++){
//            for (int j=0;j<a[i].length;j++){
//                a[i][j] = j;
//            }
//        }
//
//
//        for (int i=0;i<a.length;i++){
//            for (int j=0;j<a[i].length;j++){
//                a[j][i] = j;
//            }
//        }

        int[][] arr={{12,58},{56,78,41},{0}};
        //System.out.println(arr[1][1]);
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

    }
}