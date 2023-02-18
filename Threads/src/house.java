public class house extends Thread {
////    public void run() {
////        System.out.println("Students Running..........");
////    }
////    public void start() {
////        System.out.println("Students Entering The House..........");
////    }
//student student1;
//
////    house(){
////        this.student1 = student1;
////    }
//
//    public void run()
//    {
//        synchronized (this)
//        {
//            System.out.println(
//                    Thread.currentThread().getName()
//                            + "...starts");
//
//            try {
//                this.wait();
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(
//                    Thread.currentThread().getName()
//                            + "...notified");
//        }
//    }

    private Thread t;
    private String threadName;

    house (String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("house: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("house " +  threadName + " interrupted.");
        }
        System.out.println("house " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
    public static long time = System.currentTimeMillis();
    public void msg(String m) {
        System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
    }
}
