---
name: lint-roller
description: enforcing coding preferences and best practices
---

### General Formatting

- If anything is violated, enforce by reporting as an error in bold font.
- Warn if tabs are discovered (instead of spaces).
- Enforce that braces are on the same line such as:
```
while (!done) {
    if (a && b) {
        doSomething();
    }
}
```

### Ebean ORM in Java

- Warn for any methods that perform a count of objects, but use `findList()` to do it,
as this is a performance concern.

- Warn for any EBean queries that use `findList()` without a `where()` clause, as this can lead to fetching large amounts of data unintentionally. Suggest a `QueryIterator`.
