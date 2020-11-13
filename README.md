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

The program utilizes a MySQL database to store all relevant data, however, different implementations are also possible. After each start, the program reads the database and loads the data into the program, which shows everything on the screen. By default, the program shows all the entries for the current month.

### Functionality

* Add and modify Penztarcas
* Add, remove, and modify Tranzakcios, that is, Bevetel and Kiadas items
* Reroute money from one Penztarca to another
* Sort the content of the tables in both directions with a single click
* Filter entries based on the Month they are entered

After starting the program, the main screen shows up. For the sake of simplicity, an empty table is used. At any time an action is not needed, press <b>Mégsem</b> to cancel the action.

<a href="https://imgur.com/csrUToD"><img src="https://imgur.com/csrUToD.jpeg" title="program main screen" /></a>

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

#### Adding Bevetels

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

TBC
