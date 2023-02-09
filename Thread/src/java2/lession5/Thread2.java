package java2.lession5;

public class Thread2 extends  Thread {
    SharedData sharedData;

    public Thread2(SharedData sharedData) {
        this.sharedData = sharedData;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (sharedData){
                sharedData.notifyAll();


                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int result = sharedData.rad* sharedData.rad;
                System.out.println("i(T2): "+i+" T2 :"+result);

                if (i==19){
                    System.out.println("Stop t2");
                    stop();
                }

            }

        }
    }
}
