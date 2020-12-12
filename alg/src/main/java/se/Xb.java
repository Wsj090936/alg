package se;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2020/9/8 21:30
 */
public class Xb {

    private static int i = 333;
    static {
        System.out.println("static" + i);
    }
    public Xb(){
        System.out.println("父类+++++++");
        System.out.println(i);
    }
    public Xb(int i){
        System.out.println(i);
    }

    public static void main(String[] args) {
        new Xb();
    }
}
