package se;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2020/12/9 9:19
 */
public class XbSon extends Xb {

    public XbSon(){
        super(1);
        System.out.println("子类+++++++==");
    }

    public static void main(String[] args) {
        new XbSon();
    }
}
