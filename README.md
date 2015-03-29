
Thymeleaf Joda Dialect
======================

A dialect for Thymeleaf that adds Joda utility methods to Thymeleaf templates.

 - Current version: 1.0.1
 - Released: 29 March 2015


Installation
------------

Minimum of Java 7 required.

### Standalone distribution
Copy the JAR from [the latest release bundle](https://github.com/ultraq/thymeleaf-joda-dialect/releases),
placing it in the classpath of your program, or build the project from the
source code here on GitHub.

### For Maven and Maven-compatible dependency managers
Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.thymeleaf`
 - ArtifactId: `thymeleaf-joda-dialect`
 - Version: `1.0.1`


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


Changelog
---------

### 1.0.1
 - Return `null` from the `format` method when given a `null` date

### 1.0.0
 - Initial release

