# Learning Plan — Week 1

Java OOP practice projects built from scratch.

---

## Phonebook App

A contact manager using three different **Java Collections**.

### Project Structure
```
phonebook/src/
├── Main.java
├── model/
│   └── Contact.java
└── phonebook/
    └── PhoneBook.java
```

### How It Works
| Collection | Used For |
|---|---|
| `ArrayList` | Stores all contacts in insertion order |
| `HashMap` | Fast lookup by phone number |
| `TreeMap` | Lists all contacts sorted by surname automatically |

- `Contact.java` holds name, surname, and phone number
- `PhoneBook.java` manages all three collections
- `Main.java` runs a loop showing a menu until the user chooses to exit

### How to Run
```bash
cd phonebook/src
javac model/Contact.java phonebook/PhoneBook.java Main.java
java Main
```

### Sample Output
```
=== Phonebook App ===

1. Add contact
2. Search by name
3. Search by phone number
4. List all contacts
5. Exit
Choose an option: 4

--- All Contacts (sorted by surname) ---
Alice Brown | 5678
Bob Smith | 9999
John Smith | 1234
----------------------------------------
```
---

## Shape Hierarchy

A shape calculator using **interfaces**, **inheritance**, and **polymorphism**.

### Project Structure
```
shapes/src/
├── Main.java
├── interfaces/
│   └── Shape.java
└── shapes/
    ├── Circle.java
    ├── Rectangle.java
    └── Triangle.java
```

### How It Works
- `Shape` is an interface with two methods: `calculateArea()` and `calculatePerimeter()`
- `Circle`, `Rectangle`, and `Triangle` each implement the interface
- `Main.java` asks the user which shape they want, takes the dimensions as input, and prints the area and perimeter

### How to Run
```bash
cd shapes/src
javac interfaces/Shape.java shapes/*.java Main.java
java Main
```

### Sample Output
```
Which shape do you want?
1. Circle
2. Rectangle
3. Triangle
Enter choice (1/2/3): 1
Enter radius: 5
Area      : 78.54
Perimeter : 31.42
```


