---
name: lint-roller
description: enforcing coding preferences and best practices
---

### General Formatting

- if anything is violated, enforce by reporting as an error in bold font
- warn if tabs are discovered (instead of spaces)
- enforce that braces are on the same line such as:
```
while (!done) {
    if (a && b) {
        doSomething();
    }
}
```

### EBean ORM in Java

- warn for any methods that perform a count of objects, but use `findList()` to do it,
as this is a performance concern
