--Michael Weinberger 4AHIT, erstellt am 18.03.2015
--modelliert nach Vorgabe des RM

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
	personen SMALLINT,
	tiefgang DECIMAL	
);

--Ist 'id INTEGER PRIMARY KEY REFERENCES Boot(id)' auch valide?
CREATE TABLE Tourenboot(
	id SERIAL REFERENCES Boot(id) PRIMARY KEY,
	bootsklasse	VARCHAR(50)
);

CREATE TABLE Sportboot(
	id SERIAL REFERENCES Boot(id) PRIMARY KEY ,
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

--land im Laendercode, z.B. AT, DE, CH
CREATE TABLE Regatta(
	name VARCHAR(50),
	jahr SMALLINT,
	land VARCHAR(2), 
	PRIMARY KEY(name, jahr)
);

CREATE TABLE Wettfahrt(
	name VARCHAR(50) REFERENCES Regatta(name),
	jahr SMALLINT REFERENCES Regatta(jahr),
	datum DATE,
	laenge DECIMAL,
	PRIMARY KEY (name, jahr, datum)
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

CREATE TABLE nimmt_teil(
	mname VARCHAR(50) REFERENCES Mannschaft(name),
	rname VARCHAR(50) REFERENCES Regatta(name)
);

CREATE TABLE erzielt(
		
);
