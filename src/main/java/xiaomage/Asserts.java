package xiaomage;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 5:19 PM 2020/7/31
**/

public class Asserts {
	public static void test(boolean value) {
		try {
			if (!value) throw new Exception("测试未通过");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
