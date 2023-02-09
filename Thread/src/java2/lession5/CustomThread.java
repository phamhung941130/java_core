package java2.lession5;

import java.util.Random;

public class CustomThread extends Thread{
    SharedData sharedData;

    public CustomThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int rad = random.nextInt(5);
            sharedData.add(rad);
        }
    }
}
