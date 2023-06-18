/* Program to create a deadlock scenario using runnable interface (anonymous function) */

package MultiThreading;

import java.util.concurrent.TimeUnit;

public class CreateDeadlockRunnableAnonymousFunction {

    static String s1 = "printer", s2 = "scanner";

    Runnable runnable1 = new Runnable() {
        public void run() {
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
        }
    };

    Runnable runnable2 = new Runnable() {
        public void run() {
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
        }
    };

    public static void main(String[] args) {
        CreateDeadlockRunnableAnonymousFunction object = new CreateDeadlockRunnableAnonymousFunction();

        Thread thread1 = new Thread(object.runnable1);
        Thread thread2 = new Thread(object.runnable2);

        thread1.setName("Desktop1");
        thread2.setName("Desktop2");

        thread1.start();
        thread2.start();
    }
}
