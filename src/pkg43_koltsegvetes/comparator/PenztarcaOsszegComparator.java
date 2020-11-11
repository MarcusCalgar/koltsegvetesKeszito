package pkg43_koltsegvetes.comparator;

import pkg43_koltsegvetes.model.Penztarca;

public class PenztarcaOsszegComparator extends PenztarcaComparator{

    @Override
    public int compare(Penztarca tarca1, Penztarca tarca2) {
        if (!forditott) {
            return tarca1.getOsszeg() - tarca2.getOsszeg();
        } else {
            return tarca2.getOsszeg() - tarca1.getOsszeg();
        }
    }

}
