package sys.tem;

import sys.tem.food.Apple;
import sys.tem.food.Bread;
import sys.tem.non_food.ARattleToy;
import sys.tem.non_food.Tea;
import sys.tem.non_food.ToiletPaper;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    //Magic Numbers Principle - вместо чисел используем константы {
    public static final int VARIABLE_TYPE_CODE_TOY = 100;
    //                                                             }


    public static void main(String[] args) {

        Set<Product> products = new HashSet<>();

        //Liskov substitution principle - наследники класса Product полностью играют роль предка {
        Map<Product, Integer> shoppingCart = new HashMap<>();
        products.add(new Tea());
        products.add(new Bread());
        products.add(new Apple());
        products.add(new ToiletPaper());
        products.add(new ARattleToy());
        //                                                                                        }

        Integer code;
        Integer quantity;
        while (true) {
            printOutTheListOfProducts(products);

            //принцип DRY - повторяющийся код запроса данных выносим в отдельный метод {
            code = requestANumber("Введите номер товара | `end`-завершить программу ", "end");
            //                                                                          }

            if (code == null) {
                break;
            }
            if (productByCode(products, code) == null) {
                System.out.println("Нет товара с таким кодом");
                continue;
            }

            quantity = requestANumber("Введите количество товара | `end`-завершить программу ", "end");
            if (quantity == null) {
                break;
            }
            Product res = productByCode(products, code);
            if (shoppingCart.containsKey(res)) {
                shoppingCart.put(res, shoppingCart.get(res) + quantity);
            } else {
                shoppingCart.put(res, quantity);
            }
            printTheShoppingCart(shoppingCart);
        }
        System.out.println("Программа завершена.");
    }

    private static Product productByCode(Set<Product> products, Integer code) {

        for (Product product : products) {
            if (product.getcode() == code) {
                return product;
            }
        }
        return null;
    }

    private static Integer requestANumber(String s, String end) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(s);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            if (end.equals(scanner.nextLine())) return null;
            System.out.println("Нужно ввести число");
        }
    }

    private static void printTheShoppingCart(Map shoppingCart) {
        System.out.println("___________________");
        if (shoppingCart.isEmpty()) {
            System.out.println("Корзина покупок пуста");
        } else {
            AtomicReference<Integer> res = new AtomicReference<>(0);
            System.out.println("Ваша корзина:");
            shoppingCart.forEach((key, value) -> {
                Product d = (Product) key;
                res.updateAndGet(v -> v + (d.getPrice() * (Integer) value));
                System.out.println(key + " | - " + value + "шт.");
            });
            System.out.println("Итого к оплате: " + res + " руб.");
        }
        System.out.println("___________________");
    }

    private static void printOutTheListOfProducts(Set<Product> products) {
        for (Product product : products) {
            System.out.println(product);
            if (product.getcode() == VARIABLE_TYPE_CODE_TOY) {
                System.out.println("         ---   " + ((ARattleToy) product).aFootnote());
                System.out.println("         ---   " + ((ARattleToy) product).ageRestrictions());
            }
        }
    }
}