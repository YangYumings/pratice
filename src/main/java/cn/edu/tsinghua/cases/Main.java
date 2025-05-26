package cn.edu.tsinghua.cases;

public class Main {
    public static void main(String[] args) {
        // 测试类型转换
        B b = new B();
        // 类型信息通过指针指向 JVM 的元数据信息 class
        b.getClass();
        // 向下转型报错 ClassCastException
        C c = (C) b;
    }
}
