package pkg43_koltsegvetes.comparator;

import pkg43_koltsegvetes.model.Tranzakcio;

public class MegnevezesComparator extends TranzakcioComparator{

    @Override
    public int compare(Tranzakcio tranzakcio1, Tranzakcio tranzakcio2) {
        if (!forditott) {
            return tranzakcio1.getMegnevezes().compareTo(tranzakcio2.getMegnevezes());
        } else {
            return tranzakcio2.getMegnevezes().compareTo(tranzakcio1.getMegnevezes());
        }  
    }

}
