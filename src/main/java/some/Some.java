package some;

/**
 * @description:
 * @projectName:dataStructure
 * @see:some
 * @author:xwy
 * @createTime:2021/4/18 18:40
 * @version:1.0
 */
public class Some {
    public static void main(String[] args) {

        double zfb = 129264.07;
        double wx = 174430.29 + 77;
        double zs = 5508.86;
        double jd = 9540;
        double gp = 56000;
        double gf = 39733; // 亏5000
        double gjj = 20000;
        double qj = 20634.85;

        double js = 0;
        double ny = 0;
        double xianxian = 5000;
        double fang = 1650;
        double che = 3125;
        double huabei = 1000;
        double zong = zfb + wx + zs + jd + gp + gf + gjj + js + ny + qj;
        double hua = huabei + fang + che;
        System.out.println("总：" + zong);
        System.out.println("花销：" + hua);
        System.out.println("除去房租车贷花呗：" + (zong - hua));
        System.out.println("车子剩余：" + 3125 * 4);
    }
}
