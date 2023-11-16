# SWTII - Übung 3

## Aufgabe 3 - Maven initialisieren

* neues (IntelliJ-) Projekt erstellt
  * Vorlage für Maven-Projekte ausgewählt
  * SimpleLinkedList

## Aufgabe 4 - JUnit & AssertJ

In der `pom.xml` müssen im Abschnitt `project.dependencies` folgende Dependencies eingefügt werden:
* ```xml
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.5.2</version>
    <scope>test</scope>
  </dependency>
  ```
* ```xml
  <dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <version>3.24.2</version>
    <scope>test</scope>
  </dependency>
  ```  

## Aufgabe 5 - Jacoco

Um JaCoCo zu Maven hinzuzufügen, wurde in `pom.xml` im Abschnitt `project.dependencies` folgende Dependency eingefügt:
```xml
<dependency>
  <groupId>org.jacoco</groupId>
  <artifactId>jacoco-maven-plugin</artifactId>
  <version>0.8.11</version>
  <scope>test</scope>
</dependency>
```
Außerdem wurde festgelegt, dass beim Buildvorgang folgende Schritte passieren:
* `clean`
  * entfernt bisherige Projektdateien
* `<jacoco>:prepare-agent`
  * initialisiert JaCoCo
* `verify`
  * führt Tests durch
* `<jacoco>:report`
  * speichert Coverage-Bericht in `target/site/jacoco`

Diese Schritte werden in der `pom.xml` in Abschnitt `project.build` definiert:
```xml
<defaultGoal>clean org.jacoco:jacoco-maven-plugin:prepare-agent verify org.jacoco:jacoco-maven-plugin:report</defaultGoal>
```

## Aufgabe 6 - Testsuite

## Aufgabe 7 - Statische Analyse

## Aufgabe 8 - Debugger