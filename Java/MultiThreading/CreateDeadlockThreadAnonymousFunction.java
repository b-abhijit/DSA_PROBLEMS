/* Program to create a deadlock scenario using thread class (anonymous function) */

package MultiThreading;

import java.util.concurrent.TimeUnit;

public class CreateDeadlockThreadAnonymousFunction {

    static String s1 = "printer", s2 = "scanner";

    Thread thread1 = new Thread() {
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

    Thread thread2 = new Thread() {
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
        CreateDeadlockThreadAnonymousFunction object = new CreateDeadlockThreadAnonymousFunction();

        object.thread1.setName("Desktop1");
        object.thread2.setName("Desktop2");

        object.thread1.start();
        object.thread2.start();
    }
}
