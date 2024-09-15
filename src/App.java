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
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class App {

    public static void main(String[] args) throws Exception {

        Runnable a = new A();
        Runnable b = new B();

        Thread obj1 = new Thread(a);
        Thread obj2 = new Thread(b);

        obj1.start();
        obj2.start();

    }
}
