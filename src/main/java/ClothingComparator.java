import java.util.Comparator;

public class ClothingComparator implements Comparator<Clothing> {

    @Override
    public int compare(Clothing c1, Clothing c2) {
        if(c1.getPrice() > c2.getPrice()){
            return 1;
        }
        return -1;
    }
}
