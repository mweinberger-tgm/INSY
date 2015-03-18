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

--Serial ist unter Postgres Auto Increment!
CREATE TABLE Person(
	key SERIAL PRIMARY KEY,
	name VARCHAR(50),
	geburtsdatum DATE
);

CREATE TABLE zugewiesen( 
	id INTEGER REFERENCES Boot(id),
	name VARCHAR(100) REFERENCES Mannschaft(name),
	PRIMARY KEY(id, name)
);