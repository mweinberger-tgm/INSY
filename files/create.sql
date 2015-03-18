--Michael Weinberger 4AHIT

CREATE TABLE Boot(
	tiefgang DECIMAL,
	personen SMALLINT,
	name VARCHAR(100),
	id INTEGER PRIMARY KEY
);

CREATE TABLE Tourenboot(
	bootsklasse	VARCHAR(50),
	id INTEGER PRIMARY KEY REFERENCES Boot(id)
);

CREATE TABLE Sportboot(
	segelflaeche DECIMAL, 
	id INTEGER PRIMARY KEY REFERENCES Boot(id)
);

CREATE TABLE Person(
	key
);

CREATE TABLE zugewiesen( 
	id INTEGER REFERENCES Boot(id),
	name VARCHAR(50) REFERENCES Mannschaft(name),
	PRIMARY KEY(id, name)
);