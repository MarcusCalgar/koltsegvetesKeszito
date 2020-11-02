package pkg43_filter;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Predicate;
import pkg43_koltsegvetes.model.Tranzakcio;

public class aktualisHonap implements Predicate<Tranzakcio> {

    private Month aktualisHonap;

    public Month getAktualisHonap() {
        return aktualisHonap;
    }
    
    public aktualisHonap(Month mutatandoHonap) {
        this.aktualisHonap = mutatandoHonap;
    }

    @Override
    public boolean test(Tranzakcio tranzakcio) {
        return tranzakcio.getDatum().getYear() == LocalDate.now().getYear() && tranzakcio.getDatum().getMonth() == aktualisHonap;
    }

}
