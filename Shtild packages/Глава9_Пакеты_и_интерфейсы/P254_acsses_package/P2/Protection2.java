package Глава9_Пакеты_и_интерфейсы.P254_acsses_package.P2;

public class Protection2 extends Глава9_Пакеты_и_интерфейсы.P254_acsses_package.P1.Protection {

    Protection2(){
        System.out.println("Конструктор, унаследованный из другого пакета");

        //Доступно только для данного класса или пакета
        //System.out.println("n = " + n);

        //доступно только для  данного класса
        //System.out.println("n_pri" + n_pri);

        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub );

    }
}


