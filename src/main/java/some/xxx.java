package some;

public class xxx {
    public static void main(String[] args) {
        double xw = 11624.85 + 161236.79;
        double zfb = 129838.99;
        double js = 0;
        double zs = 9451.89;
        double ny = 0;
        double gupiao = 50000;
        double guangfa = 36668.2; // 亏 5000
        double jd = 9500;
        // 至2021年3月
        double chezong = 3125 * 4;
        double xianxian = 5000;
        double gjj = 19566.17;
        double fang = 0;
        double che = 3125;
        double huabei = 1000;
        double zong = xw + zfb + js + zs + ny + gjj + gupiao + guangfa + jd;
        double hua = fang + che + huabei;
        double zong1 = zong - hua;
        System.out.println("公积金：" + gjj);
        System.out.println("房租车贷花呗：" + hua);
        System.out.println("总：" + zong);
        System.out.println("除去房租和车贷花呗：" + zong1);
        System.out.println();
        System.out.println("车子剩余：" + chezong + "  " + 4 + "个月   ");

        // 车子：3125 1300
        // 定 支10w  微10w

        // 股票:4w 基金:1.5w + 2w 共:7.5w
        // 富途牛牛入金: 需 5w


        double baoxian = 450 + 999 + 240 + 2803.17 + 855 + 300;
        double x = 4042.17 + 1605;
        double j = 1072 + 28;
        System.out.println("保险:" + (x - j));


        /**
         * 4975   +   9300
         * 7888    +  6300
         * 7785.75  + 6300
         * 10795.38  +3300
         */
        System.out.println(4975 + 9300);
        System.out.println(7888 + 6300);
        System.out.println(7785.75 + 6300);
        System.out.println(10795.38 + 3300);

        //       房    花呗    车
        int a = 1650 + 1000 + 3125;
        System.out.println(14000-a);
    }
}