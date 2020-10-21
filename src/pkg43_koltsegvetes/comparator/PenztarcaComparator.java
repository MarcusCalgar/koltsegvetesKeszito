package pkg43_koltsegvetes.comparator;

import pkg43_koltsegvetes.model.Tranzakcio;

public class PenztarcaComparator extends TranzakcioComparator{
    
    @Override
    public int compare(Tranzakcio tranzakcio1, Tranzakcio tranzakcio2) {
        if (!forditott) {
            return tranzakcio1.getErintettPenztarca().getNev().compareTo(tranzakcio2.getErintettPenztarca().getNev());
        } else {
            return tranzakcio2.getErintettPenztarca().getNev().compareTo(tranzakcio1.getErintettPenztarca().getNev());
        }  
    }

}
