package se.Singleton;

/**
 * 懒汉式V2
 * 静态内部类
 *
 * @Author jiahao
 * @Date 2020/9/9 21:42
 */
public class LazySingletonV2 {

    private LazySingletonV2(){

    }
    private static class Inner{
        private static final LazySingletonV2 INSTANCE = new LazySingletonV2();
    }
    public static LazySingletonV2 getInstance(){
        return Inner.INSTANCE;
    }
}
