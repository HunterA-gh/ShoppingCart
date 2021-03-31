public abstract class Employee extends Customer{
    private final double discount = 0.10;

    public Employee(Clothing[] clothingItems, char size) {
        super(clothingItems, size);
    }

    public double getDiscount() {
        return discount;
    }

    public abstract void printEmpPriceAfterDisc(Clothing c);
}
