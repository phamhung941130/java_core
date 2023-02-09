package java2.lession5;

import java.util.Random;

public class Thread1 extends Thread{
    SharedData sharedData;

    public Thread1(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            synchronized (sharedData){

                int rad = random.nextInt(10);
                sharedData.rad = rad;
                System.out.println("i(T1): "+i+" T1 :"+rad);

                sharedData.notifyAll(); // Đánh thức các luồng xếp sau

                if (i==19){
                    System.out.println("Stop t1");
                    stop();
                }
                    try {
                        sharedData.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


            }

        }
    }
}
