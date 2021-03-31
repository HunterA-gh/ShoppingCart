public class Manager extends Employee implements Discountable{


    public Manager(Clothing[] clothingItems, char size, String name) {
        super(clothingItems, size);
        setName(name);
    }

    @Override
    public void printEmpPriceAfterDisc(Clothing c) {
        double newPrice = c.getPrice() - calcDiscount(c);
        System.out.println(c.getDescription() + " costs " + String.format("%s" + "%.2f", "$", newPrice) + " after Manager's discount");

    }

    public double getDiscount(){
        double managersExtraDiscount = 0.15;
        return super.getDiscount() + managersExtraDiscount;
    }


    @Override
    public double calcDiscount(Clothing clothing) {
        return clothing.getPrice() * getDiscount();
    }
}
