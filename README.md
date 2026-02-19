
### Info

* derived from [this repo](https://github.com/TuxGamer/ebean-example)
* tested with Java 21, Gradle 8.4

### Notes

* This project is a minimal project which uses Ebean (no Play Framework) to read from Postgres.
* It has a skill as a tiny linter, for demo purposes.
* See the skill definition in `.claude/skills/lint-roller/SKILL.md` 

### Usage

* for normal use, in Terminal:
    * edit `./setvars.sh`
    * `./gradlew clean run`
* for skill illustration, in Terminal:
    * `claude`
    * `/init`
    * `/lint-roller`
