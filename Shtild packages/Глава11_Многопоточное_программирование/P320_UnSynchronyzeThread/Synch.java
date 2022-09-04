package Глава11_Многопоточное_программирование.P320_UnSynchronyzeThread;

class Callme{
    void call(String msg){
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.println("Прервано");
        }
        System.out.print("]");
    }
}

class Caller implements Runnable{
    Callme target;
    String msg;
    Thread t;

    public Caller(Callme targ,String s){
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run(){
        target.call(msg);
    }
}

public class Synch {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target, "в синхронизованный");
        Caller ob3 = new Caller(target, "мир");

        try{
        ob1.t.join();
        ob2.t.join();
        ob3.t.join();
        }
        catch(InterruptedException e){
            System.out.println("Прервано");
        }
    }
}
