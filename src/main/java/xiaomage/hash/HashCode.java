package xiaomage.hash;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:36 PM 2020/7/26
**/

public class HashCode {
    /**
     * 获取一个string类型的hashCode，和java自带的效果是一样的
     * @param s
     * @return
     */
    public int getHashCode(String s){
        int len = s.length();
        int hashCode = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            hashCode = hashCode * 31 + c;
            // 上面等价于下面
//            hashCode = (hashCode << 5) - hashCode + c;
        }
        return hashCode;
    }

    public static void main(String[] args) {
        HashCode hashCode = new HashCode();
        int abc = hashCode.getHashCode("abc");
        System.out.println(abc);

        // jdk自带的hashCode方法
        System.out.println("abc".hashCode());
    }

}