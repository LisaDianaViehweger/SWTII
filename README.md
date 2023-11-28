# SWTII - Übung 3

## Aufgabe 3 - Maven initialisieren

Neues (IntelliJ-) Projekt erstellt:
* Vorlage für Maven-Projekte ausgewählt
* SimpleLinkedList

Kompilier- und Testvorgänge anstoßen:

* IntelliJ &rarr; Maven &rarr; Lifecycle &rarr; *compile* oder *test*
* Maven CLT:
```console
  ~/IdeaProjects/SWTII main ❯ mvn compile
  ~/IdeaProjects/SWTII main ❯ mvn test
  ```

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

Die folgenden Arten von Code Coverage werden unterstützt:
* Instruction Coverage
* Line Coverage
* Branch Coverage
* Method Coverage
* Class Coverage



## Aufgabe 6 - Testsuite

### Definition der Tests
Zum Testen der Klasse haben wir `src/test/java/st2/SimpleLinkedListUnitTest.java` hinzugefügt, worin alle Testfälle mit JUnit5 definiert sind. Vor jedem Testfall wird `initializeEmptyList()` ausgeführt (@BeforeEach). Die Tests sind durch Subklassen strukturiert (@Nested). Folgende Testfälle sind implementiert:
* `SizeFunctionTests`
  * `emptyListSize0()`: Für leere Liste gilt `size == 0`.
  * `addIncreasesSize()`: Wenn `add()` n-mal aufgerufen wird, gilt `size == n`.
* `AddFunctionTests`
  * `addsElements()`: Elemente für die `add()` aufgerufen wird, sind in der Liste.
  * `acceptsNullValues()`: `null` ist valides Element.
  * `acceptsDoubleValues()`: Dopplungen von Elementen sind erlaubt.
  * `keepsOrder()`: Reihenfolge der Listenelemente entspricht Reihenfolge der `add()`-Aufrufe
* `IteratorTests`
  * `IteratorConstructorTests`
    * `iteratorStartsAtFirstElement()`: Erster `next()`-Aufruf gibt erstes Element zurück.
  * `HasNextFunctionTests`
    * `emptyListReturnsFalse()`: `hasNext() == false` für leere Liste.
    * `returnsFalseAtEnd()`: Bei n Elementen und nach n `next()`-Aufrufen gilt `hasNext() == false`. 
    * `returnsTrueWhenNextElementExists()`: Bei n Elementen und nach 1..n-1 `next()`-Aufrufen gilt `hasNext() == true`.
  * `NextFunctionTests`
    * `emptyListThrowsNoSuchElementException()`: `next()`-Aufruf wirft `NoSuchElementException` für leere Listen.
    * `throwsNoSuchElementExceptionAtEnd()`: Bei n Elementen und nach n `next()`-Aufrufen wirft `next()`-Aufruf `NoSuchElementException`.
    * `returnsNextElement()`: Bei n Elementen und nach k=1..n-1 `next()`-Aufrufen gibt `next()` das (k+1)-te Element der Liste zurück.
  * `RemoveFunctionTests`
    * `throwsUnsupportedOperationException()`: `remove()` wirft `UnsupportedOperationException`.

### Gefundene Fehler


## Aufgabe 7 - Statische Analyse

## Aufgabe 8 - Debugger