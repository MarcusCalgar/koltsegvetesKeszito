package pkg43_koltsegvetes.comparator;

import java.util.Comparator;
import pkg43_koltsegvetes.model.Penztarca;

public abstract class PenztarcaComparator implements Comparator<Penztarca> {

    boolean forditott = false;

    public boolean getForditott() {
        return forditott;
    }

    public void setForditott(boolean forditott) {
        this.forditott = forditott;
    }
}
