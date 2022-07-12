import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ShoppingManager {

    ShoppingList shoppingList;

    void readShoppingList(String fileName) {
        String content = readFileContentsOrNull(fileName);
        String[] lines = content.split(System.lineSeparator());

        ArrayList<Record> records = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            Record record = makeRecordFromLine(lines[i]);
            records.add(record);
        }

        shoppingList = new ShoppingList(records);
        System.out.println("Список успешно загружен!");
    }

    Record makeRecordFromLine(String line) {
        String[] tokens = line.split(",");
        return new Record(
            tokens[0],
            Integer.parseInt(tokens[1]),
            Double.parseDouble(tokens[2])
        );
    }

    void addRecord(String name, int quantity, double pricePerOne) {
        if (shoppingList == null) {
            System.out.println("Изначальный список не загружен!");
            return;
        }
        Record record = new Record(name, quantity, pricePerOne);
        shoppingList.addRecord(record);
        System.out.println("Товар успешно добавлен");
    }

    void removeRecord(String name) {
        if (shoppingList == null) {
            System.out.println("Изначальный список не загружен!");
            return;
        }

        boolean isSuccess = shoppingList.removeRecord(name);
        if (isSuccess) {
            System.out.println("Товар успешно убран");
        } else {
            System.out.println("Такого товара в списке нет");
        }
    }

    void printShoppingList() {
        if (shoppingList == null) {
            System.out.println("Список покупок не считан");
        }

        System.out.println("Список покупок:");
        for (Record record : shoppingList.records) {
            System.out.println(record.name + ", " + record.quantity + " шт., " + (record.quantity * record.pricePerOne) + " руб.");
        }
        System.out.println("Итого: " + shoppingList.calcTotalPrice() + " руб.");
    }

    void checkEnoughMoney(double money) {
        double totalPrice = shoppingList.calcTotalPrice();

        if (money > totalPrice) {
            System.out.println("Можно идти в магазин!");
        } else {
            System.out.println("Пока в магазин сходить не получится...");
        }
    }

    String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

}
