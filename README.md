# SWTII - Übung 3

## Aufgabe 3 - Maven initialisieren

* neues (IntelliJ-) Projekt erstellt
  * Vorlage für Maven-Projekte ausgewählt
  * SimpleLinkedList

## Aufgabe 4 - JUnit & AssertJ

In der `pom.xml` müssen im Abschnitt `project.dependencies` folgende Dependencies eingefügt werden:
* ```
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.5.2</version>
    <scope>test</scope>
  </dependency>
  ```
* ```
  <dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <version>3.24.2</version>
    <scope>test</scope>
  </dependency>
  ```  

## Aufgabe 5 - Jacoco

## Aufgabe 6 - Testsuite

## Aufgabe 7 - Statische Analyse

## Aufgabe 8 - Debugger