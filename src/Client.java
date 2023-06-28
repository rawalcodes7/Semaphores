import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        int maxSize=3;
        Queue<Object> shop=new ConcurrentLinkedQueue<>();

        Semaphore P=new Semaphore(maxSize);
        Semaphore C=new Semaphore(0);

        Producer p1=new Producer(maxSize,shop,P,C);
        Producer p2=new Producer(maxSize,shop,P,C);
        Producer p3=new Producer(maxSize,shop,P,C);



        Consumer c1=new Consumer(maxSize,shop,P,C);
        Consumer c2=new Consumer(maxSize,shop,P,C);
        Consumer c3=new Consumer(maxSize,shop,P,C);
        Consumer c4=new Consumer(maxSize,shop,P,C);
        Consumer c5=new Consumer(maxSize,shop,P,C);





        Thread t1=new Thread(p1);
        Thread t2=new Thread(p2);
        Thread t3=new Thread(p3);



        Thread t5=new Thread(c1);
        Thread t6=new Thread(c2);
        Thread t7=new Thread(c3);
        Thread t8=new Thread(c4);
        Thread t9=new Thread(c5);


        t1.start();
        t2.start();
        t3.start();

        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();

    }
}
