
# Setup:

2 scenarios with same name "Adding" (in same file)

# Cases:

## 1 OK / 1 failing 

Depending on the order, the `sbt test` will fail or not

```
❯ sbt test
[info] Loading settings for project global-plugins from plugins.sbt ...
[info] Loading global plugins from /home/jourdang/.sbt/1.0/plugins
[info] Loading project definition from /tmp/scala-cucumber/project
[info] Updating ProjectRef(uri("file:/tmp/scala-cucumber/project/"), "scala-cucumber-build")...
[info] Done updating.
[info] Loading settings for project root from build.sbt ...
[info] Set current project to test (in build file:/tmp/scala-cucumber/)
[debug] Test run started
[debug] Test Basic Arithmetic.Adding started
[debug] Test Basic Arithmetic.Adding finished, took 0.022 sec
[debug] Test Basic Arithmetic.Adding started
[error] Test Basic Arithmetic.Adding failed: expected:<9.0> but was:<29.0>, took 0.024 sec
[debug] Test Basic Arithmetic.Adding finished, took 0.025 sec
[debug] Test run finished: 1 failed, 0 ignored, 2 total, 0.43s
[info] Passed: Total 1, Failed 0, Errors 0, Passed 1
[success] Total time: 3 s, completed 14 avr. 2020 11:07:02

> echo $?
0
```

This is NOT expected behavior.

## 1 failing / 1 OK (reverse order)

```
❯ sbt test
[info] Loading settings for project global-plugins from plugins.sbt ...
[info] Loading global plugins from /home/jourdang/.sbt/1.0/plugins
[info] Loading project definition from /tmp/scala-cucumber/project
[info] Loading settings for project root from build.sbt ...
[info] Set current project to test (in build file:/tmp/scala-cucumber/)
[debug] Test run started
[debug] Test Basic Arithmetic.Adding started
[error] Test Basic Arithmetic.Adding failed: expected:<9.0> but was:<29.0>, took 0.023 sec
[debug] Test Basic Arithmetic.Adding finished, took 0.024 sec
[debug] Test Basic Arithmetic.Adding started
[debug] Test Basic Arithmetic.Adding finished, took 0.025 sec
[debug] Test run finished: 1 failed, 0 ignored, 2 total, 0.354s
[error] Failed: Total 1, Failed 1, Errors 0, Passed 0
[error] Failed tests:
[error]         cucumber.examples.scalacalculator.RunCukesTest
[error] (Test / test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 1 s, completed 14 avr. 2020 11:09:27

> echo $?
1
```

## 2 failing

OK

## None failing

OK