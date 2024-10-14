package sys.tem.non_food;

import sys.tem.AgeRestrictions;
import sys.tem.Product;
import sys.tem.Battery;

public class ARattleToy extends Product implements Battery, AgeRestrictions {//Interface Segregation Principle - применяем разные интерфейсы вместо одного большого

    //Open Closed Principle - имплементируя интерфейс мы добавляем
    // классу функциональности, не изменяя его код   {
    @Override
    public String aFootnote() {
        return "(Для работы используется 3 батареи типа 'AAA')";
    }

    @Override
    public String ageRestrictions() {
        return "(от 10 лет)";
    }

    //Dependency Inversion Principle - разделив интерфейсы мы не зависим от их общей функциональности,
    // мы можем поменять один интерфейс на другой      }

    public ARattleToy() {
        this.setName("Радиоуправляемая игрушка");
        this.setCode(100);
        this.setPrice(199);
    }


}
