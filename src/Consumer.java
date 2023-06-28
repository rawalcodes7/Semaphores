
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    int maxSize;
    Queue<Object> shop;
    Semaphore p;
    Semaphore c;

    public Consumer(int maxSize, Queue<Object> shop,Semaphore p,Semaphore c) {
        this.maxSize = maxSize;
        this.shop = shop;
        this.p=p;
        this.c=c;
    }

    @Override
    public void run() {
        while(true) {
            try {
                c.acquire();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            shop.remove();
            System.out.println("Consumer has consumed, shop size is: " + shop.size());

            p.release();
        }
    }
}
