package sys.tem;

public class Product {
    private String name;
    private int price;
    private int code;

    @Override
    public String toString() {
        return "Наименование='" + name + '\'' +
                " | Цена=" + price +
                " | Код товара=" + code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getcode() {
        return code;
    }
}
