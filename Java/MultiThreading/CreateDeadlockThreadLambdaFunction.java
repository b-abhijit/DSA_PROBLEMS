/* Program to create a deadlock scenario using thread class (lambda function) */

package MultiThreading;

import java.util.concurrent.TimeUnit;

public class CreateDeadlockThreadLambdaFunction {

    static String s1 = "printer", s2 = "scanner";

    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            synchronized (s1) {
                try {
                    System.out.println(Thread.currentThread().getName() + " : " + s1 + " is acquired");
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " : waiting for " + s2);
                synchronized (s2) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (s2) {
                try {
                    System.out.println(Thread.currentThread().getName() + " : " + s2 + " is acquired");
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " : waiting for " + s1);
                synchronized (s1) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.setName("Desktop1");
        thread2.setName("Desktop2");

        thread1.start();
        thread2.start();
    }
}
