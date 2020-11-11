package pkg43_koltsegvetes.comparator;

import pkg43_koltsegvetes.model.Penztarca;

public class PenztarcaTipusComparator extends PenztarcaComparator {

    @Override
    public int compare(Penztarca tarca1, Penztarca tarca2) {
        if (!forditott) {
            return tarca1.getTipus().compareTo(tarca2.getTipus());
        } else {
            return tarca2.getTipus().compareTo(tarca1.getTipus());
        }
    }

}
