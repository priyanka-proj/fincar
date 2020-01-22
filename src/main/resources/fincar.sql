CREATE DATABASEIF NOT EXISTS fincar;

CREATE TABLE Car
( Id INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(30) NOT NULL,
  ManufacturerName VARCHAR(40),
  Model VARCHAR(30),
  ManufacturingYear VARCHAR(20),
  Color VARCHAR(20),

  CONSTRAINT car_pk PRIMARY KEY (id)
);

INSERT INTO Car (Name,ManufacturerName,Model,ManufacturingYear,Color)
VALUES ('Audi','Volkswagen','Audi_Q7','2005','white');

INSERT INTO Car (Name,ManufacturerName,Model,ManufacturingYear,Color)
VALUES ('Chevrolet','GM','Shevrolet Beat','2017','Black');

INSERT INTO Car (Name,ManufacturerName,Model,ManufacturingYear,Color)
VALUES ('Suzuki','Maruti Suzuki','Maruti 800','1983','Lars');

