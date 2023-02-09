package java2.lession5;

public class Test {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread1 t1 = new Thread1(sharedData);
        Thread2 t2 = new Thread2(sharedData);

        t1.start();
        t2.start();
    }
}
