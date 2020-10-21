package pkg43_koltsegvetes.comparator;

import java.util.Comparator;
import pkg43_koltsegvetes.model.Tranzakcio;

public abstract class TranzakcioComparator implements Comparator<Tranzakcio> {

    boolean forditott = false;

    public boolean getForditott() {
        return forditott;
    }

    public void setForditott(boolean forditott) {
        this.forditott = forditott;
    }
}
