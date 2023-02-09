package java2.baitap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
        t1.join();;
        t2.join();
        //hiển thị kết quả
        System.out.println("Hiển thị kết quả sinh ngẫu nhiên của 2 Thread 1 & 2");
        System.out.println("T1 :");
        for (int i = 0; i < t1.list.size(); i++) {
            System.out.println(" "+t1.list.get(i));
        }
        System.out.println("\nT2 :");
        for (int i = 0; i <t2.list.size() ; i++) {
            System.out.println(" "+t2.list.get(i));
        }
    }

}
