CREATE TABLE RESERVERING (ID INTEGER AUTO_INCREMENT NOT NULL, AANTALPERSONEN INTEGER, CODE VARCHAR(255), RESERVERINGSDATUM DATE, TIJDSLOT INTEGER, CONTACPERSOON_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE PERSOON (ID INTEGER AUTO_INCREMENT NOT NULL, EMAIL VARCHAR(255), NAAM VARCHAR(255), TELNR VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE TAFEL (ID INTEGER AUTO_INCREMENT NOT NULL, AANTALZITPLAATSEN INTEGER, TAFELNUMMER INTEGER, PRIMARY KEY (ID))
ALTER TABLE RESERVERING ADD CONSTRAINT FK_RESERVERING_CONTACPERSOON_ID FOREIGN KEY (CONTACPERSOON_ID) REFERENCES PERSOON (ID)
