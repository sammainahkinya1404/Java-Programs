//Extending class


public class student extends Thread {
////    public void run() {
////        System.out.println("Running .......");
////    }
////    public void start() {
////        System.out.println("Starting...");
////    }
//    public  void run() {
//        synchronized (this) {
//            System.out.println(
//                    Thread.currentThread().getName()
//                            + "...starts");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(
//                    Thread.currentThread().getName()
//                            + "...notified");
//        }
//    }
private Thread t;
    private String threadName;

    student( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 20; i > 0; i--) {
                System.out.println("Student: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Student " +  threadName + " interrupted.");
        }
        System.out.println("Student " +  threadName + " exiting.");
    }

    public  void start() {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    /*



    @Override
public void run() {
  synchronized (book) {
   System.out.println(Thread.currentThread().getName()+" is waiting for the book to be completed: "+book.getTitle());
   try {
    book.wait();
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
   System.out.println(Thread.currentThread().getName()+": Book has been completed now!! you can read it");
  }
}
     */

    public static long time = System.currentTimeMillis();
    public void msg(String m) {
        System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
    }
}
