import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    int maxSize;
    Queue<Object> shop;
    Semaphore p;
    Semaphore c;

    public Producer(int maxSize, Queue<Object> shop, Semaphore p, Semaphore c) {
        this.maxSize = maxSize;
        this.shop = shop;
        this.p = p;
        this.c = c;
    }

    @Override
    public void run() {
        while(true) {
            try {
                p.acquire();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            shop.add(new Object());
            System.out.println("Producer has produced, shop size is: " + shop.size());
            c.release();
        }
    }
}
