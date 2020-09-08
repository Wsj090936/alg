package se.Singleton;

import com.sun.corba.se.impl.protocol.INSServerRequestDispatcher;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import org.omg.SendingContext.RunTime;

import java.io.IOException;
import java.util.Properties;

/**
 * 通过静态代码块的方式实现
 *
 * @Author jiahao
 * @Date 2020/9/8 21:43
 */
public class HungryStatic {
    private static final HungryStatic INSTANCE;

    static {

        try {
            Properties pro = new Properties();
            pro.load(HungryStatic.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new HungryStatic(pro.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private HungryStatic(){

    }

    private String info;
    private HungryStatic(String info){
        this.info = info;
    }

    @Override
    public String toString() {
        return "HungryStatic{" +
                "info='" + info + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(HungryStatic.INSTANCE);
    }
}
