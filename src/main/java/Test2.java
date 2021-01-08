import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @description:
 * @author: xwy
 * @create: 7:15 PM 2020/5/12
 **/

public class Test2 {
    static boolean boolValue;

    public static void main(String[] args) {
//        boolValue = true; // 将这个 true 替换为 2 或者 3，再看看打印结果
//        if (boolValue) System.out.println("Hello, Java!");
//        if (boolValue == true) System.out.println("Hello, JVM!");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -2);
        String date = sdf.format(calendar.getTime());
        System.out.println(date);
    }
}