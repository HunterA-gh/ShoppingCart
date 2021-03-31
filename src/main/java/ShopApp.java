import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ShopApp {

    public static double calcTotal(Clothing[] clothes){
        double total = 0;
        for(int i = 0; i < clothes.length; i++){
            total += clothes[i].getPrice();
        }
        return total;
    }

    public static double employeePriceAfterDiscount(Employee e){
        return calcTotal(e.getClothingItems()) * e.getDiscount();
    }

    public static boolean isAFit(Customer cust, Clothing cloth){
        if(cust.getSize() == cloth.getSize()){
            return true;
        } else{
            return false;
        }
    }

    public static void sortAndPrintClothingByPrice(ArrayList<Clothing> clothes){
        clothes.sort(Comparator.comparing(Clothing::getPrice));
        for(Clothing c : clothes){
            System.out.println(c.getDescription() + " costs " + String.format("%s" + "%.2f", "$", c.getPrice()));
        }
    }

    public static void printEmployeeName(Employee e){
        System.out.println(e.getName());
    }

    public static void printDiscAmtOff(Discountable[] pplWithDiscounts, Clothing cloth){
        for(Discountable d : pplWithDiscounts){
            System.out.println(d.calcDiscount(cloth));
        }
    }

    public static void main(String[] args) {
        Clothing shirt = new Clothing("Blue Shirt", 14.99, 'M');
        Clothing pants = new Clothing("Dress Pants", 34.99, 'L');
        Clothing shirt2 = new Clothing("Red Shirt", 19.99, 'S');

        Clothing[] managerCart = {shirt, pants, shirt2};
        Employee m1 = new Manager(managerCart, 'M', "Cashier Joe");

        Clothing[] employeeCart = {shirt, pants, shirt2};
        Employee e1 = new HourlyEmployee(employeeCart, 'L', "Boss Bob");

        System.out.println(calcTotal(managerCart));

        System.out.println(isAFit(e1, pants));

        e1.printEmpPriceAfterDisc(pants);
        e1.printEmpPriceAfterDisc(shirt);

        m1.printEmpPriceAfterDisc(pants);
        m1.printEmpPriceAfterDisc(shirt);

        ArrayList<Clothing> clothes = new ArrayList<Clothing>();
        clothes.add(shirt);
        clothes.add(pants);
        clothes.add(shirt2);

        for(Clothing c : clothes){
            System.out.println(c.getDescription() + " is size " + c.getSize() + " and costs " + String.format("%s" + "%.2f", "$", c.getPrice()));
        }

        printEmployeeName(m1);
        printEmployeeName(e1);

        sortAndPrintClothingByPrice(clothes);


    }
}
