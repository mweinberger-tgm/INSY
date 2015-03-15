Segelverein
====
Sie erhalten den Auftrag f�r den Europ�ischen Dachverband der Segelvereine eine Datenbank zu implementieren.
====
Beschreibung

F�r Segler und Trainer sind Name (NAME) und Geburtsdatum (GEBURTSDATUM) bekannt. Sie werden beide identifiziert duch eine eindeutige Nummer (KEY). Mindestens zwei Segler, maximal jedoch vier Segler bilden eine Mannschaft. F�r jede Mannschaft wird ein eindeutiger Name (NAME) und eine Altersklasse (AKLASSE) gespeichert. Jede Mannschaft wird genau von einem Trainer betreut. Ein Trainer kann jedoch mehrere Mannschaften betreuen.

Jeder Mannschaft sind Boote zugewiesen. Ein Boot kann mehreren Mannschaften zugewiesen sein. Ein Boot wird eindeutig durch eine Nummer (ID) identifiziert. Weiters sind zu jedem Boot ein Name (NAME), die Anzahl der Personen (PERSONEN) und der Tiefgang (TIEFGANG) bekannt. Es gibt Tourenboote und Sportboote. Tourenboote haben zus�tzlich eine Bootsklasse (BOOTSKLASSE) und Sportboote haben zus�tzlich eine Segelfl�che (SEGELFLAECHE) gespeichert. Es ist au�erdem bekannt welche Mannschaften mit welchen Sportbooten an welchen Regatten mit welcher Startnummer (STARTNR) teilgenommen haben.

Eine Regatta wird eindeutig identifiziert durch ihren Namen (NAME) und durch das Jahr (JAHR), in dem sie stattgefunden hat. Das Land (LAND) ist au�erdem noch bekannt. Jede Regatta besteht aus mindestens drei jedoch maximal f�nf Wettfahrten. Wettfahrten werden durch die zugeh�rige Regatta und das Datum (DATUM) identifiziert, au�erdem wird die L�nge (LAENGE) der Strecke gespeichert. Mannschaften k�nnen bei jeder Wettfahrent Punkte (PUNKTE) erzielen.

INSY Michael Weinberger 4AHITT 2014/2015
