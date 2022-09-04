package Глава11_Многопоточное_программирование.P308_Thread_exec;

public class ThreadDemo {

}

class CurrentThreadDemo{
    Thread t = Thread.currentThread();
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t);
        System.out.println("Текущий поток исполнения" + t);
        //изменить имя потока исполнения
        t.setName("MyThread");
        System.out.println("После изменения потока" + t);
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1200);
            }
        }catch (InterruptedException e){
            System.out.println("Главный поток исполнения прерван");
        }
    }
}

