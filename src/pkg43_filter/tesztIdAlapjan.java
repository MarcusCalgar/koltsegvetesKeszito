package pkg43_filter;

import java.util.function.Predicate;
import pkg43_koltsegvetes.model.Tranzakcio;

public class tesztIdAlapjan implements Predicate<Tranzakcio> {

    private int ID;

    public tesztIdAlapjan(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean test(Tranzakcio tranzakcio) {
        return ID == tranzakcio.getId();
    }

}
