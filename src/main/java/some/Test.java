package some;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
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

//        int[][] arr={{12,58},{56,78,41},{0}};
//        //System.out.println(arr[1][1]);
//        for(int i=0;i<arr.length;i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                Systemheap.out.print(arr[i][j] + "  ");
//            }
//            System.out.println();
//        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        System.out.println("现在时间："+sdf.format(now));

        Date date = sdf.parse("2020-06-24 17:46:28");
        System.out.println("2020-06-24 17:46:28");
        long l = date.getTime() + 100 * 1000; // 加多少秒
        date = new Date(l);
        System.out.println(sdf.format(date ));




    }
}