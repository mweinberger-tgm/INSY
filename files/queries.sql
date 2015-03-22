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
--Hat bei den meisten Wettfahrten Punkte erzielt = die meisten Punkte? Kann eine teilnehmende Mannschaft ueberhaupt 0 Punkte erzielen?
--DONE, aber verbesserungswuerdig --> auf eine Ausgabe reduzieren, die nur die Mannschaft anzeigt
SELECT aklasse, COUNT(punkte) FROM Mannschaft m INNER JOIN erzielt e ON m.name = e.mname GROUP BY aklasse HAVING (SELECT MAX(alter) FROM (SELECT COUNT(aklasse) AS alter FROM Mannschaft m INNER JOIN erzielt e ON m.name = e.mname GROUP BY aklasse) s)  IN (SELECT COUNT(aklasse) FROM Mannschaft m INNER JOIN erzielt e ON m.name = e.mname GROUP BY aklasse);

--ACHTUNG, Sie muessen jetzt ganz, ganz stark sein! Das ist ein groesserer Pfusch, quick & dirty um der Aufgabenstellung zu entsprechen.
SELECT aklasse FROM Mannschaft m INNER JOIN erzielt e ON m.name = e.mname GROUP BY aklasse HAVING (SELECT MAX(alter) FROM (SELECT COUNT(aklasse) AS alter FROM Mannschaft m INNER JOIN erzielt e ON m.name = e.mname GROUP BY aklasse) s)  IN (SELECT COUNT(aklasse) FROM Mannschaft m INNER JOIN erzielt e ON m.name = e.mname GROUP BY aklasse) LIMIT 1;

--8.)

--11.) DONE!
SELECT name FROM Trainer NATURAL JOIN Person GROUP BY name, key HAVING key IN (SELECT m.key FROM erzielt e INNER JOIN Mannschaft m ON m.name = e.mname GROUP BY m.key, e.punkte HAVING e.punkte = (SELECT MAX(e.punkte) FROM erzielt e));

--12.) Betonung auf JEDE --> Auch Null-Werte erlaubt!
--Ein paar Teams fehlen noch, und zwar diese, die an sontigen Regatten teilgenommen haben.
SELECT m.name, e.punkte FROM erzielt e RIGHT OUTER JOIN Mannschaft m ON m.name = e.mname LEFT OUTER JOIN Regatta r ON e.wname = r.name WHERE e.punkte IS NULL OR e.wname = 'Bodenseeregatta' AND r.land = 'Oesterreich';

--13.) DONE!
SELECT s.id, b.name FROM Sportboot s NATURAL JOIN Boot b GROUP BY s.id, b.name HAVING s.id NOT IN (SELECT key FROM Mannschaft) AND s.id IN (SELECT n.sportboot FROM nimmt_teil n GROUP BY n.sportboot HAVING COUNT(sportboot) > 2);

--14.) DONE!
SELECT r.name, r.jahr, r.land FROM Regatta r NATURAL JOIN Wettfahrt w GROUP BY w.laenge, r.name, r.jahr, r.land HAVING w.laenge = (SELECT MIN(laenge) FROM Wettfahrt w);