package Глава11_Многопоточное_программирование.P329_330_DeadLock;

class A{
    synchronized void foo(B b){
        String name = Thread.currentThread().getName();

        System.out.println(name + "вошел в метод A.foo()");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException E){
            System.out.println("Класс A прерван");
        }
        System.out.println(name + " Пытается вызвать метод B.last()");
        b.last();
    }
    synchronized void last(){
        System.out.println("В методе A.last()");
    }
}

class B{
    synchronized void bar(A a){
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод b.bar()");
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Класс B прерван");
        }
        System.out.println(name + " пытается вызвать метод A.last()");
        a.last();
    }
    synchronized void last(){
        System.out.println("В методе A.last");
    }
}

public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();

    DeadLock(){
        Thread.currentThread().setName("Главный поток");
        Thread t = new Thread(this, "Соперничающий поток");
        t.start();
        a.foo(b);
    }
    public void run() {
        b.bar(a);
        System.out.println("Назад в другой поток");
    }
    public static void main (String[] args){
        new DeadLock();
    }
}
