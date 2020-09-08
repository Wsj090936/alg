package se.Singleton;

/**
 *
 *  单例饿汗
 * @Author jiahao
 * @Date 2020/9/8 21:32
 */
public class Hungry {
    private static final Hungry instance  = new Hungry();
    private Hungry(){

    }
    public static Hungry getInstance() {
        return instance;
    }
}
