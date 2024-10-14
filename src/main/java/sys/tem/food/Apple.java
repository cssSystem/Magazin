package sys.tem.food;

import sys.tem.Product;

public class Apple extends Product {
    //Single Responsibility Principle - класс описывает только Яблоки
    public Apple() {
        this.setName("Яблоки в асортименте");
        this.setCode(133);
        this.setPrice(100);
    }
}
