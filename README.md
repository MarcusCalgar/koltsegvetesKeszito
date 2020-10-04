# Költségvetés Készítő

## Summary

This program is designed to track the finances of a family. It was the final project at StudiCore Online. Please note, that the classes, variables and methods are written in Hungarian.


## Use Cases

- Susan is a 29 year old single woman, working at an international corporation. Despite having a decent salary, she barely has any money left at the end of the month.
Wondering where might her money goes, she starts using this program. After a month of carefully recording all of her income and spending, she finds out that she often goes out 
with her colleauges to a nearby cafe, and that the overpriced coffee and cakes take a toll on her budget. Armed with this knowledge, she decides to cut back on her spending.

- George is 45 years old, father of two boys. His kids always complain that they run out of their pocket money rather quickly. He teaches his kids how to use the program, and 
they find out, that video game subscriptions and a lot of snacks aren't exactly cheap. With the extra information gathered, they decide to make some changes, so the kids learn the value of money more.


## How does it work?

The program utilizes a MySQL database to store all relevant data. At first, the user has to add some Penztarca's, which are objects representing different kinds of purses. For example, a Penztarca can be Készpénz (Cash), Bankkártya (Credit card) or other. Once it is set up, Bevetel (Income) and Kiadas (Expense) objects can be created, and added to one of the Penztarcas. The program records these and calculates how the amount of money is changing.

As all incomes/expenses have certain types, it is possible to quickly search for specific types of data. For example, how much money one spends in a certain shop, or how much money was spent on travel related expenses.

Please note that some of the functionalities are still under development.
