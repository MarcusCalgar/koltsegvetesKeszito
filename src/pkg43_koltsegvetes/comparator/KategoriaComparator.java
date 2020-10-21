package pkg43_koltsegvetes.comparator;

import pkg43_koltsegvetes.model.Kiadas;
import pkg43_koltsegvetes.model.Tranzakcio;

public class KategoriaComparator extends TranzakcioComparator {

    @Override
    public int compare(Tranzakcio tranzakcio1, Tranzakcio tranzakcio2) {
        Kiadas kiadas1 = (Kiadas) tranzakcio1;
        Kiadas kiadas2 = (Kiadas) tranzakcio2;
        if (!forditott) {
            return kiadas1.getKategoria().compareTo(kiadas2.getKategoria());
        } else {
            return kiadas2.getKategoria().compareTo(kiadas1.getKategoria());
        }
    }

}
