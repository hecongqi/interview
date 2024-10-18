import java.util.concurrent.CountDownLatch;

/**
 * 三个线程t1、t2、t3，
 * t1打印test1，t2打印test2，t3打印test3，
 * 要求按顺序输出test1test2test3，test1test2test3……总共输出10次
 */
public class ThreeThread {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(30);
        new Thread(()->{
            int i=0;
            while(true){
                long num = latch.getCount();
                if(num%3==0){
                    System.out.print("test1");
                    latch.countDown();
                    i++;
                }
                if(i==10) break;
            }
        },"t1").start();
        new Thread(()->{
            int i=0;
            while(true){
                long num = latch.getCount();
                if(num%3==2){
                    System.out.print("test2");
                    latch.countDown();
                    i++;
                }
                if(i==10) break;
            }
        },"t2").start();
        new Thread(()->{
            int i=0;
            while(true){
                long num = latch.getCount();
                if(num%3==1){
                    System.out.print("test3,");
                    latch.countDown();
                    i++;
                }
                if(i==10) break;
            }
        },"t3").start();
        latch.await();
    }
}
