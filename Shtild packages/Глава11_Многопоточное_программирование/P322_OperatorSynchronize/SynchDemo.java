package Глава11_Многопоточное_программирование.P322_OperatorSynchronize;


// в этой программе используется синхронизированный блок
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
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String s){
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }
    //синхронизированные вызовы метода call()
    public void run() {
        synchronized (target){
            //синхронизированный блок
            target.call(msg);
        }
    }
}

public class SynchDemo {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target, "в синхронизованный");
        Caller ob3 = new Caller(target, "мир");

        //ожидать завершения потока исполенения
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println("прервано");
        }
    }
}
