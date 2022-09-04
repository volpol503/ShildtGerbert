package Глава11_Многопоточное_программирование.P316_isAliveJoin;

class NewThread implements Runnable{
    String name;
    Thread t;
    NewThread(String threadname){
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Новый поток:" + t);
        t.start(); // запустить поток на исполнение
    }
    // Точка входа в поток исполнения
    public void run(){
        try {
            for(int i = 5; i>0;i--) {
                System.out.println( name+": " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println(name + "прерван" );
        }
        System.out.println("завершен");
    }
}


public class DemoJoin {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("Один");
        NewThread ob2 = new NewThread("Два");
        NewThread ob3 = new NewThread("Три");
        System.out.println("Поток Один запущен: " + ob1.t.isAlive());
        System.out.println("Поток Два запущен: "  + ob2.t.isAlive());
        System.out.println("Поток Три запущен: "  + ob3.t.isAlive());

        //ожидать завершения потоков исполнения
        try {
            System.out.println("Ожидание завершения потоков");
            ob1.t.join();
            ob1.t.join();
            ob1.t.join();

        }
        catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Поток один запущен: " + ob1.t.isAlive());
        System.out.println("Поток Два запущен:  " + ob2.t.isAlive());
        System.out.println("Поток Три запущен:  " + ob3.t.isAlive());
        System.out.println("Главный поток завершен");
    }
}
