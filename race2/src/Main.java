public class Main {
    static int x=0;
    static int y=10;
    static Object lck = new Object();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                System.out.println(lck);
                synchronized (lck)
                {
                    x = 2;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lck)
                {
                    x = 9;
                }
            }
        });

        thread1.start();
        thread2.start();
        synchronized (lck)
        {
            x = 20;
            x = 10;
            x = 7;
            x = 10;
        }
    }
}
