public class Main {
    public static void main(String[] args) {
        //Thead main -> luồng chính
        System.out.println("Start");
        //cach 1
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread 1 > "+i);
                }
            }
        });
        t.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread 2 > "+i);
                }
            }
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            //abc
        });
        t3.start();

        //Cach2
        new  Thread(new Runnable() {
            @Override
            public void run() {
                //
            }
        }).start();

        //Cach3
        new  Thread(()->{
            //abcd
        }).start();

        System.out.println("Ends");
    }
}
