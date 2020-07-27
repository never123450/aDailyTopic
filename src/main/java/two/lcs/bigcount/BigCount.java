package two.lcs.bigcount;


/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 10:53 PM 2020/7/8
**/

public class BigCount {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "113";
        String str2 = "999";

        int len1 = str1.length();
        int len2 = str2.length();

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        covertdata(s1, len1);
        covertdata(s2, len2);
        System.out.println("" + str1);
        System.out.println("" + str2);
        multiply(s1, len1, s2, len2);

    }

    public static void covertdata(char data[], int len) {
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }

    public static void multiply(char a[], int alen, char b[], int blen) {
        // 2数乘积位数不会超过乘数位数和+3
        int csize = alen + blen + 3;
        // 开辟乘积数组
        int[] c = new int[csize];
//		// 乘积数组填充
//		for (int ii = 0; ii < csize; ii++) {
//			c[ii] = 0;
//		}
        // 对齐逐位相乘
        for (int j = 0; j < blen; j++) {
            for (int i = 0; i < alen; i++) {
                c[i + j] += Integer.parseInt(String.valueOf(a[i])) * Integer.parseInt(String.valueOf(b[j]));
            }
        }
        int m = 0;
        // 进位处理
        for (m = 0; m < csize; m++) {
            int carry = c[m] / 10;
            c[m] = c[m] % 10;
            if (carry > 0)
                c[m + 1] += carry;
        }
        for (m = csize - 1; m >= 0; ) {
            if (c[m] > 0)
                break;
            m--;
        }
        for (int n = 0; n <= m; n++) {
            System.out.print(c[m - n]);
        }
        System.out.println("");
    }
}

