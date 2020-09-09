package se.Singleton;

/**
 *
 * 懒汉式 1使用锁
 * @Author jiahao
 * @Date 2020/9/9 21:38
 */
public class LazySingleton {
    private static LazySingleton INSTANCE;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if(INSTANCE == null){
            synchronized (LazySingleton.class){
                if(INSTANCE == null){
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}
