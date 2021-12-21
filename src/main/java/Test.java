
/**
 * @description:
 * idae git 插件
 * https://plugins.jetbrains.com/plugin/7499-gittoolbox
 * @author: xwy
 * @create: 下午5:09 2021/2/24
 **/


public class Test {

    static {
        System.out.println("Test 静态代码块");
    }

    {
        System.out.println("Test 构造块");
    }

    public Test() {
        System.out.println("Test 构造方法");
    }

    public static void main(String[] args) {
        new Sub();
    }
}

class Super {
    static {
        System.out.println("Super 静态代码块");
    }

    {
        System.out.println("Super 构造块");
    }

    public Super() {
        System.out.println("Super 构造方法");
    }
}

class Sub extends Super {
    static {
        System.out.println("Sub 静态块");
    }

    public Sub() {
        System.out.println("Sub 构造方法");
    }

    {
        System.out.println("Sub 构造块");
    }
}

/*
Test 静态代码块
Super 静态代码块
Sub 静态块
Super 构造块
Super 构造方法
Sub 构造块
Sub 构造方法
 */