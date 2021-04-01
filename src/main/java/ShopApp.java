import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        return calcTotal(e.getClothingItems()) - calcTotal(e.getClothingItems()) * e.getDiscount();
    }

    public static boolean isAFit(Customer cust, Clothing cloth){
        if(cust.getSize() == cloth.getSize()){
            return true;
        } else{
            return false;
        }
    }

    public static void sortAndPrintClothingByPrice(ArrayList<Clothing> clothes){
        //Collections.sort(clothes, new ClothingComparator());
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

    public static void printDiscAmtOff(Clothing c){
        System.out.println(c.getDescription() + " gets a " + String.format("%s" + "%.2f", "$", c.getPrice()*0.10) + " from Hourly Employee's discount");
        System.out.println(c.getDescription() + " gets a " + String.format("%s" + "%.2f", "$", c.getPrice()*0.25) + " from Manager's Discount");
    }



    public static void main(String[] args) {
        Clothing jeans = new Clothing("Blue Jeans", 20, 'M');
        Clothing tShirt = new Clothing("White T Shirt", 5.0,'S');
        Clothing buttonUp = new Clothing("Button Up Shirt", 30.0, 'L');

        Clothing[] managerCart = {jeans, tShirt, buttonUp};
        Employee m1 = new Manager(managerCart, 'M', "Jim Jones");

        Clothing[] employeeCart = {jeans, tShirt, buttonUp};
        Employee e1 = new HourlyEmployee(employeeCart, 'L', "Mike Jones");
        System.out.println("Total of Manager's Cart-");
        System.out.println("$" + calcTotal(managerCart));

        System.out.println("\nCheck if a clothing fits an employee-");
        System.out.println(isAFit(m1, tShirt));

        System.out.println("\nHourly Employee price after discount-");
        System.out.println("Jeans:");
        e1.printEmpPriceAfterDisc(jeans);
        System.out.println("T-Shirt:");
        e1.printEmpPriceAfterDisc(tShirt);

        System.out.println("\nManager price after discount-");
        System.out.println("Jeans:");
        m1.printEmpPriceAfterDisc(jeans);
        System.out.println("T-Shirt:");
        m1.printEmpPriceAfterDisc(tShirt);


        ArrayList<Clothing> clothes = new ArrayList<Clothing>();
        clothes.add(jeans);
        clothes.add(buttonUp);
        clothes.add(tShirt);


        System.out.println("\nPrinting each type of Employee's name-");
        printEmployeeName(m1);
        printEmployeeName(e1);

        System.out.println("\nPrior to sorting by price:");
        for(Clothing c : clothes){
            System.out.println(c.getDescription() + " is size " + c.getSize() + " and costs " + String.format("%s" + "%.2f", "$", c.getPrice()));
        }

        System.out.println("\nAfter sorting by price:");
        sortAndPrintClothingByPrice(clothes);

        System.out.println("\nDiscount for type of clothing for each employee-");
        printDiscAmtOff(jeans);


    }
}
