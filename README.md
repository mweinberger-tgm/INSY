Segelverein
====
Sie erhalten den Auftrag f�r den Europ�ischen Dachverband der Segelvereine eine Datenbank zu implementieren.

Beschreibung
====

F�r Segler und Trainer sind Name (NAME) und Geburtsdatum (GEBURTSDATUM) bekannt. Sie werden beide identifiziert duch eine eindeutige Nummer (KEY). Mindestens zwei Segler, maximal jedoch vier Segler bilden eine Mannschaft. F�r jede Mannschaft wird ein eindeutiger Name (NAME) und eine Altersklasse (AKLASSE) gespeichert. Jede Mannschaft wird genau von einem Trainer betreut. Ein Trainer kann jedoch mehrere Mannschaften betreuen.

Jeder Mannschaft sind Boote zugewiesen. Ein Boot kann mehreren Mannschaften zugewiesen sein. Ein Boot wird eindeutig durch eine Nummer (ID) identifiziert. Weiters sind zu jedem Boot ein Name (NAME), die Anzahl der Personen (PERSONEN) und der Tiefgang (TIEFGANG) bekannt. Es gibt Tourenboote und Sportboote. Tourenboote haben zus�tzlich eine Bootsklasse (BOOTSKLASSE) und Sportboote haben zus�tzlich eine Segelfl�che (SEGELFLAECHE) gespeichert. Es ist au�erdem bekannt welche Mannschaften mit welchen Sportbooten an welchen Regatten mit welcher Startnummer (STARTNR) teilgenommen haben.

Eine Regatta wird eindeutig identifiziert durch ihren Namen (NAME) und durch das Jahr (JAHR), in dem sie stattgefunden hat. Das Land (LAND) ist au�erdem noch bekannt. Jede Regatta besteht aus mindestens drei jedoch maximal f�nf Wettfahrten. Wettfahrten werden durch die zugeh�rige Regatta und das Datum (DATUM) identifiziert, au�erdem wird die L�nge (LAENGE) der Strecke gespeichert. Mannschaften k�nnen bei jeder Wettfahrent Punkte (PUNKTE) erzielen.

ER-Diagramm
====
Siehe eLearning (http://bit.ly/1BJkaSx).

Relationenmodell
====

Person(*key*, name, geburtsdatum)

Segler(*key: Person.key*)

Trainer(*key: Person.key*) 

Boot(*id*, name, personen, tiefgang) 

Tourenboot(*id: Boot.id*, bootsklasse) 

Sportboot(*id: Boot.id*, segelflaeche) 

Mannschaft(*name*, aklasse, key: Trainer.key) 

Regatta(*name, jahr*, land) 

Wettfahrt(*name: Regatta.name, jahr: Regatta.jahr, datum*, laenge) 

bildet(*key: Segler.key, name: Mannschaft.name*)

zugewiesen(*id: Boot.id, name: Mannschaft.name*)
 
nimmt_teil(*mname: Mannschaft.name, rname: Regatta.name, rjahr: Regatta.jahr, sportboot: Sportboot.id*, startnr) 

erzielt(*mname: Mannschaft.name, wname: Wettfahrt.name, wjahr: Wettfahrt.jahr, wdatum: Wettfahrt.datum*, punkte)

SQL Abfragen
====

1. Geben Sie alle Mannschaften aus, die bei der Bodenseeregatta im Jahr 2014 teilgenommen haben. Wenn eine Mannschaft mit einem Boot mit der Segelfl�che kleiner als 20 m2 teilgenommen hat, soll auch die ID des Bootes ausgegeben werden.
2. Geben Sie den Namen und das Geburtsdatum der j�ngsten Trainer aus (k�nnen auch mehrere sein).
3. Geben Sie alle Personen geordnet nach Geburtsdatum aus, die sowohl Segler als auch Trainer sind, allerdings in keiner Mannschaft dabei sind.
4. Geben Sie alle Personen geordnet nach Geburtsdatum aus, die entweder Segler oder Trainer sind, jedoch nicht beides und vermerken Sie in einer Spalte, ob es sich um einen Trainer oder einen Segler handelt.
5. Geben Sie die Regatten (Name und Jahr) mit den wenigsten Wettfahrten an und geben Sie auch die Anzahl aus.
6. Geben Sie die Namen jener Trainer aus, die zwei oder mehr Mannschaften betreuen.
7. Welche Altersklasse ist am aktivsten (hat an den meisten Wettfahrten Punkte erzielt)?
8. Um wieviel gehen Tourenboote durchschnittlich tiefer als Sportboote?
9. Geben Sie f�r alle Mannschaften aus, an wievielen Regatten sie bereits teilgenommen haben und wieviele Punkte sie dort erzielt haben.
10. Welches Land bietet die l�ngste Wettfahrtsstrecke und hat zus�tzlich nicht die k�rzeste?
11. Wie hei�t der Trainer, der die Manschaft mit den meisten Punkten trainiert hat?
12. Geben Sie f�r JEDE Mannschaft aus, wieviele Punkte Sie bei der 'Bodenseeregatta' in 'Oesterreich' erzielt haben.
13. Geben Sie die ID und den Namen jener Sportboote aus, die mindestens an zwei Regatten Teil genommen haben, aber keiner Mannschaft zugewiesen sind.
14. Geben Sie die Regatten (Name, Jahr und Land) aus, die �ber die k�rzeste Distanz gehen.

Java & JDBC 
====

Schreiben Sie einen Java Client, der eine JDBC-Verbindung zur Datenbank herstellt und AUTOCOMMIT ausschaltet. Realisieren Sie eine GUI, die einfache CRUD-Befehle auf die Boote des Vereins implementiert (keine explizite SQL-Eingabe). Verwenden Sie dabei auf jeden Fall eine JTable, die auch eine grafische Ver�nderung der Datens�tze erlauben soll.

Als Erweiterung (Bonuspunkte) soll bei der Anzeige der Boote die M�glichkeit der Sortierung und Filterung �ber ein neues SQL-Kommando bereitgestellt werden. Auch hier soll nicht der Benutzer die SQL-Befehle eingeben, sondern es muss die Funktionalit�t �ber entsprechende GUI-Elemente realisiert werden!

Erm�glichen Sie die gleichzeitige Verbindung von mehreren Clients auf die Datenbasis. Implementieren Sie dabei eine transaktionell, gesicherte Erstellung und �nderung von Wettfahrten. Beachten Sie dabei, dass der Punktestand der einzelnen Wettfahrten laufend und von mehreren Clients gleichzeitig aktualisiert werden k�nnte. Stellen Sie f�r die Eingabe der Wettfahrt und Mannschaft eine einfache grafische M�glichkeit zur Verf�gung.

Abgabe
====

Die Abgabe ist am 20. M�rz 2015 um 08:00 per elearning zu t�tigen. Es wird ein Protokoll (Metaregeln), die SQL-Files (drop.sql, create.sql, start.sql, insert.sql, insert-*.sql, queries.sql) in einem eigenen Verzeichnis. Dies alles wird in einem ausf�hrbaren JAR-Archiv erwartet. Die Abgabe wird mit einem Pr�fungsgespr�ch validiert, wobei auf eine eigenst�ndige L�sung geachtet wird - kopierte L�sungen f�hren zu einer negativen Benotung! Quellen sollen somit auf den theoretischen Background und auf die Manuals beschr�nkt sein. Teile von bestehendem JDBC-Code aus dem Internet und vorgefertigte SQL-Abfragen d�rfen somit nicht verwendet werden. Im Zweifelsfall ist es notwendig die Lehrkr�fte um Freigabe von Quellen zu bitten. Das Beispiel soll f�r eine Postgresql 9.4 Umgebung implementiert werden.

Die Inserts sollen mindestens 10.000 Eintr�ge enthalten. Es bleibt Ihnen �berlassen, ob Sie einen selbstgeschriebenen Generator oder ein externes Tool verwenden m�chten. Auf jeden Fall muss Ihre Vorgehensweise gut dokumentiert und nachvollziehbar sein. Die Daten sollen so nahe wie m�glich der Wirklichkeit entsprechen, um entsprechende Testf�lle und Performancetests auf der Datenbank starten zu k�nnen (Person1..10000 sind somit keine erw�nschten Datens�tze).

Bei Problemen mit dem Create-Script und den Inserts kann ein Example-Set bei den Lehrenden angefordert werden. Dies muss aber f�r jeden Kandidaten einzeln geschehen! Anfragen bitte immer per eMail an BEIDE Lehrer.


====

(c) Markus Pichlmair; adaptiert bei Michael Borko und Erhard List

INSY Michael Weinberger 4AHIT 2014/2015
