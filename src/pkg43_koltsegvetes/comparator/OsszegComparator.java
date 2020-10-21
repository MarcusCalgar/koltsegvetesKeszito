package pkg43_koltsegvetes.comparator;

import pkg43_koltsegvetes.model.Tranzakcio;

public class OsszegComparator extends TranzakcioComparator{

    @Override
    public int compare(Tranzakcio tranzakcio1, Tranzakcio tranzakcio2) {
        if (!forditott) {
            return tranzakcio1.getOsszeg() - tranzakcio2.getOsszeg();
        } else {
            return tranzakcio2.getOsszeg() - tranzakcio1.getOsszeg();
        }  
    }

}
