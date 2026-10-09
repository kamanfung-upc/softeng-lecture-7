# Software Architecture - JUnit

Maven project with Exercise 1 of the JUnit lab: a library of books with its unit tests.

## Notes

- `Book` overrides `equals` and `hashCode` (same title, author and year means same book), as in the *Best Practices* part of the tutorial. Without it `removeBook(new Book(...))` would never find the book.
- `removeBook` returns `true` or `false` so `Main` can tell the user if the book was in the library.
- `LibraryTest` uses `setUp` with `@BeforeEach`, so every test starts with the same 3 books. Each method has a test for the normal case and one for the "not found" case.

## Tests

```
[INFO] Running org.example.BookTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running org.example.LibraryTest
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] Tests run: 16, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

### Coverage

| Class | Methods | Lines | Branches |
|---|---|---|---|
| `Library` | 6/6 | 18/18 | 8/8 |
| `Book` | 7/7 | 16/16 | 10/12 |
| `Main` | 0/4 | 0/61 | 0/20 |

`Main` is not tested (see Question 1), and the two missing branches of `Book` are in `equals`: comparing a book with an object of another class.

## Questions

### 1. Is it easy to test the Main class? Why?

No, `Main` only has a `static main` that reads from the keyboard (`Scanner` on `System.in`) and prints to the screen. It does not return anything and it keeps no state we can look at, so there is nothing to put in an `assertEquals`. 
To test it we would have to replace `System.in` with a prepared text, capture `System.out` and compare the printed text, and any small change in a menu message would break the test. That is why the logic is in `Library` and `Book`, which take parameters and return values, and `Main` only reads the option and calls them.
