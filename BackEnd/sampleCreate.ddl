CREATE TABLE RESERVERING (ID INTEGER AUTO_INCREMENT NOT NULL, AANTALPERSONEN INTEGER, NAAM VARCHAR(255), RESERVERINGSDATUM LONGBLOB, TIJDSLOT INTEGER, PRIMARY KEY (ID))
CREATE TABLE PERSOON (ID INTEGER AUTO_INCREMENT NOT NULL, EMAIL VARCHAR(255), NAAM VARCHAR(255), TELNR VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE TAFEL (ID INTEGER AUTO_INCREMENT NOT NULL, AANTALZITPLAATSEN INTEGER, TAFELNUMMER INTEGER, PRIMARY KEY (ID))
