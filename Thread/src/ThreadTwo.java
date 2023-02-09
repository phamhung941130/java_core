public class ThreadTwo implements   Runnable {
    ThreadOne t1;

    public ThreadTwo() {
    }

    public ThreadTwo(ThreadOne t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        System.out.println("T2 is running");
        try {
            System.out.println("joinT1 into t2");
            t1.join();
            System.out.println("T1 Finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadTwo > "+ i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
