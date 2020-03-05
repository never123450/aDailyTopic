package zzzzz;

public class zzzz {

    public static void main(String[] args) {
        double wx = 50609.18 + 38098.06;
        double zfb = 69282.37;
        double zs = 20210.35;
        double js = 99634.42;
        double ny = 0;

        double jie2 = 5000;//徐文贤

        double fang = 1650;
        double che月 = 3125;
        double che总 = 60000;
        double huabei = 2000;
        double gjj = 8643.28;// 公积金

        double zong = wx + zfb + zs + ny + js + gjj;
        System.out.println("啥都不减：" + zong);

        double zong1 = zong + jie2;
        System.out.println("包括借出去的钱：" + zong1);

        zong = wx + zfb + zs + ny + js + gjj - che月 - fang - huabei;
        System.out.println("除去花呗车子房租（月供的）：" + zong);

        double zong2 = zong + jie2 - che总;
        System.out.println("除去车子：" + zong2);


    }
}