public class Main {
    //throws void InterruptedException
        public static void main (String[]args) throws InterruptedException {
            System.out.println("Teacher Threads has been started");

            teacher t1 = new teacher( "Teacher");
            t1.start();
            house h1 = new house( "house");
            h1.start();
            student s1 = new student( "student");
            s1.start();




        }
    }

