import java.util.Arrays;

public class Customer extends Person {
    private Clothing[] clothingItems;
    private char size;

    public Customer(Clothing[] clothingItems, char size) {
        this.clothingItems = clothingItems;
        this.size = size;
    }

    public Clothing[] getClothingItems() {
        return clothingItems;
    }

    public char getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "clothingItems=" + Arrays.toString(clothingItems) +
                ", size=" + size +
                '}';
    }
}
