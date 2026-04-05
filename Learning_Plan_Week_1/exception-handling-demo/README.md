# Exception Handling in Java

A beginner-friendly demo project covering the three core exception handling concepts in Java.

---

## Project Structure

```
exception-handling-demo/
├── checked/
│   └── CheckedExceptionExample.java
├── unchecked/
│   ├── UncheckedExceptionExample.java
│   └── CatchingUncheckedExample.java
├── custom/
│   ├── InsufficientFundsException.java
│   ├── BankAccount.java
│   └── BankAccountDemo.java
├── trywithresources/
│   └── TryWithResourcesExample.java
└── out/                                  ← compiled .class files go here
```

---

## Concept 1: Checked Exceptions

The Java **compiler forces** you to handle these. If you don't, your code won't compile.

They represent problems **outside your control** — file not found, network failure, database unavailable.

**Two ways to handle them:**

```java
// Option 1: catch it yourself
void readFile(String name) {
    try {
        FileReader reader = new FileReader(name);
    } catch (IOException e) {
        System.out.println("File not found: " + e.getMessage());
    }
}

// Option 2: declare "throws" and let the caller handle it
void readFile(String name) throws IOException {
    FileReader reader = new FileReader(name);
}
```

**Common examples:** `IOException`, `FileNotFoundException`, `SQLException`

---

## Concept 2: Unchecked Exceptions

The compiler does **not** force you to handle these. They represent **programmer mistakes** — bugs in your logic.

The right fix is usually to prevent them with a check, not catch them.

**Common examples:**

| Exception | Cause |
|---|---|
| `ArithmeticException` | Dividing by zero |
| `NullPointerException` | Using a null reference |
| `ArrayIndexOutOfBoundsException` | Bad array index |
| `NumberFormatException` | Parsing `"abc"` as a number |

**Prevent, don't catch:**
```java
// Prefer this
if (b != 0) {
    int result = a / b;
}

// Over this
try {
    int result = a / b;
} catch (ArithmeticException e) { ... }
```

Catching unchecked exceptions is acceptable when dealing with **user input** you can't control.

---

## Checked vs Unchecked — Key Differences

| | Checked | Unchecked |
|---|---|---|
| Extends | `Exception` | `RuntimeException` |
| Compiler enforces? | Yes | No |
| Represents | External failures | Programmer bugs |
| Fix by | Handling the error | Fixing the logic |

> If the problem is in the **world outside your code** → Checked
> If the problem is in **how your code is written** → Unchecked

---

## Concept 3: Custom Exceptions

Create your own exception when a built-in one doesn't describe your problem clearly.

**Define it:**
```java
public class InsufficientFundsException extends Exception {
    private double amountRequested;
    private double currentBalance;

    public InsufficientFundsException(double requested, double balance) {
        super("Insufficient funds! Tried to withdraw $" + requested
              + " but balance is only $" + balance);
        this.amountRequested = requested;
        this.currentBalance = balance;
    }

    public double getShortfall() {
        return amountRequested - currentBalance;
    }
}
```

**Throw it:**
```java
public void withdraw(double amount) throws InsufficientFundsException {
    if (amount > balance) {
        throw new InsufficientFundsException(amount, balance);
    }
    balance -= amount;
}
```

**Catch it:**
```java
try {
    account.withdraw(500.00);
} catch (InsufficientFundsException e) {
    System.out.println(e.getMessage());
    System.out.println("You need $" + e.getShortfall() + " more.");
}
```

---

## Concept 4: Try-With-Resources

A **resource** is something your program opens and must close — like a file. Forgetting to close causes memory leaks and file locks.

`try-with-resources` closes the resource **automatically** when the block ends, even if an exception occurs.

```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line = reader.readLine();
    System.out.println(line);
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
// reader.close() is called automatically — you don't write it
```

Use this whenever you work with files, database connections, or network sockets.

---

## How to Run

All compiled `.class` files go into the `out/` folder.

```bash
# From the exception-handling-demo directory:

# Compile
javac -d out checked/CheckedExceptionExample.java
javac -d out unchecked/UncheckedExceptionExample.java
javac -d out unchecked/CatchingUncheckedExample.java
javac -d out custom/InsufficientFundsException.java custom/BankAccount.java custom/BankAccountDemo.java
javac -d out trywithresources/TryWithResourcesExample.java

# Run
java -cp out CheckedExceptionExample
java -cp out UncheckedExceptionExample
java -cp out CatchingUncheckedExample
java -cp out BankAccountDemo
java -cp out TryWithResourcesExample
```

> The file reading examples will show a "file not found" error — that's expected. It's there to demonstrate the exception being caught.