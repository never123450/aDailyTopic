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

        double zfb = 98784.17+20000+30744.95;
        double wx = 163604.03 + 11616.42;
        double zs = 5508.86;
        double jd = 9547;
        double gp = 56000;
        double gf = 39733; // 亏5000
        double gjj = 20000;

        double js = 0;
        double ny = 0;
        double xianxian = 5000;
        double fang = 1300;
        double che = 3125;
        double huabei = 1000;
        double zong = zfb + wx + zs + jd + gp + gf + gjj + js + ny;
        double hua = huabei + fang ;
        System.out.println("总：" + zong);
        System.out.println("花销：" + hua);
        System.out.println("除去房租车贷花呗：" + (zong - hua));
        System.out.println("车子剩余：" + 3125 * 4);
    }
}
