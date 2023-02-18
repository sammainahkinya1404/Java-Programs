public class teacher extends  Thread {
//    public teacher() {
//        Thread t;
//        String threadName;
//
//
//    }
//
//    //    public void run() {
////        System.out.println("Running.......");
////    }
//@Override
//public void run() {
//    System.out.println("Teacher Threads processing - START "+Thread.currentThread().getName());
//    try {
//        Thread.sleep(1000);
//
//        doDBProcessing();
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//    System.out.println("Teacher Threads - END "+Thread.currentThread().getName());
//}
//
//    private void doDBProcessing() throws InterruptedException {
//        Thread.sleep(5000);
//    }
//
//
//    public void start() {
//        System.out.println(" Waiting for Students...");
//    }
//    public static long time = System.currentTimeMillis();

    private Thread t;
    private String threadName;

    teacher( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 2; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
//    public void msg(String m) {
//        System.out.println("["+(System.currentTimeMillis()- student.time)+"] "+getName()+": "+m);
//    }
public static long time = System.currentTimeMillis();
    public void msg(String m) {
        System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
    }






}
