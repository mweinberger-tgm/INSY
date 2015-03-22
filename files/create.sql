--Michael Weinberger 4AHIT, erstellt am 18.03.2015
--modelliert nach Vorgabe des RM

--TODO!!
--Constraints einfuegen, Fehler beheben!

--Anfangs war hier bei denkbar kleineren Zahlen Smallint enthalten, wie etwa die Startnummer
--Angesichts der Tatsache, dass 10.000 bis 100.000 DS oder mehr eingefuegt werden sollen ist dies nicht mehr sinnvoll.
--=> umgeaendert auf Integer

--Serial ist unter Postgres Auto Increment!
CREATE TABLE Person(
	key SERIAL PRIMARY KEY,
	name VARCHAR(50),
	geburtsdatum DATE
);

CREATE TABLE Segler(
	key SERIAL REFERENCES Person(key) PRIMARY KEY	
);

CREATE TABLE Trainer(
	key SERIAL REFERENCES Person(key) PRIMARY KEY	
);

--/////

CREATE TABLE Boot(
	id SERIAL PRIMARY KEY,
	name VARCHAR(100),
	personen INTEGER,
	tiefgang DECIMAL	
);

--Ist 'id INTEGER PRIMARY KEY REFERENCES Boot(id)' auch valide?
CREATE TABLE Tourenboot(
	id SERIAL REFERENCES Boot(id) PRIMARY KEY,
	bootsklasse	VARCHAR(50)
);

CREATE TABLE Sportboot(
	id SERIAL REFERENCES Boot(id) PRIMARY KEY,
	segelflaeche DECIMAL
);

--/////

--Altersklasse beinhaltet nicht nur Nummern, sonder bspw. auch Buchstaben wie z.B. U20
CREATE TABLE Mannschaft(
	name VARCHAR (50) PRIMARY KEY,
	aklasse VARCHAR(20),
	key SERIAL REFERENCES Trainer(key)
);

--/////

--'land' im Laendercode, z.B. AT, DE, CH --> Verworfen wegen Data Generator 
CREATE TABLE Regatta(
	name VARCHAR(50),
	jahr INTEGER,
	land VARCHAR(50), 
	PRIMARY KEY(name, jahr)
);

CREATE TABLE Wettfahrt(
	name VARCHAR(50),
	jahr INTEGER,
	datum DATE,
	laenge DECIMAL,
	PRIMARY KEY (name, jahr, datum),
	FOREIGN KEY (name, jahr) REFERENCES Regatta(name, jahr)
);

--/////

CREATE TABLE bildet(
	key SERIAL REFERENCES Segler(key),
	name VARCHAR(50) REFERENCES Mannschaft(name),
	PRIMARY KEY(key, name)
);

CREATE TABLE zugewiesen(
	id SERIAL REFERENCES Boot(id),
	name VARCHAR(50) REFERENCES Mannschaft(name),
	PRIMARY KEY(id, name)
);

--Schwerer Fehler, Abbruch des Create hier ! Noch zu beheben
--Loesung: FK zusammenfassen, PK ordentlich definieren
CREATE TABLE nimmt_teil(
	mname VARCHAR(50) REFERENCES Mannschaft(name),
	rname VARCHAR(50),
	rjahr INTEGER,
	sportboot SERIAL REFERENCES Sportboot(id),
	startnr INTEGER,
	PRIMARY KEY(mname, rname, rjahr, sportboot),
	FOREIGN KEY (rname, rjahr) REFERENCES Regatta(name, jahr)
);

CREATE TABLE erzielt(
	mname VARCHAR(50),
	wname VARCHAR(50),
	wjahr INTEGER,
	wdatum DATE,
	punkte INTEGER,
	PRIMARY KEY(mname, wname, wjahr, wdatum),
	FOREIGN KEY (mname) REFERENCES Mannschaft(name),
	FOREIGN KEY (wname, wjahr, wdatum) REFERENCES Wettfahrt(name, jahr, datum)
);
