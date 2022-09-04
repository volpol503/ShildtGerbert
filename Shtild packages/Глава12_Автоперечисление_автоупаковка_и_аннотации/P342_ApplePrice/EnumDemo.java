package Глава12_Автоперечисление_автоупаковка_и_аннотации.P342_ApplePrice;

enum Apple{
    Jonathan(10),GoldenDel(9),RedDel(12),
    Winesap(15),Cortland(8);
    //цена яблока для каждого сорта
    private int price;
    //Конструктор
    Apple(int p){
        price = p;
    }
    int getPrice(){
        return price;
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;
        System.out.println("Яблоко сорта Winesap стоит"
        + Apple.Winesap.getPrice() + " центов");
        System.out.println("Цены на все сорта яблок:");
        for(Apple a : Apple.values())
            System.out.println(a + " стоит " + a.getPrice() + " центов");
    }
}

