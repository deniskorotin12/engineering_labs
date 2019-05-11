package mutex;

import java.util.concurrent.Semaphore;

public class Mutex {

    private static Semaphore semaphore = new Semaphore(1);

    static class LockerThread extends Thread {

        String name;

        LockerThread(String name) {
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : is performing operation " + i
                                + ", available Semaphore permits : "
                                + semaphore.availablePermits());

                        Thread.sleep(1000);

                    }

                } finally {

                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available Semaphore permits now: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public static void main(String[] args) {

        System.out.println("Total available Semaphore permits : "
                + semaphore.availablePermits());

        LockerThread t1 = new LockerThread("A");
        t1.start();

        LockerThread t2 = new LockerThread("B");
        t2.start();

        LockerThread t3 = new LockerThread("C");
        t3.start();

        LockerThread t4 = new LockerThread("D");
        t4.start();

        LockerThread t5 = new LockerThread("E");
        t5.start();

        LockerThread t6 = new LockerThread("F");
        t6.start();

    }
}