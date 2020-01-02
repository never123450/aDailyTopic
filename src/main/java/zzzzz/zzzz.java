package zzzzz;

public class zzzz {

    public static void main(String[] args) {
        double wx = 27251.01 + 30280.25;
        double zfb = 60253.49;
        double zs = 20103.45;
        double js = 100639.58;
        double ny = 4994.31;

        double jie = 10000;//熊璐
        double jie2 = 5000;//徐文贤

        double fang = 1650;
        double che月 = 3125;
        double che总 = 70000;
        double huabei = 2000;


        double zong = wx + zfb + zs + ny + js - che月 - fang - huabei;
        System.out.println(zong);

        double zong1 = zong + jie + jie2 ;
        System.out.println(zong1);

        double zong2 = zong + jie + jie2 - che总 ;
        System.out.println(zong2);


    }
}