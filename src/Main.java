import java.util.Scanner;

// Требования к приложению для управления списком товаров
// Приложение должно реализовывать следующий функционал:
// 1. Считать список товаров из .csv файла
// 2. Добавить товар
// 3. Убрать товар
// 4. Распечатать список
// 5. Посчитать хватит ли денег
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingManager shoppingManager = new ShoppingManager();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {

                System.out.println("Введите имя файла:");
                String fileName = scanner.next();
                shoppingManager.readShoppingList(fileName);

            } else if (command == 2) {

                System.out.println("Введите имя товара");
                String name = scanner.next();
                System.out.println("Введите кол-во товара");
                int quantity = scanner.nextInt();
                System.out.println("Введите стоимость за штуку");
                double pricePerOne = scanner.nextDouble();
                shoppingManager.addRecord(name, quantity, pricePerOne);

            } else if (command == 3) {

                System.out.println("Какой товар убрать?");
                String name = scanner.next();
                shoppingManager.removeRecord(name);

            } else if (command == 4) {

                shoppingManager.printShoppingList();

            } else if (command == 5) {

                System.out.println("Сколько у вас денег?");
                double money = Double.parseDouble(scanner.next());
                shoppingManager.checkEnoughMoney(money);

            } else if (command == 0) {

                System.out.println("Выход...");
                return;

            } else {
                System.out.println("Такой команды нет!");
            }
        }

    }

    public static void printMenu() {
        System.out.println("1. Считать список товаров");
        System.out.println("2. Добавить товар");
        System.out.println("3. Убрать товар");
        System.out.println("4. Распечатать список");
        System.out.println("5. Посчитать хватит ли денег");
        System.out.println("0. Выход");
    }

}
