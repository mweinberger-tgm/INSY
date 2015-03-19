--Michael Weinberger 4AHIT, erstellt am 18.03.2015

--1.) In einer Query ???
SELECT mname FROM nimmt_teil WHERE rjahr = 2007 AND rname = 'Bodenseeregatta';
SELECT mname, id FROM nimmt_teil INNER JOIN Sportboot ON nimmt_teil.sportboot=Sportboot.id  WHERE rjahr = 2007 AND rname = 'Bodenseeregatta' AND segelflaeche < 20;

--2.) DONE ! Wenn 2 Tabellen mit ihren PK's gejoined werden, kann alternativ auch ein NATURAL JOIN gewaehlt werden.
SELECT name FROM Trainer INNER JOIN Person ON Trainer.key=Person.key WHERE geburtsdatum = (SELECT MIN(geburtsdatum) FROM Trainer INNER JOIN Person ON Trainer.key=Person.key);

--3.)
