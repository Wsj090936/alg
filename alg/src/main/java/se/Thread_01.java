package se;

import java.util.Arrays;

/**
 *
 * @Author jiahao
 * @Date 2021/1/21 21:36
 */
public class Thread_01{
    private volatile int tag = 1;
    public synchronized void printA(){

            if(tag != 1){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("A");
                tag = 2;
                this.notifyAll();
            }

    }
    public synchronized void printB(){
        if(tag != 2){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("B");
            tag = 3;
            this.notifyAll();
        }

    }
    public synchronized void printC(){
        if(tag != 3){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("C");
            tag = 4;
            this.notifyAll();
        }
    }
    public synchronized void printD(){
        if (tag != 4){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("D");
            tag = 1;
            this.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread_01 rd = new Thread_01();
        Thread thread = new Thread(() ->
        {
            while (true){
                rd.printA();
            }
        }
        );
        Thread threadB = new Thread(() ->
        {
            while (true){
                rd.printB();
            }
        }
        );
        Thread threadC = new Thread(() ->
        {
            while (true){
                rd.printC();
            }
        }
        );
        Thread threadD = new Thread(() ->
        {
            while (true){
                rd.printD();
            }
        }
        );
        thread.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }

}
