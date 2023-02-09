public class Test {
    public static void main(String[] args) {
        System.out.println("Thread main Start");
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();;
        ThreadTwo threadTwo = new ThreadTwo();
        Thread t = new Thread(threadTwo);
        t.start();

        try {
            System.out.println("Nối 1 vao Thread Main");
            threadOne.join();
            System.out.println("Thực hiện Join 2 vào Thread main");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread main stop");
//        try {
//            Thread.sleep(5000);
//            threadOne.stop();
//            t.stop();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
