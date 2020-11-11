package pkg43_koltsegvetes.comparator;

import pkg43_koltsegvetes.model.Penztarca;

public class PenztarcaNevComparator extends PenztarcaComparator {

    @Override
    public int compare(Penztarca tarca1, Penztarca tarca2) {
        if (!forditott) {
            return tarca1.getNev().compareTo(tarca2.getNev());
        } else {
            return tarca2.getNev().compareTo(tarca1.getNev());
        } 
    }

}
