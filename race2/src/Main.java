public class Main {
    static int x=0;
    static int y=10;
    static Object lck = new Object();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        {
            Thread thread = new Thread(() -> {
                System.out.println(lck);
//                synchronized (lck)
                {
                    x = 2;
                }
            });
            thread.start();

//            synchronized (lck)
            {
                x = 20;
                x = 10;
            }
        }
    }
}
