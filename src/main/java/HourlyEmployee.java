public class HourlyEmployee extends Employee implements Discountable{


    public HourlyEmployee(Clothing[] clothingItems, char size, String name) {
        super(clothingItems, size);
        setName(name);
    }

    @Override
    public void printEmpPriceAfterDisc(Clothing c) {
        double newPrice = c.getPrice()  - calcDiscount(c);
        System.out.println(c.getDescription() + " costs " + String.format("%s" + "%.2f", "$", newPrice) + " after Employee's discount");

    }

    public double getDiscount(){
        return super.getDiscount();
    }

    @Override
    public double calcDiscount(Clothing clothing) {
        return clothing.getPrice() * getDiscount();
    }
}
