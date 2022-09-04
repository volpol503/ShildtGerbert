package Глава11_Многопоточное_программирование.P332_SuspendResume;

class NewThread implements Runnable{

    String name;
    Thread t;
    boolean suspendFlag;

    NewThread(String threadname){
        name = threadname;
        t = new Thread(this,name);
        System.out.println("Новый поток: " + t);
        suspendFlag = false;
        t.start();
    }

    public void run() {
        try {
            for(int i = 15; i > 0; i--){
                Thread.sleep(200);
                synchronized(this){
                    while (suspendFlag)
                        wait();
                }
            }
        }catch (InterruptedException e){
            System.out.println(name + "прерван");
        }
    }
    synchronized void mysuspend(){
        suspendFlag = true;
    }
    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }
}


public class SuspendResume {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("Один");
        NewThread ob2 = new NewThread("Два");


        try {
            Thread.sleep(1000);

            ob1.mysuspend();
            System.out.println("Приостановка потока Один");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Возобновление потока Один");

            ob2.mysuspend();
            System.out.println("Приостановка потока Два");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Возобновление потока Два");
        }
        catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }

        try{
            System.out.println("ожидание завершения потоков");
            ob1.t.join();
            ob2.t.join();
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
