# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Minimal sandbox for experimenting with **Ebean ORM** against a **PostgreSQL** database. Uses a task-runner pattern: developers add `Task` implementations in `app.tasks`, write Ebean queries there, and point `App.java` to the desired task.

Derived from [TuxGamer/ebean-example](https://github.com/TuxGamer/ebean-example).

## Build & Run

```bash
# Build
./gradlew build

# Run (requires DB env vars)
. ./setvars.sh    # edit setvars.sh first with real PostgreSQL credentials
./gradlew run
```

Environment variables required: `DB_USERNAME`, `DB_PASSWORD`, `DB_URL` (JDBC PostgreSQL URL).

**No tests exist in this project.**

## Tech Stack

- Java 21, Gradle 8.4 (wrapper included)
- Ebean ORM 15.1.0 with querybean-generator (annotation processor for type-safe queries)
- PostgreSQL 42.7.1 driver, HikariCP 5.1.0 connection pool
- Logback/SLF4J for logging

## Architecture

- **`app.App`** — Entry point. Builds HikariCP DataSource from env vars, constructs Ebean `Database` with underscore naming convention, runs the active `Task`.
- **`app.models`** — JPA `@Entity` classes (`Book`, `Topic`). Ebean entity package declared in `src/main/resources/ebean.mf`.
- **`app.tasks.Task`** — Interface with `run()` method. Implement this to add new experiments.
- **`app.tasks.SimpleEbeanTask`** — Sample task querying `Book` entities via Ebean query builder.

## Key Config Files

- `build.gradle` — Dependencies and Ebean plugin (handles bytecode enhancement)
- `src/main/resources/ebean.mf` — Declares entity package (`entity-packages: models`)
- `src/main/resources/logback.xml` — Logging config; TRACE enabled for `io.ebean.DDL`, `io.ebean.SQL`, `io.ebean.TXN`
- `setvars.sh` — Template for DB connection env vars
