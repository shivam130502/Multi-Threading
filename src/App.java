class A implements Runnable {

    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Class A");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class B implements Runnable{

    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Class B");
            try {
                Thread.sleep(10); // Threads.sleep() asks the thread to wait for a certain amount of time before executing next task.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class C extends Thread {
    private int count;

    // Race Condition occurs when multiple threads try to access the same variable, function etc at the same time which may result in wrong output

    public synchronized void increment(){ // synchronized keywords allows only 1 thread to call the increment function at a time
        count++;
    }

    public int counter(){
        return count;
    }
}

public class App {

    public static void main(String[] args) throws Exception {

        C c = new C();

        Runnable obj1 = () -> { // lambda function
                for(int i=0;i<1000;i++)
                    c.increment();
        };

        Runnable obj2 = () -> { // lambda function
                for(int i=0;i<1000;i++)
                    c.increment();
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.counter());

    }
}
