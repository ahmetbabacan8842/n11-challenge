# n11 Test Automation Challenge

## About
Tests n11.com Facebook login cases.
              Login cases.
              Login cases(unsuccesfully login, because take a screenshot)
              Categories cases.
              Author cases.

## Running

```bash
git clone https://github.com/ahmetbabacan8842/n11-challenge.git
cd n11-challenge
mvn clean test
```

## Failed Tests Screenshots
```bash
cd n11-challenge/target/failed-tests-screenshots
```

## Multi Platform

Also it can be run on Chrome or Firefox if requested, you just need to change the platform from the `src/test/resources/config.json` file or give a JVM parameter to mvn command, for example:
```bash
mvn clean test -Dplatform=firefox
```
