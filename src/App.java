class A extends Thread {

    public void run(){
        System.err.println("Class A");
    }

}

class B extends Thread{

    public void run(){
        System.out.println("Class B");
    }

}

public class App {

    public static void main(String[] args) throws Exception {

        Thread obj1 = new A();
        Thread obj2 = new B();

        obj1.run();
        obj2.run();

    }
}
