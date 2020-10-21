package pkg43_koltsegvetes.comparator;

import pkg43_koltsegvetes.model.Kiadas;
import pkg43_koltsegvetes.model.Tranzakcio;

public class VasarlasHelyComparator extends TranzakcioComparator{

    @Override
    public int compare(Tranzakcio tranzakcio1, Tranzakcio tranzakcio2) {
        Kiadas kiadas1 = (Kiadas) tranzakcio1;
        Kiadas kiadas2 = (Kiadas) tranzakcio2;
        if (!forditott) {
            return kiadas1.getKiadasHely().compareTo(kiadas2.getKiadasHely());
        } else {
            return kiadas2.getKiadasHely().compareTo(kiadas1.getKiadasHely());
        }
    }

}
