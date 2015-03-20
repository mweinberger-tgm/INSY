--Michael Weinberger 4AHIT, erstellt am 18.03.2015

--1.) In einer Query ???
SELECT mname FROM nimmt_teil WHERE rjahr = 2007 AND rname = 'Bodenseeregatta';
SELECT mname, id FROM nimmt_teil INNER JOIN Sportboot ON nimmt_teil.sportboot=Sportboot.id  WHERE rjahr = 2007 AND rname = 'Bodenseeregatta' AND segelflaeche < 20;

--2.) DONE ! Wenn 2 Tabellen mit ihren PK's gejoined werden, kann alternativ auch ein NATURAL JOIN gewaehlt werden.
SELECT name FROM Trainer INNER JOIN Person ON Trainer.key=Person.key WHERE geburtsdatum = (SELECT MIN(geburtsdatum) FROM Trainer INNER JOIN Person ON Trainer.key=Person.key);

--3.) DONE!
SELECT name, geburtsdatum FROM Person AS p NATURAL JOIN Segler NATURAL JOIN Trainer WHERE p.key NOT IN (SELECT key FROM Mannschaft);

--4.)


--5.)
SELECT name, jahr, COUNT(*) FROM Regatta NATURAL JOIN Wettfahrt WHERE (SELECT COUNT(*) FROM Wettfahrt) = (SELECT MIN(COUNT(*)) FROM Wettfahrt) GROUP BY name, jahr; 
SELECT COUNT(*) FROM Regatta NATURAL JOIN Wettfahrt GROUP BY name, jahr; --Als Subselect fuer Ermittlung des kleinsten Wertes.
SELECT name, jahr, COUNT(*) FROM Regatta NATURAL JOIN Wettfahrt WHERE (SELECT COUNT(*) FROM Regatta NATURAL JOIN Wettfahrt GROUP BY name, jahr) = (SELECT MIN(c) FROM (SELECT COUNT(*) as c FROM Regatta NATURAL JOIN Wettfahrt GROUP BY name, jahr)) GROUP BY name, jahr;


--6.) DONE!
--HAVING ist nicht so schoen, aber hier einer der wenigen Moeglichkeiten.
SELECT p.name FROM Person p NATURAL JOIN Trainer t INNER JOIN Mannschaft m on t.key = m.key GROUP BY p.name, t.key HAVING COUNT(m.key) >= 2;

--7.)
SELECT aklasse, COUNT(aklasse) FROM Mannschaft m NATURAL JOIN erzielt e GROUP BY aklasse;

--8.)

--14.)
SELECT name, jahr, land, laenge FROM Regatta r NATURAL JOIN Wettfahrt w GROUP BY name, jahr, land, laenge HAVING laenge = MAX(laenge);