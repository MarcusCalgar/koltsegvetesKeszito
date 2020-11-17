# Költségvetés Készítő

## Summary

This program is designed to track the finances of a family. It was the final project at StudiCore Online. Please note, that the classes, variables and methods are written in Hungarian.


## Use Cases

- Susan is a 29 year old single woman, working at an international corporation. Despite having a decent salary, she barely has any money left at the end of the month.
Wondering where might her money goes, she starts using this program. After a month of carefully recording all of her income and spending, she finds out that she often goes out 
with her colleauges to a nearby cafe, and that the overpriced coffee and cakes take a toll on her budget. Armed with this knowledge, she decides to cut back on her spending.

- George is 45 years old, father of two boys. His kids always complain that they run out of their pocket money rather quickly. He teaches his kids how to use the program, and 
they find out, that video game subscriptions and a lot of snacks aren't exactly cheap. With the extra information gathered, they decide to make some changes, so the kids learn the value of money more.


## Technical Description

The program utilizes a MySQL database to store all relevant data, however, different implementations are also possible. After each start, the program reads the database and loads the data into the program, which shows everything on the screen. By default, the program shows all the entries for the current month. To change the viewed month, go to <b>Nézet</b> -> <b>Hónap</b> and select the required month.

### Functionality

* Add and modify Penztarcas
* Add, remove, and modify Tranzakcios, that is, Bevetel and Kiadas items
* Transfer money from one Penztarca to another
* Sort the content of the tables in both directions with a single click
* Filter entries based on the Month they are entered

After starting the program, the main screen shows up. For the sake of simplicity, an empty table is used. At any time an action is not needed, press <b>Mégsem</b> to cancel the action.

<a href="https://imgur.com/csrUToD"><img src="https://imgur.com/csrUToD.jpeg" title="program main screen" /></a>

### GUI

There are three tables on the main screen. The leftmost shows the available Pénztárcas, the middle one the Bevétels, and the rightmost the Kiadás'.

Next to the Kiadás table, the buttons for the main actions of the program are located.

Below the tables are the summary fields that automatically calculate and show various values based on the entries in the tables.

#### Pénztárca summary fields

- Összes Megtakarítás: the sum of all pénztárca values that is a "megtakarítás" (savings) type.

- Összes Szép kártya: the sum of all pénztárca values that is a "szép kártya" type.

- Összes Pénz: the sum of all pénztárca values that is a "készpénz" or "bankkártya" type.

- Összes vagyon: the sum of "Összes Szép Kártya" and "Összes Pénz".

#### Bevételek summary field

- Összes bevétel: the sum of all the Bevétel entries

#### Kiadások summary field

- Összes Rezsi: the sum of all Kiadás entry that has the category of "Rezsi".

- Összes Élelmiszer: the sum of all Kiadás entry that has the category of "Élelmiszer".

- Összes Étkezés: the sum of all Kiadás entry that has the category of "Étkezés".

- Összes Közlekedés: the sum of all Kiadás entry that has the category of "Közlekedés".

- Összes Egészség: the sum of all Kiadás entry that has the category of "Egészség".

- Összes Egyéb kat.: the sum of all Kiadás entry that has the category that is not one of the above.

- Összes Kiadás: the sum of all the entries in the Kiadás table.

### How to Use

#### Managing Pénztárcas

To add a new Pentarca, go to <b>Pénztárcák</b> -> <b>Kezelés</b>

<a href="https://imgur.com/q38KF3u"><img src="https://imgur.com/q38KF3u.jpeg" title="penztarca menu" /></a>

The Pénztárcák kezelése window appears where it is possible to add a new Penztarca, or modify an existing one.
 
<a href="https://imgur.com/cC5xHrM"><img src="https://imgur.com/cC5xHrM.jpeg" title="penztarca main screen" /></a>

To add a new Penztarca, press <b>Új pénztárca</b>

<a href="https://imgur.com/WZnc7fJ"><img src="https://imgur.com/WZnc7fJ.jpeg" title="add new penztarca" /></a>

Enter the name, then select the Típus from the dropdown. There are a number of types available, for example Készpénz, Bankkártya, various kinds of Szép Kártya and so on. Then, enter the available amount in HUF.

<b>Note:</b> The name of the Pénztárca can only contain lower and uppercase letters, numbers, space and underscore.

<b>Note:</b> It is not possible to have two Pénztárca with the same name.

If all done, press <b>OK</b>. The new Pénztárca is now available.

<a href="https://imgur.com/fqGjbFD"><img src="https://imgur.com/fqGjbFD.jpeg" title="pénztárcák kezelése" /></a>

To modify an existing Pénztárca, select it (otherwise an error message is shown) and press <b>Módosítás</b>. The program loads the values of the fields. Change the values as required, then press <b>OK</b>.

<a href="https://imgur.com/qf5dosC"><img src="https://i.imgur.com/qf5dosC.jpg" title="pénztárca módosítása" /></a>

(For the sake of this overview, a new Bankkártya type pénztárca is also added.)

<a href="https://imgur.com/LxAdobW"><img src="https://i.imgur.com/LxAdobW.jpg" title="2 pénztárca létrehozva" /></a>

If everything is done, press <b>OK</b>. The created items are now shown in the leftmost table of the main screen.

<a href="https://imgur.com/FlBo6qL"><img src="https://i.imgur.com/FlBo6qL.jpg" title="main screen with 2 added pénztárca" /></a>

#### Adding Bevetel

To add a new Bevetel (income) press the <b>Új bevétel</b> button on the upper right side of the main screen. The "Új bevétel felvitele" window appears.

<a href="https://imgur.com/Nz2sq99"><img src="https://i.imgur.com/Nz2sq99.jpg" title="source: imgur.com" /></a>

1. Select the Időpont (date) of the Bevetel from the date picker dropdown.
2. Enter the Megnevezés (name). All previous values are available in the dropdown. It is also possible to add a new one by typing it into the field.
3. Select the appropiate Pénztárca from the dropdown.
4. Enter the amount in HUF.
5. If everything is as desired, press <b>OK</b>, or <b>Mégsem</b> to cancel the action.

The new Bevetel is now shown on the main screen.

<b>Note:</b> The summary fields below the tables are automatically updated with the correct values. These fields make tracking the finances easy to overview.

<a href="https://imgur.com/DNwAAVV"><img src="https://i.imgur.com/DNwAAVV.jpg" title="source: imgur.com" /></a>

#### Adding Kiadas

To add a new Kiadas (expense) press the <b>Új kiadás</b> button on the upper right side of the main screen. The "Új kiadás felvitele" window appears.

1. Select the Időpont (date) of the Kiadas from the date picker dropdown.
2. Enter the Megnevezés (name).
3. Select the appropiate Pénztárca from the dropdown.
4. Enter or select the category. The program has a number of default options, but they are not visible by defualt at this point. Enter "Rezsi" (common expenses), "Élelmiszer" (food), "Étkezés" (takeouts, restaurants etc), "Közlekedés" (travel expenses) or "Egészség" (health) to enable tracking of these types of expenses. Their cummulative is shown in the summary fields below the table.
5. Enter or select the location or recipient of the expense. The dropdown saves all the previous entries based on Kategória (category). Therefore, switching to a different category will update the "Vásárlás helye" dropdown to show only the related locations/recipients. 
6. Enter the amount in HUF.
7. If everything is as desired, press <b>OK</b>, or <b>Mégsem</b> to cancel the action.

<a href="https://imgur.com/GpHLEtX"><img src="https://i.imgur.com/GpHLEtX.jpg" title="source: imgur.com" /></a>

The end result:

<a href="https://imgur.com/3ZBP3Gd"><img src="https://i.imgur.com/3ZBP3Gd.jpg" title="source: imgur.com" /></a>

For this example, I added a new expense to the Élelmiszer category, to show that the summary field automatically updates.

<a href="https://imgur.com/V9wXUkx"><img src="https://i.imgur.com/V9wXUkx.jpg" title="source: imgur.com" /></a>

#### Modifying an Entry

Modification of Bevétel and Kiadás entries are also possible. To do that, click the entry to be modified in either the Bevételek, or Kiadások table, then click the <b>Módosítás</b> button on the right. 

<b>Note:</b> Only one selection is possible, tehrefore it is only possible, to modify one entry at a time.

<b>Note:</b> If no entry is selected before clicking the <b>Módosítás</b> button, an error message is shown.

##### Modifying a Bevétel

1. To modify a bevétel, select one, then click the <b>Módosítás</b> button. The values of the entry are automatically loaded.

<a href="https://imgur.com/qOLWQlV"><img src="https://i.imgur.com/qOLWQlV.jpg" title="modifying a bevétel" /></a>

2. Make the required changes as needed. In this example, the Összeg of the bevétel is changed from 2.500 to 12.500.

3. Click <b>OK</b>.

The entry is now updated in the Bevételek table, also, the summary fields update automatically.

<a href="https://imgur.com/0NdFsXu"><img src="https://i.imgur.com/0NdFsXu.jpg" title="main after bevétel moficiation" /></a>

##### Modifying a Kiadás

1. To modify a kiadás, select one, then click the <b>Módosítás</b> button. The values of the entry are automatically loaded.

<a href="https://imgur.com/hwoaj4K"><img src="https://i.imgur.com/hwoaj4K.jpg" title="modifying a kiadás" /></a>

2. Make the required changes as needed. In this example, the Összeg of the kiadás is changed from 3.000 to 13.000. Also, the Kategória is changed to Közlekedés, and a new Vásárlás helye is also added.

3. Click <b>OK</b>.

The entry is now updated in the Kiadások table, also, the summary fields update automatically.

<a href="https://imgur.com/SQtjPMR"><img src="https://i.imgur.com/SQtjPMR.jpg" title="main after kiadás modification" /></a>

#### Transfer Between two Pénztárca

Unfortunately, now the Teszt 2 Pénztárca is in negative. It is possible to tranfer money between two Pénztárca.

<b>Note:</b> Transferring money between Pénztárcas do not leave a record. Therefore, if a transfer is entered incorrectly, there is no way to redo the action. However, it is possible to do another transfer in reverse, thus negating the error.

1. To transfer between Pénztárcas, click the <b>Átvezetés</b> button on the right.

2. Choose the pénztárca from where the money is to be transferred, and the one where the money is being transferred to.

3. Enter the amount.

<a href="https://imgur.com/tDIzPxh"><img src="https://i.imgur.com/tDIzPxh.jpg" title="átvezetés" /></a>

4. If everything is as needed, click <b>OK</b>. Once again, the summary fields automatically update.

<a href="https://imgur.com/GGQpMon"><img src="https://i.imgur.com/GGQpMon.jpg" title="main after átvezetés" /></a>

#### Deleting an Entry

To delete an entry, select it from the tables, then click the <b>Törlés</b> button on the right. A popup appears, click <b>Yes</b> to confirm the deletion, or <b>No</b>, to cancel the action. In this example, a kiadás is deleted.

<a href="https://imgur.com/O6jypXm"><img src="https://i.imgur.com/O6jypXm.jpg" title="deletion" /></a>

The selected item is removed from the list, and the summary fields are automatically updated.

<a href="https://imgur.com/z2bkpkR"><img src="https://i.imgur.com/z2bkpkR.jpg" title="after deletion" /></a>

#### Sorting

It is possible to sort the tables according to all the columns of the tables. To do so, click the header of column in any table. The program sorts the entries in ascending or descending order. Click again, to reverse the sorting.

#### Quitting

To exit the program, click the <b>Kilépés</b> button at the lower right corner of the screen.

