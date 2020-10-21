package pkg43_koltsegvetes.comparator;

import pkg43_koltsegvetes.model.Tranzakcio;

public class DatumComparator extends TranzakcioComparator{

    @Override
    public int compare(Tranzakcio tranzakcio1, Tranzakcio tranzakcio2) {
        if (!forditott) {          
            return tranzakcio1.getDatum().compareTo(tranzakcio2.getDatum());
        } else {            
            return tranzakcio2.getDatum().compareTo(tranzakcio1.getDatum());
        } 
    }
}
