package Глава11_Многопоточное_программирование.P313_Thread;


//Расширение класса Thread - наследование экземпляра от класса Thread
//сначала создается класс расширяющий от класса Thread в котором непременно переопределен
//метод run() который является точкой входа в поток исполнения
//


class NewThread extends Thread{
    //Создать второй поток исполнения расширив клапсс Thread
    NewThread(){
        super("Демонстрированный поток");
        System.out.println("Дочерний поток" + this);
        start();     //Запустить поток на исполнение
    }

    public void run() {
        try {
            for(int i = 5; i>0;i--){
                System.out.println("Дочерний поток исполнения" + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e){
            System.out.println("Дочерний поток прерван");
        }
        System.out.println("Дочерний поток завершен");
    }
}




public class ExtendThread {
    public static void main(String[] args) {
        new NewThread();
        try {
            for (int i = 5; i >0;i--) {
                System.out.println("Главный поток исполнения" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}



