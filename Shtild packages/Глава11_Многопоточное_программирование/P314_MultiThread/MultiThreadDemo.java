package Глава11_Многопоточное_программирование.P314_MultiThread;

class NewThread implements Runnable{
    String Name;

    NewThread(String threadname){
        Name = threadname;
        Thread t = new Thread(this, Name);
        System.out.println("Новый поток" + t);
        t.start();
    }

    public void run() {
        try{
            for(int i = 5;i > 0; i--)
                System.out.println(Name + ":" + i);
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.println(Name + "Прерван");
        }
        System.out.println(Name + "Завершен");
    }
}


public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread("Один");
        new NewThread("Два");
        new NewThread("Три");
        try{Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
