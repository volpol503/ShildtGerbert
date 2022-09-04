package Глава11_Многопоточное_программирование.P326_WaitNotify;

class Q{
    int n;
    boolean valueSet = false;

    synchronized int get(){
        while(!valueSet)
           try {
               wait();
           } catch (InterruptedException e){
               System.out.println("Исключение типа InterruptedException перехвачено");
        }
        System.out.println("Получено: " + n);
        valueSet = false;
        notify();
        return n;
    }
    synchronized void put(int n){
        while(valueSet)
            try {
               wait();
            }catch (InterruptedException E){
                System.out.println("Исключение типа InterruptedException перехвачено");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Отправлено" + n);
        notify();
    }
}

class Consumer implements Runnable{
    Q q;
    Consumer(Q q){
        this.q = q;
        new Thread(this," Потребитель").start();
    }
    public void run(){
        while(true)
            q.get();
    }
}

class Producer implements Runnable{
    Q q;
    Producer(Q q){
        this.q = q;
        new Thread(this, "Постащик").start();
    }
    public void run(){
        int i = 0;
        while(true){
            q.put(i++);
        }
    }
}


public class PCFixed {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
