package java2.lession5;

public class Main {
    public static void main(String[] args) {
        //Tại sao chúng ta cần đồng bộ luồng
        SharedData sharedData = new SharedData();
        CustomThread t1 = new CustomThread(sharedData);
        CustomThread t2 = new CustomThread(sharedData);
        CustomThread t3 = new CustomThread(sharedData);
        CustomThread t4 = new CustomThread(sharedData);
        CustomThread t5 = new CustomThread(sharedData);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();










    }
}
