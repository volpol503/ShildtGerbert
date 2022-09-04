package Глава12_Автоперечисление_автоупаковка_и_аннотации.P339_EnumDemo;

enum Apple{
    Jonathan, GoldenDel,RedDel,Winesap,Cortland
}

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;
        ap = Apple.GoldenDel;
        // вывести значение перечисленного типа
        System.out.println("Значение ap: " + ap);
        System.out.println();

        if(ap == Apple.GoldenDel){
            System.out.println("Переменная содержит GoldenDel");
        }
        switch (ap){

            case Jonathan:
                System.out.println("Сорт Jonathan красный");
                break;
            case GoldenDel:
                System.out.println("Сорт Golden Delicious желтый");
                break;
            case RedDel:

                System.out.println("Срот Red Delicious красный");
                break;
            case Winesap:
                System.out.println("Сорт Winesap красный");
                break;
            case Cortland:
                System.out.println("Сорт Cortland красный");
                break;
        }
    }
    //сравнить два значения перечисляемого типа
}
