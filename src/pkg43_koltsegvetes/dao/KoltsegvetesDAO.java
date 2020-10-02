package pkg43_koltsegvetes.dao;

import java.util.List;
import pkg43_koltsegvetes.exception.KoltsegvetesException;

/**
 * Ez az interface írja elő a program által megvalósított adatmentés és szerzés
 * metódusait.
 */
public interface KoltsegvetesDAO<T> {

    /**
     * Betölti az összes elemet.
     * @return a betöltött elemeket egy List-ben adja vissza
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException adatkapcsolat hiba esetén KoltsegvetesException-t dob
     */
    List<T> osszesBetolt() throws KoltsegvetesException;

    /**
     * Új elemet ad hozzá az adatokhoz.
     * @param elem a hozzáadni kívánt elem
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException adatkapcsolat hiba esetén KoltsegvetesException-t dob
     */
    void beilleszt(T elem) throws KoltsegvetesException;

    /**
     * Módosít egy már meglévő elemet.
     * @param elem a módosítani kívánt elem
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException adatkapcsolat hiba esetén KoltsegvetesException-t dob
     */
    void felulir(T elem) throws KoltsegvetesException;

    /**
     * Elment egy elemet. Ez a metódus a beilleszt() és a felulir() metódusok közül választ a megadott feltétel szerint.
     * @param elem - a menteni kívánt elem
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException adatkapcsolat hiba esetén KoltsegvetesException-t dob
     */
    void elment(T elem) throws KoltsegvetesException;

    /**
     * Törli a megadott azonosítójú elemet.
     * @param id a törölni kívánt elem azonosítója
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException adatkapcsolat hiba esetén KoltsegvetesException-t dob
     */
    void torol(int id) throws KoltsegvetesException;

    /**
     * Lezárja az adatkapcsolatot.
     * @throws pkg43_koltsegvetes.exception.KoltsegvetesException adatkapcsolat hiba esetén KoltsegvetesException-t dob
     */
    void lezar() throws KoltsegvetesException;
}
