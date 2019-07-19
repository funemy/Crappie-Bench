public class Race {
    static int x=0,y=0;
    static int z=0;//assume z is a shared resource
    static Object lock = new Object();
    public static void main(String[] args){
        MyThread t = new MyThread();
        t.start();
        synchronized(lock)
        {
            y = 1;
            x =1;
        }
        try{
            t.join();
            //use z - may throw divide by zero exception
            System.out.println(1/z);
        }catch(Exception e){
            e.printStackTrace();
        }	}
    static class MyThread extends Thread{
        public void run(){
            //y=0;
            Object lock2 = this;
            lock2 = lock;
            int r1,r2;
            //synchronized(lock2)
            {
                r1 = y;
            }
            synchronized(lock2)
            {
                r2 =x;
            }
            if(r1+r2>0)	{
                z=1;//authenticate z here if x or y is positive
            }
        }	}}