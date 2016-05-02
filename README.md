
Thymeleaf Joda Dialect
======================

[![Build Status](https://travis-ci.org/ultraq/thymeleaf-joda-dialect.svg?branch=master)](https://travis-ci.org/ultraq/thymeleaf-joda-dialect)
[![GitHub Release](https://img.shields.io/github/release/ultraq/thymeleaf-joda-dialect.svg?maxAge=3600)](https://github.com/ultraq/thymeleaf-joda-dialect/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/nz.net.ultraq.thymeleaf/thymeleaf-joda-dialect.svg?maxAge=3600)](http://search.maven.org/#search|ga|1|g%3A%22nz.net.ultraq.thymeleaf%22%20AND%20a%3A%22thymeleaf-joda-dialect%22)
[![License](https://img.shields.io/github/license/ultraq/thymeleaf-joda-dialect.svg?maxAge=2592000)](https://github.com/ultraq/thymeleaf-joda-dialect/blob/master/LICENSE.txt)

A dialect for Thymeleaf that adds Joda utility methods to Thymeleaf templates.


Installation
------------

Minimum of Java 7 and Thymeleaf 3.0 required.  If you're looking for a version
of this dialect for Thymeleaf 2.1, use the 1.0 releases instead.

### Standalone distribution
Copy the JAR from [one of the release bundles](https://github.com/ultraq/thymeleaf-joda-dialect/releases),
placing it in the classpath of your program, or build the project from the
source code here on GitHub.

### For Maven and Maven-compatible dependency managers
Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.thymeleaf`
 - ArtifactId: `thymeleaf-joda-dialect`
 - Version: (as per the badges above)


Usage
-----

Add the Joda dialect to your existing Thymeleaf template engine, eg:

Java example:

```java
templateEngine.addDialect(new JodaDialect());
```

Spring XML configuration example:

```xml
<bean id="templateEngine" class="org.thymeleaf.spring3.SpringTemplateEngine">
  ...
  <property name="additionalDialects">
    <set>
      <bean class="nz.net.ultraq.thymeleaf.JodaDialect"/>
    </set>
  </property>
</bean>
```

This will introduce the `joda` expression object to your Thymeleaf templates,
adding 2 new utility methods you can use in your pages: `createNow`, and `format`.

### createNow

Creates a new Joda `DateTime` instance whose time is the instant at which the
method was called.

```html
<div th:with="now=${#joda.createNow()}">...</div>
```

### format

Formats a Joda `DateTime` instance according to the given format string.
Documentation on the format string can be found on Joda's API pages
[here](http://www.joda.org/joda-time/apidocs/org/joda/time/format/DateTimeFormat.html),
although it's mostly compatible with the JDK date patterns that all Java devs
know already.

```html
<div th:text="${#joda.format(myDate, 'EEEE, d MMMM yyyy')}">...</div>
```
