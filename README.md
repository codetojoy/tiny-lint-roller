
### Info

* originally derived from [this repo](https://github.com/TuxGamer/ebean-example)
* [This repo](https://github.com/codetojoy/easter_eggs_for_play_framework/tree/main/egg_play_as_sdk_MAY_2024/commandline_app_ebean) is known to work. This particular repo is used to illustrate a skill in Claude Code.

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
