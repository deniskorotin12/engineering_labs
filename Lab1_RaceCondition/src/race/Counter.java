package race;

class Counter  implements Runnable{
    private int counter = 0;

    public void increment() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getValue() {
        return counter;
    }

    @Override
    public void run() {
        this.increment();
        System.out.println("Value for Thread After increment "
                + Thread.currentThread().getName() + " " + this.getValue());
        this.decrement();
        System.out.println("Value for Thread at last "
                + Thread.currentThread().getName() + " " + this.getValue());
    }
}