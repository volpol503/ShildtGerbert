package Глава12_Автоперечисление_автоупаковка_и_аннотации.P340_EnumApple_values_valuesOF;

enum Apple{
    Jonathan, GoldenDel,RedDel,Winesap,Cortland
}

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;
        System.out.println("Константы перечисляемого типа apple");

        //применить метод values()
        Apple apples[] = Apple.values();
        for(Apple a : apples){
            System.out.println(a);
        }
        System.out.println();
        //Применить метод valueOF
        ap = Apple.valueOf("Winesap");
        System.out.println("Переменная ap содержит " + ap);
    }
}
