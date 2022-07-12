import java.util.ArrayList;

public class ShoppingList {

    ArrayList<Record> records;

    ShoppingList(ArrayList<Record> newRecords) {
        records = newRecords;
    }

    void addRecord(Record record) {
        records.add(record);
    }

    boolean removeRecord(String name) {
        for (Record record : records) {
            if (record.name.equals(name)) {
                records.remove(record);
                return true;
            }
        }
        return false;
    }

    double calcTotalPrice() {
        double totalPrice = 0.0;
        for (Record record : records) {
            totalPrice += record.quantity * record.pricePerOne;
        }
        return totalPrice;
    }

}
